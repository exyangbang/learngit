package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDMBUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountBalanceQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountBalanceQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
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
 * @Description : 内部账号余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 9:53
 */
@Component("innerAccountBalanceQuery")
@ServiceContext(bodyClass = OneBankInnerAccountBalanceQueryReqDTO.class)
@Slf4j
public class InnerAccountBalanceQueryService extends AbstractAccountOnebankService<OneBankInnerAccountBalanceQueryReqDTO, OneBankInnerAccountBalanceQueryRespDTO> {

    private static final String PROPERTIES_KEY = "innerAccountBalanceQuery";
    private static final String API_NAME = UnionPaySubTypeEnum.INNER_ACCOUNT_BALANCE_QUERY.getDesc();

    public InnerAccountBalanceQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected Map<String, Object> addInputContent(FetureContext<OneBankInnerAccountBalanceQueryReqDTO, OneBankInnerAccountBalanceQueryRespDTO> fetureContext) {
        OneBankInnerAccountBalanceQueryReqDTO reqDTO = fetureContext.getSpReq();
        Map<String, Object> input = new HashMap<>(8);
        input.put("SUBACCOUNT", reqDTO.getSubAccount());

        input.put("FIRST_INQUIRY_FLG", reqDTO.getFirstInquiryFlg());
        input.put("PER_RETURN_ROWS", reqDTO.getPerReturnRows());
        input.put("STARTING_ROW", reqDTO.getStartingRow());

        return input;
    }

    @Override
    protected SysHeader addSpecificSysHeader(SysHeader commonSysheadder, FetureContext<OneBankInnerAccountBalanceQueryReqDTO, OneBankInnerAccountBalanceQueryRespDTO> fetureContext) {
        OneBankInnerAccountBalanceQueryReqDTO reqDTO = fetureContext.getSpReq();
        commonSysheadder.setTargetDfa(UtpDMBUtil.getRDfaListSync());
        return commonSysheadder;
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankInnerAccountBalanceQueryReqDTO, OneBankInnerAccountBalanceQueryRespDTO> fetureContext, byte[] respBody) {

        JSONObject respBodyJson = JSON.parseObject(new String(respBody));

        JSONObject outputObj = respBodyJson.getJSONObject("output");
        int totalRecords = outputObj.getIntValue("TOTAL_RECORDS");
        JSONArray jsonArray = outputObj.getJSONArray("LSTDXZYUE");

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
