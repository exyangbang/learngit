package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IAccountElectronicReceiptHandler;
import cn.kingnet.utp.service.persistence.entity.AccountElectronicReceipt;
import cn.kingnet.utp.service.persistence.entity.AccountElectronicReceiptCondition;
import cn.kingnet.utp.service.persistence.entity.ElectronicReceipt;
import cn.kingnet.utp.service.persistence.service.JobTaskService;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description : 开户电子回单
 * @Author : linkaigui
 * @Create : 2020/3/13 15:34
 */
@RestController
@RequestMapping("/spi/persistence/accountElectronicReceipt")
@Slf4j
public class AccountElectronicReceiptHandler extends DefaultFeginExceptionHandler implements IAccountElectronicReceiptHandler {

    @Resource
    private JobTaskService jobTaskService;

    /**
     * 根据电子回单号获取电子回单信息
     * @param receiptNo 电子回单号
     * @return
     */
    @PostMapping("/getByReceiptNo")
    @Override
    public AccountElectronicReceipt getByReceiptNo(String receiptNo) {
        ValidateUtils.hasText(receiptNo, "电子回单号");
        AccountElectronicReceiptCondition condition = AccountElectronicReceiptCondition.builder().andReceiptNoEq(receiptNo);
        return MybatisDaoImpl.run().selectOne(condition.build());
    }

    /**
     * 根据虚拟帐号获取电子回单信息
     * @param account 虚拟帐号
     * @return
     */
    @PostMapping("/getByAccount")
    @Override
    public AccountElectronicReceipt getByAccount(String account) {
        ValidateUtils.hasText(account, "虚拟帐号");
        AccountElectronicReceiptCondition condition = AccountElectronicReceiptCondition.builder().andAccountEq(account);
        return MybatisDaoImpl.run().selectOne(condition.build());
    }

    /**
     * 创建生成开户电子回单任务
     * @param account 虚拟账户
     * @param nature  账户性质
     */
    @Override
    @PostMapping("/createJobTask")
    public void createJobTask(String account, String nature) {
        ValidateUtils.hasText(account, "虚拟账户");
        jobTaskService.createJobTask4AcctReceipt(account, nature);
    }

    @Override
    @PostMapping("/queryFilePathById")
    public String queryFilePathById(long id) {
        ValidateUtils.notNull(id, "参数[id]不能为空");
        AccountElectronicReceipt electronicReceipt = MybatisDaoImpl.run().selectById(AccountElectronicReceipt.class, id);
        return electronicReceipt.getFilePath();
    }
}
