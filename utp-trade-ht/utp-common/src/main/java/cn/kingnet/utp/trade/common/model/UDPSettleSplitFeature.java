package cn.kingnet.utp.trade.common.model;

import cn.kingnet.utp.trade.common.enums.TransStatus;
import lombok.Getter;

/**
 * @Description UDP云平台清算分账文件相关特征
 * @Author WJH
 * @Date 2018年11月01日
 */
public class UDPSettleSplitFeature {

    /**
     *  清算分账文件格式
     * H|settle|20180101|222
     * 清算日期|商户号|金额|账期|账户类型|收款人账号|收款人名称|收款人清算行行号|备注信息|扩展字段1|扩展字段2|扩展字段3
     *
     */


    /**
     * 清算分账结果文件格式
     * H|settle_result|20180101|222
     * 清算日期|商户号|金额|账期|账户类型|收款人账号|收款人名称|收款人清算行行号|结果|失败信息
     */

    public static final String HEADMARK = "H";

    /**
     * 清算分账文件存储根目录
     */
    private String settleSplitDir;
    /**
     * 服务商Id：udp平台分配
     */
    private String serviceProvider;
    /**
     * 服务商Id对应校验码 udp平台分配
     */
    private String validateCode;

    /**
     * 清算分账结果推送地址
     */
    private String settleResultUrl;

    /**
     * 回调文件存储根目录
     */
    private String resultDir;

    @Getter
    public  enum TxType {

        SETTLE("settle", "清算分账文件"),
        SETTLE_RESULT("settle_result", "清算分账回盘文件"),
        RECONCILE("reconcile", "平台对账文件"),
        INCOME("income", "平台账户入金明细文件"),
        OUTCOME("outcome", "平台账户出金明细文件"),
        ENTRY("entry", "入账文件"),
        ENTRY_RESULT("entry_result", "入账结果文件"),
        ACCRECONCILE("accReconcile", "账户对账文件"),
        PAY_FLOW("pay_flow", "支付流水文件"),
        SPLIT_PAY("split_pay", "分账支付关联补登文件"),
        SUBACCOUNT_PAY_FLOW("subaccount_pay_flow", "子账户入金流水报备文件"),
        SUBACCOUNT_SETTLE("subaccount_settle", "子账户清算分账文件"),
        SUBACCOUNT_SETTLE_RESULT("subaccount_settle_result", "子账户清分回盘文件"),
        MIXPAY_FLOW("mixpay_flow", "上送融合支付流水文件"),
        ;
        /**
         * 标识文件类型|业务类型
         */
        private String type;
        private String desc;

        TxType(String type, String desc) {
            this.type = type;
            this.desc = desc;
        }

    }


    @Getter
    public  enum ResultType {

        SUCCESS("S", "成功"),
        ERROR("E", "失败"),
        OTHER("O", "其他"),;

        private String type;
        private String desc;

        ResultType(String type, String desc) {
            this.type = type;
            this.desc = desc;
        }

    }


    /**
     * @param transStatus 交易状态
     * @return UDP响应结果：S=成功 E=失败 [O=其他]
     */
    public static String transStatus2UDP(String transStatus) {
        if (TransStatus.TRADE_SUCCESS.name().equals(transStatus)) {
            return ResultType.SUCCESS.type;
        }
        if (TransStatus.TRADE_FAILURE.name().equals(transStatus)
                || TransStatus.TRADE_ERROR.name().equals(transStatus)
                ) {
            return ResultType.ERROR.type;
        }

        return ResultType.OTHER.type;
    }

    public static String buildUploadFileName(String providerCode,String settleDate, String batchId) {
        return String.format("%s%s%s.txt", providerCode, settleDate, batchId);
    }

    public static String buildResultFileName(String providerCode,String settleDate, String batchId) {
        return String.format("%s%s%s_result.txt",providerCode, settleDate, batchId);
    }

    public String getSettleSplitDir() {
        return settleSplitDir;
    }

    public void setSettleSplitDir(String settleSplitDir) {
        this.settleSplitDir = settleSplitDir;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getSettleResultUrl() {
        return settleResultUrl;
    }

    public void setSettleResultUrl(String settleResultUrl) {
        this.settleResultUrl = settleResultUrl;
    }

    public String getResultDir() {
        return resultDir;
    }

    public void setResultDir(String resultDir) {
        this.resultDir = resultDir;
    }
}
