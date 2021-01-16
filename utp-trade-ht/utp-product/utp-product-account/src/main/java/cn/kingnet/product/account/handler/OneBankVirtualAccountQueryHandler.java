package cn.kingnet.product.account.handler;

import cn.kingnet.product.api.account.IOneBankVirtualAccountQueryHandler;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IIndustryHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankReqHead;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankRspHead;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankVirtualAccountQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankVirtualAccountQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description : 电子账户所属实体机构户查询
 * @Author : linkaigui
 * @Create : 2019/3/14 18:45
 */
@RestController
@RequestMapping("/innerAccount/virtualAccountQuery")
@Slf4j
public class OneBankVirtualAccountQueryHandler extends DefaultFeginExceptionHandler implements IOneBankVirtualAccountQueryHandler {

    private final IAccountHandler accountHandler;
    @Resource
    private IMerchantAccountHandler merchantAccountHandler;
    @Resource
    private IIndustryHandler industryHandler;

    private static final String reqchid = "0000";

    public OneBankVirtualAccountQueryHandler(IAccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    /**
     * 电子账户所属实体机构户查询
     *
     * @param oneBankVirtualAccountQueryReqDTO
     * @return
     */
    @Override
    public OneBankVirtualAccountQueryRespDTO virtualAccountQuery(@RequestBody(required = false) OneBankVirtualAccountQueryReqDTO oneBankVirtualAccountQueryReqDTO) {

        LambdaLogger.info(log, "电子账户所属实体户查询 >> 请求报文：{}", JSON.toJSONString(oneBankVirtualAccountQueryReqDTO));

        OneBankVirtualAccountQueryRespDTO.OneBankVirtualAccountQueryRespDTOBuilder respDTOBuilder = OneBankVirtualAccountQueryRespDTO.builder();
        OneBankRspHead.OneBankRspHeadBuilder rspHeadBuilder = OneBankRspHead.builder().reqchid(reqchid);
        OneBankVirtualAccountQueryRespDTO.RspBody.RspBodyBuilder rspBodyBuilder = OneBankVirtualAccountQueryRespDTO.RspBody.builder();
        if (oneBankVirtualAccountQueryReqDTO == null) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R14, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        OneBankReqHead reqHead = oneBankVirtualAccountQueryReqDTO.getReqHead();
        OneBankVirtualAccountQueryReqDTO.ReqBody reqBody = oneBankVirtualAccountQueryReqDTO.getReqBody();

        //请求头部校验
        if (reqHead == null) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R14, "参数[reqHead]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        rspHeadBuilder.reqchid(reqHead.getReqchid()).reqno(reqHead.getReqno()).reqtime(reqHead.getReqtime());

        if (StringUtil.isBlank(reqHead.getReqno())) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R14, "参数[reqno]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        if (StringUtil.isBlank(reqHead.getReqtime()) || reqHead.getReqtime().length() != 14) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R14, "参数[reqtime]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        if (StringUtil.isBlank(reqHead.getReqchid()) || !reqchid.equals(reqHead.getReqchid())) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R12, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        //校验请求body
        if (reqBody == null) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R14, "参数[reqBody]错误", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        if (StringUtil.isBlank(reqBody.getAcctNo())) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R08, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        if (reqBody.getAmt() == null || reqBody.getAmt() < 0) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R09, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        if (StringUtil.isBlank(reqBody.getExAcctNo())) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R10, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        if (StringUtil.isBlank(reqBody.getExAcctName())) {
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R11, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }

        try {
            //FIXME 支持功能账户上账 + 原二级子账户上账
            Account account = accountHandler.findAccount(reqBody.getAcctNo());
            if (account == null) {
                return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R01, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            }
            if (StringUtil.isBlank(account.getFundAccount())) {
                return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R07, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            }

            if (VirtualAccountType.isFunctionAccount(account.getObjType())) {
                Industry platformIndustry = accountHandler.getIndustryByFunctionAccount(account.getAccount());
                //业务又调整 功能账户 默认都可以对外接款 且 开通的手续费支出账户、小额打款账户 至多仅能被唯一平台客户关联
                if (platformIndustry == null || StringUtil.isBlank(platformIndustry.getFundAccount())) {
                    return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R06, "该功能账户关联平台账户未配置实体账户", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                }
            } else if (VirtualAccountType.isSubAccount(account.getObjType())) {
                Industry platformIndustry = accountHandler.getIndustryBySubAccount(account.getAccount());
                if (platformIndustry == null || !"1".equals(platformIndustry.getWhetherExternal())) {
                    return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R06, "该二级子账户归属平台账户未开通对外接款权限", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                }
                MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(reqBody.getAcctNo(),false);
                if (merchantInfoBo == null) {
                    return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R01, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                }

                if (AccountStatus.CANCEL.getCode().toString().equals(merchantInfoBo.getStatus()) || VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())) {
                    return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R03, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                }

                if (AccountStatus.FREEZE.getCode().toString().equals(merchantInfoBo.getStatus()) || AccountStatus.NO_OPEN.getCode().toString().equals(merchantInfoBo.getStatus()) || VirtualAccountStatus.FREEZE.getType().equals(account.getStatus())) {
                    return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R05, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                }

                //企业用户只有审核通过才可能出入金
                if(VirtualAccountType.MERCHANT.getType().equals(merchantInfoBo.getNature())){
                    MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(merchantInfoBo.getAuthStatus());
                    if(MerAuthStatus.NORMAL != merAuthStatus){
                        return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R06, "企业账户审核状态[" + merAuthStatus.getValue() + "]不可用", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                    }
                }

                //1.“仅同名账户二级账户入金”：开户时的同名账户的资金才能入账，其他直接拒绝入金【校验二级账户绑卡时的 账户名称】
                //2.“无账户限制二级账户入金”：任意来款账户均可以入金【不限制】
                //3.“仅白名单账户二级账户入金”：需要配置二级账户入金的白名单，非白名单的账户来款不能入金【该白名单就是原客户号的白名单，后改为来款账户配置项且同时交易账号和户名】
                String errorMsg = validSubIncome(platformIndustry,merchantInfoBo,reqBody);
                if(StringUtil.isNotBlank(errorMsg)){
                    return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R06, errorMsg, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
                }

            } else {
                return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R06, "账户类型[" + account.getObjType() + "]暂无此接口权限", respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            }

            //直接虚账户 关联的 实体账户获取
            FundAccount fundAccount = accountHandler.findFundAccount(account.getFundAccount());
            if (fundAccount == null) {
                return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R07, null, respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
            }

            return respDTOBuilder
                    .rspHead(rspHeadBuilder.bzflag(OneBankVirtualAccountQueryRespCode.SUCCESS.getHeadRspCode()).build())
                    .rspBody(rspBodyBuilder.rspCode(OneBankVirtualAccountQueryRespCode.SUCCESS.getRspCode()).orgRealAcctNo(fundAccount.getBankAccountNo()).orgRealAcctName(fundAccount.getBankAccountName()).build()).build();
        } catch (Exception e) {
            log.error("电子账户获取内部户信息异常：", e);
            return this.respDTOBuilder(OneBankVirtualAccountQueryRespCode.R99, "内部错误:" + e.getMessage(), respDTOBuilder, rspHeadBuilder, rspBodyBuilder);
        }
    }

