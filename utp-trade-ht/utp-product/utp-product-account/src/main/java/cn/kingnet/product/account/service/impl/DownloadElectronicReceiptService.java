package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IElectronicReceiptHandler;
import cn.kingnet.utp.service.persistence.entity.ElectronicReceipt;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadElectronicReceiptReqDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadElectronicReceiptRespDTO;
import cn.kingnet.utp.trade.common.enums.FundAccType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description : 电子回单下载
 * @Author : caohong
 * @Date : 2019-03-18
 */
@Slf4j
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.DOWNLOAD_ELECTRONIC_RECEIPT,
        reqClass = DownloadElectronicReceiptReqDTO.class,
        respClass = DownloadElectronicReceiptRespDTO.class
)
public class DownloadElectronicReceiptService extends AbstractAccountTradeService<DownloadElectronicReceiptReqDTO, DownloadElectronicReceiptRespDTO> {

    @Resource
    private IElectronicReceiptHandler electronicReceiptHandler;

    public DownloadElectronicReceiptService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<DownloadElectronicReceiptReqDTO, DownloadElectronicReceiptRespDTO> tradeContext) {
        DownloadElectronicReceiptReqDTO reqDTO = tradeContext.getRequestDTO();
        ElectronicReceipt electronicReceipt = null;
        //通过交易流水ID查找电子回单信息
        electronicReceipt = electronicReceiptHandler.foundByServerTransId(reqDTO.getOrigTradeId());
        if (electronicReceipt == null) {
            // 没有查到电子回单
            throw new ProductException(HttpRespStatus.FORBIDDEN, "未找到电子回单信息");
        }
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if(!basicConfigInfo.getIndustryCode().equals(electronicReceipt.getIndustryCode())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "警告：仅能下载本平台客户下交易电子回单");
        }

        byte[] fileAy;
        if (electronicReceipt.getFileContent() != null) {
            fileAy = electronicReceipt.getFileContent();
        } else {
            if (StringUtil.isBlank(electronicReceipt.getFilePath())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "电子回单保存路径不能为空");
            }
            try {
                fileAy = Files.readAllBytes(Paths.get(electronicReceipt.getFilePath()));
            } catch (Exception e) {
                log.error("id==>{}，文件路径{}，电子回单信息异常==>{}", electronicReceipt.getId(), electronicReceipt.getFilePath(), e.getMessage(), e);
                throw new ProductException(HttpRespStatus.FORBIDDEN, "电子回单信息异常");
            }
        }
        String result = DataUtil.deflaterAndEncode64(fileAy);
        DownloadElectronicReceiptRespDTO.DownloadElectronicReceiptRespDTOBuilder builder = DownloadElectronicReceiptRespDTO.builder().receiptNo(electronicReceipt.getOrderNo()).content(result);
        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<DownloadElectronicReceiptReqDTO, DownloadElectronicReceiptRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        DownloadElectronicReceiptReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.hasText(reqDTO.getOrigTradeId(), "交易流水ID");
        ValidateUtils.maxLength(reqDTO.getOrigTradeId(), 36, true, "交易流水ID");
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if(FundAccType.GENERAL_ACC.getType().equals(basicConfigInfo.getFundAccType())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "资金账户一般户,不允许下载交易电子回单!");
        }
    }

    @Override
    public void initTransFlow(TradeContext<DownloadElectronicReceiptReqDTO, DownloadElectronicReceiptRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<DownloadElectronicReceiptReqDTO, DownloadElectronicReceiptRespDTO> tradeContext) {

    }
}
