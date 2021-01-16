package cn.kingnet.utp.sdk.precard;

import cn.kingnet.utp.sdk.core.UtpClient;
import cn.kingnet.utp.sdk.core.auth.Authorization;
import cn.kingnet.utp.sdk.precard.dto.*;

/**
 * @Description
 * @Author WJH
 * @Date 2018年09月14日
 */
public class PreCardClient extends UtpClient {

    public PreCardClient(Authorization authorization, String host) {
        super(authorization, host);
    }

    /**
     * 预付费卡入账文件上送
     *
     * @return
     */
    public Builder<UploadAccountEntryRespDTO> newUploadAccountEntryBuilder() {
        return new Builder<UploadAccountEntryRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadAccountEntryRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.precard.upload_account_entry.url")) {
        };
    }

    /**
     * 预付费卡入账结果查询
     *
     * @return
     */
    public Builder<QueryAccountEntryRespDTO> newQueryAccountEntryBuilder() {
        return new Builder<QueryAccountEntryRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryAccountEntryRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.precard.query_account_entry.url")) {
        };
    }

    /**
     * 预付费卡清算文件上送
     *
     * @return
     */
    public Builder<UploadAccountSettleRespDTO> newUploadAccountSettleBuilder() {
        return new Builder<UploadAccountSettleRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                UploadAccountSettleRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.precard.upload_account_settle.url")) {
        };
    }

    /**
     * 预付费卡清算结果查询
     *
     * @return
     */
    public Builder<QueryAccountSettleRespDTO> newQueryAccountSettleResultBuilder() {
        return new Builder<QueryAccountSettleRespDTO>(
                this.asyncHttpClient,
                this.authorization,
                QueryAccountSettleRespDTO.class,
                this.getHost(),
                properties.getProperty("utp.precard.query_account_settle.url")) {
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
                properties.getProperty("utp.precard.query_industry_account_detail.url")) {
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
                properties.getProperty("utp.precard.download_settle_data.url")) {
        };
    }
}
