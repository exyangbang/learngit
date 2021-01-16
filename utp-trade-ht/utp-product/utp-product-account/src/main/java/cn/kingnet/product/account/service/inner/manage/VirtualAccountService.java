package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.utp.product.common.dto.manage.FreezenBalanceReqDTO;
import cn.kingnet.utp.product.common.dto.manage.FreezenBalanceRespDTO;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IManageHandler;
import cn.kingnet.utp.service.persistence.entity.FreezingFundsOpeApproval;
import cn.kingnet.utp.service.persistence.entity.vo.FreezingFundsOpeApprovalVo;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Description
 * @Author WJH
 * @Date 2019/10/16
 */
@Service
public class VirtualAccountService {
    private IAccountHandler accountHandler;
    private IManageHandler manageHandler;

    @Resource
    private ServerIdGenerate serverIdGenerate;

    public VirtualAccountService(IAccountHandler accountHandler, IManageHandler manageHandler) {
        this.accountHandler = accountHandler;
        this.manageHandler = manageHandler;
    }

    static String[] auditStatusAy = new String[]{"0", "1", "2"};


    public FreezenBalanceRespDTO freezenBalance(FreezenBalanceReqDTO freezenBalanceReqDTO) {
        FreezenBalanceRespDTO respDTO = new FreezenBalanceRespDTO();
        BeanUtils.copyProperties(freezenBalanceReqDTO, respDTO);
        if (freezenBalanceReqDTO == null) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "请求报文不能为空");
        }
        if (freezenBalanceReqDTO.getFrozenAmount() == null || freezenBalanceReqDTO.getFrozenAmount().longValue() <= 0) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "冻结/解冻金额必须大于0");
        }
        ValidateUtils.maxLength(freezenBalanceReqDTO.getIndustryCode(), 32, true, "客户号");
        ValidateUtils.maxLength(freezenBalanceReqDTO.getClientTransId(), 32, true, "客户端流水号");
        ValidateUtils.maxLength(freezenBalanceReqDTO.getUserAccount(), 19, true, "虚拟账号");
        String auditStatus = freezenBalanceReqDTO.getAuditStatus();
        if (!Arrays.asList(auditStatusAy).contains(auditStatus)) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "审核状态值[" + auditStatus + "]不合法");
        }
        ValidateUtils.hasText(freezenBalanceReqDTO.getOperationType(),"操作类型");
        if (!SHA1.genWithAmple(freezenBalanceReqDTO.toSHA1()).equals(freezenBalanceReqDTO.getSign())) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }
        //验证客户端流水号存在且对应的记录 和 上送接口一致
        FreezingFundsOpeApproval freezingFundsOpeApproval = manageHandler.selectFreezingFundsOpeApproval(FreezingFundsOpeApprovalVo.builder()
                .account(freezenBalanceReqDTO.getUserAccount()).clinetTransId(freezenBalanceReqDTO.getClientTransId()).build());
        if (freezingFundsOpeApproval == null) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "查无此对应账户+客户端流水号相关记录");
        }
        if (freezingFundsOpeApproval.getFrozenAmount() == null || freezenBalanceReqDTO.getFrozenAmount().longValue() != freezingFundsOpeApproval.getFrozenAmount().longValue()) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "交易金额与库表记录不相符");
        }
        String operationType = freezenBalanceReqDTO.getOperationType();
        String serverTransId = serverIdGenerate.generateServerTransId();
        respDTO.setServerTransId(serverTransId);
        switch (operationType) {
            case "0": {
                AccountOperBo accountOperBo = AccountOperBo.builder().industryCode(freezenBalanceReqDTO.getIndustryCode())
                        .accountOperSubType(AccountOperSubType.OTHER).userAccount(freezenBalanceReqDTO.getUserAccount()).amount(freezenBalanceReqDTO.getFrozenAmount())
                        .peerAccNo(freezenBalanceReqDTO.getUserAccount()).remark("人工后管冻结金额")
                        .serverTransId(serverTransId).outsideOrderId(freezenBalanceReqDTO.getClientTransId()).build();
                if (accountHandler.freezeAccountBalance(accountOperBo)) {
                    respDTO.setStatus(HttpRespStatus.OK.valueStr());
                }
            }
            break;
            case "1": {
                AccountOperBo accountOperBo = AccountOperBo.builder().industryCode(freezenBalanceReqDTO.getIndustryCode())
                        .accountOperSubType(AccountOperSubType.OTHER).userAccount(freezenBalanceReqDTO.getUserAccount()).amount(freezenBalanceReqDTO.getFrozenAmount())
                        .peerAccNo(freezenBalanceReqDTO.getUserAccount()).remark("人工后管解冻金额")
                        .serverTransId(serverTransId).outsideOrderId(freezenBalanceReqDTO.getClientTransId()).build();
                if (accountHandler.unfreezeAccountBalance(accountOperBo)) {
                    respDTO.setStatus(HttpRespStatus.OK.valueStr());
                }
            }
            break;
            default: {
                throw new ManageException(HttpRespStatus.BAD_REQUEST, "暂不支持的操作类型[" + operationType + "]");
            }
        }
        return respDTO;
    }
}
