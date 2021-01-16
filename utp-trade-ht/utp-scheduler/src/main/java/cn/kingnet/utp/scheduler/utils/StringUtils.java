package cn.kingnet.utp.scheduler.utils;

import cn.kingnet.utp.trade.common.utils.StringUtil;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String TIME_PATTERN = "yyyyMMddHHmmss";
    public static final String DATE_PATTERN = "yyyyMMdd";

    public static String getFormatPattern(long value, long minLength) {
        if (value < 0) {
            throw new IllegalArgumentException("格式值必须大于或等于0");
        }
        if (minLength <= 0) {
            throw new IllegalArgumentException("最小长度必须大于0");
        }
        String str = String.valueOf(value);
        long length = minLength;
        if (str.length() > length) {
            length = str.length();
        }
        StringBuffer sb = new StringBuffer();
        for (long i = 0; i < length; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 格式化时间 yyyyMMddHHmmssSSS
     *
     * @param date
     * @return
     */
    public static String formatMsecTime(Date date) {
        return format(date, "yyyyMMddHHmmssSSS");
    }

    /**
     * 格式化时间 yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        return format(date, "yyyyMMddHHmmss");
    }

    /**
     * 格式化日期  yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return format(date, "yyyyMMdd");
    }

    /**
     * 生成uuid
     *
     * @param name
     * @return
     */
    public static String uuid(String name) {
        try {
            return java.util.UUID.nameUUIDFromBytes(name.getBytes("utf-8")).toString().toLowerCase();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成uuid
     *
     * @return
     */
    public static String generateUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }

    /**
     * 判断是否为空 null or empty string
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Object value) {
        return null == value || "".equals(value.toString());
    }

    /**
     * 将异常转换成字节流
     *
     * @param e
     * @return
     */
    public static byte[] getData(Exception e) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            e.printStackTrace(new PrintStream(out));
            return out.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }

    /**
     * 解析成日期
     *
     * @param text
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parse(String text, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(text);
    }

    public static Date parseTime(String text) throws ParseException {
        return parse(text, TIME_PATTERN);
    }

    /**
     * 转换银行卡号,仅显示前4位和后4位,其他由*号代替
     *
     * @param text
     * @return
     */
    public static String convertBankNo(String text) {
        if (null != text && text.length() > 8) {
            return String.format("%s****%s", text.substring(0, 4), text.substring(text.length() - 4, text.length()));
        }
        return text;
    }

    /**
     * 转换身份证号码,仅显示前4位和后4位,其他由*号代替
     *
     * @param text
     * @return
     */
    public static String convertIDCard(String text) {
        if (null != text && text.length() > 8) {
            return String.format("%s****%s", text.substring(0, 4), text.substring(text.length() - 4, text.length()));
        }
        return text;
    }

    /**
     * 转换姓名,若姓名为两位,则仅显示第一位，否则显示第一位和最后一位，其他由*号代替
     *
     * @param text
     * @return
     */
    public static String convertName(String text) {
        if (null == text || "".equals(text) || text.length() < 2) {
            return text;
        }
        if (text.length() == 2) {
            text = String.format("%s*", text.substring(0, 1));
        } else {
            text = String.format("%s*%s", text.substring(0, 1), text.substring(text.length() - 1, text.length()));
        }
        return text;
    }

    /**
     * 转换手机号码,显示前3位、后4位，中间字段由*号代替
     *
     * @param text
     * @return
     */
    public static String convertPhoneNumber(String text) {
        if (null != text && text.length() > 7) {
            return String.format("%s****%s", text.substring(0, 3), text.substring(text.length() - 4, text.length()));
        }
        return text;
    }

    /**
     * 转换日期,由yyyyMMdd转为yyyy-MM-dd格式
     *
     * @param text
     * @return
     */
    public static String convertDate(String text) {
        if (null != text && text.length() == 8) {
            return text.replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3");
        }
        return text;
    }

    /**
     * 转换时间,由HHmmss转为HH:mm:ss格式
     *
     * @param text
     * @return
     */
    public static String convertTime(String text) {
        if (null != text && text.length() == 6) {
            return text.replaceAll("(\\d{2})(\\d{2})(\\d{2})", "$1:$2:$3");
        }
        return text;
    }

    /**
     * 获取日期
     *
     * @param amount
     * @return
     */
    public static Date getDate(int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, amount);
        return cal.getTime();
    }

    /**
     * 获取字符串
     *
     * @param arr
     * @param index
     * @param defaultValue
     * @return
     */
    public static String getString(String[] arr, int index, String defaultValue) {
        String v = arr[index];
        if (null == v) {
            return defaultValue;
        }
        return v;
    }

    /**
     * 校验手机号
     *
     * @return
     */
    public static Boolean mobileValidate(String mobile) {
        final String pattern = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(mobile);
        return matcher.matches();
    }

    /**
     * 往后days天的日期
     *
     * @param dateStr   时间
     * @param formatter 格式
     * @param days      天数
     * @return
     */
    public static String plusDate(String dateStr, DateTimeFormatter formatter, int days) {
        return LocalDate.parse(dateStr, formatter).plusDays(days).format(formatter);
    }

    /**
     * 往前days天的日期
     *
     * @param dateStr   时间
     * @param formatter 格式
     * @param days      天数
     * @return
     */
    public static String minusDate(String dateStr, DateTimeFormatter formatter, int days) {
        return LocalDate.parse(dateStr, formatter).minusDays(days).format(formatter);
    }



}
