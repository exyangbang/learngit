package com.scenetec.upf.operation.service.blacklist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.blacklisapproval.BlacklistApprovalDO;
import com.scenetec.upf.operation.model.vo.BlacklistOperationRecordVO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface BlacklistApprovalService {
    Long create(BlacklistOperationRecordVO blacklistOperationRecordVO);

    void update(BlacklistOperationRecordVO blacklistOperationRecordVO);

    PageInfo<BlacklistApprovalDO> pageList(Query query);
}
