package com.scenetec.upf.operation.service.merchant.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.certificate.CertificateMerchantInfoDO;
import com.scenetec.upf.operation.model.domain.channel.ChannelMerchantDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.merchant.MerchantInfoVo;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.certificate.CertificateMerchantInfoMapper;
import com.scenetec.upf.operation.repository.channel.ChannelMerchantMapper;
import com.scenetec.upf.operation.repository.merchant.MerchantInfoExtMapper;
import com.scenetec.upf.operation.repository.merchant.MerchantInfoMapper;
import com.scenetec.upf.operation.service.merchant.MerchantInfoExtService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/07/25
 */
@Service
public class MerchantInfoExtServiceImpl implements MerchantInfoExtService {

    @Resource
    MerchantInfoExtMapper extMapper;
	@Resource
	MerchantInfoMapper mapper;
	@Resource
	CertificateMerchantInfoMapper cmMapper;
	@Resource
    UserService userService;
	@Resource
	AccountMapper accountMapper;
	@Resource
    ChannelMerchantMapper channelMerchantMapper;

    @Override
    public PageInfo<MerchantInfoVo> queryListWithCertId(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());        
	    Page<MerchantInfoVo> page = extMapper.queryListWithCertId(query.getParameters());
	    return new PageInfo<>(page);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public int delete(Long id) {
    	// 校验商户
    	MerchantInfoDO checkDo = mapper.getById(id);
    	if (checkDo == null) {
    		throw new SystemRuntimeException(ErrorCode.BSMME007);
	    }
	    // 校验是否绑定证书
		CertificateMerchantInfoDO cerMerDo = new CertificateMerchantInfoDO();
		cerMerDo.setMerNo(checkDo.getMerNo());
		List<CertificateMerchantInfoDO> cmList = cmMapper.selectList(cerMerDo);
		if (cmList != null && cmList.size() > 0) {
			throw new SystemRuntimeException(ErrorCode.BSMME008);
		}
        ChannelMerchantDO cmd=new ChannelMerchantDO();
		cmd.setMerNo(checkDo.getMerNo());
		Integer num=channelMerchantMapper.count(cmd);
        if(num!=0){
            throw new SystemRuntimeException(ErrorCode.BSMME010);
        }
        disableAccount(checkDo.getMerNo());
		// 修改商户状态
		MerchantInfoDO mer = new MerchantInfoDO();
		mer.setId(id);
		mer.setStatus("0");
    	return mapper.update(mer);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public long create(MerchantInfoDO obj) {

    	// 设置状态
    	obj.setStatus("1");
    	// 保存
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtCreate(new Date());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());

		MerchantInfoDO checkDo = new MerchantInfoDO();
		checkDo.setMerNo(obj.getMerNo());
		MerchantInfoDO mer=mapper.selectOne(checkDo);
		if(mer==null){
			obj.setId(IdGenerate.getId());
			mapper.create(obj);
			createVirtualAccount(obj);
		}else if(mer.getStatus().equals("0")){
			obj.setId(mer.getId());
			mapper.update(obj);
			enableAccount(mer.getMerNo());
		}else {
			throw new SystemRuntimeException(ErrorCode.BSMME009);
		}
		// 返回结果
		return obj.getId();
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
	void disableAccount(String objCode){
		AccountDO accountDO=new AccountDO();
		accountDO.setStatus("0");
		accountDO.setObjType("2");
		accountDO.setObjCode(objCode);
		accountMapper.updateByObj(accountDO);
	}
}
