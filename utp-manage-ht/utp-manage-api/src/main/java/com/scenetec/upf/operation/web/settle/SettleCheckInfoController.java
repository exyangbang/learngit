package com.scenetec.upf.operation.web.settle;


import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.*;
import com.scenetec.upf.operation.model.domain.settle.SettleCheckInfoDO;
import com.scenetec.upf.operation.service.settle.SettleCheckInfoService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@Api(value = "差错流水", tags = {"差错流水"})
@RestController
@Slf4j
public class SettleCheckInfoController {

    @Resource
    SettleCheckInfoService service;
    @Autowired
    private ResourceLoader resourceLoader;
    /**
     * 对账差错联机地址
     */
    @Value("${settle.url}")
    private String url;


//    @RequestMapping(value = "/api/settleCheckInfo", method = RequestMethod.POST)
//    public long create(@RequestBody SettleCheckInfoDO obj){
//        return service.create(obj);
//    }
//
//    @RequestMapping(value = "/api/settleCheckInfo/{id}", method = RequestMethod.DELETE)
//    public int delete(@PathVariable Long id){
//	    return service.delete(id);
//	}

    /**
     * 人工处理提交 审批 渠道多流水和信息不匹配无法做人工处理
     *
     * @param reqObj
     */
    @RequestMapping(value = "/api/settleCheckInfo", method = RequestMethod.PUT)
    public void update(@RequestBody SettleCheckInfoDO reqObj) {
        if (reqObj.getAuditStatus() != null && reqObj.getAuditStatus().equals(AuditStatusEnum.AUDIT_PASS.getValue())) {//审批通过

        } else {
            reqObj.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            if (reqObj == null || reqObj.getRemark() == null) {
                throw new SystemRuntimeException(ErrorCode.BSMCM001);
            }
            //提交审核
            service.updateAuditStatus(reqObj);
        }
    }

    /**
     * 人工处理 审批 渠道多流水和信息不匹配无法做人工处理
     *
     * @param reqObj
     */
    @RequestMapping(value = "/api/settleCheckInfoExamine", method = RequestMethod.PUT)
    @Transactional
    public void settleCheckInfoExamine(@RequestBody SettleCheckInfoDO reqObj) {
        if (reqObj.getAuditStatus() != null && reqObj.getAuditStatus().equals(AuditStatusEnum.AUDIT_PASS.getValue())) {//审批通过
            for (int i = 0; i < reqObj.getTempIdList().size(); i++) {//批量处理
                String res = reqObj.getTempIdList().get(i).toString();
                SettleCheckInfoDO obj = service.getById(new Long(res));
                if (obj == null) {
                    throw new SystemRuntimeException(ErrorCode.PERR001);
                }
                if (obj.getErrorType().equals("b") || obj.getErrorType().equals("g")) {
                    throw new SystemRuntimeException(ErrorCode.PERR001);
                }
                if (obj.getStatus().equals("1")) {
                    throw new SystemRuntimeException(ErrorCode.BSMST003);
                }
                if (obj.getRemark() == null) {
                    throw new SystemRuntimeException(ErrorCode.BSMCD101, "remark参数");
                }
                MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
                request.add("id", obj.getId());
                request.add("reconciliationError", obj.getErrorType());
                request.add("industryCode", obj.getIndustryCode());
                request.add("tradeType", obj.getTradeType());
                request.add("transStatus", obj.getTransStatus());
                request.add("remark", obj.getRemark());
                request.add("serverTransId", obj.getServerTransId());
                request.add("needUpdateTransFlow", true);
                RestTemplate restTemplate = new RestTemplate();
                try {
                    Boolean response = restTemplate.postForObject(url, request, Boolean.class);
                    log.info("差错批量人工审核：" +request.toString()+"==>结果："+ response.toString());
                } catch (Exception e) {
                    log.error("差错批量人工审核异常", e);
                    throw new SystemRuntimeException(ErrorCode.BSMST003);
                }
            }
        } else {
            reqObj.setAuditStatus(AuditStatusEnum.AUDIT_REJECT.getValue());
            //驳回
            service.updateAuditStatus(reqObj);

        }
    }
//    @RequestMapping(value = "/api/settleCheckInfo/{id}", method = RequestMethod.GET)
//    public SettleCheckInfoDO get(@PathVariable Long id){
//        return service.getById(id);
//    }

    @RequestMapping(value = "/api/settleCheckInfo/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Query query) {
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("page", service.list(query));
        map.put("total", service.countSum(query.getParameters()));
        return map;
    }


    @RequestMapping(value = "/api/settleCheckInfo/download", method = RequestMethod.POST)
    public void transFlowHistory(HttpServletResponse response, @RequestBody Query query) {
        String path = "tabledefines_created/template/settleCheckInfoFileFile.xlsx";
        String filename = "差错流水";
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        List<SettleCheckInfoDO> lists = service.listDownload(query).getList();
        for (SettleCheckInfoDO tem : lists) {
            tem.setTransStatus(TransStatusEnum.getValue(tem.getTransStatus()));
            tem.setTradeType(TradeTypeEnum.getValue(tem.getTradeType()));
            tem.setProductCode(ProductCodeEnum.getValue(tem.getProductCode()));
            tem.setErrorType(ErrorTypeEnum.getValue(tem.getErrorType()));
            tem.setStatus(ProcessingMarkEnum.getValue(tem.getStatus()));
            String stringDate1 = tem.getTransDate() + tem.getTransTime();
            SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = null;
            try {
                date = f1.parse(stringDate1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tem.setTransDate(sdf.format(date));


            String settleDate = tem.getChannelSettleDate();
            if (StringUtils.isNoneBlank(settleDate)) {
                SimpleDateFormat fdate = new SimpleDateFormat("yyyyMMdd");
                Date date2 = null;
                try {
                    date2 = fdate.parse(settleDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                tem.setChannelSettleDate(sdf2.format(date2));
            } else {
                tem.setChannelSettleDate("");
            }
        }
        Map<String, Long> map = service.countSum(query.getParameters());
        download(path, filename, response, lists, map);
    }

    private void download(String path, String filename, HttpServletResponse response, List items, Map total) {
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:" + path);
        try (InputStream is = resource.getInputStream()) {
            Context context = new Context();
            context.putVar("items", items);
            context.putVar("total", total);
            response.setHeader("Content-type", "application/vnd.ms-excel");
            // 解决导出文件名中文乱码
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8"), "ISO-8859-1") + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemRuntimeException(ErrorCode.BSMST001);
        }
    }
}
