package cn.kingnet.utp.sdk.account.tools;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class SHA1 {
    public SHA1() {
    }

    public static String gen(String... arr) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        String[] arr$ = arr;
        int len$ = arr.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            String a = arr$[i$];
            sb.append(a);
        }

        return DigestUtils.sha1Hex(sb.toString());
    }

    public static String genWithAmple(String... arr) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; ++i) {
            String a = arr[i];
            sb.append(a);
            if (i != arr.length - 1) {
                sb.append('&');
            }
        }

        return DigestUtils.sha1Hex(sb.toString());
    }
}
