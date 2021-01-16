package cn.kingnet.utp.trade.common.utils;

import cn.kingnet.utp.trade.common.enums.TradeType;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2018/5/16
 *
 * @author by linkaigui
 */
public class IdGenerate {

    /**
     * 主机和进程的机器码
     */
    private static final Sequence worker = new Sequence();

    final static int MAX = 10000;

    final static int length = String.valueOf(MAX).length();

    static AtomicInteger adder = new AtomicInteger();

    public static long getId() {
        return worker.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(worker.nextId());
    }

    /**
     *
     * @param len 保留位数
     * @return
     */
    public static String getIdStr(int len) {
        long tmpId = getId();
        if(String.valueOf(tmpId).length()<len) {
            return String.format("%0"+len+"d",tmpId);
        }
        return String.valueOf(tmpId).substring(String.valueOf(tmpId).length()-len);
    }
    public static long getId(int len) {
        return Long.valueOf(getIdStr(len));
    }

    /**
     * <p>
     * 获取去掉"-" UUID
     * </p>
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取16位随机字符串
     * @return String
     */
    public static String getUUID16() {
        String uuid = UUID.randomUUID().toString();
        char[] cs = new char[32];
        char c = 0;
        for (int i = uuid.length() / 2, j = 1; i-- > 0; ) {
            if ((c = uuid.charAt(i)) != '-') {
                cs[j++] = c;
            }
        }
        String uid = String.valueOf(cs).trim();
        return uid;
    }

    public static String next(){
        StringBuffer stringBuffer = new StringBuffer();
        long value = adder.incrementAndGet();
        if(value > MAX){
            adder.set(0);
        }
        String str = value + "";
        for (int i = 0;i < length - str.length();i++){
            stringBuffer.append("0");
        }
        stringBuffer.append(str);
        return System.currentTimeMillis() + "" + stringBuffer.toString();
    }

    public static String next(TradeType tradeType){
        return String.format("%02d%s",tradeType.ordinal(),next());
    }

    public static String generateServerTransId(final String dfa,final String systemId){
        return new StringBuilder()
                .append(DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE))
                .append(dfa)
                .append(systemId)
                .append(IdGenerate.getIdStr(18))
                .toString();
    }


}
