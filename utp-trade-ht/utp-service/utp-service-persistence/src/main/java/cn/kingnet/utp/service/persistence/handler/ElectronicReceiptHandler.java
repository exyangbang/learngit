package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IElectronicReceiptHandler;
import cn.kingnet.utp.service.persistence.entity.ElectronicReceipt;
import cn.kingnet.utp.service.persistence.entity.ElectronicReceiptCondition;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.PayMode;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description
 * @Author : caohong
 * @Date : 2019-03-19
 */
@RestController
@RequestMapping("/spi/persistence/electronic/receipt")
@Slf4j
public class ElectronicReceiptHandler extends DefaultFeginExceptionHandler implements IElectronicReceiptHandler {

    @Override
    public ElectronicReceipt foundByServerTransId(String origTradeId) {
        Assert.hasText(origTradeId, () -> "原流水号不能为空");
        ElectronicReceiptCondition condition = ElectronicReceiptCondition.builder().andServerTransIdEq(origTradeId).orClientTransIdEq(origTradeId);
        return MybatisDaoImpl.run().selectOne(condition.build());
    }

    @Override
    public ElectronicReceipt foundByServerTransIdAndReceiptNo(String origTradeId, String receiptNo) {
        Assert.hasText(origTradeId, () -> "原流水号不能为空");
        Assert.hasText(receiptNo, () -> "电子回单号不能为空");
        ElectronicReceiptCondition condition = ElectronicReceiptCondition.builder().andServerTransIdEq(origTradeId).andOrderNoEq(receiptNo);
        return MybatisDaoImpl.run().selectOne(condition.build());
    }

    @Override
    public String queryFilePathById(long id) {
        ValidateUtils.notNull(id, "参数[id]不能为空");
        ElectronicReceipt electronicReceipt = MybatisDaoImpl.run().selectById(ElectronicReceipt.class, id);
        return electronicReceipt.getFilePath();
    }
}