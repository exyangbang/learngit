package cn.kingnet.utp.trade.common.exception;

/**
 * @Description : 签名加解密异常
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/7 18:07
 */
public class EncryptException extends Exception{

    private static final long serialVersionUID = 1L;

    public EncryptException(String message) {
        super(message);
    }

    public EncryptException(String message, Throwable parent) {
        super(message, parent);
    }
}
