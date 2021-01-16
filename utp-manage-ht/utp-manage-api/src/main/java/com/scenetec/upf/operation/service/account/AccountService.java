package com.scenetec.upf.operation.service.account;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.account.AccountDetailDO;
import com.scenetec.upf.operation.model.domain.electronicreceipt.AaccountElectronicReceiptDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.AccountInfoVO;
import com.scenetec.upf.operation.model.vo.AccountReqVO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/29
 */
public interface AccountService {

    /**
     * 创建
     *
     * @param obj
     * @return
     */
    long create(AccountDO obj);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新
     *
     * @param obj
     */
    void update(AccountDO obj);

    void updateFeeTemplate(AccountDO obj);

    MerchantInfoDO getImage(Map obj);

    void updateMerchInfo(AccountInfoVO merchantInfoDO);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    AccountDO getById(Long id);

    /**
     * 查询列表(分页)
     *
     * @param query
     * @return
     */
    PageInfo<AccountDO> pageList(Query query);

    PageInfo<AccountDO> pageListExclusive(Query query);

    Map<String, Long> countSum(Map<String, Object> parameters);

    /**
     * 查询列表(分页)
     *
     * @param query
     * @return
     */
    PageInfo<AccountDetailDO> pageListDetail(Query query);

    /**
     * 查询列表(无分页)
     *
     * @param query
     * @return
     */
    List<AccountDO> list(Map<String, Object> params);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    AccountInfoVO accountDetail(Long id);

    /**
     * 上报银行
     *
     * @param obj
     */
    void reportBank(AccountReqVO obj);

    /**
     * 获取电子回单信息
     * @param account
     * @return
     */
    AaccountElectronicReceiptDO getAccounElectronic(String account);
}
