package com.scenetec.upf.operation.web.settle;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.*;
import com.scenetec.upf.operation.model.domain.settle.*;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import com.scenetec.upf.operation.service.settle.SettleSumInfoService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;

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
@Api(value="对账接口",tags={"对账接口"})
@RestController
public class SettleSumInfoController {

    @Resource
    SettleSumInfoService service;

    @Autowired
    private ResourceLoader resourceLoader;

/*    @RequestMapping(value = "/api/settleSumInfo", method = RequestMethod.POST)
    public long create(@RequestBody SettleSumInfoDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/settleSumInfo/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/settleSumInfo", method = RequestMethod.PUT)
    public void update(@RequestBody SettleSumInfoDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/settleSumInfo/{id}", method = RequestMethod.GET)
    public SettleSumInfoDO get(@PathVariable Long id){
        return service.getById(id);
    }*/

    @RequestMapping(value = "/api/orgSettleSumInfo/list", method = RequestMethod.POST)
    public Map orglist(@RequestBody Query query) {
        Map<String,Object> map=new HashMap<>();
	    map.put("page",service.orgList(query));
	    map.put("total",service.countOrg((String)query.getParameters().get("orgCode"),(String)query.getParameters().get("reconcileDate")));
	    return map;
	}

    @RequestMapping(value = "/api/orgSettleSumInfo/download/{reconcileDate}/{orgCode}", method = RequestMethod.GET)
    public void org(HttpServletResponse response, @PathVariable String reconcileDate,@PathVariable String orgCode) {
        String path = "tabledefines_created/template/orgReconcileFile.xlsx";
        String filename="机构对账单下载";
        OrgSettleSumInfoDO obj=new OrgSettleSumInfoDO();
        obj.setReconcileDate(reconcileDate);
        obj.setOrgCode(orgCode);
        List<OrgSettleSumInfoDO> lists=service.selectOrgList(obj);
        Map<String,Long> map=service.countOrg(orgCode,reconcileDate);
        download(path,filename,response,lists,map);
    }

    @RequestMapping(value = "/api/merSettleSumInfo/list", method = RequestMethod.POST)
    public Map merlist(@RequestBody Query query) {
        Map<String,Object> map=new HashMap<>();
        map.put("page",service.merList(query));
        map.put("total",service.countMer((String)query.getParameters().get("merNo"),(String)query.getParameters().get("reconcileDate")));
        return map;
    }

    @RequestMapping(value = "/api/merSettleSumInfo/download/{reconcileDate}/{merNo}", method = RequestMethod.GET)
    public void mer(HttpServletResponse response, @PathVariable String reconcileDate,@PathVariable String merNo) {
        String path = "tabledefines_created/template/merReconcileFile.xlsx";
        String filename="商户对账单下载";
        MerSettleSumInfoDO obj=new MerSettleSumInfoDO();
        obj.setReconcileDate(reconcileDate);
        obj.setMerNo(merNo);
        List<MerSettleSumInfoDO> lists=service.selectMerList(obj);
        Map<String,Long> map=service.countMer(merNo,reconcileDate);
        download(path,filename,response,lists,map);
    }

    @RequestMapping(value = "/api/indSettleSumInfo/list", method = RequestMethod.POST)
    public Map indlist(@RequestBody Query query) {
        Map<String,Object> map=new HashMap<>();
        map.put("page",service.indList(query));
        map.put("total",service.countInd((String)query.getParameters().get("industryCode"),(String)query.getParameters().get("reconcileDate")));
        return map;
    }

    @RequestMapping(value = "/api/indSettleSumInfo/download/{reconcileDate}/{industryCode}", method = RequestMethod.GET)
    public void ind(HttpServletResponse response, @PathVariable String reconcileDate,@PathVariable String industryCode) {
        String path = "tabledefines_created/template/indReconcileFile.xlsx";
        String filename="客户对账单下载";
        IndSettleSumInfoDO obj=new IndSettleSumInfoDO();
        obj.setReconcileDate(reconcileDate);
        obj.setIndustryCode(industryCode);
        List<IndSettleSumInfoDO> lists=service.selectIndList(obj);
        for (IndSettleSumInfoDO tem : lists) {
            tem.setTradeType(TradeTypeEnum.getValue(tem.getTradeType()));
            String stringDate1 = tem.getTransDate() ;
            String stringtime = tem.getTransTime();
            SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat ftime = new SimpleDateFormat("HHmmss");
            Date date = null;
            Date timeDate = null;
            try {
                date = f1.parse(stringDate1);
                timeDate = ftime.parse(stringtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss");
            tem.setTransDate(sdf.format(date));
            tem.setTransTime(sdftime.format(timeDate));
        }
        Map<String,Long> map=service.countInd(industryCode,reconcileDate);
        download(path,filename,response,lists,map);
    }

    @RequestMapping(value = "/api/transSumInfo/list", method = RequestMethod.POST)
    public Map translist(@RequestBody Query query) {
        Map<String,Object> map=new HashMap<>();
        if (query.getParameters().get("productCode") != null) {
            query.getParameters().put("productCode", ProductNoEnum.getCodeByNo(query.getParameters().get("productCode").toString()));
        }
        map.put("page",service.sumList(query));
        map.put("total",service.countSum(query.getParameters()));
        return map;
    }

    @RequestMapping(value = "/api/transSumInfo/download", method = RequestMethod.POST)
    public void trans(HttpServletResponse response,@RequestBody Map<String, Object> parameters) {
        String path = "tabledefines_created/template/transReconcileFile.xlsx";
        String filename="交易统计报表";
        if (parameters.get("productCode") != null) {
            parameters.put("productCode", ProductNoEnum.getCodeByNo(parameters.get("productCode").toString()));
        }
        List<TransSumInfoDO> lists=service.selectSumList(parameters);
        Map<String,Long> map=service.countSum(parameters);
        download(path,filename,response,lists,map);
    }

    private void download(String path,String filename,HttpServletResponse response,List items,Map total){
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:" + path);
        try (InputStream is = resource.getInputStream()) {
            Context context = new Context();
            context.putVar("items", items);
            context.putVar("total", total);
            response.setHeader("Content-type","application/vnd.ms-excel");
            // 解决导出文件名中文乱码
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("UTF-8"),"ISO-8859-1")+".xlsx");
            response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemRuntimeException(ErrorCode.BSMST001);
        }
    }
}
