package cn.kingnet.utp.trade.common.dto.onebank;

import lombok.*;

import java.io.Serializable;

/**
 * @Description : 华通异步回调报文
 *          "payTransType": "04",
 *         "newHoldId": "",
 *         "oldReqTime": "142222",
 *         "oldReqDate": "20180727",
 *         "oldBizSeqNo": "6458504398833188864",
 *         "settleDate": "20181018",
 *         "respMsg": "扣客户账成功",
 *         "returnAmount": "",
 *         "respCode": "PCC00000",
 *         "oldTransId": "6458504398833188864",
 *         "payRouteCode": "PCC",
 *         "payTranStatus": "PR03"
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 10:11
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankTransferCallbackReqDTO implements Serializable {
    private String payTransType;
    private String newHoldId;
    private String oldReqTime;
    private String oldReqDate;
    private String oldBizSeqNo;
    private String settleDate;
    private String respMsg;
    private String returnAmount;
    private String respCode;
    private String oldTransId;
    private String payRouteCode;
    private String payTranStatus;
}
