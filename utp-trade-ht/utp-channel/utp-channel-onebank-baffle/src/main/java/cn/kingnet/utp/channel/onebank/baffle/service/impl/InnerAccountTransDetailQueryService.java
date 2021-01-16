package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountTransDetailQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountTransDetailQueryRespDTO;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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
public class InnerAccountTransDetailQueryService extends BaseOnebankPayService<OneBankInnerAccountTransDetailQueryReqDTO, OneBankInnerAccountTransDetailQueryRespDTO> {


    public InnerAccountTransDetailQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected Map<String, Object> buildSpResponse(FetureContext<OneBankInnerAccountTransDetailQueryReqDTO, OneBankInnerAccountTransDetailQueryRespDTO> fetureContext) {
        OneBankInnerAccountTransDetailQueryReqDTO reqDTO = fetureContext.getSpReq();
        OneBankInnerAccountTransDetailQueryRespDTO respDTO = new OneBankInnerAccountTransDetailQueryRespDTO();
        respDTO.setCustAccountNo(reqDTO.getCustAccountNo());
        respDTO.setTxnAmount(100d);
        respDTO.setSysReferenceno(IdGenerate.generateServerTransId("DFA","88888"));
        Map<String,Object> spMap = new HashMap<>(4);
        spMap.put("totalRecords",1);
        spMap.put("data",new OneBankInnerAccountTransDetailQueryRespDTO[]{respDTO});
        return spMap;
    }

    @Override
    protected String apiName() {
        return "内部户资金明细查询";
    }
}
