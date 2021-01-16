package com.scenetec.upf.operation.service.merchant.impl;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.domain.system.Organization;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.merchant.MerchantInfoMapper;
import com.scenetec.upf.operation.repository.system.OrganizationMapper;
import com.scenetec.upf.operation.service.industry.IndustryService;
import com.scenetec.upf.operation.service.merchant.MerchantImportService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.LoggerUtil;
import com.scenetec.upf.operation.utils.PoiExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.*;

/**
 * @author shendunyuan@scenetec.com
 * 2018/7/11 下午5:07
 */
@Service
@Slf4j
public class MerchantImportServiceImpl implements MerchantImportService {

	@Resource
    MerchantInfoMapper mapper;
	@Resource
	OrganizationMapper organizationMapper;

	@Resource
	UserService userService;

	@Resource
	AccountMapper accountMapper;

	@Resource
    IndustryMapper industryMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public String upload(MultipartFile file, org.springframework.core.io.Resource resource) {
		InputStream is;
		InputStream xml;
		XLSReader mainReader;
		try {
			is = file.getInputStream();
			xml=resource.getInputStream();
			mainReader = ReaderBuilder.buildFromXML( xml );
		}catch (Exception e){
			throw new SystemRuntimeException(ErrorCode.BSMME002);
		}
		List<MerchantInfoDO> merchantInfoDOS=new ArrayList<>();
		Map beans = new HashMap();
		beans.put("items", merchantInfoDOS);
		ReaderConfig.getInstance().setSkipErrors( false );
		try {
			mainReader.read(is, beans);
		}catch (Exception e){
			throw new SystemRuntimeException(ErrorCode.BSMME002);
		}
		if(merchantInfoDOS.size()<=1){
            throw new SystemRuntimeException(ErrorCode.BSMME0021,"商户号");
        }
        if(merchantInfoDOS.size()>2001){
            throw new SystemRuntimeException(ErrorCode.BSMME0025,"2000");
        }
		for(int i=0;i<merchantInfoDOS.size()-1;i++) {
			MerchantInfoDO merchantInfoDO=merchantInfoDOS.get(i);
            if(checkAvailable(merchantInfoDO)) {
                merchantInfoDO.setId(IdGenerate.getId());
                mapper.create(merchantInfoDO);
                merchantInfoDO.setId(IdGenerate.getId());
                mapper.createAccount(merchantInfoDO);
                createVirtualAccount(merchantInfoDO);
            }else {
                mapper.update(merchantInfoDO);
                mapper.updateAccount(merchantInfoDO);
                enableAccount(merchantInfoDO.getMerNo());
            }
		}
		return null;
	}
    boolean checkAvailable(MerchantInfoDO merchantInfoDO){
        String reg = "^[a-zA-Z0-9]+$";
	    //商户号判断
	    if(merchantInfoDO.getMerNo()==null){
            throw new SystemRuntimeException(ErrorCode.BSMME0021,"商户号");
        }
        if (merchantInfoDO.getMerNo().length() > 20) {
            throw new SystemRuntimeException(ErrorCode.BSMME0022,"商户号","20");
        }
        if (!merchantInfoDO.getMerNo().matches(reg)) {
            throw new SystemRuntimeException(ErrorCode.BSMME0023,"商户号");
        }
        if(merchantInfoDO.getMerName()==null){
            throw new SystemRuntimeException(ErrorCode.BSMME0021,"商户名称");
        }
        if (merchantInfoDO.getMerName().length() > 200) {
            throw new SystemRuntimeException(ErrorCode.BSMME0022,"商户名称","200");
        }

        if(merchantInfoDO.getOrgCode()==null){
            throw new SystemRuntimeException(ErrorCode.BSMME0021,"所属收单机构代码");
        }
        if (merchantInfoDO.getOrgCode().length() > 12) {
            throw new SystemRuntimeException(ErrorCode.BSMME0022,"所属收单机构代码","12");
        }
        if (!merchantInfoDO.getOrgCode().matches(reg)) {
            throw new SystemRuntimeException(ErrorCode.BSMME0023,"所属收单机构代码");
        }
        Organization org = organizationMapper.findOneByOrgCode(merchantInfoDO.getOrgCode(),"0");
        if(org==null){
            throw new SystemRuntimeException(ErrorCode.BSMME0026,"所属收单机构代码");
        }

        if(merchantInfoDO.getIndustryCode()==null){
            throw new SystemRuntimeException(ErrorCode.BSMME0021,"平台编号");
        }
        if (merchantInfoDO.getIndustryCode().length() > 12) {
            throw new SystemRuntimeException(ErrorCode.BSMME0022,"平台编号","12");
        }
        if (!merchantInfoDO.getIndustryCode().matches(reg)) {
            throw new SystemRuntimeException(ErrorCode.BSMME0023,"平台编号");
        }
        IndustryDO query=new IndustryDO();
        query.setCode(merchantInfoDO.getIndustryCode());
        IndustryDO idt = industryMapper.selectOne(query);
        if(idt==null){
            throw new SystemRuntimeException(ErrorCode.BSMME0026,"平台编号");
        }
        merchantInfoDO.setOrgName(org.getFullName());
        merchantInfoDO.setIndustryName(idt.getName());
        merchantInfoDO.setGmtCreate(new Date());
        merchantInfoDO.setGmtModified(new Date());
        merchantInfoDO.setUserCreate(userService.getUserContext().getUsername());
        merchantInfoDO.setUserModified(userService.getUserContext().getUsername());
        merchantInfoDO.setStatus("1");
        MerchantInfoDO ckMer = new MerchantInfoDO();
        ckMer.setMerNo(merchantInfoDO.getMerNo());
        ckMer = mapper.selectOne(ckMer);
        if (ckMer == null) {
            return true;
        }else if(ckMer.getStatus().equals("0")){
            merchantInfoDO.setId(ckMer.getId());
            return false;
        }else {
            throw new SystemRuntimeException(ErrorCode.BSMME0024,"商户号");
        }
    }
	//创建虚拟账户
	void createVirtualAccount(MerchantInfoDO obj){
		AccountDO accountDO=new AccountDO();
		accountDO.setAccount(obj.getIndustryCode()+obj.getMerNo());
		accountDO.setObjType("2");
		accountDO.setObjCode(obj.getMerNo());
		accountDO.setObjName(obj.getMerName());
		accountDO.setBalance(0L);
		accountDO.setAvailAmount(0L);
		accountDO.setFrozenAmount(0L);
		accountDO.setGmtCreate(new Date());
		accountDO.setGmtModified(new Date());
		accountDO.setUserCreate(userService.getUserContext().getUsername());
		accountDO.setUserModified(userService.getUserContext().getUsername());
		accountDO.setStatus("1");
        accountDO.setId(IdGenerate.getId());
		accountMapper.create(accountDO);
	}
    void enableAccount(String objCode){
        AccountDO accountDO=new AccountDO();
        accountDO.setStatus("1");
        accountDO.setObjType("2");
        accountDO.setObjCode(objCode);
        accountMapper.updateByObj(accountDO);
    }

}