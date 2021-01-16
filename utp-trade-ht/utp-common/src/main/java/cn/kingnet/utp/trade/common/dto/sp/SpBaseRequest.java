package cn.kingnet.utp.trade.common.dto.sp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/11/01
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpBaseRequest implements Serializable {
    /**
     * 请求客户端流水号
     */
    private String clientTradeId;
    /**
     * yyyyMMdd
     */
    private String reqDate;
    /**
     * HHmmss
     */
    private String reqTime;
}
