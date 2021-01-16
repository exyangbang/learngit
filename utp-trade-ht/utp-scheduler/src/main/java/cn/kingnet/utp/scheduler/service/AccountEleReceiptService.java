package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.bo.AccountEleReceiptTaskBO;
import cn.kingnet.utp.scheduler.data.entity.AccountElectronicReceiptCondition;
import cn.kingnet.utp.scheduler.data.entity.MerchantInfo;
import cn.kingnet.utp.scheduler.data.entity.MerchantInfoCondition;
import cn.kingnet.utp.scheduler.pdf.OneBankAccountEleReceiptPdf;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description : 开户电子回单PDF
 * @Author : linkaigui
 * @Create : 2020/3/17 10:58
 */
@Service
@Slf4j
public class AccountEleReceiptService {

    @Resource
    private OneBankAccountEleReceiptPdf oneBankAccountEleReceiptPdf;


    /**
     * 生成开户电子回单
     * @param accountEleReceiptTaskBO
     */
    public void eleReceipt(AccountEleReceiptTaskBO accountEleReceiptTaskBO){
        ValidateUtils.notNull(accountEleReceiptTaskBO,"开户电子回单参数");
        ValidateUtils.abcValid(accountEleReceiptTaskBO.getAccount(),true,"虚拟账户");
        // 下期优化需过滤掉pic字段
        MerchantInfo merchantInfo = MybatisDaoImpl.run().selectOne(MerchantInfoCondition.builder().andAccountEq(accountEleReceiptTaskBO.getAccount()).build());
        if(merchantInfo == null){
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("虚拟账户%信息未空!",accountEleReceiptTaskBO.getAccount()));
        }
        try {
            int count = MybatisDaoImpl.run().selectCount(AccountElectronicReceiptCondition.builder().andAccountEq(merchantInfo.getAccount()).build());
            if(count > 0){
                throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,String.format("虚拟账户%已生成电子回单!",accountEleReceiptTaskBO.getAccount()));
            }
            oneBankAccountEleReceiptPdf.buildPdf(merchantInfo,null);
        } catch (Exception e) {
            log.error("虚拟账户[{}]创建电子回单异常：{}", accountEleReceiptTaskBO.getAccount(), e.getMessage(), e);
            throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,String.format("虚拟账户创建电子回单异常"),e);
        }
    }
}
