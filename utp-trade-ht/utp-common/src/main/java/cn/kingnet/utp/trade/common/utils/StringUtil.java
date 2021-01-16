package cn.kingnet.utp.trade.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 字符串工具类
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/8 9:57
 */
public class StringUtil extends StringUtils {

    /**
     * 首字母转换为小写
     * @param str
     * @return
     */
    public static String toLowerCaseFirstOne(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * 首字母转换为大写
     * @param str
     * @return
     */
    public static String toUpperCaseFirstOne(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * Object去掉前后空格
     * @param str
     * @return
     */
    public static String objTrimToEmpty(final Object str) {
        if (str == null) {
            return EMPTY;
        }
        return StringUtils.trimToEmpty(str.toString());
    }

//    /**
//     * 参数拼接
//     *
//     * @param reqMap 请求参数
//     * @return 请求参数串
//     */
//    public static String getSortString(Map<String, String> reqMap) {
//        return reqMap.entrySet().stream()
//                .filter(entry -> entry.getKey() != null && entry.getValue() != null && !StringUtils.isEmpty(entry.getValue()))
//                .sorted(Comparator.comparing(Map.Entry::getKey))
//                .map(entry -> entry.getKey() + "=" + entry.getValue())
//                .reduce((a, b) -> a + "&" + b)
//                .orElse("");
//    }
//

    /**
     * 参数拼接   Map<String,String> --> Map<String,Object>
     * @param paramsMap 请求参数
     * @return 请求参数串
     */
    public static String getSortString(Map<String, Object> paramsMap) {
        return paramsMap.entrySet().stream()
                .filter(entry -> !StringUtils.isEmpty(entry.getKey()) && null != entry.getValue() && !StringUtils.isEmpty(String.valueOf(entry.getValue())))
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(entry -> entry.getKey() + "=" + String.valueOf(entry.getValue()))
                .reduce((a, b) -> a + "&" + b)
                .orElse("");
    }


    /**
     * <p>
     * 字符串下划线转驼峰格式
     * </p>
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    public static String underlineToCamel(String param) {
        if (StringUtils.isEmpty(param)) {
            return "";
        }
        String temp = param.toLowerCase();
        int len = temp.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = temp.charAt(i);
            if (c == '_') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(temp.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * <p>
     * 字符串驼峰转下划线格式
     * </p>
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    public static String camelToUnderline(String param) {
        if (StringUtils.isEmpty(param)) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                sb.append('_');
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }


    /**
     * 将url参数转换成map
     * @param param aa=11&bb=22&cc=33
     * @return
     */
    public static Map<String, String> getUrlParams(String param) {
        Map<String, String> map = new HashMap<String, String>(0);
        if (StringUtils.isBlank(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

    /**
     * 将map转换成url
     * @param map
     * @return
     */
    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }

    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     * @param value 指定字符串
     * @return 字符串的长度
     */
    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < value.length(); i++) {
            String temp = value.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }

    /**
     * 根据身份证号码倒数第二位，奇数偶数判断
     * @param idCode
     * @return 奇数-M-男 偶数-F-女
     */
    public static String getSexByIdCode(String idCode) {
        Integer sex = Integer.valueOf(idCode.substring(idCode.length() - 2, idCode.length() - 1));
        if ((sex & 1) == 1) {
            return "M";
        } else {
            return "F";
        }
    }

}
