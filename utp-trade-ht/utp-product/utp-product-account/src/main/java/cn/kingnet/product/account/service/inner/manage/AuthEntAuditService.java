package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.product.account.support.UtpCallbackTemplate;
import cn.kingnet.utp.product.common.dto.AuthEntAccountDto;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.bo.AccountAuditBO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.UtpCallbackException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @Description : 账户开户鉴权审核服务
 * @Author : linkaigui
 * @Create : 2020/2/13 13:06
 */
@Slf4j
@Service
public class AuthEntAuditService {

    private final UtpCallbackTemplate utpCallbackTemplate;

    @Resource
    private IAccountHandler accountHandler;

    public AuthEntAuditService(UtpCallbackTemplate utpCallbackTemplate) {
        this.utpCallbackTemplate = utpCallbackTemplate;
    }

    /**
     * 开户认证审核
     * @param authEntAccountDto
     * @return
     */
    public HttpRespStatus audit(AuthEntAccountDto authEntAccountDto) {
        if (StringUtils.isBlank(authEntAccountDto.getId()) || authEntAccountDto.getAuthStatus() == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数不规范");
        }
        int authStatus = authEntAccountDto.getAuthStatus().intValue();
        if (!(authStatus == MerAuthStatus.NORMAL.getCode().intValue() || authStatus == MerAuthStatus.TURN_DOWN.getCode().intValue())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "审核结果参数不规范");
        }
        String[] sign = authEntAccountDto.toSHA1(AuthEntAccountDto.secret);
        if (!SHA1.genWithAmple(sign).equals(authEntAccountDto.getSign())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "签名不正确");
        }
        MerchantInfo merchantInfo = accountHandler.findMerchantById(Long.valueOf(authEntAccountDto.getId()));
        if (merchantInfo == null) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("未找到该记录 id=%s", authEntAccountDto.getId()));
        }
        if (VirtualAccountType.SELFEMPLOYED.getType().equals(merchantInfo.getNature())) {
            this.auditSelfemployed(authEntAccountDto, merchantInfo);
        } else {
            this.auditEnt(authEntAccountDto, merchantInfo);
        }
        try {
            Map<String, String> respMap = Maps.newHashMap();
            respMap.put("userAccount", merchantInfo.getAccount());
            respMap.put("authStatus", authEntAccountDto.getAuthStatus().toString());
            respMap.put("remark", authEntAccountDto.getAuthRemark());
            ResponseEntity<String> resp = utpCallbackTemplate.exchange(merchantInfo.getIndustryCode(), merchantInfo.getAuthCallBack(), HttpMethod.POST, respMap, String.class);
            if (!resp.getStatusCode().is2xxSuccessful()) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "企业证件认证结果回调异常");
            }
        } catch (Exception e) {
            log.error("审核完成，但回调下游出现异常:" + e.getMessage(), e);
            throw new UtpCallbackException("审核完成，但回调下游出现异常:" + e.getMessage());
        }
        return HttpRespStatus.OK;
    }

    /**
     * 企业审核处理
     * @param authEntAccountDto
     * @param merchantInfo
     */
    private void auditEnt(AuthEntAccountDto authEntAccountDto, MerchantInfo merchantInfo) {
        if (!UserType.MER.getType().equals(merchantInfo.getUserType())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不是企业用户");
        }
        if (AccountStatus.NO_OPEN.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户未开户，无法进行审核");
        }
        if (AccountStatus.CANCEL.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户已销户，无法进行审核");
        }
        if (merchantInfo.getAuthStatus() != null && MerAuthStatus.NORMAL.getCode().intValue() == merchantInfo.getAuthStatus().intValue()) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户已审核，无需重复审核");
        }

        Industry industry = accountHandler.findIndustry(merchantInfo.getIndustryCode());
        if (Objects.isNull(industry)) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("该客户[%s]不存在", merchantInfo.getIndustryCode()));
        }

        MerchantInfo.MerchantInfoBuilder builder = MerchantInfo.builder()
                .account(merchantInfo.getAccount())
                .gmtModified(new Date())
                .userModified(authEntAccountDto.getUserModified())
                .authRemark(authEntAccountDto.getAuthRemark());
        int authStatus = authEntAccountDto.getAuthStatus().intValue();
        if (OpenAccountMode.BIND.getCode().equals(industry.getOpenAccountMode())) {
            // 对于客户号标志是 “鉴权绑卡时上传图片资料(旧)” ，按照原来流程
            if (AccountStatus.OPEN_UNBIND.getCode().toString().equals(merchantInfo.getStatus())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户未鉴权绑卡，无法进行审核");
            }
            if (authStatus == MerAuthStatus.NORMAL.getCode().intValue()) {
                //设置最终状态为：已开户已绑卡
                builder.status(AccountStatus.OPEN_BIND.getCode().toString());
            } else if (authStatus == MerAuthStatus.TURN_DOWN.getCode().intValue()) {
                //设置最终状态为：冻结
                builder.status(AccountStatus.FREEZE.getCode().toString());
            }
        } else if (OpenAccountMode.OPEN.getCode().equals(industry.getOpenAccountMode())) {
            // 对于客户号标志是 “开户时上传图片资料(新)” ，只有已开户未绑卡的，待审核状态的就可以进行审核
            if (!AccountStatus.OPEN_UNBIND.getCode().toString().equals(merchantInfo.getStatus())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不是已开户未绑卡，无法进行审核");
            }
            if (MerAuthStatus.PENDING_REVIEW.getCode().intValue() != merchantInfo.getAuthStatus()) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不是待审核状态，无法进行审核");
            }
        }
        builder.authStatus(authStatus);
        //更新操作
        AccountAuditBO accountAuditBO = new AccountAuditBO();
        accountAuditBO.setMerchantInfo(builder.build());
        accountHandler.auditAccount(accountAuditBO);
    }

    /**
     * 个体工商户审核处理
     * @param authEntAccountDto
     * @param merchantInfo
     */
    private void auditSelfemployed(AuthEntAccountDto authEntAccountDto, MerchantInfo merchantInfo) {
        if (!VirtualAccountType.SELFEMPLOYED.getType().equals(merchantInfo.getNature())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不是个体工商户");
        }
        if (AccountStatus.NO_OPEN.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户未开户，无法进行审核");
        }
        if (AccountStatus.OPEN_UNBIND.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户未鉴权绑卡，无法进行审核");
        }
        if (AccountStatus.CANCEL.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户已销户，无法进行审核");
        }
        if (merchantInfo.getAuthStatus() != null && MerAuthStatus.NORMAL.getCode().intValue() == merchantInfo.getAuthStatus().intValue()) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户已审核，无需重复审核");
        }
        MerchantInfo.MerchantInfoBuilder builder = MerchantInfo.builder()
                .account(merchantInfo.getAccount())
                .gmtModified(new Date())
                .userModified(authEntAccountDto.getUserModified())
                .authStatus(authEntAccountDto.getAuthStatus().intValue())
                .authRemark(authEntAccountDto.getAuthRemark());

        int authStatus = authEntAccountDto.getAuthStatus().intValue();
        if (authStatus == MerAuthStatus.NORMAL.getCode().intValue()) {
            //设置最终状态为：已开户已绑卡
            builder.status(AccountStatus.OPEN_BIND.getCode().toString());
        } else if (authStatus == MerAuthStatus.TURN_DOWN.getCode().intValue()) {
            //设置最终状态为：冻结
            builder.status(AccountStatus.FREEZE.getCode().toString());
        }
        builder.authStatus(authStatus);
        //更新操作
        AccountAuditBO accountAuditBO = new AccountAuditBO();
        accountAuditBO.setMerchantInfo(builder.build());
        accountHandler.auditAccount(accountAuditBO);
    }
}
