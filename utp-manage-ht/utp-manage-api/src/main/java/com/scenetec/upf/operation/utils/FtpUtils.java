package com.scenetec.upf.operation.utils;

import com.scenetec.upf.operation.config.FtpConfig;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/12 下午3:18
 */
@Component
public class FtpUtils {

    private Logger logger = LoggerFactory.getLogger(FtpUtils.class);

    @Resource
    private FtpConfig ftpConfig;

    public boolean uploadFile(String originFileName,InputStream input, String path){
        if (logger.isDebugEnabled()) {
            logger.debug("开始上传文件: " + originFileName);
        }
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect(ftpConfig.getAddress(), ftpConfig.getPort());
            ftp.login(ftpConfig.getUsername(), ftpConfig.getPassword());
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                logger.error("连接失败: " + ftp.getReplyString());
                throw new SystemRuntimeException(ErrorCode.BSMAU003);
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(ftpConfig.getBasePath()+path)) {
                //如果目录不存在创建目录
                String[] dirs = path.split("/");
                String tempPath = "";
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return false;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            boolean isSuccess  =ftp.storeFile(originFileName,input);
            if (!isSuccess) {
                logger.error("上传失败: "  + ftp.getReplyString());
            }
            input.close();
            ftp.logout();
            if (logger.isDebugEnabled()) {
                logger.debug("上传图片完成: " + originFileName);
            }
            return isSuccess;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemRuntimeException(ErrorCode.BSMAU003);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    // ignore
                }
            }
        }
    }
}
