package com.scenetec.upf.operation.web.splitinfo;


import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.Enum.ProcessingMarkEnum;
import com.scenetec.upf.operation.model.Enum.ProductNoEnum;
import com.scenetec.upf.operation.model.Enum.SettleModelEnum;
import com.scenetec.upf.operation.model.Enum.TransStatusEnum;
import com.scenetec.upf.operation.model.domain.splitinfo.SplitInfoDO;
import com.scenetec.upf.operation.service.splitinfo.SplitInfoService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.DownloadExcelTool;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@Api(value = "分账信息记录", tags = {"分账信息记录"})
@RestController
public class SplitInfoController {

    @Resource
    SplitInfoService service;
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private DownloadExcelTool downloadExcelTool;


    @RequestMapping(value = "/api/splitInfo/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Query query) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<SplitInfoDO> lists = service.list(query);
        for (SplitInfoDO tem : lists.getList()) {
            String settleDate = tem.getSettleDate();
            tem.setSettleDate(DateUtilities.dateTool(settleDate));
            tem.setSplitDate(DateUtilities.dateTool(tem.getSplitDate()));
        }
        map.put("page", lists);
        map.put("total", service.countSum(query.getParameters()));
        return map;
    }


    @RequestMapping(value = "/api/splitInfo/download", method = RequestMethod.POST)
    public void splitInfoDownload(HttpServletResponse response, @RequestBody Query query) {
        String path = "tabledefines_created/template/SplitInfoFile.xlsx";
        String filename = "平台分账信息记录";
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        List<SplitInfoDO> lists = service.listDownload(query).getList();
        for (SplitInfoDO tem : lists) {
            tem.setTransStatus(TransStatusEnum.getValue(tem.getTransStatus()));
            tem.setStatus(ProcessingMarkEnum.getValue(tem.getStatus()));
            String settleDate = tem.getSettleDate();
            tem.setSettleDate(DateUtilities.dateTool(settleDate));
            tem.setSettleMode(SettleModelEnum.getValue(tem.getSettleMode()));
            tem.setSplitDate(DateUtilities.dateTool(tem.getSplitDate()));
        }
        Map<String, Long> map = service.countSum(query.getParameters());
        downloadExcelTool.download(path, filename, response, lists, map);

    }


    @RequestMapping(value = "/api/splitInfo/{id}", method = RequestMethod.GET)
    public SplitInfoDO get(@PathVariable Long id) {
        return service.getById(id);
    }
}
