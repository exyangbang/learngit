package com.scenetec.upf.operation.service.merchant.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import com.scenetec.upf.operation.model.domain.country.CountryDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoAuthDo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.AccountInfoVO;
import com.scenetec.upf.operation.model.vo.UploadIndustryMerchantImagesRespDTO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.codedictionary.CodeDictionaryMapper;
import com.scenetec.upf.operation.repository.country.CountryMapper;
import com.scenetec.upf.operation.repository.merchant.MerchantInfoMapper;
import com.scenetec.upf.operation.service.imageHanlder.ImageHanlderService;
import com.scenetec.upf.operation.service.merchant.MerchantInfoService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.SHA1;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/07/25
 */
@Service
public class MerchantInfoServiceImpl implements MerchantInfoService {
    private static final String secret = "mh7d3scgRHvk0AO6";
    @Resource
    MerchantInfoMapper mapper;

    @Resource
    private UserService userService;

    @Resource
    AccountMapper accountMapper;

    @Value("${innerAccount.auth.url}")
    private String innerAccountUrl;

    @Resource
    CountryMapper countryMapper;
    @Resource
    CodeDictionaryMapper codeDictionaryMapper;
    @Resource
    ImageHanlderService imageHanlderService;

    @Override
    public long create(MerchantInfoDO obj) {

        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtCreate(new Date());
        obj.setId(IdGenerate.getId());
        mapper.create(obj);
        return obj.getId();
    }

    @Override
    public int delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public void update(MerchantInfoDO obj) {
        MerchantInfoDO dbMerchantInfo = mapper.getById(obj.getId());

        AccountInfoVO accountInfoVO = new AccountInfoVO();
        accountInfoVO.setAccount(dbMerchantInfo.getAccount());
        accountInfoVO.setIndustryCode(dbMerchantInfo.getIndustryCode());
        accountInfoVO.setBusLicPic(obj.getBusLicPic());
        accountInfoVO.setPersonPic(obj.getPersonPic());
        accountInfoVO.setPersonReversePic(obj.getPersonReversePic());
        accountInfoVO.setLicensePic(obj.getLicensePic());
        //上传转换图片
        UploadIndustryMerchantImagesRespDTO imagesRespDTO = imageHanlderService.uploadImageReque(accountInfoVO);

        MerchantInfoDO temObj = new MerchantInfoDO();
        temObj.setGmtModified(new Date());
        temObj.setUserModified(userService.getUserContext().getUsername());

        temObj.setLicensePic(imagesRespDTO.getLicensePicPath());
        temObj.setPersonPic(imagesRespDTO.getPersonPicPath());
        temObj.setBusLicPic(imagesRespDTO.getBusLicPicPath());
        temObj.setPersonReversePic(imagesRespDTO.getPersonReversePicPath());
        temObj.setId(obj.getId());
        temObj.setAuthStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        mapper.update(temObj);

//        if (StringUtils.isNoneBlank(obj.getMerNo())
//                && StringUtils.isNoneBlank(obj.getMerName())) {
//            AccountDO accountDO = new AccountDO();
//            accountDO.setObjCode(obj.getMerNo());
//            accountDO.setObjType("2");
//            accountDO.setObjName(obj.getMerName());
//            accountMapper.updateByObj(accountDO);
//        }

    }

    /**
     * 企业认证审批
     *
     * @param obj
     */
    @Override
    public void updateAuth(MerchantInfoAuthDo obj) {
        if (obj.getId() == null || obj.getAuthStatus() == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        RestTemplate restTemplate = new RestTemplate();
        obj.setUserModified(userService.getUserContext().getUsername());
        try {
            obj.setSign(SHA1.genWithAmple(obj.toSHA1(secret)));
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.AUCRD001);
        }
        Map<String, Object> resultMap = restTemplate.postForObject(innerAccountUrl, obj, Map.class);
        if (resultMap == null) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机问题。返回空" + innerAccountUrl);
        }
        if (!"200".equals(resultMap.get("status"))) {
            if (resultMap.get("message") != null) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, (String) resultMap.get("message"));
            }
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "审核失败");
        }
    }

    @Override
    public MerchantInfoDO getById(Long id) {
        MerchantInfoDO mer = mapper.getById(id);
        if (mer != null) {
            CountryDO countryDO = countryMapper.getByThreeBitLetters(mer.getCountry());
            if (countryDO != null) {
                mer.setCountry(countryDO.getChName() + "(" + countryDO.getThreeBitLetters() + ")");
            }
            CodeDictionaryDO codeDictionaryDO = codeDictionaryMapper.getByCode(mer.getProsession());
            if (codeDictionaryDO != null) {
                mer.setProsession(codeDictionaryDO.getValue() + "(" + codeDictionaryDO.getCode() + ")");
            }
            AccountDO accountDO = new AccountDO();
            accountDO.setAccount(mer.getAccount());
            accountDO = accountMapper.selectOne(accountDO);
            Map map = new HashMap();
            map.put("account",mer.getAccount());
            map.put("objType",accountDO.getObjType());
            MerchantInfoDO merchantInfoDO = imageHanlderService.getImage(map);
            mer.setPersonPic(merchantInfoDO.getPersonPic());
            mer.setPersonReversePic(merchantInfoDO.getPersonReversePic());
            mer.setLicensePic(merchantInfoDO.getLicensePic());
            mer.setBusLicPic(merchantInfoDO.getBusLicPic());
        }
        return mer;
    }

    @Override
    public PageInfo<MerchantInfoDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_create desc");
        Map<String, Object> params = query.getParameters();
        if (params.get("merName") != null) {
            params.put("merName", ((String) params.get("merName")).replaceAll("\u0025", "\\\\\u0025"));
        }
        if (params.get("merNo") != null) {
            params.put("merNo", ((String) params.get("merNo")).replaceAll("\u0025", "\\\\\u0025"));
        }
        //已经销户的状态不显示
        Map tempMap = query.getParameters();
        tempMap.put("status", "3");
        Page<MerchantInfoDO> page = mapper.list(tempMap);
        return new PageInfo<>(page);
    }

    /**
     * 获取子账户，如果被选过的的子账户需要屏蔽
     *
     * @param query
     * @return
     */
    @Override
    public PageInfo<MerchantInfoDO> listExclusionOfSelection(Query query) {
        //已经销户的状态不显示
        Map tempMap = query.getParameters();
        tempMap.put("status", "3");
        Page<MerchantInfoDO> page = mapper.listExclusionOfSelection(tempMap);
        return new PageInfo<>(page);
    }

}
