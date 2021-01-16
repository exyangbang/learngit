package cn.kingnet.product.account.handler;

import cn.kingnet.product.api.account.IAccountIncomeNoticeHandler;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBankAccountTransDetailHandler;
import cn.kingnet.utp.service.persistence.api.IChannelIncomeFlowHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.BankAccountTransDetail;
import cn.kingnet.utp.service.persistence.entity.ChannelIncomeFlow;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountIncomeNoticeReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountIncomeNoticeRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankReqHead;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankRspHead;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 华通内部账户入金通知
 * @Author : linkaigui
 * @Create : 2019/3/16 18:39
 */
@RestController
@RequestMapping("/innerAccount/accountIncomeNotice")
@Slf4j
public class AccountIncomeNoticeHandler extends DefaultFeginExceptionHandler implements IAccountIncomeNoticeHandler {

    private static final String reqchid = "0000";

    private final IAccountHandler accountHandler;

    private final IBankAccountTransDetailHandler bankAccountTransDetailHandler;

    private final IChannelIncomeFlowHandler channelIncomeFlowHandler;

    public AccountIncomeNoticeHandler(IAccountHandler accountHandler, IBankAccountTransDetailHandler bankAccountTransDetailHandler, IChannelIncomeFlowHandler channelIncomeFlowHandler) {
        this.accountHandler = accountHandler;
        this.bankAccountTransDetailHandler = bankAccountTransDetailHandler;
        this.channelIncomeFlowHandler = channelIncomeFlowHandler;
    }

