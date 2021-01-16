package com.scenetec.upf.operation.web.trade;

import com.scenetec.upf.operation.model.Enum.TransStatusEnum;
import com.scenetec.upf.operation.model.vo.SubAccountPaymentFlowVO;
import com.scenetec.upf.operation.service.trade.SubAccountPaymentService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.DownloadExcelTool;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LIFA
 */
@ApiIgnore
@Api(value="子账户单笔付款信息",tags={"子账户单笔付款信息"})
@RestController
public class SubAccountPaymentFlowController {

    @Autowired
    private SubAccountPaymentService subAccountPaymentService;

    @Autowired
    private DownloadExcelTool downloadExcelTool;

    @RequestMapping(value = "/api/subAccountPayment/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Query query) {
        Map<String, Object> result = new HashMap<>(4);
        result.put("page", subAccountPaymentService.query(query));
        result.put("statistics", subAccountPaymentService.countTotal(query.getParameters()));
        return result;
    }

    @RequestMapping(value = "/api/subAccountPayment/download", method = RequestMethod.POST)
    public void download(HttpServletResponse response, @RequestBody Query query) {
        String path = "tabledefines_created/template/SubAccountPaymentFlowFile.xlsx";
        String filename = "子账户单笔付款信息记录";
        query.setPageNo(1);
        query.setPageSize(10000);
        List<SubAccountPaymentFlowVO> lists = subAccountPaymentService.query(query).getList();
        for(SubAccountPaymentFlowVO subAccountPaymentFlowVO : lists) {
            subAccountPaymentFlowVO.setTransStatus(TransStatusEnum.getValue(subAccountPaymentFlowVO.getTransStatus()));
            subAccountPaymentFlowVO.setSettleDate(DateUtilities.dateTool(subAccountPaymentFlowVO.getSettleDate()));
            subAccountPaymentFlowVO.setTradeDate(DateUtilities.dateAndTimeTool(subAccountPaymentFlowVO.getTradeDate()));
        }
        Map<String, Long> map = subAccountPaymentService.countTotal(query.getParameters());
        downloadExcelTool.download(path, filename, response, lists, map);
    }
}
