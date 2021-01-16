package com.scenetec.upf.operation.web.account;


import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.account.AccountDetailDO;
import com.scenetec.upf.operation.model.domain.electronicreceipt.AaccountElectronicReceiptDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.AccountInfoVO;
import com.scenetec.upf.operation.model.vo.AccountReqVO;
import com.scenetec.upf.operation.model.vo.DownloadPdfReqDTO;
import com.scenetec.upf.operation.model.vo.DownloadPdfRespDTO;
import com.scenetec.upf.operation.service.account.AccountService;
import com.scenetec.upf.operation.service.imageHanlder.ImageHanlderService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@Api(value = "账户管理", tags = {"账户管理"})
@RestController
public class AccountController {

    @Resource
    AccountService service;
    @Resource
    ImageHanlderService imageHanlderService;

//    @RequestMapping(value = "/api/account", method = RequestMethod.POST)
//    public long create(@RequestBody AccountDO obj){
//        return service.create(obj);
//    }
//
//    @RequestMapping(value = "/api/account/{id}", method = RequestMethod.DELETE)
//    public int delete(@PathVariable Long id){
//	    return service.delete(id);
//	}
//

    /**
     * 配置手续费 账户管理权限
     *
     * @param obj
     */
    @RequestMapping(value = "/api/account", method = RequestMethod.PUT)
    public void update(@RequestBody AccountDO obj) {
        service.updateFeeTemplate(obj);
    }
//
//    @RequestMapping(value = "/api/account/{id}", method = RequestMethod.GET)
//    public AccountDO get(@PathVariable Long id){
//        return service.getById(id);
//    }

    @RequestMapping(value = "/api/account/pageList", method = RequestMethod.POST)
    public Map<String, Object> pageList(@RequestBody Query query) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", service.pageList(query));
        map.put("total", service.countSum(query.getParameters()));
        return map;
    }

    /**
     * 排除收益账户 未入账流水查询，手工入账中不能出现收益账号
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/account/pageListExclusive", method = RequestMethod.POST)
    public PageInfo<AccountDO> pageListExclusive(@RequestBody Query query) {
        return service.pageListExclusive(query);
    }

    @RequestMapping(value = "/api/accountDetail/pageList", method = RequestMethod.POST)
    public PageInfo<AccountDetailDO> pageListDetail(@RequestBody Query query) {
        return service.pageListDetail(query);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/account/accountDetail/{id}", method = RequestMethod.GET)
    public AccountInfoVO accountDetafil(@PathVariable Long id) {

        return service.accountDetail(id);
    }

    /**
     * 上报银行系统
     *
     * @param obj
     */
    @RequestMapping(value = "/api/account/reportBank", method = RequestMethod.PUT)
    public void reportBank(@Validated @RequestBody AccountReqVO obj) {
        service.reportBank(obj);
    }


    /**
     * 电子回单
     *
     * @param
     * @return //
     */
    @RequestMapping(value = "/api/accounElectronic/download/{account}", method = RequestMethod.GET)
    public void download(@PathVariable String account, HttpServletResponse response) throws IOException {
        AaccountElectronicReceiptDO receiptDO = service.getAccounElectronic(account);
        if (receiptDO != null) {
            byte[] fileAy = receiptDO.getFileContent();
            if (fileAy != null){
                response.setContentType("application/pdf");//设置显示内容类型
                ServletOutputStream out = response.getOutputStream();
                out.write(fileAy);
                out.flush();
                out.close();
            }else {
                DownloadPdfReqDTO downloadPdfReqDTO = new DownloadPdfReqDTO();
                downloadPdfReqDTO.setId(receiptDO.getId());
                downloadPdfReqDTO.setType("3");
                DownloadPdfRespDTO dw = imageHanlderService.uploadPDFReque(downloadPdfReqDTO);
                ServletOutputStream out = response.getOutputStream();
                out.write(dw.getContent());
                out.flush();
                out.close();
            }


        }
    }
    /**
     * 获取图片
     */
    @RequestMapping(value = "/api/account/getImage", method = RequestMethod.POST)
    public MerchantInfoDO getImage(@RequestBody Map obj) {
       return service.getImage(obj);
    }


    @RequestMapping(value = "/api/account/updateAccInfo", method = RequestMethod.PUT)
    public void udpateAccinfo(@RequestBody AccountInfoVO obj) {
         service.updateMerchInfo(obj);
    }
}
