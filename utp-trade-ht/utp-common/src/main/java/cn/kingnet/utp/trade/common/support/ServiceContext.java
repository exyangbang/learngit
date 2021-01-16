package cn.kingnet.utp.trade.common.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

/**
 * @author zhongli
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceContext {
    /**
     * 请求报文
     *
     * @return
     */
    Class<?> bodyClass() default HashMap.class;

}
