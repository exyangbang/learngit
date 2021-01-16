package cn.kingnet.utp.trade.common.validator;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Description : 常用校验工具类
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/18 10:29
 */
public class ValidateUtils {


    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    /**
     * 手机号码
     */
    public static final String MOBILE = "^((10[0-9])|(11[0-9])|(12[0-9])|(13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";

    /**
     * 固定电话
     */
    public static final String PHONE = "^0.+\\d$";

    /**
     * 电子邮箱
     */
    public static final String EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 字母，数字下划线，中划线
     */
    public static final String ABC = "[a-zA-Z0-9_-]*";

    /**
     * 特殊字符
     */
    public static final String STR_SPECIAL = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】《》《》｛｝＼‘；：”“’。，、？]";
    /**
     * 排除掉中括号（中英文）的特殊字符
     */
    public static final Pattern STR_SPECIALExcludeParenthesis = Pattern.compile("[`~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*——+|{}【】《》《》｛｝＼‘；：”“’。，、？]");

    /**
     * 身份证正则表达式
     */
    public static final String IDCARD = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})" +
            "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" +
            "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";

    /**
     * 匹配数字组成的字符串
     */
    public static final String STR_NUM = "^[0-9]+$";
    /**
     * 0或正整数
     */
    public static final String INTEGER_NEGATIVE = "^[1-9]\\d*|0$";
    /**
     * 正整数（不包括0）
     */
    public static final String POSITIVE_INTEGER = "^[1-9]\\d*$";

    public static final String HTTP_URL = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$";

    public static final Pattern CHINESE_REGEX = Pattern.compile("[\\u4e00-\\u9fa5]");

    /**
     * 营业执照号码为18位阿拉伯数字或者大写英文字母。
     */
    public static final Pattern BIS_CODE_REGEX = Pattern.compile("^[0-9A-Z]{18}$");
    /**
     * 性别 M男 F女
     */
    public static final String SEX[] = {"M", "F"};

    /**
     * 校验对象不为NULL
     *
     * @param value
     * @param message 错误提示信息
     */
    public static void notNull(Object value, String message) {
        if (value == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, message);
        }
    }

    /**
     * 校验字符串不为空或等于null字符串
     *
     * @param value
     * @param message 错误提示信息
     */
    public static void hasText(String value, String message) {
        if (!StringUtils.hasText(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, message + "不能为空!");
        }
    }

    /**
     * 校验字段最大长度
     *
     * @param value
     * @param maxLength 最大长度
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void maxLength(String value, int maxLength, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            if (StringUtil.length(value) > maxLength) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("%s长度不正确,最大长度：%d,实际长度%d", fieldName, maxLength, StringUtil.length(value)));
            }
        }
    }

    /**
     * 校验字段长度区间
     *
     * @param value
     * @param maxLength 最大长度
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void minMaxLength(String value, int minLength, int maxLength, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            if (StringUtil.length(value) > maxLength) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("%s长度不正确,最大长度：%d,实际长度%d", fieldName, maxLength, StringUtil.length(value)));
            }
            if (StringUtil.length(value) < minLength) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("%s长度不正确,最小长度：%d,实际长度%d", fieldName, minLength, StringUtil.length(value)));
            }
        }
    }

    /**
     * 正则表达式验证
     *
     * @param value
     * @param regex   正则表达式
     * @param message 错误提示信息
     */
    public static void regexValid(String value, String regex, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        boolean isMatch = matcher.matches();
        if (!isMatch) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, message);
        }
    }

    /**
     * 手机号码校验
     *
     * @param mobile    手机号码
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void mobileValid(String mobile, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(mobile)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(mobile)) {
            regexValid(mobile, MOBILE, fieldName + "格式不正确!");
        }
    }

    /**
     * 电子邮箱校验
     *
     * @param email     电子邮箱
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void emailValid(String email, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(email)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(email)) {
            regexValid(email, EMAIL, fieldName + "格式不正确!");
        }
    }

    /**
     * 校验字段由字母数字下划线或中划线组成
     *
     * @param value
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void abcValid(String value, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            regexValid(value, ABC, fieldName + "格式不正确!");
        }
    }

    public static void abcValid(String value, int maxLength, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            maxLength(value, maxLength, required, fieldName);
            regexValid(value, ABC, fieldName + "格式不正确!");
        }
    }

    /**
     * 判断字符串是否包含特殊字符
     *
     * @param value     字符串
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void notSpecialStr(String value, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            Pattern pattern = Pattern.compile(STR_SPECIAL);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "包含特殊字符!");
            }
        }
    }

    public static void notSpecialStrExcludeParenthesis(String value, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            Matcher matcher = STR_SPECIALExcludeParenthesis.matcher(value);
            if (matcher.find()) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "包含特殊字符!");
            }
        }
    }

    /**
     * 身份证验证方式
     *
     * @param value
     * @param required
     * @param fieldName
     */
    public static void idCardValid(String value, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            regexValid(value, IDCARD, fieldName + "不正确!");
        }
    }

    /**
     * 匹配数字
     *
     * @param value
     * @param required
     * @param fieldName
     */
    public static void isNum(String value, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            regexValid(value, STR_NUM, fieldName + "只能是数字组成!");
        }
    }

    /**
     * 匹配正整数
     *
     * @param value
     * @param required
     * @param fieldName
     */
    public static void isIntegerNegative(String value, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            regexValid(value, INTEGER_NEGATIVE, fieldName + "只能是零和正整数!");
        }
    }

    public static void isIntegerNegative(String value, int maxLength, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            maxLength(value, maxLength, required, fieldName);
            regexValid(value, INTEGER_NEGATIVE, fieldName + "只能是零和正整数!");
        }
    }

    /**
     * 校验日期格式为yyyyMMdd
     *
     * @param yyyyMMdd
     * @param required
     * @param fieldName
     */
    public static void isYyyyMMdd(String yyyyMMdd, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(yyyyMMdd)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(yyyyMMdd)) {
            LocalDate localDate = null;
            try {
                localDate = LocalDate.parse(yyyyMMdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
            } catch (Exception e) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
            if (localDate == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
        }
    }

    /**
     * 校验日期格式为yyyy-MM-dd
     *
     * @param yyyyMMdd
     * @param required
     * @param fieldName
     */
    public static void isYyyy_MM_dd(String yyyyMMdd, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(yyyyMMdd)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(yyyyMMdd)) {
            LocalDate localDate = null;
            try {
                localDate = LocalDate.parse(yyyyMMdd, DateTimeFormatter.ISO_DATE);
            } catch (Exception e) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
            if (localDate == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
        }
    }

    /**
     * 校验日期时间为HHmmss
     *
     * @param HHmmss
     * @param required
     * @param fieldName
     */
    public static void isHHmmss(String HHmmss, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(HHmmss)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(HHmmss)) {
            LocalTime localTime = null;
            try {
                localTime = LocalTime.parse(HHmmss, DateTimeFormatter.ofPattern("HHmmss"));
            } catch (Exception e) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
            if (localTime == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
        }
    }

    public static void isHttpUrl(String httpUrl, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(httpUrl)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(httpUrl)) {
            regexValid(httpUrl, HTTP_URL, fieldName + "格式不正确!");
        }
    }

    /**
     * 校验性别
     *
     * @param sex
     * @param required
     * @param fieldName
     */
    public static void checkSex(String sex, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(sex)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(sex)) {
            boolean isExist = Arrays.asList(SEX).contains(sex);
            if (!isExist) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
        }
    }

    /**
     * 匹配正整数
     *
     * @param value
     * @param maxLength
     * @param required
     * @param fieldName
     */
    public static void isPositiveInteger(String value, int maxLength, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            maxLength(value, maxLength, required, fieldName);
            regexValid(value, POSITIVE_INTEGER, fieldName + "只能是正整数!");
        }
    }

    /**
     * 固定电话校验
     *
     * @param phone     手机号码
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void phoneValid(String phone, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(phone)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(phone)) {
            regexValid(phone, PHONE, fieldName + "格式不正确!");
            //提取固定电话字符串中数字，校验长度
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(phone);
            String realPhone = m.replaceAll("").trim();
            minMaxLength(realPhone, 10, 12, required, fieldName);
        }
    }

    /**
     * 校验字段是否为base64编码
     *
     * @param value
     * @param required  是否必填
     * @param fieldName 字段名称
     */
    public static void base64Valid(String value, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            if (!DataUtil.isBase64Format(value)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "格式不正确!");
            }
        }
    }

    /**
     * 至少包含minLength个汉字
     *
     * @param value
     * @param minLength
     * @param required
     * @param fieldName
     */
    public static void minChineseNum(String value, int minLength, boolean required, String fieldName) {
        if (required && StringUtil.isBlank(value)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不能为空!");
        }
        if (StringUtil.isNotBlank(value)) {
            int chineseNum = chineseNum(value);
            if (chineseNum < minLength) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + "不少于" + minLength + "个汉字");
            }
        }
    }

    private static int chineseNum(String value) {
        Matcher matcher = CHINESE_REGEX.matcher(value);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * 涉及身份证有效期的地方，校验如下规则：
     * 1、16周岁以下的和70周岁以上的拒绝开户；
     * 2、16（含）-25（含）周岁的，有效期不超过（系统当前年份+10）-12-31；
     * 3、26（含）-45（含）周岁的，有效期不超过（系统当前年份+20）-12-31；
     * 4、46（含）周岁以上的，有效期不超过（系统当前年份+20）-12-31或者是9999-12-31；
     * 5、所有情况下身份证有效期不能晚于系统当前日期，否则提示身份证已经过期。
     *
     * @param idIndate
     */
    public static void validIdIndate(String idIndate, String idCode, boolean required, String fieldName) {
        isYyyy_MM_dd(idIndate, required, fieldName);
        if (required && StringUtil.isBlank(idIndate)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + " 不能为空");
        }
        if (StringUtil.isNotBlank(idIndate)) {
            LocalDate inLocalDate = LocalDate.parse(idIndate, DateTimeFormatter.ISO_DATE);
            LocalDate birthLocalDate = LocalDate.parse(getBirthDate(idCode), DateTimeFormatter.ISO_DATE);
            LocalDate curLocalDate = LocalDate.now();
            LocalDate curLastDateOfYear = LocalDate.now().with(TemporalAdjusters.lastDayOfYear());

            if (inLocalDate.isBefore(curLocalDate)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, fieldName + " 不能晚于系统当前日期(身份证已经过期)");
            }

            long age = Period.between(birthLocalDate, curLocalDate).getYears();
            if (age < 0) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "出生日期不能超过当前系统日期");
            }
            if (age < 16 || age > 70) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "16周岁以下的和70周岁以上的拒绝开户");
            } else if (age >= 16 && age <= 25) {
                LocalDate maxIndateLocalDate = curLastDateOfYear.plusYears(10);
                if (inLocalDate.isAfter(maxIndateLocalDate)) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "16（含）-25（含）周岁的，有效期不超过（系统当前年份+10）-12-31");
                }
            } else if (age >= 26 && age <= 45) {
                LocalDate maxIndateLocalDate = curLastDateOfYear.plusYears(20);
                if (inLocalDate.isAfter(maxIndateLocalDate)) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "26（含）-45（含）周岁的，有效期不超过（系统当前年份+20）-12-31");
                }
            } else if (age >= 46 && age <= 70) {
                LocalDate maxIndateLocalDate = curLastDateOfYear.plusYears(20);

                if (inLocalDate.isAfter(maxIndateLocalDate) && !idIndate.equals("2099-12-31") && !idIndate.equals("9999-12-31")) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "46（含）周岁以上的，有效期不超过（系统当前年份+20）-12-31或者是9999-12-31");
                }
            }


        }
    }

    /**
     * @param idCode 身份证
     * @return
     */
    public static String getBirthDate(String idCode) {
        if (idCode != null && idCode.length() > 14) {
            String birthDate = idCode.substring(6, 10).concat("-").concat(idCode.substring(10, 12)).concat("-").concat(idCode.substring(12, 14));
            isYyyy_MM_dd(birthDate, true, "身份证截取出生日期");
            return birthDate;
        }
        throw new TradeException(HttpRespStatus.BAD_REQUEST, "身份证号码格式错误");
    }

    public static void validBicCode(String bicCode) {
        if (StringUtil.isEmpty(bicCode) || !BIS_CODE_REGEX.matcher(bicCode).matches()) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "营业执照号码必须是18位阿拉伯数字或者大写英文字母组合");
        }
    }

    /**
     * 校验实体参数
     */
    public static <T> void validate(T entity) {
        if (entity == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "参数对象不能为空");
        }
        Set<ConstraintViolation<T>> set = null;
        try {
            set = ValidateUtils.validator.validate(entity);
        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "参数校验异常：" + e.getMessage(), e);

        }
        if (set != null && !set.isEmpty()) {
            String errorMsg = set.stream().map(cv -> String.format("[%s]%s,当前值为[%s]", cv.getPropertyPath(), cv.getMessage(), cv.getInvalidValue())).collect(Collectors.joining(";"));
            throw new TradeException(HttpRespStatus.BAD_REQUEST, errorMsg);
        }
    }


}
