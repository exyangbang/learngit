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
import cn.kingnet.utp.trade.common.dto.account.ValidateElectronicReceiptReqDTO;
import cn.kingnet.utp.trade.common.dto.account.ValidateElectronicReceiptRespDTO;
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
 * @Description : 电子回单验证
 * @Author : caohong
 * @Date : 2019-03-18
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.VALIDATE_ELECTRONIC_RECEIPT,
        reqClass = ValidateElectronicReceiptReqDTO.class,
        respClass = ValidateElectronicReceiptRespDTO.class
)
public class ValidateElectronicReceiptService extends AbstractAccountTradeService<ValidateElectronicReceiptReqDTO, ValidateElectronicReceiptRespDTO> {

    @Resource
    private IElectronicReceiptHandler electronicReceiptHandler;

    public ValidateElectronicReceiptService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties,basicConfigHandler,productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<ValidateElectronicReceiptReqDTO, ValidateElectronicReceiptRespDTO> tradeContext) {
        ValidateElectronicReceiptReqDTO reqDTO = tradeContext.getRequestDTO();
        ElectronicReceipt electronicReceipt = null;
        //通过交易流水ID和电子回单号查询电子回单信息
        electronicReceipt = electronicReceiptHandler.foundByServerTransIdAndReceiptNo(reqDTO.getOrigTradeId(), reqDTO.getReceiptNo());
        String md5Hex = "";
        if (electronicReceipt == null) {
            // 没有查到电子回单
            throw new ProductException(HttpRespStatus.FORBIDDEN, "未找到电子回单信息,验证失败");
        } else {
            byte[] file;
            try {
                file = DataUtil.inflaterAndDecode64(reqDTO.getContent());
                md5Hex = DigestUtils.md5Hex(file);
            } catch (Exception e) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "电子回单信息不匹配，验证失败");
            }
            if (electronicReceipt.getMd5Hex().equals(md5Hex)) {
                return ChannelResponseUtil.success(null, null, null);
            } else {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "电子回单信息不匹配，验证失败");
            }
        }
    }

    @Override
    protected void verifyReqParam(TradeContext<ValidateElectronicReceiptReqDTO, ValidateElectronicReceiptRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        ValidateElectronicReceiptReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.hasText(reqDTO.getOrigTradeId(),"交易流水ID");
        ValidateUtils.maxLength(reqDTO.getOrigTradeId(), 36, true, "交易流水ID");
        ValidateUtils.maxLength(reqDTO.getReceiptNo(), 32, true, "电子回单号");
        ValidateUtils.hasText(reqDTO.getContent(), "电子回单号pdf文件流");
    }

    @Override
    public void updateTransFlow(TradeContext<ValidateElectronicReceiptReqDTO, ValidateElectronicReceiptRespDTO> tradeContext) {

    }

    @Override
    public void initTransFlow(TradeContext<ValidateElectronicReceiptReqDTO, ValidateElectronicReceiptRespDTO> tradeContext) {

    }
}
