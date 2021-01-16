package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuerySubAccountSettleSplitRespDTO extends BaseResponseDTO {

    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 清算日期
     */
    private String settleDate;

    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 用户账户（出金子账户）目前仅支持待结算账户
     */
    private String userAccount;

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success;
    /**
     * 清算结果文件域			M	回执文件byte[]经过
     * defalter压缩后再Base64编码字符串
     * 回执文件格式详见：
     * 子账户清算分账结果格式
     */
    private String content;


}
