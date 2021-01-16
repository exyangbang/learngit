package com.scenetec.upf.operation.web.certificate;

import com.scenetec.upf.operation.service.certificate.CertificateMerchantInfoExtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangyongchao
 * @date 2018/7/24
 */
@Api(value="证书商户关联模块",tags={"证书商户关联表"})
@RestController
public class CertificateMerchantInfoExtController {

    @Resource
    CertificateMerchantInfoExtService service;

    @ApiOperation(value = "证书关联商户接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "certificateId",value = "证书编号",paramType = "path",required = true),
        @ApiImplicitParam(name = "merchants",value = "商户编号列表",required = true)
    })
    @RequestMapping(value = "/api/certificateMerchantInfo/{certificateId}", method = RequestMethod.POST)
    public void certificateMerchantInfo(@PathVariable String certificateId , @RequestBody List<String> merchants) {

         service.certificateMerchantInfo(certificateId,merchants);
    }
}
