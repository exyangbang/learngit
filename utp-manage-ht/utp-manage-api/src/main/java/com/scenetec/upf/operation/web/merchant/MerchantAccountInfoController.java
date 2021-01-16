package com.scenetec.upf.operation.web.merchant;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantAccountInfoDO;
import com.scenetec.upf.operation.service.merchant.MerchantAccountInfoSrvice;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "银行", tags = {"商户账户信息表"})
public class MerchantAccountInfoController {
    @Resource
    private MerchantAccountInfoSrvice accountInfoSrvice;

    @RequestMapping(value = "/api/merchantAccountInfo/list", method = RequestMethod.POST)
    public PageInfo<MerchantAccountInfoDO> list(@RequestBody Query query) {
        return accountInfoSrvice.getBankList(query);
    }


}
