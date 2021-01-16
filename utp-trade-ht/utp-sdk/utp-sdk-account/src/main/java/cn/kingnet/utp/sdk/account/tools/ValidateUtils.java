package cn.kingnet.utp.sdk.account.tools;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
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
     * 校验实体参数
     */
    public static <T> void validate(T entity) {
        if (entity == null) {
            throw new RuntimeException("参数对象不能为空");
        }
        Set<ConstraintViolation<T>> set = null;
        try {
            set = ValidateUtils.validator.validate(entity);
        } catch (Exception e) {
            throw new RuntimeException("参数校验异常：" + e.getMessage(), e);

        }
        if (set != null && !set.isEmpty()) {
            String errorMsg = set.stream().map(cv -> String.format("[%s]%s,当前值为[%s]", cv.getPropertyPath(), cv.getMessage(), cv.getInvalidValue())).collect(Collectors.joining(";"));
            throw new RuntimeException(errorMsg);
        }
    }


}
