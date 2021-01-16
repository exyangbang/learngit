package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.product.account.service.inner.manage.ManageException;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IFreeFundsOpeApprovalHandler;
import cn.kingnet.utp.service.persistence.api.IManageHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.FreezingFundsOpeApproval;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.bo.FreeFundsOpeApprovalBo;
import cn.kingnet.utp.service.persistence.entity.vo.FreezingFundsOpeApprovalVo;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.FreezeBalanceReqDTO;
import cn.kingnet.utp.trade.common.dto.account.FreezeBalanceRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 用户账户资金冻结/解冻
 *
 * @author sheqingquan@scenetec.com
 * @date 2019-03-04
 */
@Slf4j
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.FREEZE_BALANCE,
        reqClass = FreezeBalanceReqDTO.class,
        respClass = FreezeBalanceRespDTO.class
)
public class FreezeBalanceService extends AbstractAccountTradeService<FreezeBalanceReqDTO, FreezeBalanceRespDTO> {

    private IManageHandler manageHandler;
    private IFreeFundsOpeApprovalHandler freeFundsOpeApprovalHandler;

    public FreezeBalanceService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties, IManageHandler manageHandler, IFreeFundsOpeApprovalHandler freeFundsOpeApprovalHandler) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
        this.manageHandler = manageHandler;
        this.freeFundsOpeApprovalHandler = freeFundsOpeApprovalHandler;
    }

    @Override
    protected void verifyReqParam(TradeContext<FreezeBalanceReqDTO, FreezeBalanceRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        setBasicConfigInfo(tradeContext, null);
        FreezeBalanceReqDTO freezeBalanceReqDTO = tradeContext.getRequestDTO();

        ValidateUtils.abcValid(freezeBalanceReqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(freezeBalanceReqDTO.getUserAccount(), 19, true, "用户账户");

        ValidateUtils.isYyyyMMdd(freezeBalanceReqDTO.getReqDate(), true, "请求日期");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(freezeBalanceReqDTO.getReqDate())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        }

        ValidateUtils.maxLength(freezeBalanceReqDTO.getAmount(), 15, true, "交易金额");
        ValidateUtils.isIntegerNegative(freezeBalanceReqDTO.getAmount(), true, "交易金额");
        if (freezeBalanceReqDTO.getAmount() == null || Long.valueOf(freezeBalanceReqDTO.getAmount()) <= 0) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "冻结/解冻金额必须大于0");
        }

        ValidateUtils.maxLength(freezeBalanceReqDTO.getType(), 2, true, "操作类型");
        if (freezeBalanceReqDTO.getType().equals("1")) {
            ValidateUtils.maxLength(freezeBalanceReqDTO.getOrigTradeId(), 34, true, "原客户端流水/服务端流水");
            //根据userAccount+origtradeId 查询 冻结解冻表，不存在抛异常 存在则校验其原冻结金额是否和解冻金额一致，不一致抛异常
            FreezingFundsOpeApproval freezingFundsOpeApproval = manageHandler.selectFreezingFundsOpeApproval(FreezingFundsOpeApprovalVo.builder()
                    .account(freezeBalanceReqDTO.getUserAccount()).clinetTransId(freezeBalanceReqDTO.getOrigTradeId()).build());
            if (freezingFundsOpeApproval == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此对应账户+客户端流水号相关记录");
            }
            if (freezingFundsOpeApproval.getFrozenAmount() == null || Long.valueOf(freezeBalanceReqDTO.getAmount()) != freezingFundsOpeApproval.getFrozenAmount().longValue()) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "交易金额与库表记录不相符");
            }
            //缓存冻结id
            tradeContext.setAttribute("FreezeBalance_".concat(freezeBalanceReqDTO.getUserAccount()), freezingFundsOpeApproval.getId());
        }

        //校验虚拟账户只能是 2-企业商户 3-个人 这两种才能操作
        Account account = accountHandler.findAccount(freezeBalanceReqDTO.getUserAccount());
        if (account == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此对应账户记录");
        }
        if (!(account.getObjType().equals(VirtualAccountType.MERCHANT.getType()) || account.getObjType().equals(VirtualAccountType.PERSON.getType()))) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "该账户类型不支持冻结/解冻操作");
        }

        //查询个人和企业商户信息
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(freezeBalanceReqDTO.getUserAccount());
        if (merchantInfo == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此对应商户信息");
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        //企业用户只有审核通过才可能出入金
        if(VirtualAccountType.MERCHANT.getType().equals(merchantInfo.getNature())){
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(merchantInfo.getAuthStatus());
            if(MerAuthStatus.NORMAL != merAuthStatus){
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "用户账户审核状态[" + merAuthStatus.getValue() + "],不允许操作!");
            }
        }
    }

    @Override
    public void initTransFlow(TradeContext<FreezeBalanceReqDTO, FreezeBalanceRespDTO> tradeContext) {

    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<FreezeBalanceReqDTO, FreezeBalanceRespDTO> tradeContext) {
        FreezeBalanceReqDTO freezeBalanceReqDTO = tradeContext.getRequestDTO();
        String operationType = freezeBalanceReqDTO.getType();
        String serverTransId = tradeContext.getServerTransId();

        FreezeBalanceRespDTO resq = new FreezeBalanceRespDTO();
        resq.setClientTradeId(tradeContext.getClientTradeId());
        resq.setServerTradeId(tradeContext.getServerTransId());
        resq.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        switch (operationType) {
            case "0": {
                String clientTradeId = StringUtil.isEmpty(freezeBalanceReqDTO.getOrigTradeId()) ? freezeBalanceReqDTO.getClientTradeId() : freezeBalanceReqDTO.getOrigTradeId();
                String remark = "接口用户账户资金冻结金额";
                AccountOperBo accountOperBo = AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.OTHER).userAccount(freezeBalanceReqDTO.getUserAccount()).amount(Long.valueOf(freezeBalanceReqDTO.getAmount()))
                        .peerAccNo(freezeBalanceReqDTO.getUserAccount()).remark(remark)
                        .serverTransId(serverTransId).outsideOrderId(clientTradeId).build();
                if (accountHandler.freezeAccountBalance(accountOperBo)) {
                    try {
                        //保存解冻记录
                        FreeFundsOpeApprovalBo freeFundsOpeApprovalBo = buildFreeFundsOpeApproval(freezeBalanceReqDTO, clientTradeId, serverTransId);
                        freeFundsOpeApprovalHandler.saveFreeFundsOpeApproval(freeFundsOpeApprovalBo);
                    } catch (Exception e) {
                        log.error("服务端流水{},保存冻结记录异常：{}", serverTransId, e.getMessage(), e);
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, "保存冻结记录异常");
                    }
                    resq.setStatus(HttpRespStatus.OK.valueStr());
                    resq.setMessage(HttpRespStatus.OK.getReasonPhrase());
                } else {
                    resq.setStatus(HttpRespStatus.BAD_REQUEST.valueStr());
                    resq.setMessage("冻结金额失败");
                }
            }
            break;
            case "1": {
                String clientTradeId = freezeBalanceReqDTO.getOrigTradeId();
                String remark = "接口用户账户资金解冻金额";
                Long freezeId = Long.valueOf(tradeContext.getAttribute("FreezeBalance_".concat(freezeBalanceReqDTO.getUserAccount())).toString());
                AccountOperBo accountOperBo = AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.OTHER).userAccount(freezeBalanceReqDTO.getUserAccount()).amount(Long.valueOf(freezeBalanceReqDTO.getAmount()))
                        .peerAccNo(freezeBalanceReqDTO.getUserAccount()).remark(remark)
                        .serverTransId(serverTransId).outsideOrderId(clientTradeId).build();
                if (accountHandler.unfreezeAccountBalance(accountOperBo)) {
                    try {
                        //保存解冻记录
                        FreeFundsOpeApprovalBo freeFundsOpeApprovalBo = buildFreeFundsOpeApproval(freezeBalanceReqDTO, clientTradeId, serverTransId);
                        freeFundsOpeApprovalBo.setFreezeId(freezeId);
                        freeFundsOpeApprovalBo.setUnfreezeStatus("1");
                        freeFundsOpeApprovalHandler.saveFreeFundsOpeApproval(freeFundsOpeApprovalBo);
                    } catch (Exception e) {
                        log.error("服务端流水{},保存解冻记录异常：{}", serverTransId, e.getMessage(), e);
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, "保存解冻记录异常");
                    }

                    resq.setStatus(HttpRespStatus.OK.valueStr());
                    resq.setMessage(HttpRespStatus.OK.getReasonPhrase());
                } else {
                    resq.setStatus(HttpRespStatus.BAD_REQUEST.valueStr());
                    resq.setMessage("解冻金额失败");
                }
            }
            break;
            default: {
                throw new ManageException(HttpRespStatus.BAD_REQUEST, "暂不支持的操作类型[" + operationType + "]");
            }
        }
        tradeContext.setResponseDTO(resq);
        HttpRespStatus httpRespStatus = HttpRespStatus.resolve(resq.getStatus());
        return ChannelResponseUtil.build(resq, null, null, httpRespStatus == null ? HttpRespStatus.BAD_REQUEST : httpRespStatus, resq.getMessage());
    }

    @Override
    public void updateTransFlow(TradeContext<FreezeBalanceReqDTO, FreezeBalanceRespDTO> tradeContext) {

    }

    /**
     * 构建冻结/解冻记录
     *
     * @param freezeBalanceReqDTO
     * @param clientTradeId
     * @param serverTransId
     * @return
     */
    private FreeFundsOpeApprovalBo buildFreeFundsOpeApproval(FreezeBalanceReqDTO freezeBalanceReqDTO, String clientTradeId, String serverTransId) {
        FreeFundsOpeApprovalBo freeFundsOpeApprovalBo = FreeFundsOpeApprovalBo.builder()
                .userAccount(freezeBalanceReqDTO.getUserAccount())
                .amount(Long.valueOf(freezeBalanceReqDTO.getAmount()))
                .clientTradeId(clientTradeId)
                .serverTransId(serverTransId)
                .operationType(freezeBalanceReqDTO.getType())
                .build();
        return freeFundsOpeApprovalBo;
    }
}
