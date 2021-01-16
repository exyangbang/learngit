package com.scenetec.upf.operation.web.financialaccountstatement;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.financialaccountstatement.FinancialAccountStatementDO;
import com.scenetec.upf.operation.service.financialaccountstatement.FinancialAccountStatementService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "资金账户统计报表", tags = {"资金账户统计报表"})
@RestController
public class FinancialAccountStatementController {
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    FinancialAccountStatementService statementService;

    @RequestMapping(value = "/api/financialAccountStatement/{id}", method = RequestMethod.GET)
    public FinancialAccountStatementDO get(@PathVariable Long id) {
        return statementService.getById(id);
    }

    @RequestMapping(value = "/api/financialAccountStatement/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Query query) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", statementService.list(query));
        map.put("total", statementService.countSum(query.getParameters()));
        return map;
    }

    @RequestMapping(value = "/api/financialAccountStatement/download", method = RequestMethod.POST)
    public void trans(HttpServletResponse response, @RequestBody Query query) {
        String path = "tabledefines_created/template/FinancialAccountStatementFile.xlsx";
        String filename = "资金账户统计报表";
        List<FinancialAccountStatementDO> lists = statementService.listDownload(query).getList();
        for (FinancialAccountStatementDO tem : lists) {
            String stringDate1 = tem.getTransDate();
            SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
            Date date = null;
            try {
                date = f1.parse(stringDate1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tem.setTransDate(sdf.format(date));
        }
        Map<String, Long> map = statementService.countSum(query.getParameters());
        downloads(path, filename, response, lists, map);
    }

    private void downloads(String path, String filename, HttpServletResponse response, List items, Map total) {
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
