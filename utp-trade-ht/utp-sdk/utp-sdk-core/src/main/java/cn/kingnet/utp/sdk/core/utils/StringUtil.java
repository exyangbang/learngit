package cn.kingnet.utp.sdk.core.utils;

import java.util.Comparator;
import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2019/09/26
 */
public class StringUtil {


    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static String createSortString(Map<String, String> paramters) {
        String sortString = "";
        if (paramters != null && paramters.size() > 0) {
            sortString = paramters.entrySet().stream()
                    .filter(entity -> !isEmpty(entity.getKey()) && !isEmpty(entity.getValue()))
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .reduce((l, r) -> l + "&" + r)
                    .orElse("");
        }
        return sortString;
    }

}
