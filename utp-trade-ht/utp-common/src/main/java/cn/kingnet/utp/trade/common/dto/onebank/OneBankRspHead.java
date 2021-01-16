package cn.kingnet.utp.trade.common.dto.onebank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description : 描述
 * @Author : linkaigui
 * @Create : 2019/3/15 9:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneBankRspHead implements Serializable {
    /**
     * 请求渠道号	N	X	由电子账户平台分配
     */
    private String reqchid;
    /**
     * 请求时间	N	X（14）	yyyymmddhhmmss
     */
    private String reqtime;
    /**
     * 请求日志号	N	X（LT50）	渠道调用方生成渠道内唯一编号
     */
    private String reqno;
    /**
     * 业务处理标志位	N		"0000业务处理正常 其他业务处理标志见接口定义"
     */
    private String bzflag;
    /**
     * 失败信息	Y		处理失败详细信息
     */
    private String errmsg;
}
