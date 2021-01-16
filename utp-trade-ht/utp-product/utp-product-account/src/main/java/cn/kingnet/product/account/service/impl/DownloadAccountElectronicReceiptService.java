package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountElectronicReceiptHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.AccountElectronicReceipt;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadAccountElectronicReceiptReqDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadAccountElectronicReceiptRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description : 开户电子回单下载
 * @Author : linkaigui
 * @Create : 2020/3/13 10:05
 */
@Slf4j
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.DOWNLOAD_ACCOUNT_ELECTRONIC_RECEIPT,
        reqClass = DownloadAccountElectronicReceiptReqDTO.class,
        respClass = DownloadAccountElectronicReceiptRespDTO.class
)
public class DownloadAccountElectronicReceiptService extends AbstractAccountTradeService<DownloadAccountElectronicReceiptReqDTO, DownloadAccountElectronicReceiptRespDTO> {

    @Resource
    private IAccountElectronicReceiptHandler accountElectronicReceiptHandler;

    public DownloadAccountElectronicReceiptService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<DownloadAccountElectronicReceiptReqDTO, DownloadAccountElectronicReceiptRespDTO> tradeContext) {
        DownloadAccountElectronicReceiptReqDTO receiptReqDTO = tradeContext.getRequestDTO();
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(receiptReqDTO.getUserAccount());
        if (merchantInfo == null || StringUtils.isBlank(merchantInfo.getAccount())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未开户");
        }
        if(UserType.ONE.getType().equals(merchantInfo.getUserType())){
            if(!receiptReqDTO.getCertificateNo().equals(merchantInfo.getIdCode())){
                throw new ProductException(HttpRespStatus.BAD_REQUEST,"证件号码不匹配!");
            }
        }else {
            if(!receiptReqDTO.getCertificateNo().equals(merchantInfo.getBusLicCode())){
                throw new ProductException(HttpRespStatus.BAD_REQUEST,"证件号码不匹配!");
            }
        }
        //校验当前代付客户号跟上送代付号是否是同一个
        String industryNumber = tradeContext.getAuthInfo().getAuthNo();
        if (industryNumber == null || !industryNumber.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "当前代付客户号与开户时代付客户不一致");
        }
        AccountElectronicReceipt accountElectronicReceipt = accountElectronicReceiptHandler.getByAccount(receiptReqDTO.getUserAccount());
        if(accountElectronicReceipt != null){
            byte[] fileAy;
            if (accountElectronicReceipt.getFileContent() != null) {
                fileAy = accountElectronicReceipt.getFileContent();
            } else {
                if (StringUtil.isBlank(accountElectronicReceipt.getFilePath())) {
                    throw new ProductException(HttpRespStatus.FORBIDDEN, "开户电子回单保存路径不能为空");
                }
                try {
                    fileAy = Files.readAllBytes(Paths.get(accountElectronicReceipt.getFilePath()));
                } catch (Exception e) {
                    log.error("id==>{}，文件路径{}，开户电子回单信息异常==>{}", accountElectronicReceipt.getId(), accountElectronicReceipt.getFilePath(), e.getMessage(), e);
                    throw new ProductException(HttpRespStatus.FORBIDDEN, "开户电子回单信息异常");
                }
            }
            String content = DataUtil.deflaterAndEncode64(fileAy);
            DownloadAccountElectronicReceiptRespDTO downloadAccountElectronicReceiptRespDTO = new DownloadAccountElectronicReceiptRespDTO();
            downloadAccountElectronicReceiptRespDTO.setAccountReceiptNo(accountElectronicReceipt.getReceiptNo());
            downloadAccountElectronicReceiptRespDTO.setContent(content);
            return ChannelResponseUtil.success(downloadAccountElectronicReceiptRespDTO, null, null);
        }else {
            try{
                accountElectronicReceiptHandler.createJobTask(merchantInfo.getAccount(),merchantInfo.getNature());
            }catch (Exception e){
                logger.error("创建开户电子回单异常:{}",e.getMessage(),e);
            }
            throw new ProductException(HttpRespStatus.FORBIDDEN, "未找到电子回单信息");
        }
    }

    @Override
    protected void verifyReqParam(TradeContext<DownloadAccountElectronicReceiptReqDTO, DownloadAccountElectronicReceiptRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        DownloadAccountElectronicReceiptReqDTO receiptReqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(receiptReqDTO.getUserAccount(),true,"用户账户");
        ValidateUtils.maxLength(receiptReqDTO.getUserAccount(),19,true,"用户账户");
        ValidateUtils.maxLength(receiptReqDTO.getCertificateNo(), 50, true, "证件号");
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if(FundAccType.GENERAL_ACC.getType().equals(basicConfigInfo.getFundAccType())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "资金账户一般户,不允许下载开户电子回单!");
        }
    }

    @Override
    public void initTransFlow(TradeContext<DownloadAccountElectronicReceiptReqDTO, DownloadAccountElectronicReceiptRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<DownloadAccountElectronicReceiptReqDTO, DownloadAccountElectronicReceiptRespDTO> tradeContext) {

    }
}
