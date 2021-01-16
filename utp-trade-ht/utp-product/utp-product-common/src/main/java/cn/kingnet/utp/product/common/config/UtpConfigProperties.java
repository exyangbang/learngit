package cn.kingnet.utp.product.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description : 平台属性配置
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/5 18:16
 */
@Configuration
public class UtpConfigProperties {

    @Value("${cn.kingnet.utp.sign-type}")
    private String signType;

    @Value("${cn.kingnet.utp.private-key}")
    private String privateKey;

    @Value("${cn.kingnet.utp.public-key}")
    private String publicKey;

    /**
     * 后管设置保护上传公私钥的3des加密 秘钥key
     */
    @Value("${cn.kingnet.utp.manage.des-key}")
    private String desKey;

    @Value("${cn.kingnet.utp.download.batch-dir}")
    private String downloadBatchDir;

    @Value("${cn.kingnet.utp.download.settle-dir}")
    private String downloadSettleDir;

    @Value("${cn.kingnet.utp.upload.settle-split-dir}")
    private String uploadSettleSplitDir;

    /**
     * 是否启用华通数字签名 0-不启用,其他全部启用
     */
    @Value("${cn.kingnet.utp.ht-sign-flag}")
    private String htSignFlag = "1";
    /**
     * 华通数字签名加签证书名称
     */
    @Value("${cn.kingnet.utp.sign-cert-name}")
    private String signCertName;

    /**
     * 华通数字签名核签证书名称
     */
    @Value("${cn.kingnet.utp.verify-cert-name}")
    private String verifyCertName;

    @Value("${cn.kingnet.utp.upload.file-dir}")
    private String uploadFileDir;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getDesKey() {
        return desKey;
    }

    public void setDesKey(String desKey) {
        this.desKey = desKey;
    }

    public String getDownloadBatchDir() {
        return downloadBatchDir;
    }

    public void setDownloadBatchDir(String downloadBatchDir) {
        this.downloadBatchDir = downloadBatchDir;
    }

    public String getDownloadSettleDir() {
        return downloadSettleDir;
    }

    public void setDownloadSettleDir(String downloadSettleDir) {
        this.downloadSettleDir = downloadSettleDir;
    }

    public String getUploadSettleSplitDir() {
        return uploadSettleSplitDir;
    }

    public void setUploadSettleSplitDir(String uploadSettleSplitDir) {
        this.uploadSettleSplitDir = uploadSettleSplitDir;
    }

    public String getHtSignFlag() {
        return htSignFlag;
    }

    public void setHtSignFlag(String htSignFlag) {
        this.htSignFlag = htSignFlag;
    }

    public String getSignCertName() {
        return signCertName;
    }

    public void setSignCertName(String signCertName) {
        this.signCertName = signCertName;
    }

    public String getVerifyCertName() {
        return verifyCertName;
    }

    public void setVerifyCertName(String verifyCertName) {
        this.verifyCertName = verifyCertName;
    }

    public String getUploadFileDir() {
        return uploadFileDir;
    }

    public void setUploadFileDir(String uploadFileDir) {
        this.uploadFileDir = uploadFileDir;
    }
}
