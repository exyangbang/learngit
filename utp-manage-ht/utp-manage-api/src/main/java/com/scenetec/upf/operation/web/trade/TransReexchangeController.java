package com.scenetec.upf.operation.web.trade;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.ProductCodeEnum;
import com.scenetec.upf.operation.model.Enum.SolveStatusEnum;
import com.scenetec.upf.operation.model.Enum.TradeTypeEnum;
import com.scenetec.upf.operation.model.Enum.TransStatusEnum;
import com.scenetec.upf.operation.model.domain.trade.TransReexchangeDO;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.service.trade.TransReexchangeService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
 * @Description : 退汇流水信息 。
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 17:57
 */
@Api(value = "退汇流水信息", tags = {"退汇流水信息"})
@RestController
public class TransReexchangeController {

    @Value("${reexchange.accout.url}")
    private String reexchangeAccoutUrl;


    @Resource
    private TransReexchangeService transReexchangeService;

    @Resource
    private UserService userService;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/api/transReexchange", method = RequestMethod.POST)
    public int transReexchange(@RequestBody TransReexchangeDO transReexchangeDO) {
        int createCount = transReexchangeService.create(transReexchangeDO);
        if (createCount > 0) {
            MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
            request.add("id", transReexchangeDO.getId());
            request.add("userModified", userService.getUserContext().getUsername());
            RestTemplate restTemplate = new RestTemplate();
            try {
                Map<String, Object> resultMap = restTemplate.postForObject(reexchangeAccoutUrl, request, Map.class);
                if (!"200".equals(resultMap.get("status"))) {
                    throw new SystemRuntimeException(ErrorCode.BSMPS001, (String) resultMap.get("message"));
                }
            } catch (SystemRuntimeException systemRuntimeException) {
                throw systemRuntimeException;
            } catch (HttpClientErrorException httpClientErrorException) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, "退汇账户处理失败:" + httpClientErrorException.getMessage());
            } catch (Exception e) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, "未知异常:" + e.getMessage());
            }
        }
        return createCount;
    }

    /**
     * 退汇管理重新处理
     *
     * @param id
     */
    @RequestMapping(value = "/api/transReexchange/{id}", method = RequestMethod.POST)
    public void audit(@PathVariable Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
        request.add("id", id);
        request.add("userModified", userService.getUserContext().getUsername());
        RestTemplate restTemplate = new RestTemplate();
        try {
            Map<String, Object> resultMap = restTemplate.postForObject(reexchangeAccoutUrl, request, Map.class);
            if (!"200".equals(resultMap.get("status"))) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, (String) resultMap.get("message"));
            }
        } catch (SystemRuntimeException systemRuntimeException) {
            throw systemRuntimeException;
        } catch (HttpClientErrorException httpClientErrorException) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "退汇账户处理失败:" + httpClientErrorException.getMessage());
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "未知异常:" + e.getMessage());
        }
    }

    @RequestMapping(value = "/api/transReexchange/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Query query) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", transReexchangeService.pageReexchange(query));
        map.put("total", transReexchangeService.countSum(query.getParameters()));
        return map;
    }

    @RequestMapping(value = "/api/transReexchange/download", method = RequestMethod.POST)
    public void download(HttpServletResponse response, @RequestBody(required = false) Query query) throws ParseException {
        String path = "tabledefines_created/template/transReexchangeFile.xlsx";
        String filename = "退汇管理列表下载";
        List<TransReexchangeDO> lists = transReexchangeService.pageReexchangeDownload(query).getList();
        for (TransReexchangeDO tem : lists) {
            tem.setTransStatus(TransStatusEnum.getValue(tem.getTransStatus()));
            tem.setTradeType(TradeTypeEnum.getValue(tem.getTradeType()));
            tem.setProductCode(ProductCodeEnum.getValue(tem.getProductCode()));
            String stringDate1 = tem.getTransDate() + tem.getTransTime();
            SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = f1.parse(stringDate1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tem.setTransDate(sdf.format(date));
            tem.setSolveStatus(SolveStatusEnum.getValue(tem.getSolveStatus()));

            String stringDate2 = tem.getReconcileDate();
            SimpleDateFormat f2 = new SimpleDateFormat("yyyyMMdd");
            Date date2 = f2.parse(stringDate2);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            tem.setReconcileDate(sdf2.format(date2));

            Date mttime = tem.getGmtModified();
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tem.setGmtModifiedStr(sdf3.format(mttime));
        }
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:" + path);
        try (InputStream is = resource.getInputStream()) {
            Context context = new Context();
            context.putVar("items", lists);
            context.putVar("total", transReexchangeService.countSum(query.getParameters()));
            response.setHeader("Content-type", "application/vnd.ms-excel");
            // 解决导出文件名中文乱码
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8"), "ISO-8859-1") + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            JxlsHelper jxlsHelper = JxlsHelper.getInstance();
            Transformer transformer = jxlsHelper.createTransformer(is, response.getOutputStream());
            JxlsHelper.getInstance().processTemplate(context, transformer);
        } catch (IOException e) {
            throw new SystemRuntimeException(ErrorCode.BSMST001);
        }

    }
}
