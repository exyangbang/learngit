package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDMBUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountBalanceQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountBalanceQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.dmb.common.message.SysHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 客户账号余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 9:53
 */
@Component("accountBalanceQuery")
@ServiceContext(bodyClass = OneBankAccountBalanceQueryReqDTO.class)
@Slf4j
public class AccountBalanceQueryService extends AbstractAccountOnebankService<OneBankAccountBalanceQueryReqDTO, OneBankAccountBalanceQueryRespDTO> {

    private static final String PROPERTIES_KEY = "accountBalanceQuery";
    private static final String API_NAME = UnionPaySubTypeEnum.ACCOUNT_BALANCE_QUERY.getDesc();

    public AccountBalanceQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected SysHeader addSpecificSysHeader(SysHeader commonSysheadder, FetureContext<OneBankAccountBalanceQueryReqDTO, OneBankAccountBalanceQueryRespDTO> fetureContext) {
        OneBankAccountBalanceQueryReqDTO reqDTO = fetureContext.getSpReq();
        commonSysheadder.setTargetDfa(UtpDMBUtil.getCDfaNumSync());
        commonSysheadder.setAcctType(reqDTO.getAcctType());
        commonSysheadder.setAcctNo(reqDTO.getAcctNo());
        return commonSysheadder;
    }

    @Override
    protected Map<String, Object> addInputContent(FetureContext<OneBankAccountBalanceQueryReqDTO, OneBankAccountBalanceQueryRespDTO> fetureContext) {
        OneBankAccountBalanceQueryReqDTO reqDTO = fetureContext.getSpReq();
        Map<String, Object> input = new HashMap<>(8);
        input.put("CUST_ACCT_RANGE_FLG", StringUtil.isNotBlank(reqDTO.getCustAcctRangeFlg()) ? reqDTO.getCustAcctRangeFlg() : "0");
        input.put("CUST_ACCOUNT_NO", reqDTO.getCustAccountNo());
        input.put("FIRST_INQUIRY_FLG", reqDTO.getFirstInquiryFlg());
        input.put("PER_RETURN_ROWS", reqDTO.getPerReturnRows());
        input.put("STARTING_ROW", reqDTO.getStartingRow());
        return input;
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankAccountBalanceQueryReqDTO, OneBankAccountBalanceQueryRespDTO> fetureContext, byte[] respBody) {

        JSONObject respBodyJson = JSON.parseObject(new String(respBody));
        JSONObject outputObj = respBodyJson.getJSONObject("output");
        int totalRecords = outputObj.getIntValue("TOTAL_RECORDS");

        JSONArray jsonArray = outputObj.getJSONArray("LISTFUZH");
        Map<String, Object> reMap = Maps.newHashMap();
        reMap.put("totalRecords", totalRecords);
        List<Map<String, Object>> data = convertJsonArray2ListMap(jsonArray);
        reMap.put("data", data != null ? JSON.toJSONString(data) : null);

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
