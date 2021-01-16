package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Description 企业客户注册资金信息
 * @Author WJH
 * @Date 2019/10/30
 */
@Getter@Setter
public class RegisterCapital implements Serializable {

    /**
     * 货币类型	STRING(10)	Y
     */
    private String currencyTpCd = "CNY";
    /**
     * 注册资金	DECIMAL(25,7)	Y
     */
    private BigDecimal registerAmt;

    public RegisterCapital() {
    }

    public RegisterCapital(String registerAmt) {
        //注册资金外部单位分，转换成单位元（四舍五入）
        try {
            this.registerAmt = new BigDecimal(registerAmt).divide(new BigDecimal("100"),2, RoundingMode.HALF_UP);
        } catch (Exception e) {
           throw new RuntimeException("注册资金["+registerAmt+"]转换异常");
        }
    }
}
