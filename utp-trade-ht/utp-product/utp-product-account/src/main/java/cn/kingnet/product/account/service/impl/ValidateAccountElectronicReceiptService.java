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
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.ValidateAccountElectronicReceiptReqDTO;
import cn.kingnet.utp.trade.common.dto.account.ValidateAccountElectronicReceiptRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.Resource;

/**
 * @Description : 开户电子回单验证
 * @Author : linkaigui
 * @Create : 2020/3/13 10:05
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.VALIDATE_ACCOUNT_ELECTRONIC_RECEIPT,
        reqClass = ValidateAccountElectronicReceiptReqDTO.class,
        respClass = ValidateAccountElectronicReceiptRespDTO.class
)
public class ValidateAccountElectronicReceiptService extends AbstractAccountTradeService<ValidateAccountElectronicReceiptReqDTO, ValidateAccountElectronicReceiptRespDTO> {

    @Resource
    private IAccountElectronicReceiptHandler accountElectronicReceiptHandler;

    public ValidateAccountElectronicReceiptService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<ValidateAccountElectronicReceiptReqDTO, ValidateAccountElectronicReceiptRespDTO> tradeContext) {
        ValidateAccountElectronicReceiptReqDTO validateAccountElectronicReceiptReqDTO = tradeContext.getRequestDTO();
        AccountElectronicReceipt accountElectronicReceipt = accountElectronicReceiptHandler.getByReceiptNo(validateAccountElectronicReceiptReqDTO.getAccountReceiptNo());
        if(accountElectronicReceipt == null){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "未找到开户电子回单信息,验证失败");
        }
        String md5Hex = "";
        try{
            byte[] fileContent = DataUtil.inflaterAndDecode64(validateAccountElectronicReceiptReqDTO.getContent());
            md5Hex = DigestUtils.md5Hex(fileContent);
        }catch (Exception e){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "开户电子回单信息不匹配，验证失败",e);
        }
        if (md5Hex.equals(accountElectronicReceipt.getMd5Hex())) {
            return ChannelResponseUtil.success(null, null, null);
        }else {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "开户电子回单信息不匹配，验证失败");
        }
    }

    @Override
    protected void verifyReqParam(TradeContext<ValidateAccountElectronicReceiptReqDTO, ValidateAccountElectronicReceiptRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        ValidateAccountElectronicReceiptReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(reqDTO.getAccountReceiptNo(),true,"账户电子回单号");
        ValidateUtils.maxLength(reqDTO.getAccountReceiptNo(),32,true,"账户电子回单号");
        ValidateUtils.hasText(reqDTO.getContent(),"电子回单文件流");
    }

    @Override
    public void initTransFlow(TradeContext<ValidateAccountElectronicReceiptReqDTO, ValidateAccountElectronicReceiptRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<ValidateAccountElectronicReceiptReqDTO, ValidateAccountElectronicReceiptRespDTO> tradeContext) {

    }
}
