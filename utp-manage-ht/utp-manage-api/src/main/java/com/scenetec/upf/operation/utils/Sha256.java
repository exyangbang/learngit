package com.scenetec.upf.operation.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jason
 * @Description: TODO
 * @date 2018-12-20 16:17
 */
public class Sha256 {
    /**
     * 对明文密码进行加密
     * @param pwd
     * @param accountId
     * @return
     * @throws Exception
     */
    public static String shaEncode(String pwd,String accountId) {
        try {
            String str=String.format("%s{%s}", pwd,accountId);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes("GBK"));
            StringBuffer strHexString = new StringBuffer();
            for (byte b : md.digest()) {
                strHexString.append(String.format("%02X", b));
            }
            return strHexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }



}