    /**
     *     // 20200714 需求：直接在核心查询时校验，后续的订单入金通知及上账不校验
     *         // "根据入金类型进行处理：【仅针对普通的二级账户：平台客户配置类型】 默认类型为2
     *         //1.“仅同名账户二级账户入金”：开户时的同名账户的资金才能入账，其他直接拒绝入金【校验二级账户绑卡时的 账户名称】
     *         //2.“无账户限制二级账户入金”：任意来款账户均可以入金【不限制】
     *         //3.“仅白名单账户二级账户入金”：需要配置二级账户入金的白名单，非白名单的账户来款不能入金【该白名单就是原客户号的白名单，后改为来款账户配置项且同时交易账号和户名】
     */
    private String validSubIncome(Industry platformIndustry, MerchantInfoBo merchantInfoBo,OneBankVirtualAccountQueryReqDTO.ReqBody reqBody) {

        String errorMsg = null;
        Integer subIncomeType = platformIndustry.getSubIncomeType();
        subIncomeType = subIncomeType==null?2:subIncomeType;
        //若二级账户为待结算账户，那么其关联关系信息也是通过其原宿主 二级账户关联获取其关联关系信息
        String userAccount = merchantInfoBo.getAccount();
        if(subIncomeType==1){
            boolean existsBindAccName = merchantAccountHandler.existsMerchantAccount(userAccount,reqBody.getExAcctName());
            if(!existsBindAccName){
                errorMsg = "受限于:仅同名账户二级账户入金";
            }
        }else if(subIncomeType==3){
            boolean existsWhiteAccName = industryHandler.existsIndustryAccountInfo(platformIndustry.getCode(),reqBody.getExAcctNo(),reqBody.getExAcctName());
            if(!existsWhiteAccName){
                errorMsg = "受限于:仅白名单账户二级账户入金";
            }
        }else{
            //默认2或者未配置 则不受限制
            errorMsg = null;
        }
        return errorMsg;
    }

    private OneBankVirtualAccountQueryRespDTO respDTOBuilder(OneBankVirtualAccountQueryRespCode respCode, String errmsg, OneBankVirtualAccountQueryRespDTO.OneBankVirtualAccountQueryRespDTOBuilder respDTOBuilder, OneBankRspHead.OneBankRspHeadBuilder rspHeadBuilder, OneBankVirtualAccountQueryRespDTO.RspBody.RspBodyBuilder rspBodyBuilder) {
        OneBankVirtualAccountQueryRespDTO virtualAccountQueryRespDTO;
        if (StringUtil.isNotBlank(errmsg)) {
            rspHeadBuilder.errmsg(errmsg);
        } else {
            rspHeadBuilder.errmsg(respCode.getDesc());
        }
        virtualAccountQueryRespDTO = respDTOBuilder
                .rspHead(rspHeadBuilder.bzflag(respCode.getHeadRspCode()).build())
                .rspBody(rspBodyBuilder.rspCode(respCode.getRspCode()).build()).build();
        LambdaLogger.info(log, "电子账户所属实体户查询 << 响应报文：{}", JSON.toJSONString(virtualAccountQueryRespDTO));
        return virtualAccountQueryRespDTO;
    }
}
