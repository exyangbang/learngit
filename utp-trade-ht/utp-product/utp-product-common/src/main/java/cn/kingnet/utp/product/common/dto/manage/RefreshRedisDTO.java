package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description
 * @Author WJH
 * @Date 2019/07/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefreshRedisDTO extends BaseInnerManageReqDTO {

    /**
     * 类型：01 渠道总额度 02 客户号总限额及单笔限额 03 客户号下子账户单日|单笔限额
     */
    private String type;
    /**
     * 操作时间: yyyyMMddHHmmss
     */
    private String time;
    /**
     * 操作类型：1:新增 2:修改 3:删除
     */
    private String operateType;

    private ChannelLimitAmountVO channelLimitAmountVO;
    private IndustryLimitAmountVO industryLimitAmountVO;
    private SubAccountLimitAmountVO subAccountLimitAmountVO;


    @Data
    public static class ChannelLimitAmountVO {
        private String channelCode;
        /**
         * 渠道限制总额度
         **/
        private Long limitTotalAmount;
    }

    @Data
    public static class IndustryLimitAmountVO {
        /**
         * 客户号限额表主键Id
         */
        private Long industryLimitId;
        /**
         * 客户号
         */
        private String industryCode;

    }

    @Data
    public static class SubAccountLimitAmountVO {
        /**
         * 子账户限额主键Id
         */
        private Long subAccountLimitId;
        private String industryCode;
        private String subAccount;

    }

    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "type=".concat(type), "time=".concat(time), "operateType=".concat(operateType)};
    }


}
