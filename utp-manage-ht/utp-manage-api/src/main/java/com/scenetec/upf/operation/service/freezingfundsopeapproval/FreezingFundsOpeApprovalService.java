package com.scenetec.upf.operation.service.freezingfundsopeapproval;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.freezingfundsopeapproval.FreezingFundsOpeApprovalDO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface FreezingFundsOpeApprovalService {

    Long create(FreezingFundsOpeApprovalDO freezingDo);

    void update(FreezingFundsOpeApprovalDO freezingFundsOpeApprovalDO);

    PageInfo<FreezingFundsOpeApprovalDO> pageList(Query query);
}
