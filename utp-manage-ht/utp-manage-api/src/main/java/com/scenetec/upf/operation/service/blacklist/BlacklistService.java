package com.scenetec.upf.operation.service.blacklist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.blacklist.BlacklistDO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface BlacklistService {
    PageInfo<BlacklistDO> getBlackList(Query query);
}
