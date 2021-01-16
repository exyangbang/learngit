package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ITransHistoryHandler;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustrySubAccountDailyBalanceFileReqDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustrySubAccountDailyBalanceFileRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : WJH
 * @Description :4.5.14. 子账户日终余额对账单下载(京东定制化)
 * "按照客户号配置需要生成日终余额对账的，D+1日凌晨00点，生成D日的客户号下所有子账户的单日余额对账单。
 * 客户D+1日凌晨00:30分后可以下载D日的余额对账单，最多保留10天（参数配置），超过10天的数据自动清理，不允许下载。
 * @Create : 2018-11-07
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.DOWNLOAD_BALANCE_DATA,
        reqClass = DownloadIndustrySubAccountDailyBalanceFileReqDTO.class,
        respClass = DownloadIndustrySubAccountDailyBalanceFileRespDTO.class
)
@Slf4j
public class DownloadIndustrySubAccountDailyBalanceFileService extends AbstractAccountTradeService<DownloadIndustrySubAccountDailyBalanceFileReqDTO, DownloadIndustrySubAccountDailyBalanceFileRespDTO> {

    @Resource
    private ITransHistoryHandler transHistoryHandler;

    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.retainSubDailyBalanceFileDayNum:10}")
    private int retainSubDailyBalanceFileDayNum;

    public DownloadIndustrySubAccountDailyBalanceFileService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<DownloadIndustrySubAccountDailyBalanceFileReqDTO, DownloadIndustrySubAccountDailyBalanceFileRespDTO> tradeContext) {

        ChannelResponseDTO channelResponseDTO = null;
        DownloadIndustrySubAccountDailyBalanceFileReqDTO reqDTO = tradeContext.getRequestDTO();
        DownloadIndustrySubAccountDailyBalanceFileRespDTO.DownloadIndustrySubAccountDailyBalanceFileRespDTOBuilder builder = DownloadIndustrySubAccountDailyBalanceFileRespDTO.builder();
        builder.success(Boolean.FALSE.toString());
        try {
            byte[] d1SpecailReconFile = transHistoryHandler.downloadIndustrySubAccountDailyBalanceFile(tradeContext.getIndustryCode(), reqDTO.getTxDate());
            String content = DataUtil.deflaterAndEncode64(d1SpecailReconFile);
            builder.success(Boolean.TRUE.toString()).content(content);
            channelResponseDTO = ChannelResponseUtil.success(builder.build(),null,null);
        } catch (TradeException e) {
            builder.success(Boolean.FALSE.toString()).desc("D日对账单下载失败");
            channelResponseDTO = ChannelResponseUtil.build(builder.build(), null, null, HttpRespStatus.resolve(e.getStatus()), "D日对账单下载失败:"+e.getMessage());
            LambdaLogger.error(log, "流水号:{} >> D日对账单下载失败.{}", tradeContext.getServerTransId(), e.getMessage(), e);
        } catch (Exception e) {
            builder.success(Boolean.FALSE.toString()).desc("D日对账单下载异常");
            channelResponseDTO = ChannelResponseUtil.build(builder.build(), null, null, HttpRespStatus.SERVER_ERROR, "D日对账单下载异常:"+e.getMessage());
            LambdaLogger.error(log, "流水号:{} >> D日对账单下载异常.{}", tradeContext.getServerTransId(), e.getMessage(), e);
        }
        return channelResponseDTO;
    }


    @Override
    protected void verifyReqParam(TradeContext<DownloadIndustrySubAccountDailyBalanceFileReqDTO, DownloadIndustrySubAccountDailyBalanceFileRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        DownloadIndustrySubAccountDailyBalanceFileReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getTxDate(), true, "交易日期");

        LocalDate reqLocalDate = LocalDate.parse(reqDTO.getTxDate(), DateTimeFormatter.BASIC_ISO_DATE);
        if (reqLocalDate.compareTo(LocalDate.now()) >= 0) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "交易日期必须小于当前日期");
        }

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        Integer ableDownloadDailyBalance = getBasicConfigInfo(tradeContext).getAbleDownloadDailyBalance();
        if(ableDownloadDailyBalance==null || ableDownloadDailyBalance.intValue()!=1){
            throw new ProductException(HttpRespStatus.FORBIDDEN,"该平台客户不允许下载子账户日终余额对账单");
        }

        long retainDays = Duration.between(LocalDateTime.of(reqLocalDate, LocalTime.MIN), LocalDateTime.now()).toDays();
        if (retainDays > retainSubDailyBalanceFileDayNum) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("余额对账单至多保留[%s]日", retainSubDailyBalanceFileDayNum));
        }


    }

    @Override
    public void initTransFlow(TradeContext<DownloadIndustrySubAccountDailyBalanceFileReqDTO, DownloadIndustrySubAccountDailyBalanceFileRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<DownloadIndustrySubAccountDailyBalanceFileReqDTO, DownloadIndustrySubAccountDailyBalanceFileRespDTO> tradeContext) {

    }
}
