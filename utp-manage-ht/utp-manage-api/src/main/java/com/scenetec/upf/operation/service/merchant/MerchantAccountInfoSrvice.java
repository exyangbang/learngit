package com.scenetec.upf.operation.service.merchant;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantAccountInfoDO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface MerchantAccountInfoSrvice {
    PageInfo<MerchantAccountInfoDO> getBankList(Query query);
}
