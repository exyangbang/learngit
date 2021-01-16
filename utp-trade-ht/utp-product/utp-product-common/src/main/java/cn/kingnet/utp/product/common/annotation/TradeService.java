package cn.kingnet.utp.product.common.annotation;

import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author Administrator on 2018-05-20.
 * @ 创建日期：2018-05-20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface TradeService {

    ProductCode productCode();//产品类型

    TradeType tradeType();//交易类型

    Class<?> reqClass();//请求对象CLASS

    Class<?> respClass();//响应对象CLASS

    boolean createTransFlow() default false;//创建交易流水

    boolean chargeFlag() default false;//手续费计算

    boolean isManageService() default false;//是否后管服务|验证规则不一致

    TransStatus successTransStatus() default TransStatus.PRE_CREATE;//交易2xx(流程无错误异常)对应的交易状态 默认处理中
}
