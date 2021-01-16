package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : orc身份识别
 * @Author : WJH
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class OneBankOnlineCheckReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 客户端流水号 M
     */
    private String clientTradeId;
    /**
     * 公民证件号码
     */
    private String personId;
    /**
     * 公民姓名
     */
    private String personName;
    /**
     * 业务发生地
     * 为客户办理业务时的所在地，6位的行政区划编号，如深圳市 440300
     */
    private String businessPlace;

    /**
     * business_type	业务类型	STRING	2		     Y	"01 银行账户业务
     * 02 信贷及征信业务
     * 03 支付结算业务
     * 04 反洗钱业务
     * 05 其他业务"
     */
    private String businessType;



}
