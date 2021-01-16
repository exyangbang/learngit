package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountTransDetailQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountTransDetailQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.HTDrcrFlag;
import cn.kingnet.utp.trade.common.enums.HTReverseFlag;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 客户账户交易明细查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 9:51
 */
@Component("accountTransDetailQuery")
@ServiceContext(bodyClass = OneBankAccountTransDetailQueryReqDTO.class)
@Slf4j
public class AccountTransDetailQueryService extends BaseOnebankPayService<OneBankAccountTransDetailQueryReqDTO, OneBankAccountTransDetailQueryRespDTO> {
 
    public AccountTransDetailQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected Map<String, Object> buildSpResponse(FetureContext<OneBankAccountTransDetailQueryReqDTO, OneBankAccountTransDetailQueryRespDTO> fetureContext) {
        OneBankAccountTransDetailQueryReqDTO reqDTO = fetureContext.getSpReq();
        OneBankAccountTransDetailQueryRespDTO respDTO = new OneBankAccountTransDetailQueryRespDTO();
        respDTO.setCustAccountNo(reqDTO.getCustAccountNo());
        respDTO.setTxnAmount(100d);
        respDTO.setDrcrFlag(HTDrcrFlag.CREDIT.getFlag());
        respDTO.setReversedFlag(HTReverseFlag.NORMAL.getFlag());
        respDTO.setSysReferenceno(IdGenerate.generateServerTransId("DFA", "88888"));
        Map<String, Object> spMap = new HashMap<>(4);
        spMap.put("totalRecords", 1);
        spMap.put("data", new OneBankAccountTransDetailQueryRespDTO[]{respDTO});
        return spMap;
    }

    @Override
    protected String apiName() {
        return "一般户资金明细查询";
    }
}
