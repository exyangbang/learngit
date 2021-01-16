package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : 华通内部户入金通知
 * @Author : linkaigui
 * @Create : 2019/3/14 19:39
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankAccountIncomeNoticeRespDTO extends SpBaseResponse implements Serializable {

    private OneBankRspHead rspHead;

    private RspBody rspBody;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RspBody implements Serializable {
        //X	balance	账户处理后余额
        private Long balance;
    }
}
