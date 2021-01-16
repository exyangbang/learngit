package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ITransHistoryHandler;
import cn.kingnet.utp.service.persistence.entity.AccountDetail;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustryAccountDetailFileReqDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustryAccountDetailFileRespDTO;
import cn.kingnet.utp.trade.common.enums.AccountOperType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author : WJH
 * @Description : 下载代付客户平台下关联账户资金明细
 * @Create : 2019-03-16
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.DOWNLOAD_INDUSTRY_ACCOUNT_DETAIL,
        reqClass = DownloadIndustryAccountDetailFileReqDTO.class,
        respClass = DownloadIndustryAccountDetailFileRespDTO.class
)
public class DownloadIndustryAccountDetailService extends AbstractAccountTradeService<DownloadIndustryAccountDetailFileReqDTO, DownloadIndustryAccountDetailFileRespDTO> {

    private static final String SEPARATOR = "|";

    @Resource
    private ITransHistoryHandler transHistoryHandler;
    @Resource
    private IAccountHandler accountHandler;

    public DownloadIndustryAccountDetailService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<DownloadIndustryAccountDetailFileReqDTO, DownloadIndustryAccountDetailFileRespDTO> tradeContext) {

        DownloadIndustryAccountDetailFileReqDTO reqDTO = tradeContext.getRequestDTO();
        DownloadIndustryAccountDetailFileRespDTO.DownloadIndustryAccountDetailFileRespDTOBuilder builder = DownloadIndustryAccountDetailFileRespDTO.builder();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        try {
            List<AccountDetail> accountDetailList = accountHandler.queryIndustryAccountDetail(basicConfigInfo.getIndustryCode(), reqDTO.getOperateType(), reqDTO.getStartDate(), reqDTO.getEndDate());
            String content = buildIndustryAccountDetail(accountDetailList);
            builder.success(Boolean.TRUE.toString()).content(content).desc("账户对账文件下载成功");
        } catch (Exception e) {
            builder.success(Boolean.FALSE.toString()).desc("账户对账文件下载失败");
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "账户对账文件下载异常",e);
        }
        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    private String buildIndustryAccountDetail(List<AccountDetail> accountDetailList) {

        String queryDate = DateUtil.getCurrentDate();
        // 按规范生成文件
        int totalCount = CollectionUtils.isEmpty(accountDetailList) ? 0 : accountDetailList.size();
        //H|settle_result|20180101|222
        StringBuffer fileBuf = new StringBuffer()
                .append(UDPSettleSplitFeature.HEADMARK).append(SEPARATOR)
                .append(UDPSettleSplitFeature.TxType.ACCRECONCILE.getType()).append(SEPARATOR)
                .append(queryDate).append(SEPARATOR).append(String.valueOf(totalCount));
        if (totalCount > 0) {
            //查询日期|用户账号|操作类型|操作子类型|发生金额|操作前余额|操作后余额|记录时间|明细序号|备注说明|对方账户|流水号|订单号
            accountDetailList.forEach(item -> {
                fileBuf.append("\n")
                        .append(StringUtil.objTrimToEmpty(DateUtil.formateDate(item.getRecordTime(), "yyyyMMdd"))).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getAccount())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getOperateType())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getOperateSubType())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getAmount().toString())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getBeforeBalance().toString())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getAfterBalance().toString())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(DateUtil.formateDate(item.getRecordTime(), "yyyy-MM-dd HH:mm:ss"))).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getSeqNo())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getRemark())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getPeerAccNo())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getServerTransId())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getOutsideOrderId()));

            });
        }
        try {
            byte[] fileAy = fileBuf.toString().getBytes("UTF-8");
            return DataUtil.deflaterAndEncode64(fileAy);
        } catch (UnsupportedEncodingException e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "不支持的编码格式",e);
        }
    }


    @Override
    protected void verifyReqParam(TradeContext<DownloadIndustryAccountDetailFileReqDTO, DownloadIndustryAccountDetailFileRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        DownloadIndustryAccountDetailFileReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getStartDate(), true, "起始日期");
        ValidateUtils.isYyyyMMdd(reqDTO.getEndDate(), true, "终止日期");

        if (LocalDate.parse(reqDTO.getStartDate(), DateTimeFormatter.BASIC_ISO_DATE).compareTo(
                LocalDate.parse(reqDTO.getEndDate(), DateTimeFormatter.BASIC_ISO_DATE)
        ) > 0) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "起始日期必须小于终止日期");
        }
        ValidateUtils.maxLength(reqDTO.getOperateType(), 2, false, "操作类型");
        if (!StringUtil.isEmpty(reqDTO.getOperateType())) {
            AccountOperType accountOperType = AccountOperType.getEnum(reqDTO.getOperateType());
            if (accountOperType == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "操作类型有误");
            }
        }
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

    }

    @Override
    public void initTransFlow(TradeContext<DownloadIndustryAccountDetailFileReqDTO, DownloadIndustryAccountDetailFileRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<DownloadIndustryAccountDetailFileReqDTO, DownloadIndustryAccountDetailFileRespDTO> tradeContext) {

    }
}
