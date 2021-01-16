package com.scenetec.upf.operation.web.feeincomeaccountmonthstat;


import com.scenetec.upf.operation.model.domain.feeincomeaccountmonthstat.FeeIncomeAccountMonthStatDO;
import com.scenetec.upf.operation.model.vo.QueryFeeIncomeAccountCollectionRespDTO;
import com.scenetec.upf.operation.service.feeincomeaccountmonthstat.FeeIncomeAccountMonthStatService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Api(value="手续费归集统计查询",tags={"手续费归集统计查询"})
@RestController
public class FeeIncomeAccountMonthStatController {

    @Resource
    FeeIncomeAccountMonthStatService service;

    /**
     * 重新归集
     * @param
     */
    @RequestMapping(value = "/api/feeIncomeAccountMonthStat", method = RequestMethod.PUT)
    public void update(@RequestBody List<String> list){
        service.feeIncomeAccountMonthStat(list);
    }
    /**
     * 重新划转
     * @param
     */
    @RequestMapping(value = "/api/feeIncomeAccountMonthStatReturn", method = RequestMethod.PUT)
    public void FeeIncomeAccountMonthStatReturn(@RequestBody List<String> list){
        service.feeIncomeAccountMonthCollection(list);
    }
    /**
     * 归集查询
     * @param
     */
    @RequestMapping(value = "/api/queryFeeIncomeAccountMonthCollection", method = RequestMethod.POST)
    public QueryFeeIncomeAccountCollectionRespDTO queryFeeIncomeAccountMonthCollection(@RequestBody Map query){
        Long lid = Long.parseLong(query.get("id").toString());
        QueryFeeIncomeAccountCollectionRespDTO res = service.queryFeeIncomeAccountMonthCollection(lid);
        return res;
    }

    /**
     * 人工核查
     * @param
     */
    @RequestMapping(value = "/api/feeManualVerification", method = RequestMethod.PUT)
    public void feeManualVerification(@RequestBody FeeIncomeAccountMonthStatDO feeIncomeAccountMonthStatDO){
        service.feeManualVerification(feeIncomeAccountMonthStatDO);
    }

    @RequestMapping(value = "/api/feeIncomeAccountMonthStat/list", method = RequestMethod.POST)
    public Map list(@RequestBody Query query) {
        Map map = new HashMap<>();
        map.put("page", service.list(query));
        map.put("total", service.countSumCollect(query.getParameters()));
	    return map;
	}
}
