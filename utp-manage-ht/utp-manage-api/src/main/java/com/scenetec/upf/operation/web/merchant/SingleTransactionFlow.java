package com.scenetec.upf.operation.web.merchant;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoAuthDo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.domain.merchant.QuerySingleTransStatusRespDTO;
import com.scenetec.upf.operation.model.vo.QuerySingleTransStatusReqDTO;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.SHA1;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(value = "单笔流水查询", tags = {"单笔流水查询"})
@RestController
public class SingleTransactionFlow {
    @Value("${account.flow.querySingleTransStatus.url}")
    private String innerAccountUrl;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/api/singleTransactionFlow", method = RequestMethod.POST)
    public List<QuerySingleTransStatusRespDTO> list(@RequestBody QuerySingleTransStatusReqDTO query) {
        if (StringUtils.isBlank(query.getIndustryCode()) || StringUtils.isBlank(query.getClientTransId())|| StringUtils.isBlank(query.getTransDate())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        RestTemplate restTemplate = new RestTemplate();
        try {
            query.setSign(SHA1.genWithAmple(query.toSHA1()));
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.AUCRD001);
        }
        QuerySingleTransStatusRespDTO resultMap = restTemplate.postForObject(innerAccountUrl, query, QuerySingleTransStatusRespDTO.class);
        if (resultMap == null) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机问题。返回空" + innerAccountUrl);
        }
        if (!"200".equals(resultMap.getStatus())) {
            if (resultMap.getMessage() != null) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, (String) resultMap.getMessage());
            }
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "单笔交易流水获取失败");
        }
        List  list = new ArrayList();
        list.add(resultMap);
        return list;
    }
}
