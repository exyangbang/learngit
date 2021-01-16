package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.scheduler.data.entity.MerchantAccountInfo;
import cn.kingnet.utp.scheduler.data.entity.MerchantAccountInfoCondition;
import cn.kingnet.utp.scheduler.data.entity.MerchantInfo;
import cn.kingnet.utp.scheduler.data.entity.MerchantInfoCondition;
import cn.kingnet.utp.service.persistence.api.IPaymentCheckHandler;
import cn.kingnet.utp.service.persistence.entity.bo.PaymentCheckBo;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.BindCardStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

import static cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl.run;

/**
 * @Description: 商户账户定时解绑任务
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/9 16:15
 */
@Slf4j
@Service
public class MerchantAccountUnbindService {

    @Resource
    private IPaymentCheckHandler paymentCheckHandler;

    public void work(int freezeHour, int applyHour) {
        unBind(applyHour);
        unFreeze(freezeHour);
    }

    /**
     * 根据冻结时间
     *
     * @param freezeHour
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void unFreeze(int freezeHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 0 - freezeHour);
        PlusEntityWrapper<MerchantAccountInfo> wrapper = MerchantAccountInfoCondition.builder().andBindStatusEq(BindCardStatus.FROZEN.getStatus()).andFreezeDateLt(calendar.getTime()).build();
        //查询符合条件的数据
        List<MerchantAccountInfo> updateList = run().selectList(wrapper);
        String updateSql = String.format("bind_status = '%s',freeze_date = null,auth_amt=0, auth_count=0 ,channel_resp_code = '',channel_resp_msg = ''", BindCardStatus.UN_BIND.getStatus());
        run().updateForSet(updateSql, wrapper);
        if (!CollectionUtils.isEmpty(updateList)) {
            //发送信息通知
            updateList.forEach(merchantAccountInfo -> {
                MerchantInfo merchantInfo = MybatisDaoImpl.run().selectOne(MerchantInfoCondition.builder().andMerNoEq(merchantAccountInfo.getMerNo()).build().setSqlSelect("industry_code"));
                sendNotify(merchantInfo.getIndustryCode(), IdGenerate.getIdStr(), merchantAccountInfo);
            });
        }
    }

    /**
     * 根据绑定时间
     *
     * @param applyHour
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void unBind(int applyHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 0 - applyHour);
        PlusEntityWrapper<MerchantAccountInfo> wrapper = MerchantAccountInfoCondition.builder()
                .andBindStatusIn(BindCardStatus.PROCESSING.getStatus(), BindCardStatus.FAILURE.getStatus(), BindCardStatus.WAITING_AUTH.getStatus(), BindCardStatus.AUTH_FAILURE.getStatus())
                .andReqBindDateLt(calendar.getTime()).build();
        //查询符合条件的数据
        List<MerchantAccountInfo> updateList = run().selectList(wrapper);
        String updateSql = String.format("bind_status = '%s',auth_amt=0, auth_count=0 ,channel_resp_code = '',channel_resp_msg = ''", BindCardStatus.UN_BIND.getStatus());
        run().updateForSet(updateSql, wrapper);
        if (!CollectionUtils.isEmpty(updateList)) {
            //发送信息通知
            updateList.forEach(merchantAccountInfo -> {
                MerchantInfo merchantInfo = MybatisDaoImpl.run().selectOne(MerchantInfoCondition.builder().andMerNoEq(merchantAccountInfo.getMerNo()).build().setSqlSelect("industry_code"));
                sendNotify(merchantInfo.getIndustryCode(), IdGenerate.getIdStr(), merchantAccountInfo);
            });
        }
    }

    /**
     * 自动解绑-绑卡状态变化通知
     *
     * @param industryCode
     * @param serverTransId
     * @param merchantAccountInfo
     */
    @Async
    public void sendNotify(String industryCode, String serverTransId, MerchantAccountInfo merchantAccountInfo) {
        PaymentCheckBo paymentCheckBo = new PaymentCheckBo();
        paymentCheckBo.setIndustryCode(industryCode);
        paymentCheckBo.setServerTransId(serverTransId);
        paymentCheckBo.setUserAccount(merchantAccountInfo.getAccount());
        paymentCheckBo.setAcctNo(merchantAccountInfo.getAccountNo());
        paymentCheckBo.setBindStatus(BindCardStatus.UN_BIND.getStatus());
        paymentCheckBo.setErrCode(merchantAccountInfo.getChannelRespCode());
        paymentCheckBo.setErrMsg(merchantAccountInfo.getChannelRespMsg());
        LambdaLogger.debug(log, log -> log.debug("自动解绑-绑卡状态变化通知，请求参数==>{}", JSON.toJSONString(paymentCheckBo)));
        ServerResponseDTO responseDTO = paymentCheckHandler.notify(paymentCheckBo);
        if (!responseDTO.getStatus().equals(HttpRespStatus.OK.valueStr())) {
            log.error("服务端流水号{}，卡号{}，自动解绑-绑卡状态变化通知异常==>{}", serverTransId, merchantAccountInfo.getAccountNo(), responseDTO.getMessage());
            throw new ProductException(HttpRespStatus.SERVER_ERROR, "自动解绑-绑卡状态变化通知异常");
        }
    }
}