    /**
     * 华通内部账户入金通知
     *
     * @param oneBankAccountIncomeNoticeReqDTO
     * @return
     */
    @Override
    public OneBankAccountIncomeNoticeRespDTO accountIncomeNotice(@RequestBody(required = false) OneBankAccountIncomeNoticeReqDTO oneBankAccountIncomeNoticeReqDTO) {
        LambdaLogger.info(log, "华通内部账户入金通知 >> 请求报文：{}", JSON.toJSONString(oneBankAccountIncomeNoticeReqDTO));

        OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder = OneBankAccountIncomeNoticeRespDTO.builder();
        OneBankRspHead.OneBankRspHeadBuilder rspHeadBuilder = OneBankRspHead.builder().reqchid(reqchid);
        OneBankAccountIncomeNoticeRespDTO.RspBody.RspBodyBuilder rspBodyBuilder = OneBankAccountIncomeNoticeRespDTO.RspBody.builder();
        OneBankAccountIncomeNoticeRespDTO noticeRespDTO = null;
        if (oneBankAccountIncomeNoticeReqDTO == null) {
            noticeRespDTO = this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031024, "通知报文为空", respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
            log.error("华通内部账户入金通知 << 参数校验失败 响应报文：{}", JSON.toJSONString(noticeRespDTO));
            return noticeRespDTO;
        }

        OneBankReqHead reqHead = oneBankAccountIncomeNoticeReqDTO.getReqHead();
        OneBankAccountIncomeNoticeReqDTO.ReqBody reqBody = oneBankAccountIncomeNoticeReqDTO.getReqBody();

        //校验参数
        boolean validateFlag = this.validateParam(reqHead, reqBody, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        if (!validateFlag) {
            noticeRespDTO = respDTOBuilder.build();
            log.error("华通内部账户入金通知 << 参数校验失败 响应报文：{}", JSON.toJSONString(noticeRespDTO));
            return noticeRespDTO;
        }

        try {
            //已入账和已手工入账 校验虚拟账户是否存在
            long balance = 0L;String industryCode=null,industryName = null,accountType=null;
            if (HTBizFlag.RECORED.getFlag().equals(reqBody.getBizFlag()) || HTBizFlag.HANDWORK_RECORED.getFlag().equals(reqBody.getBizFlag())) {
                Account account = accountHandler.findAccount(reqBody.getAcctNo());
                if (account == null || StringUtil.isBlank(account.getAccount())) {
                    noticeRespDTO = this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031004, "查无此虚账户记录", respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
                    log.error("华通内部账户入金通知 << 参数校验失败 响应报文：{}", JSON.toJSONString(noticeRespDTO));
                    return noticeRespDTO;
                }
                accountType = account.getObjType();
                Industry platformIndustry;
                if (VirtualAccountType.isFunctionAccount(account.getObjType())) {
                     platformIndustry = accountHandler.getIndustryByFunctionAccount(account.getAccount());
                    if (platformIndustry == null || StringUtil.isBlank(platformIndustry.getFundAccount())) {
                        noticeRespDTO = this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031019, "该功能账户关联平台账户未配置实体账户", respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
                        log.error("华通内部账户入金通知 << 参数校验失败 响应报文：{}", JSON.toJSONString(noticeRespDTO));
                        return noticeRespDTO;
                    }
                } else if (VirtualAccountType.isSubAccount(account.getObjType())) {
                    //1对外,0不对外 二级账户是否对外接款
                    platformIndustry = accountHandler.getIndustryBySubAccount(account.getAccount());
                    if (platformIndustry == null || !"1".equals(platformIndustry.getWhetherExternal())) {
                        noticeRespDTO = this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031019, "该二级子账户归属平台账户未开通对外接款权限", respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
                        log.error("华通内部账户入金通知 << 参数校验失败 响应报文：{}", JSON.toJSONString(noticeRespDTO));
                        return noticeRespDTO;
                    }
                } else {
                    return this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031011, "账户类型[" + account.getObjType() + "]暂无此接口权限", respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
                }

                if(platformIndustry!=null){
                    industryCode = platformIndustry.getCode();
                    industryName = platformIndustry.getName();
                }
                //acctName 非必填| 业务确认以平台查询的结果为准
                reqBody.setAcctName(account.getObjName());
                balance = account.getAvailAmount() + reqBody.getAmt();
            } else {
                noticeRespDTO = this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031004, "业务状态非已入账或手工入账", respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
                log.error("华通内部账户入金通知 << 参数校验失败 响应报文：{}", JSON.toJSONString(noticeRespDTO));
                return noticeRespDTO;
            }

          boolean existsNotice =  channelIncomeFlowHandler.isExistChannelIncomeFlowByCoreNo(reqBody.getAcctNo(),reqBody.getCoreNo());
          if(existsNotice){
              noticeRespDTO = this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031002, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
              log.error("华通内部账户入金通知 << accNo+coreNo已存在 响应报文：{}", JSON.toJSONString(noticeRespDTO));
              return noticeRespDTO;
          }

            //该二级账户通知是否已被拉取明细且已上账
            String handleFlag = TrueOrFalseStatus.FALSE.value();
            BankAccountTransDetail bankAccountTransDetail = bankAccountTransDetailHandler.queryByCoreNo(reqBody.getAcctNo(), reqBody.getCoreNo());
            if (bankAccountTransDetail != null && reqBody.getCoreNo().equals(bankAccountTransDetail.getSysReferenceNo())) {
                if (TrueOrFalseStatus.TRUE.value().equals(bankAccountTransDetail.getOperStatus())) {
                    handleFlag = TrueOrFalseStatus.TRUE.value();
                }
            }

            ChannelIncomeFlow channelIncomeFlow = ChannelIncomeFlow.builder()
                    .id(IdGenerate.getId())
                    .accNo(reqBody.getAcctNo())
                    .accName(reqBody.getAcctName())
                    .amt(reqBody.getAmt())
                    .coreNo(reqBody.getCoreNo())
                    .rid(reqBody.getRid())
                    .exAcctNo(reqBody.getExAcctNo())
                    .exAcctName(reqBody.getExAcctName())
                    .clearBankno(reqBody.getClearBankno())
                    .bankName(reqBody.getBankName())
                    .tranNo(reqBody.getTranNo())
                    .tranDate(reqBody.getTranDate())
                    .autoPayeeAcctAo(reqBody.getAutoPayeeAcctNo())
                    .autoPayeeAcctName(reqBody.getAutoPayeeAcctName())
                    .manualPayeeAcctNo(reqBody.getManualPayeeAcctNo())
                    .manualPayeeAcctName(reqBody.getManualPayeeAcctName())
                    .bizFlag(reqBody.getBizFlag())
                    .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                    .remark(reqBody.getRemark())
                    .handleFlag(handleFlag)
                    .gmtCreate(DateUtil.getSystemDate())
                    .gmtModified(DateUtil.getSystemDate())
                    .industryCode(industryCode).industryName(industryName).accountType(accountType)
                    .build();
            channelIncomeFlowHandler.saveChannelIncomeFlow(channelIncomeFlow);

            noticeRespDTO = respDTOBuilder
                    .rspHead(rspHeadBuilder.bzflag(OneBankAccountIncomeNoticeRespCode.SUCCESS.getHeadRspCode()).build())
                    .rspBody(rspBodyBuilder.balance(balance).build()).build();
            log.info("华通内部账户入金通知 << 处理成功 响应报文：{}", JSON.toJSONString(noticeRespDTO));
            return noticeRespDTO;
        } catch (Exception e) {
            noticeRespDTO = this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031025, "内部错误:" + e.getMessage(), respDTOBuilder, rspHeadBuilder, rspBodyBuilder).build();
            log.error("华通内部账户入金通知 << 处理异常 响应报文：{}", JSON.toJSONString(noticeRespDTO), e);
        }
        return noticeRespDTO;
    }

