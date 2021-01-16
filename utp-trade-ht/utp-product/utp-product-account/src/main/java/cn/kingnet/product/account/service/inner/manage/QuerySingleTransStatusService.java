package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.utp.product.common.dto.manage.QuerySingleTransStatusReqDTO;
import cn.kingnet.utp.product.common.dto.manage.QuerySingleTransStatusRespDTO;
import cn.kingnet.utp.product.common.dto.manage.QueryTransStatusReqDTO;
import cn.kingnet.utp.product.common.dto.manage.QueryTransStatusRespDTO;
import cn.kingnet.utp.service.persistence.api.ITransCurrentHandler;
import cn.kingnet.utp.service.persistence.api.ITransHistoryHandler;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sheqingquan@scenetec.com
 * @description: 查询单笔交易流水状态
 * @create 2020/2/18 10:07
 */
@Slf4j
@Service
public class QuerySingleTransStatusService {

    @Resource
    private QueryTransStatusService queryTransStatusService;
    @Resource
    private ITransCurrentHandler transCurrentHandler;
    @Resource
    private ITransHistoryHandler transHistoryHandler;

    public QuerySingleTransStatusRespDTO query(QuerySingleTransStatusReqDTO req) {
        QuerySingleTransStatusRespDTO respDTO = new QuerySingleTransStatusRespDTO();
        QueryTransStatusReqDTO queryTransStatusReqDTO = new QueryTransStatusReqDTO();

        //校验参数
        ValidateUtils.maxLength(req.getIndustryCode(), 32, true, "客户号");
        ValidateUtils.maxLength(req.getClientTransId(), 32, true, "客户端流水号");
        ValidateUtils.isYyyyMMdd(req.getTransDate(), true, "交易日期");

        String tradeType;
        Long transAmount;
        //查询当前和历史流水的服务端流水号
        TransCurrent transCurrent = transCurrentHandler.getByIndustryAndClientTransIdOrServerTransId(req.getIndustryCode(), req.getClientTransId(), null);
        if (transCurrent == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "暂无此客户端交易流水记录");
        }
        queryTransStatusReqDTO.setOrigServerTradeId(transCurrent.getServerTransId());
        tradeType = transCurrent.getTradeType();
        transAmount = transCurrent.getTransAmount();
        queryTransStatusReqDTO.setIndustryCode(req.getIndustryCode());
        queryTransStatusReqDTO.setClientTradeId(req.getClientTransId());
        QueryTransStatusRespDTO queryTransStatusRespDTO = null;
        try {
            queryTransStatusRespDTO = queryTransStatusService.doService(queryTransStatusReqDTO);
            respDTO.setTransStatus(queryTransStatusRespDTO.getTransStatus());
            respDTO.setTransAmount(transAmount);
            respDTO.setTradeType(tradeType);
            respDTO.setStatus(HttpRespStatus.OK.valueStr());
        } catch (Exception e) {
            log.error("单笔交易流水查询异常==>{}", e.getMessage(), e);
            respDTO.setStatus(HttpRespStatus.BAD_REQUEST.toString());
            respDTO.setMessage("单笔交易流水查询异常");
        }
        return respDTO;
    }
}
