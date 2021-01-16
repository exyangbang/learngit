package cn.kingnet.utp.sdk.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class IdGenerate {

    /**
     * 主机和进程的机器码
     */
    private static final Sequence worker = new Sequence();

    public static long getId() {
        return worker.nextId();
    }

    /**
     * @param len 保留位数
     * @return
     */
    public static String getIdStr(int len) {
        long tmpId = getId();
        if (String.valueOf(tmpId).length() < len) {
            return String.format("%0" + len + "d", tmpId);
        }
        return String.valueOf(tmpId).substring(String.valueOf(tmpId).length() - len);
    }

    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String mockUtpClientTransId() {
        return new StringBuilder()
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHH")))
                .append("UTP").append(getId()).toString();
    }

}
