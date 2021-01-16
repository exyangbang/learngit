package com.scenetec.upf.operation.web.splitinfo;

import com.scenetec.upf.operation.model.Enum.TransStatusEnum;
import com.scenetec.upf.operation.model.vo.SubAccountSettleSplitVO;
import com.scenetec.upf.operation.service.splitinfo.SubAccountSettleSplitService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.DownloadExcelTool;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author scenetec
 */
@Api(value = "子账户分账信息查询", tags = {"子账户分账信息查询"})
@RestController
public class SubAccountSettleSplitController {

    @Autowired
    private SubAccountSettleSplitService subAccountSettleSplitService;

    @Autowired
    private DownloadExcelTool downloadExcelTool;

    @RequestMapping(value = "/api/subAccountSettleSplit/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Query query) {
        Map<String, Object> result = new HashMap<>(4);
        result.put("page", subAccountSettleSplitService.query(query));
        result.put("statistics", subAccountSettleSplitService.countTotal(query.getParameters()));
        return result;
    }

    @RequestMapping(value = "/api/subAccountSettleSplit/download", method = RequestMethod.POST)
    public void download(HttpServletResponse response, @RequestBody Query query) {
        String path = "tabledefines_created/template/SubAccountSettleSplitFile.xlsx";
        String filename = "子账户分账信息记录";
        query.setPageNo(1);
        query.setPageSize(10000);
        List<SubAccountSettleSplitVO> lists = subAccountSettleSplitService.query(query).getList();
        for(SubAccountSettleSplitVO subAccountSettleSplitVO : lists) {
            subAccountSettleSplitVO.setTransStatus(TransStatusEnum.getValue(subAccountSettleSplitVO.getTransStatus()));
            subAccountSettleSplitVO.setSettleMode(Objects.equals("0", subAccountSettleSplitVO.getSettleMode()) ? "代付结算" : "记账结算");
            subAccountSettleSplitVO.setStatus(Objects.equals("0", subAccountSettleSplitVO.getStatus()) ? "未入账" : "已入账");
            subAccountSettleSplitVO.setSettleDate(DateUtilities.dateTool(subAccountSettleSplitVO.getSettleDate()));
        }
        Map<String, Long> map = subAccountSettleSplitService.countTotal(query.getParameters());
        downloadExcelTool.download(path, filename, response, lists, map);
    }
}
