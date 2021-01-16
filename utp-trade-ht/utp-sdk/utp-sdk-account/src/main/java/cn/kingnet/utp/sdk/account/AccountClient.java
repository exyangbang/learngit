package cn.kingnet.utp.sdk.account;

import cn.kingnet.utp.sdk.account.dto.*;
import cn.kingnet.utp.sdk.core.UtpClient;
import cn.kingnet.utp.sdk.core.auth.Authorization;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author WJH
 * @Date 2018年09月14日
 */
@Slf4j
public class AccountClient extends UtpClient {

    public AccountClient(Authorization authorization, String host) {
        super(authorization, host);
    }

    /**
     * 虚拟账户余额查询
     *
     * @return
     */
    public Builder<QueryBalanceRespDTO> newQueryBalanceBuilder() {
        return new Builder<QueryBalanceRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryBalanceRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_balance.url")) {
        };
    }

    /**
     * 账户提现
     *
     * @return
     */
    public Builder<WithdrawRespDTO> newWithdrawRespBuilder() {
        return new Builder<WithdrawRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                WithdrawRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.withdraw.url")) {
        };
    }

    /**
     * 提现结果查询
     *
     * @return
     */
    public Builder<QueryWithdrawRespDTO> newQueryWithdrawRespBuilder() {
        return new Builder<QueryWithdrawRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryWithdrawRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_withdraw.url")) {
        };
    }


    /**
     * 账户提现
     *
     * @return
     */
    public Builder<TransferSinglerPayRespDTO> newTransferSinglerPayRespBuilder() {
        return new Builder<TransferSinglerPayRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                TransferSinglerPayRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.sgl_payment.url")) {
        };
    }

    /**
     * 账户资金明细查询
     *
     * @return
     */
    public Builder<QueryAccountDetailRespDTO> newQueryAccountDetailRespBuilder() {
        return new Builder<QueryAccountDetailRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryAccountDetailRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_account_detail.url")) {
        };
    }

    /**
     * 清算分账文件上送
     *
     * @return
     */
    public Builder<UploadSettleSplitRespDTO> newUploadSettleSplitBuilder() {
        return new Builder<UploadSettleSplitRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadSettleSplitRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.upload_settle_split.url")) {
        };
    }

    /**
     * 清算分账结果查询
     *
     * @return
     */
    public Builder<EBSettleSplitResultRespDTO> newEBSettleSplitResultBuilder() {
        return new Builder<EBSettleSplitResultRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                EBSettleSplitResultRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_settle_split.url")) {
        };
    }

    /**
     * 平台对账文件下载
     *
     * @return
     */
    public Builder<DownloadIndustryReconcileFileRespDTO> newDownloadIndustryReconcileFileBuilder() {
        return new Builder<DownloadIndustryReconcileFileRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                DownloadIndustryReconcileFileRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.download_settle_data.url")) {
        };
    }

    /**
     * 平台转账
     *
     * @return
     */
    public Builder<TransferRespDTO> newTransferRespBuilder() {
        return new Builder<TransferRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                TransferRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.transfer.url")) {
        };
    }

    /**
     * 转账(用户-用户)
     *
     * @return
     */
    public Builder<TransferUser2UserRespDTO> newTransferUser2UserRespBuilder() {
        return new Builder<TransferUser2UserRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                TransferUser2UserRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.transfer_user2user.url")) {
        };
    }


    /**
     * 转账(用户-代付客户平台)
     *
     * @return
     */
    public Builder<TransferUser2IndustryRespDTO> newTransferUser2IndustryRespBuilder() {
        return new Builder<TransferUser2IndustryRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                TransferUser2IndustryRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.transfer_user2industry.url")) {
        };
    }

    /**
     * 转账结果查询
     *
     * @return
     */
    public Builder<QueryTransferRespDTO> newQueryTransferRespBuilder() {
        return new Builder<QueryTransferRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryTransferRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_transfer.url")) {
        };
    }

    /**
     * 平台及平台下关联账户资金明细文件下载
     *
     * @return
     */
    public Builder<DownloadIndustryAccountDetailFileRespDTO> newDownloadIndustryAccountDetailFileBuilder() {
        return new Builder<DownloadIndustryAccountDetailFileRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                DownloadIndustryAccountDetailFileRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.download_industry_account_detail.url")) {
        };
    }

    /**
     * 平台账户资金明细查询
     *
     * @return
     */
    public Builder<QueryIndustryAccountDetailRespDTO> newQueryIndustryAccountDetailBuilder() {
        return new Builder<QueryIndustryAccountDetailRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryIndustryAccountDetailRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_industry_account_detail.url")) {
        };
    }

    /**
     * 银行专用账户资金明细查询
     *
     * @return
     */
    public Builder<QueryBankAccountDetailRespDTO> newQueryBankAccountDetailRespBuilder() {
        return new Builder<QueryBankAccountDetailRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryBankAccountDetailRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_bank_account_detail.url")) {
        };
    }

    /**
     * 3.1.19.账户入金查询
     *
     * @return
     */
    public Builder<QueryUserAccountOrderIdRespDTO> newQueryUserAccountOrderIdRespBuilder() {
        return new Builder<QueryUserAccountOrderIdRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryUserAccountOrderIdRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_user_account_orderId.url")) {
        };
    }

    /**
     * 订单金额冻结
     *
     * @return
     */
    public Builder<FreezeOrderIdRespDTO> newFreezeOrderIdRespBuilder() {
        return new Builder<FreezeOrderIdRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                FreezeOrderIdRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.freeze_orderId.url")) {
        };
    }

    /**
     * 订单金额解冻
     *
     * @return
     */
    public Builder<UnfreezeOrderIdRespDTO> newUnfreezeOrderIdRespBuilder() {
        return new Builder<UnfreezeOrderIdRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UnfreezeOrderIdRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.unfreeze_orderId.url")) {
        };
    }

    /**
     * 订单退款
     *
     * @return
     */
    public Builder<RefundOrderIdRespDTO> newRefundOrderIdRespBuilder() {
        return new Builder<RefundOrderIdRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                RefundOrderIdRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.refund_orderId.url")) {
        };
    }


    /**
     * 交易流水文件上送
     *
     * @return
     */
    public Builder<UploadOutsideTransOrderRespDTO> newUploadOutsideTransOrderBuilder() {
        return new Builder<UploadOutsideTransOrderRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadOutsideTransOrderRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.upload_industry_pay_flow.url")) {
        };
    }

    /**
     * 交易流水文件上送结果查询
     *
     * @return
     */
    public Builder<QueryOutsideTransOrderResultRespDTO> newQueryOutsideTransOrderResultBuilder() {
        return new Builder<QueryOutsideTransOrderResultRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryOutsideTransOrderResultRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_industry_pay_flow_result.url")) {
        };
    }

    /**
     * 分账-支付交易流水补登文件上送
     *
     * @return
     */
    public Builder<UploadSplitPayFlowRespDTO> newUploadSplitPayFlowBuilder() {
        return new Builder<UploadSplitPayFlowRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadSplitPayFlowRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.upload_split_pay_flow.url")) {
        };
    }

    /**
     * 分账-支付交易流水补登文件上送结果查询
     *
     * @return
     */
    public Builder<QuerySplitPayFlowResultRespDTO> newQuerySplitPayFlowResultBuilder() {
        return new Builder<QuerySplitPayFlowResultRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QuerySplitPayFlowResultRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_split_pay_flow_result.url")) {
        };
    }

    /**
     * 个人开户
     *
     * @return
     */
    public Builder<OpenAccountRespDTO> newOpenAccountRespBuilder() {
        return new Builder<OpenAccountRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                OpenAccountRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.open_account.url")) {
        };
    }

    /**
     * 个人绑卡
     *
     * @return
     */
    public Builder<BindRespDTO> newBindRespDTOBuilder() {
        return new Builder<BindRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                BindRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.bind.url")) {
        };
    }

    /**
     * 个体工商开户
     *
     * @return
     */
    public Builder<OpenAccountSelfemployedRespDTO> newOpenAccountSelfemployedRespBuilder() {
        return new Builder<OpenAccountSelfemployedRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                OpenAccountSelfemployedRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.open_account_selfemployed.url")) {
        };
    }

    /**
     * 个体工商绑卡
     *
     * @return
     */
    public Builder<AuthBindSelfemployedRespDTO> newAuthBindSelfemployedRespBuilder() {
        return new Builder<AuthBindSelfemployedRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                AuthBindSelfemployedRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.auth_bind_selfemployed.url")) {
        };
    }


    /**
     * 企业开户
     *
     * @return
     */
    public Builder<OpenAccountRespDTO> newOpenAccountEntBuilder() {
        return new Builder<OpenAccountRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                OpenAccountRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.open_account_ent.url")) {
        };
    }

    /**
     * 企业鉴权、绑卡功能合并
     *
     * @return
     */
    public Builder<AuthBindEntRespDTO> newAuthBindEntRespBuilder() {
        return new Builder<AuthBindEntRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                AuthBindEntRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.auth_bind_ent.url")) {
        };
    }

    /**
     * 企业鉴权绑卡 审核结果 查询
     *
     * @return
     */
    public Builder<QueryAuthAccountStatusRespDTO> newQueryAuthAccountStatusBuilder() {
        return new Builder<QueryAuthAccountStatusRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryAuthAccountStatusRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.auth_ent_status.url")) {
        };
    }


    /**
     * 账户状态查询
     *
     * @return
     */
    public Builder<QueryAccountStatusRespDTO> newQueryAccountStatusBuilder() {
        return new Builder<QueryAccountStatusRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryAccountStatusRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_account_status.url")) {
        };
    }

    /**
     * 个人|企业账户解除绑定卡号 解绑
     *
     * @return
     */
    public Builder<UnBindRespDTO> newUnBindRespBuilder() {
        return new Builder<UnBindRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UnBindRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.unbind.url")) {
        };
    }

    /**
     * 个人|企业账户 销户
     *
     * @return
     */
    public Builder<AccountCancelRespDTO> newAccountCancelBuilder() {
        return new Builder<AccountCancelRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                AccountCancelRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.cancel.url")) {
        };
    }

    /**
     * 后管审核企业认证
     *
     * @return
     */
    public Builder<Object> newInnerAccountAuthEntBuilder() {
        return new Builder<Object>(
                this.asyncHttpClient,
                this.authorization,
                Object.class,
                this.getHost(),
                properties.getProperty("utp.account.innerAccount_auth_ent.url")) {
        };
    }


    /**
     * @Description: 下载电子回单
     * @Params: []
     * @return: cn.kingnet.utp.sdk.core.UtpClient.Builder<cn.kingnet.utp.sdk.account.dto.DownloadElectronicReceiptRespDTO>
     * @Date: 2019-03-20
     */
    public Builder<DownloadElectronicReceiptRespDTO> newDownloadElectronicReceiptBuilder() {
        return new Builder<DownloadElectronicReceiptRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                DownloadElectronicReceiptRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.download_electronic.url")) {
        };
    }

    /**
     * 用户账户资金冻结/解冻
     *
     * @return
     */
    public Builder<FreezeBalanceRespDTO> newFreezeBalanceBuilder() {
        return new Builder<FreezeBalanceRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                FreezeBalanceRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.freeze_balance.url")) {
        };
    }

    /**
     * 子账户入金流水报备
     *
     * @return
     */
    public Builder<UploadSubAccountPayFlowRespDTO> newUploadSubAccountPayFlowBuilder() {
        return new Builder<UploadSubAccountPayFlowRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadSubAccountPayFlowRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.upload_subAccount_pay_flow.url")) {
        };
    }

    /**
     * 待结算账户开户
     *
     * @return
     */
    public Builder<OpenAccountSettlementRespDTO> newOpenAccountSettlementBuilder() {
        return new Builder<OpenAccountSettlementRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                OpenAccountSettlementRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.open_account_settlement.url")) {
        };
    }

    /**
     * 待结算账户开户
     *
     * @return
     */
    public Builder<SubaccountSettleSplitResultRespDTO> newQuerySubAccountSettleSplitResultBuilder() {
        return new Builder<SubaccountSettleSplitResultRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                SubaccountSettleSplitResultRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_subAccount_settle_split.url")) {
        };
    }

    /**
     * 查询子账户入金流水报备结果
     *
     * @return
     */
    public Builder<QuerySubAccountPayFlowRespDTO> newQuerySubAccountPayFlowBuilder() {
        return new Builder<QuerySubAccountPayFlowRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QuerySubAccountPayFlowRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_subAccount_pay_flow_result.url")) {
        };
    }

    /**
     * 上送子账户清分文件
     *
     * @return
     */
    public Builder<UploadSubAccountSettleSplitRespDTO> newUploadSubAccountSettleSplitBuilder() {
        return new Builder<UploadSubAccountSettleSplitRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadSubAccountSettleSplitRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.upload_subAccount_settle_split.url")) {
        };
    }

    /**
     * 余额支付
     *
     * @return
     */
    public Builder<BalancePaymentRespDTO> newBalancePaymentBuilder() {
        return new Builder<BalancePaymentRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                BalancePaymentRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.balance_payment.url")) {
        };
    }

    /**
     * 余额支付退款
     *
     * @return
     */
    public Builder<BalancePaymentRefundRespDTO> newBalancePaymentRefundBuilder() {
        return new Builder<BalancePaymentRefundRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                BalancePaymentRefundRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.balance_payment_refund.url")) {
        };
    }


    /**
     * 对公打款验证
     *
     * @return
     */
    public Builder<PaymentCheckRespDTO> newPaymentCheckRespBuilder() {
        return new Builder<PaymentCheckRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                PaymentCheckRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.payment_check.url")) {
        };
    }

    /**
     * 绑卡列表查询
     *
     * @return
     */
    public Builder<BindCardListRespDTO> newBindCardListRespBuilder() {
        return new Builder<BindCardListRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                BindCardListRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.bind_card_list.url")) {
        };
    }

    /**
     * 子账户多级分账
     *
     * @return
     */
    public Builder<UploadSubAccountMultiSettleSplitRespDTO> newUploadSubAccountMultiSettleSplitBuilder() {
        return new Builder<UploadSubAccountMultiSettleSplitRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadSubAccountMultiSettleSplitRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.upload_subAccount_multiSettle_split.url")) {
        };
    }

    /**
     * 子账户多级分账结果查询
     *
     * @return
     */
    public Builder<QuerySubAccountMultiSettleSplitRespDTO> newQuerySubAccountMultiSettleSplitBuilder() {
        return new Builder<QuerySubAccountMultiSettleSplitRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QuerySubAccountMultiSettleSplitRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.query_subAccount_multiSettle_split.url")) {
        };
    }

    /**
     * 绑卡列表查询
     *
     * @return
     */
    public Builder<PlatAccountListRespDTO> newQueryPlatAccountInfoBuilder() {
        return new Builder<PlatAccountListRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                PlatAccountListRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.plat_account_list.url")) {
        };
    }

    public Builder<SplitPaymentRespDTO> newSplitPaymentBuilder() {
        return new Builder<SplitPaymentRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                SplitPaymentRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.split_payment.url")) {
        };
    }

    public Builder<SplitPaymentRefundRespDTO> newSplitPaymentRefundBuilder() {
        return new Builder<SplitPaymentRefundRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                SplitPaymentRefundRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.split_payment_refund.url")) {
        };
    }

    public Builder<DownloadIndustryD1SpecailReconFileRespDTO> newDownloadIndustryD1SpecailReconFileBuilder() {
        return new Builder<DownloadIndustryD1SpecailReconFileRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                DownloadIndustryD1SpecailReconFileRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.download_daytx_data.url")) {
        };
    }

    public Builder<DownloadIndustrySubAccountDailyBalanceFileRespDTO> newDownloadIndustrySubAccountDailyBalanceFileBuilder() {
        return new Builder<DownloadIndustrySubAccountDailyBalanceFileRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                DownloadIndustrySubAccountDailyBalanceFileRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.download_balance_data.url")) {
        };
    }

    public Builder<NewOpenAccountEntRespDTO> newNewOpenAccountEntBuilder() {
        return new Builder<NewOpenAccountEntRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                NewOpenAccountEntRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.new_open_account_ent.url")) {
        };
    }
    public Builder<NewAuthBindEntRespDTO> newNewAuthBindEntBuilder() {
        return new Builder<NewAuthBindEntRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                NewAuthBindEntRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.new_auth_bind_ent.url")) {
        };
    }

    public Builder<UploadIndustryMixPayFlowRespDTO> newUploadIndustryMixPayFlowBuilder() {
        return new Builder<UploadIndustryMixPayFlowRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadIndustryMixPayFlowRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.account.upload_industry_mixpay_flow.url")) {
        };
    }
}
