package cn.kingnet.utp.trade.common.dto.onebank;

import lombok.*;

import java.io.Serializable;

/**
 * @Description : 华通异步回调响应
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 10:20
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankTransferCallbackRespDTO implements Serializable {
    private String respCode;
    private String respMsg;
}
