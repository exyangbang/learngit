package com.scenetec.upf.operation.web.merchant;


import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.merchant.MerchantInfoVo;
import com.scenetec.upf.operation.service.merchant.MerchantInfoExtService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scenetec
 * @date 2018/07/25
 */
@Api(value="商户基本信息表扩展",tags={"商户基本信息表"})
@RestController
public class MerchantInfoExtController {

    @Resource
    MerchantInfoExtService service;

    @RequestMapping(value = "/api/merchantInfo/queryListWithCertId", method = RequestMethod.POST)
    public PageInfo<MerchantInfoVo> queryListWithCertId(@RequestBody Query query) {
	    return service.queryListWithCertId(query);
	}

	@RequestMapping(value = "/api/merchantInfo/delete/{id}", method = RequestMethod.DELETE)
	public int delete(@PathVariable Long id){
    	return service.delete(id);
	}

	@RequestMapping(value = "/api/merchantInfo/add", method = RequestMethod.POST)
	public long create(@RequestBody MerchantInfoDO obj){
    	return service.create(obj);
	}
}
