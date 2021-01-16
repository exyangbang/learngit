package cn.kingnet.utp.trade.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.util.Base64;

@SuppressWarnings({"restriction"})
public class DesUtil {

    /**
     * 3DESECB加密,key必须是长度大于等于 3*8 = 24 位
     *
     * @param src
     * @param key
     * @return
     */
    public static String encryptThreeDESECB(final String src, final String key) {
        try {
            final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
            final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            final SecretKey securekey = keyFactory.generateSecret(dks);

            final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            final byte[] b = cipher.doFinal(src.getBytes());
            return Base64.getEncoder().encodeToString(b).replaceAll("\r", "").replaceAll("\n", "");
        } catch (Exception e) {
            throw new RuntimeException("3des 加密异常：", e);
        }

    }

    /**
     * 3DESECB解密,key必须是长度大于等于 3*8 = 24 位
     *
     * @param src
     * @param key
     * @return
     */
    public static String decryptThreeDESECB(final String src, final String key) {
        try {
            final byte[] bytesrc = Base64.getDecoder().decode(src);
            // --解密的key
            final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
            final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            final SecretKey securekey = keyFactory.generateSecret(dks);

            // --Chipher对象解密
            final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, securekey);
            final byte[] retByte = cipher.doFinal(bytesrc);

            return new String(retByte);
        } catch (Exception e) {
            throw new RuntimeException("3des 解密异常：", e);
        }
    }


}
