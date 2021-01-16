package cn.kingnet.utp.sdk.account.tools;

import cn.kingnet.utp.sdk.core.utils.StringUtil;
import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Vector;

/**
 * @Description
 * @Author WJH
 * @Date 2020/08/13
 */
@Slf4j
public class SftpService {
    private final SftpConfig sftpConfig;
    private Session session;

    public SftpService(SftpConfig sftpConfig) {
        this.sftpConfig = sftpConfig;
    }

    public synchronized Session openSession() {
        try {
            if (session != null && session.isConnected()) {
                return session;
            }

            JSch jsch = new JSch();
            if (!StringUtil.isEmpty(sftpConfig.getPrivateKey())) {
                // 设置私钥
                jsch.addIdentity(sftpConfig.getPrivateKey());
            }

            session = jsch.getSession(sftpConfig.getUserName(), sftpConfig.getHost(), sftpConfig.getPort());

            if (!StringUtil.isEmpty(sftpConfig.getPassword())) {
                session.setPassword(sftpConfig.getPassword());
            }

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setServerAliveInterval(90 * 1000);
            session.setConfig(config);
            session.connect();
        } catch (JSchException e) {
            log.error("连接SFTP服务器回话异常:{}", e.getMessage(), e);
            throw new RuntimeException("连接SFTP服务器回话异常:" + e.getMessage());
        }
        return session;
    }

    public Sftp connectSftp() {
        if (session == null || !session.isConnected()) {
            session = openSession();
        }
        try {
            Channel channel = session.openChannel("sftp");
            channel.connect();

            Sftp sftp = new Sftp((ChannelSftp) channel);
            return sftp;
        } catch (JSchException e) {
            log.error("开启SFTP服务器通道异常:{}", e.getMessage(), e);
            throw new RuntimeException("开启SFTP服务器通道异常:" + e.getMessage());
        }
    }

    public void closeSFTP(ChannelSftp sftp) {
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
    }

    public void closeSession() {
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

    public static class Sftp {
        private final ChannelSftp sftp;

        public Sftp(ChannelSftp sftp) {
            this.sftp = sftp;
        }

        public boolean existsDir(String presentDirectory) {
            boolean exists = false;
            String parentDir = null;
            try {
                parentDir = sftp.pwd();
                SftpATTRS sftpATTRS = sftp.lstat(presentDirectory);
                exists = sftpATTRS.isDir();
            } catch (SftpException e) {
                log.warn("[{}/{}]目录不存在:{}", parentDir, presentDirectory, e.getMessage());
            }
            return exists;
        }

        /**
         * 将输入流的数据上传到sftp作为文件。文件完整路径=basePath+directory
         *
         * @param remoteDirectory 上传到服务器该目录
         * @param sftpFileName    sftp端文件名
         * @param localPath       本地文件
         */
        public void upload(String remoteDirectory, String sftpFileName, Path localPath) throws SftpException, IOException {
            sftp.cd(sftp.getHome());
            if (!StringUtil.isEmpty(remoteDirectory)) {
                try {
                    remoteDirectory = this.cd(remoteDirectory);
                } catch (SftpException e) {
                    //目录不存在，则创建文件夹
                    String[] dirs = remoteDirectory.split("/");
                    for (String curDir : dirs) {
                        if (!StringUtil.isEmpty(curDir)) {
                            if (!existsDir(curDir)) {
                                sftp.mkdir(curDir);
                            }
                            sftp.cd(curDir);
                        }
                    }
                }
            }
            //上传文件
            sftp.put(Files.newInputStream(localPath), sftpFileName);
        }

        /**
         * 下载文件。
         *
         * @param remoteDirectory 下载服务器目录
         * @param downloadFile    下载的文件
         * @param localSavePath   存在本地的路径文件
         */
        public void download(String remoteDirectory, String downloadFile, Path localSavePath) throws
                SftpException, IOException {
            this.cd(remoteDirectory);
            try {
                sftp.get(downloadFile, Files.newOutputStream(localSavePath));
            } catch (SftpException | IOException e) {
                //删除待保存文件
                Files.deleteIfExists(localSavePath);
                throw e;
            }
        }

        private String cd(String remoteDirectory) throws SftpException {
            String relativeDir = remoteDirectory;
            if (!StringUtil.isEmpty(relativeDir)) {
                relativeDir = relativeDir.replaceAll("\\\\", "/").trim();
                String absoluteDir = (sftp.getHome() + "/" + relativeDir).replaceAll("//", "/");
                sftp.cd(absoluteDir);
            }
            return relativeDir;
        }

        /**
         * 删除文件
         *
         * @param remoteDirectory 要删除文件所在目录
         * @param deleteFile      要删除的文件
         */
        public void delete(String remoteDirectory, String deleteFile) throws SftpException {
            this.cd(remoteDirectory);
            sftp.rm(deleteFile);
        }


        /**
         * 列出目录下的文件
         *
         * @param remoteDirectory 要列出的目录
         */
        public Vector<?> listFiles(String remoteDirectory) throws SftpException {
            sftp.cd(sftp.getHome());
            return sftp.ls(remoteDirectory.replaceAll("\\\\", "/").replaceAll("//", "/"));
        }

        public void closeSFTP() {
            if (sftp != null) {
                if (sftp.isConnected()) {
                    sftp.disconnect();
                }
            }
        }

    }


    public static void main(String[] args) throws SftpException, IOException {
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setUserName("sftpuser");
        sftpConfig.setPassword("sftpuser");
        sftpConfig.setHost("192.168.214.10");
        sftpConfig.setPort(22);

        SftpService sftpService = new SftpService(sftpConfig);

        Sftp sftp = sftpService.connectSftp();
        sftp.upload("sftpuser/t1/t2", "a.pdf", Paths.get("d:\\tmp\\a_upload.pdf"));

        Sftp sftp1 = sftpService.connectSftp();
        sftp1.download("sftpuser/t1/t2", "a.pdf", Paths.get("d:\\tmp\\a_download.pdf"));
//        sftp1.delete("sftpuser", "b.txt");

        sftp1.closeSFTP();
        sftp.closeSFTP();

        sftpService.closeSession();
    }

}