    private boolean validateParam(OneBankReqHead reqHead, OneBankAccountIncomeNoticeReqDTO.ReqBody reqBody, OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder, OneBankRspHead.OneBankRspHeadBuilder rspHeadBuilder, OneBankAccountIncomeNoticeRespDTO.RspBody.RspBodyBuilder rspBodyBuilder) {

        //请求头部校验
        if (reqHead == null) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031024, "参数[reqHead]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        rspHeadBuilder.reqchid(reqHead.getReqchid()).reqno(reqHead.getReqno()).reqtime(reqHead.getReqtime());

        if (StringUtil.isBlank(reqHead.getReqno())) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031001, "参数[reqno]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        if (StringUtil.isBlank(reqHead.getReqtime()) || reqHead.getReqtime().length() != 14) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031024, "参数[reqtime]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        if (StringUtil.isBlank(reqHead.getReqchid()) || !reqchid.equals(reqHead.getReqchid())) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031018, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        //校验请求body
        if (reqBody == null) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031024, "参数[reqBody]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        //业务状态
        if (StringUtil.isBlank(reqBody.getBizFlag())) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031022, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        if (StringUtil.isBlank(reqBody.getAcctNo())) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031011, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        if (reqBody.getAmt() == null || reqBody.getAmt() <= 0) {
            this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031012, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            return false;
        }

        if (HTBizFlag.RECORED.getFlag().equals(reqBody.getBizFlag()) || HTBizFlag.HANDWORK_RECORED.getFlag().equals(reqBody.getBizFlag())) {
            if (StringUtil.isBlank(reqBody.getCoreNo())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031024, "参数[coreNo]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getRid())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031013, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getExAcctNo())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031014, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getExAcctName())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031015, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getClearBankno())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031016, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getBankName())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031017, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getTranNo())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031021, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getTranDate()) || reqBody.getTranDate().length() != 8) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031020, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getAutoPayeeAcctNo())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031024, "参数[autoPayeeAcctNo]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }

            if (StringUtil.isBlank(reqBody.getAutoPayeeAcctName())) {
                this.respDTOBuilder(OneBankAccountIncomeNoticeRespCode.ER1031024, "参数[autoPayeeAcctName]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                return false;
            }
        }

        return true;
    }

    private OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder(OneBankAccountIncomeNoticeRespCode respCode, String errmsg, OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder, OneBankRspHead.OneBankRspHeadBuilder rspHeadBuilder, OneBankAccountIncomeNoticeRespDTO.RspBody.RspBodyBuilder rspBodyBuilder) {
        if (StringUtil.isNotBlank(errmsg)) {
            rspHeadBuilder.errmsg(errmsg);
        } else {
            rspHeadBuilder.errmsg(respCode.getDesc());
        }
        return respDTOBuilder
                .rspHead(rspHeadBuilder.bzflag(respCode.getHeadRspCode()).build())
                .rspBody(rspBodyBuilder.build());
    }
}
