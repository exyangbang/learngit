package com.scenetec.upf.operation.web.outsidetransorder;


import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.Enum.PayTypeEnum;
import com.scenetec.upf.operation.model.Enum.ProductNoEnum;
import com.scenetec.upf.operation.model.Enum.SplitStatusEnum;
import com.scenetec.upf.operation.model.domain.outsidetransorder.OutsideTransOrderDO;
import com.scenetec.upf.operation.model.vo.DownloadPdfReqDTO;
import com.scenetec.upf.operation.model.vo.DownloadPdfRespDTO;
import com.scenetec.upf.operation.service.imageHanlder.ImageHanlderService;
import com.scenetec.upf.operation.service.outsidetransorder.OutsideTransOrderService;
import com.scenetec.upf.operation.utils.DataUtil;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.DownloadExcelTool;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@Api(value = "上送支付流水查询", tags = {"上送支付流水查询"})
@RestController
public class OutsideTransOrderController {

    @Resource
    OutsideTransOrderService service;

    @Autowired
    private DownloadExcelTool downloadExcelTool;

    @Resource
    private ImageHanlderService imageHanlderService;


    @RequestMapping(value = "/api/outsideTransOrder/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Query query) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<OutsideTransOrderDO> lists = service.list(query);
        for (OutsideTransOrderDO tem : lists.getList()) {
            tem.setTransDate(DateUtilities.dateTool(tem.getTransDate()));
            tem.setTransTime(DateUtilities.timeTool(tem.getTransTime()));
        }
        map.put("page", lists);
        map.put("total", service.countSum(query.getParameters()));
        return map;
    }


    @RequestMapping(value = "/api/outsideTransOrder/{id}", method = RequestMethod.GET)
    public void showPDF(@PathVariable Long id, HttpServletResponse response) throws IOException {
        OutsideTransOrderDO orderDO = service.showPDF(id);
        if (orderDO != null && orderDO.getPayMode().equals("3")) {
            DownloadPdfReqDTO downloadPdfReqDTO = new DownloadPdfReqDTO();
            downloadPdfReqDTO.setId(id);
            downloadPdfReqDTO.setType("1");
            DownloadPdfRespDTO dw = imageHanlderService.uploadPDFReque(downloadPdfReqDTO);
            ServletOutputStream out = response.getOutputStream();
            out.write(dw.getContent());
            out.flush();
            out.close();

        }
    }

    @RequestMapping(value = "/api/outsideTransOrder/download", method = RequestMethod.POST)
    public void outsideTransOrderDownload(HttpServletResponse response, @RequestBody Query query) {
        String path = "tabledefines_created/template/OutsideTransOrderFile.xlsx";
        String filename = "上送支付流水查询";
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        List<OutsideTransOrderDO> lists = service.listDownload(query).getList();
        for (OutsideTransOrderDO tem : lists) {
            tem.setTransDate(DateUtilities.dateTool(tem.getTransDate()));
            tem.setTransTime(DateUtilities.timeTool(tem.getTransTime()));
            tem.setPayMode(PayTypeEnum.getValue(tem.getPayMode()));
            tem.setSplitStatus(SplitStatusEnum.getValue(tem.getSplitStatus()));
        }
        Map<String, Object> map = service.countSum(query.getParameters());
        double amt = Long.valueOf(map.get("inTotalAmount").toString());
        map.put("inTotalAmount", String.valueOf(BigDecimal.valueOf((amt) * 0.01)));
        downloadExcelTool.download(path, filename, response, lists, map);

    }
}
