package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDMBUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountInfoQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountInfoQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.dmb.common.message.SysHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 一般户客户账号信息查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 9:53
 */
@Component("accountInfoQuery")
@ServiceContext(bodyClass = OneBankAccountInfoQueryReqDTO.class)
@Slf4j
public class AccountInfoQueryService extends AbstractAccountOnebankService<OneBankAccountInfoQueryReqDTO, OneBankAccountInfoQueryRespDTO> {

    private static final String PROPERTIES_KEY = "accountInfoQuery";
    private static final String API_NAME = UnionPaySubTypeEnum.ACCOUNT_INFO_QUERY.getDesc();

    public AccountInfoQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected Map<String, Object> addInputContent(FetureContext<OneBankAccountInfoQueryReqDTO, OneBankAccountInfoQueryRespDTO> fetureContext) {
        OneBankAccountInfoQueryReqDTO reqDTO = fetureContext.getSpReq();
        Map<String, Object> input = new HashMap<>(8);
        input.put("CUST_ACCOUNT_NO", reqDTO.getCustAccountNo());
        input.put("FIRST_INQUIRY_FLG", reqDTO.getFirstInquiryFlg());
        input.put("PER_RETURN_ROWS", reqDTO.getPerReturnRows());
        input.put("STARTING_ROW", reqDTO.getStartingRow());
        input.put("CHECK_PASSWORD_FLG", reqDTO.getCheckPasswordFlg());
        return input;
    }

    @Override
    protected SysHeader addSpecificSysHeader(SysHeader commonSysheadder, FetureContext<OneBankAccountInfoQueryReqDTO, OneBankAccountInfoQueryRespDTO> fetureContext) {
        OneBankAccountInfoQueryReqDTO reqDTO = fetureContext.getSpReq();
        commonSysheadder.setTargetDfa(UtpDMBUtil.getTargetDfaByDFA(reqDTO.getDfa()));
        commonSysheadder.setAcctType(reqDTO.getAcctType());
        commonSysheadder.setAcctNo(reqDTO.getAcctNo());
        return commonSysheadder;
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankAccountInfoQueryReqDTO, OneBankAccountInfoQueryRespDTO> fetureContext, byte[] respBody) {
        //成功则取包处理
        JSONObject respBodyJson = JSON.parseObject(new String(respBody));
        JSONObject outputObj = respBodyJson.getJSONObject("output");

        Map<String, Object> reMap = Maps.newHashMap();
        if (outputObj != null) {
            outputObj.forEach((k, v) -> {
                if (v instanceof String || v instanceof Integer || v instanceof BigDecimal) {
                    reMap.put(StringUtil.underlineToCamel(k), v);
                }
            });
        }
        reMap.put("data", null);
        return reMap;
    }

    @Override
    public String key() {
        return PROPERTIES_KEY;
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
