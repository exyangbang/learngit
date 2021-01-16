package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IFreeFundsOpeApprovalHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.FreeFundsOpeApprovalBo;
import cn.kingnet.utp.service.persistence.service.MerchantInfoService;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description : 资金冻结解冻记录服务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/2/25 19:00
 */
@RestController
@RequestMapping("/spi/persistence/freezebalance")
@Slf4j
public class FreeFundsOpeApprovalHandler extends DefaultFeginExceptionHandler implements IFreeFundsOpeApprovalHandler {

	@Resource
	private MerchantInfoService merchantInfoService;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveFreeFundsOpeApproval(@RequestBody FreeFundsOpeApprovalBo freeFundsOpeApprovalBo) {

		//查询虚拟账户信息
		Account account = MybatisDaoImpl.run().selectOne(AccountCondition.builder().andAccountEq(freeFundsOpeApprovalBo.getUserAccount()).build());
		//查询商户基本信息
		MerchantInfo merchantInfo = merchantInfoService.selectOne(MerchantInfoCondition.builder().andAccountEq(freeFundsOpeApprovalBo.getUserAccount()).build());

		FreezingFundsOpeApproval freezingFundsOpeApproval = FreezingFundsOpeApproval.builder()
				.id(IdGenerate.getId())
				.account(freeFundsOpeApprovalBo.getUserAccount())
				.objType(account.getObjType())
				.busLicCode(merchantInfo.getBusLicCode())
				.objName(account.getObjName())
				.code(merchantInfo.getIndustryCode())
				.indName(merchantInfo.getIndustryName())
				.operationType(freeFundsOpeApprovalBo.getOperationType())
				.frozenAmount(freeFundsOpeApprovalBo.getAmount())
				.serverTransId(freeFundsOpeApprovalBo.getServerTransId())
				.clinetTransId(freeFundsOpeApprovalBo.getClientTradeId())
				.addUsr("1")
				.userCreate(account.getObjName())
				.gmtCreate(new Date())
				.auditStatus("1")
				.build();
		if(freezingFundsOpeApproval.getOperationType().equals("1")){
			freezingFundsOpeApproval.setFreezeId(freeFundsOpeApprovalBo.getFreezeId());
			freezingFundsOpeApproval.setUnfreezeStatus(freeFundsOpeApprovalBo.getUnfreezeStatus());
		}

		MybatisDaoImpl.run().insert(freezingFundsOpeApproval);
	}
}
