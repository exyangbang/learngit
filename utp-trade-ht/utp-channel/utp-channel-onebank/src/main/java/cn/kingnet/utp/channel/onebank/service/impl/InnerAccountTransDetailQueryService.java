package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDMBUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountTransDetailQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountTransDetailQueryRespDTO;
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
 * @Description : 内部账户交易明细查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 9:51
 */
@Component("innerAccountTransDetailQuery")
@ServiceContext(bodyClass = OneBankInnerAccountTransDetailQueryReqDTO.class)
@Slf4j
public class InnerAccountTransDetailQueryService extends AbstractAccountOnebankService<OneBankInnerAccountTransDetailQueryReqDTO, OneBankInnerAccountTransDetailQueryRespDTO> {

    private static final String PROPERTIES_KEY = "innerAccountTransDetailQuery";
    private static final String API_NAME = UnionPaySubTypeEnum.INNER_ACCOUNT_TRANS_DETAIL_QUERY.getDesc();

    public InnerAccountTransDetailQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected Map<String, Object> addInputContent(FetureContext<OneBankInnerAccountTransDetailQueryReqDTO, OneBankInnerAccountTransDetailQueryRespDTO> fetureContext) {
        OneBankInnerAccountTransDetailQueryReqDTO reqDTO = fetureContext.getSpReq();
        Map<String, Object> input = new HashMap<>(16);
        input.put("CUST_ACCOUNT_NO", reqDTO.getCustAccountNo());
        input.put("FIRST_INQUIRY_FLG", reqDTO.getFirstInquiryFlg());
        input.put("PER_RETURN_ROWS", reqDTO.getPerReturnRows());
        input.put("STARTING_ROW", reqDTO.getStartingRow());
        input.put("STARTING_DATE", reqDTO.getStartingDate());
        input.put("STARTING_TIME", reqDTO.getStartingTime());
        input.put("TERMINATION_DATE", reqDTO.getTerminationDate());
        input.put("TERMINATION_TIME", reqDTO.getTerminationTime());
        input.put("RIVAL_ACCT", reqDTO.getRivalAcct());

        if (StringUtil.isNotBlank(reqDTO.getDrcrFlag())) {
            input.put("DRCR_FLAG", reqDTO.getDrcrFlag());
        }

        return input;
    }

    @Override
    protected SysHeader addSpecificSysHeader(SysHeader commonSysheadder, FetureContext<OneBankInnerAccountTransDetailQueryReqDTO, OneBankInnerAccountTransDetailQueryRespDTO> fetureContext) {
        OneBankInnerAccountTransDetailQueryReqDTO reqDTO = fetureContext.getSpReq();
        commonSysheadder.setTargetDfa(UtpDMBUtil.getRDfaListSync());
        commonSysheadder.setAcctType(reqDTO.getAcctType());
        commonSysheadder.setAcctNo(reqDTO.getAcctNo());
        return commonSysheadder;
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankInnerAccountTransDetailQueryReqDTO, OneBankInnerAccountTransDetailQueryRespDTO> fetureContext, byte[] respBody) {

        JSONObject respBodyJson = JSON.parseObject(new String(respBody));

        JSONObject outputObj = respBodyJson.getJSONObject("output");
        long totalRecords = outputObj.getLongValue("TOTAL_RECORDS");
        String hasMore = outputObj.getString("HAS_MORE");

        Map<String, Object> reMap = Maps.newHashMap();
        reMap.put("totalRecords", totalRecords);
        reMap.put("hasMore", hasMore);

        JSONArray txnArray = outputObj.getJSONArray("TXN_ARRAY");
        List<Map<String, Object>> data = convertJsonArray2ListMap(txnArray);
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
