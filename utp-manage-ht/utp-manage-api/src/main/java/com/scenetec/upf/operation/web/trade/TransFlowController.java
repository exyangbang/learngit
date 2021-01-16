package com.scenetec.upf.operation.web.trade;


import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.ProductCodeEnum;
import com.scenetec.upf.operation.model.Enum.ProductNoEnum;
import com.scenetec.upf.operation.model.Enum.TradeTypeEnum;
import com.scenetec.upf.operation.model.Enum.TransStatusEnum;
import com.scenetec.upf.operation.model.domain.electronicreceipt.ElectronicReceiptDO;
import com.scenetec.upf.operation.model.domain.trade.TransFlowDO;
import com.scenetec.upf.operation.model.vo.DownloadPdfReqDTO;
import com.scenetec.upf.operation.model.vo.DownloadPdfRespDTO;
import com.scenetec.upf.operation.service.electronicreceipt.ElectronicReceiptService;
import com.scenetec.upf.operation.service.imageHanlder.ImageHanlderService;
import com.scenetec.upf.operation.service.trade.TransFlowService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.DownloadExcelTool;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/12
 */
@Api(value = "交易流水接口", tags = {"交易流水接口"})
@RestController
@Slf4j
public class TransFlowController {

    @Resource
    TransFlowService service;
    @Autowired
    private ResourceLoader resourceLoader;
    @Resource
    private ElectronicReceiptService electronicReceiptService;
    @Autowired
    private DownloadExcelTool downloadExcelTool;
    @Resource
    private ImageHanlderService imageHanlderService;


    @ApiIgnore
    @RequestMapping(value = "/api/transFlow", method = RequestMethod.POST)
    public long create(@RequestBody TransFlowDO obj) {
        return service.create(obj);
    }

    @ApiIgnore
    @RequestMapping(value = "/api/transFlow/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @ApiIgnore
    @RequestMapping(value = "/api/transFlow", method = RequestMethod.PUT)
    public void update(@RequestBody TransFlowDO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/transFlowCurrent/{id}", method = RequestMethod.GET)
    public TransFlowDO getCurrent(@PathVariable Long id) {
        return service.getCurrentById(id);
    }

    @RequestMapping(value = "/api/transFlowHistory/{id}", method = RequestMethod.GET)
    public TransFlowDO getHistory(@PathVariable Long id) {
        return service.getHistoryById(id);
    }

    @RequestMapping(value = "/api/transFlowCurrent/list", method = RequestMethod.POST)
    public Map<String, Object> listCurrent(@RequestBody Query query) {
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("page", service.listCurrent(query));
        map.put("total", service.countSum(query.getParameters()));
        return map;
    }

    @RequestMapping(value = "/api/transFlowHistory/list", method = RequestMethod.POST)
    public Map<String, Object> listHistory(@RequestBody Query query) {
        Map<String, Object> map = new HashMap<>();
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        map.put("page", service.listHistory(query));
        map.put("total", service.countSumHistory(query.getParameters()));
        return map;
    }

    /**
     * 电子回单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/transFlowHistory/download/{id}", method = RequestMethod.GET)
    public void download(@PathVariable String id, HttpServletResponse response) throws IOException {
        log.info("电子回单开始下载");
        ElectronicReceiptDO el = new ElectronicReceiptDO();
        el.setServerTransId(id);
        el = electronicReceiptService.getOne(el);
        TransFlowDO tem = service.getHistorySelctOne(id);
        if (tem == null || (!tem.getTransStatus().equals(TransStatusEnum.TRADE_SUCCESS.getValue()))) {
            throw new SystemRuntimeException(ErrorCode.BSMTR003);
        }
        if (el == null) {
            throw new SystemRuntimeException(ErrorCode.BSMTR003);
        }
        if (el != null) {
            byte[] fileAy = el.getFileContent();
            if (fileAy != null && fileAy.length != 0) {
                response.setContentType("application/pdf");//设置显示内容类型
                ServletOutputStream out = response.getOutputStream();
                out.write(fileAy);
                out.flush();
                out.close();
            } else {
                DownloadPdfReqDTO downloadPdfReqDTO = new DownloadPdfReqDTO();
                downloadPdfReqDTO.setId(el.getId());
                downloadPdfReqDTO.setType("2");
                DownloadPdfRespDTO dw = imageHanlderService.uploadPDFReque(downloadPdfReqDTO);
                ServletOutputStream out = response.getOutputStream();
                out.write(dw.getContent());
                out.flush();
                out.close();
            }
        }
    }


    @RequestMapping(value = "/api/transFlowCurrent/download", method = RequestMethod.POST)
    public void trans(HttpServletResponse response, @RequestBody Query query) {
        Map parameters = query.getParameters();
        String path = "tabledefines_created/template/transFlowCurrentFile.xlsx";
        String filename = "当前交易流水";
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        Map<String, Long> map = service.countSum(parameters);
        if (map.get("totalCount").intValue() > 15000) {
            throw new SystemRuntimeException(ErrorCode.BSMST004);
        }
        List<TransFlowDO> lists = service.listCurrentDownload(query).getList();
        for (TransFlowDO tem : lists) {
            tem.setTransStatus(TransStatusEnum.getValue(tem.getTransStatus()));
            tem.setTradeType(TradeTypeEnum.getValue(tem.getTradeType()));
            tem.setProductCode(ProductCodeEnum.getValue(tem.getProductCode()));
            String stringDate1 = tem.getTransDate() + tem.getTransTime();
            tem.setTransDate(DateUtilities.dateAndTimeTool(stringDate1));
            String settleDate = tem.getChannelSettleDate();
            tem.setChannelSettleDate(DateUtilities.dateTool(settleDate));
        }
        downloadExcelTool.download(path, filename, response, lists, map);

    }

    @RequestMapping(value = "/api/transFlowHistory/download", method = RequestMethod.POST)
    public void transFlowHistory(HttpServletResponse response, @RequestBody Query query) {
        Map parameters = query.getParameters();
        String path = "tabledefines_created/template/transFlowCurrentFile.xlsx";
        String filename = "历史交易流水";
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        Map<String, Long> map = service.countSumHistory(parameters);
        if (map.get("totalCount").intValue() > 15000) {
            throw new SystemRuntimeException(ErrorCode.BSMST004);
        }
        List<TransFlowDO> lists = service.listHistoryDownload(query).getList();
        for (TransFlowDO tem : lists) {
            tem.setTransStatus(TransStatusEnum.getValue(tem.getTransStatus()));
            tem.setTradeType(TradeTypeEnum.getValue(tem.getTradeType()));
            tem.setProductCode(ProductCodeEnum.getValue(tem.getProductCode()));
            String stringDate1 = tem.getTransDate() + tem.getTransTime();
            tem.setTransDate(DateUtilities.dateAndTimeTool(stringDate1));
            String settleDate = tem.getChannelSettleDate();
            tem.setChannelSettleDate(DateUtilities.dateTool(settleDate));
        }
        downloadExcelTool.download(path, filename, response, lists, map);
    }

}
