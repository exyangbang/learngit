package cn.kingnet.product.account.controller;

import cn.kingnet.product.account.service.inner.PictureService;
import cn.kingnet.product.account.service.inner.SchedulerServiceProvider;
import cn.kingnet.product.account.service.inner.manage.*;
import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import cn.kingnet.utp.product.common.dto.manage.*;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * @Description 内部后管服务调用
 */
@RestController
@RequestMapping("/spi/account/innerManage")
@Slf4j
public class InnerManageController extends DefaultFeginExceptionHandler {

    private final ValidAccountInfoService validAccountInfoService;
    private final RedisCacheService redisCacheService;

    @Resource
    private CollectAccountWithdrawService collectAccountWithdrawService;
    @Resource
    private QueryCollectAccountWithdrawService queryCollectAccountWithdrawService;
    @Resource
    private QueryFeeIncomeAccountCollectionService queryFeeIncomeAccountCollectionService;
    @Resource
    private SchedulerServiceProvider schedulerServiceProvider;
    @Resource
    private VirtualAccountService virtualAccountService;
    @Resource
    private PersonOrOrgHotspotService personOrOrgHotspotService;
    @Resource
    private QuerySingleTransStatusService querySingleTransStatusService;
    @Resource
    private PictureService pictureService;
    @Resource
    private DownloadPdfService downloadPdfService;

    public InnerManageController(ValidAccountInfoService validAccountInfoService, RedisCacheService redisCacheService) {
        this.validAccountInfoService = validAccountInfoService;
        this.redisCacheService = redisCacheService;
    }

    /**
     * 校验资金账户信息
     * @param validAccountInfoReqDTO
     * @return
     */
    @PostMapping("validAccountInfo")
    public DeferredResult<Object> validAccountInfo(@RequestBody ValidAccountInfoReqDTO validAccountInfoReqDTO) {
        LambdaLogger.info(log, l -> l.info("校验资金账户信息请求报文：{}", JSON.toJSONString(validAccountInfoReqDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> validAccountInfoService.validAccountInfo(validAccountInfoReqDTO))
                .whenCompleteAsync((r, e) -> {
                    ServerResponseDTO serverResponseDTO = null;
                    if (e == null) {
                        serverResponseDTO = r;
                    } else if (e instanceof ProductException) {
                        ProductException productException = (ProductException) e;
                        serverResponseDTO = new ServerResponseDTO(String.valueOf(productException.getStatus()), productException.getMessage());
                    } else {
                        serverResponseDTO = new ServerResponseDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "校验资金账户信息响应报文：{}", JSON.toJSONString(serverResponseDTO));
                    dr.setResult(serverResponseDTO);
                });
        return dr;
    }

    /**
     * 后管基本信息变更后通知 刷新缓存
     * @param refreshRedisDTO
     * @return
     */
    @PostMapping("refreshRedisCacheByManage")
    public DeferredResult<Object> refreshRedisCacheByManage(@RequestBody RefreshRedisDTO refreshRedisDTO) {
        LambdaLogger.info(log, l -> l.info("后管基本信息变更后通知 刷新缓存请求报文：{}", JSON.toJSONString(refreshRedisDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> redisCacheService.refreshRedisCache(refreshRedisDTO))
                .whenCompleteAsync((r, e) -> {
                    ServerResponseDTO serverResponseDTO;
                    if (e == null) {
                        serverResponseDTO = r;
                    } else if (e instanceof ProductException) {
                        ProductException productException = (ProductException) e;
                        serverResponseDTO = new ServerResponseDTO(String.valueOf(productException.getStatus()), productException.getMessage());
                    } else {
                        serverResponseDTO = new ServerResponseDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管基本信息变更后通知 刷新缓存响应报文：{}", JSON.toJSONString(serverResponseDTO));
                    dr.setResult(serverResponseDTO);
                });
        return dr;
    }

    /**
     * 后管归集账户提现申请
     * @param reqDTO
     * @return
     */
    @PostMapping("collectAccountWithdraw")
    public DeferredResult<Object> collectAccountWithdraw(@RequestBody CollectionAccountWithdrawReqDTO reqDTO) {
        LambdaLogger.info(log, l -> l.info("后管归集账户提现申请 请求报文：{}", JSON.toJSONString(reqDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> collectAccountWithdrawService.doService(reqDTO))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO;
                    if (e == null) {
                        respDTO = r;
                    } else if (e instanceof ManageException) {
                        ManageException manageException = (ManageException) e;
                        respDTO = new BaseInnerManageRespDTO(String.valueOf(manageException.getStatus()), manageException.getMessage());
                    } else {
                        respDTO = new BaseInnerManageRespDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管归集账户提现申请 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 后管查询归集账户提现结果
     * @param reqDTO
     * @return
     */
    @PostMapping("queryCollectAccountWithdraw")
    public DeferredResult<Object> queryCollectAccountWithdraw(@RequestBody QueryCollectionAccountWithdrawReqDTO reqDTO) {
        LambdaLogger.info(log, l -> l.info("后管查询归集账户提现结果 请求报文：{}", JSON.toJSONString(reqDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> queryCollectAccountWithdrawService.doService(reqDTO))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO;
                    if (e == null) {
                        respDTO = r;
                    } else if (e instanceof ManageException) {
                        ManageException manageException = (ManageException) e;
                        respDTO = new BaseInnerManageRespDTO(String.valueOf(manageException.getStatus()), manageException.getMessage());
                    } else {
                        respDTO = new BaseInnerManageRespDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管查询归集账户提现结果 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 后管按月份&收益虚账户(非必填)统计
     * @return
     */
    @PostMapping("feeIncomeAccountMonthStat")
    public DeferredResult<Object> feeIncomeAccountMonthStat(@RequestParam("statMonth") String statMonth, @RequestParam(name = "account", required = false) String account) {
        LambdaLogger.info(log, l -> l.info("后管收益账户月份统计收益 请求报文：statMont={},account={}", statMonth, account));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> schedulerServiceProvider.feeIncomeAccountMonthStat(statMonth, account))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO;
                    if (e == null) {
                        respDTO = r;
                    } else if (e instanceof ManageException) {
                        ManageException manageException = (ManageException) e;
                        respDTO = new BaseInnerManageRespDTO(String.valueOf(manageException.getStatus()), manageException.getMessage());
                    } else {
                        respDTO = new BaseInnerManageRespDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管收益账户月份统计收益 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 后管根据收益账户统计id进行归集划转
     * @return
     */
    @PostMapping("feeIncomeAccountMonthCollection")
    public DeferredResult<Object> feeIncomeAccountMonthCollection(@RequestParam("feeStatId") long feeStatId) {
        LambdaLogger.info(log, l -> l.info("后管收益账户月统计归集划转 请求报文：feeStatId={}", feeStatId));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> schedulerServiceProvider.feeIncomeAccountMonthCollection(feeStatId))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO;
                    if (e == null) {
                        respDTO = r;
                    } else if (e instanceof ManageException) {
                        ManageException manageException = (ManageException) e;
                        respDTO = new BaseInnerManageRespDTO(String.valueOf(manageException.getStatus()), manageException.getMessage());
                    } else {
                        respDTO = new BaseInnerManageRespDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管收益账户月统计归集划转 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 后管查询收益账户归集划转结果
     * @param reqDTO
     * @return
     */
    @PostMapping("queryFeeIncomeAccountMonthCollection")
    public DeferredResult<Object> queryFeeIncomeAccountMonthCollection(@RequestBody QueryFeeIncomeAccountCollectionReqDTO reqDTO) {
        LambdaLogger.info(log, l -> l.info("后管查询收益账户归集划转结果 请求报文：{}", JSON.toJSONString(reqDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> queryFeeIncomeAccountCollectionService.doService(reqDTO))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO;
                    if (e == null) {
                        respDTO = r;
                    } else if (e instanceof ManageException) {
                        ManageException manageException = (ManageException) e;
                        respDTO = new BaseInnerManageRespDTO(String.valueOf(manageException.getStatus()), manageException.getMessage());
                    } else {
                        respDTO = new BaseInnerManageRespDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管查询收益账户归集划转结果 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 后管资金账户冻结解冻
     * @param freezenBalanceReqDTO
     * @return
     */
    @PostMapping("freezenBalance")
    public DeferredResult<Object> freezenBalance(@RequestBody FreezenBalanceReqDTO freezenBalanceReqDTO) {
        LambdaLogger.info(log, l -> l.info("后管资金账户冻结解冻 请求报文：{}", JSON.toJSONString(freezenBalanceReqDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> virtualAccountService.freezenBalance(freezenBalanceReqDTO))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO = buildInnerManageResp(r, e);
                    LambdaLogger.info(log, "后管资金账户冻结解冻 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    private BaseInnerManageRespDTO buildInnerManageResp(BaseInnerManageRespDTO respDTO, Throwable e) {
        if (e == null) {
            return respDTO;
        }
        ManageException manageException;
        if (e instanceof ManageException) {
            manageException = (ManageException) e;
        } else if (e.getCause() != null && e.getCause() instanceof ManageException) {
            manageException = (ManageException) e.getCause();
        } else if (e instanceof TradeException) {
            manageException = new ManageException(((TradeException) e).getStatus(), e.getMessage());
        } else if (e.getCause() != null && e.getCause() instanceof TradeException) {
            manageException = new ManageException(((TradeException) e.getCause()).getStatus(), e.getCause().getMessage());
        } else {
            manageException = new ManageException(HttpRespStatus.BAD_REQUEST.value(), e.getMessage());
        }
        BaseInnerManageRespDTO manageRespDTO = new BaseInnerManageRespDTO(String.valueOf(manageException.getStatus()), manageException.getMessage());
        return manageRespDTO;
    }


    /**
     * 后管建立个人/企业的客户热点信息
     */
    @PostMapping("addPersonOrOrgHotspot")
    public DeferredResult<Object> addPersonOrOrgHotspot(@RequestBody AccountInfoDTO accountInfoDTO) {
        LambdaLogger.info(log, l -> l.info("后管建立个人/企业的客户热点信息 请求报文：{}", JSON.toJSONString(accountInfoDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> personOrOrgHotspotService.addPersonOrOrgHotspot(accountInfoDTO, 1))
                .whenCompleteAsync((r, e) -> {
                    ServerResponseDTO serverResponseDTO;
                    if (e == null) {
                        serverResponseDTO = r;
                    } else if (e instanceof ProductException) {
                        ProductException productException = (ProductException) e;
                        serverResponseDTO = new ServerResponseDTO(String.valueOf(productException.getStatus()), productException.getMessage());
                    } else {
                        serverResponseDTO = new ServerResponseDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管建立个人/企业的客户热点信息 响应报文：{}", JSON.toJSONString(serverResponseDTO));
                    dr.setResult(serverResponseDTO);
                });
        return dr;
    }

    /**
     * 后管建立个人/企业的客户热点信息
     */
    @PostMapping("updatePersonOrOrgHotspot")
    public DeferredResult<Object> updatePersonOrOrgHotspot(@RequestBody BankClientAccountInfoDTO bankClientAccountInfoDTO) {
        final String manageClientTransId = bankClientAccountInfoDTO.getClientTransId();
        Assert.hasText(manageClientTransId, () -> "后管更新个人/企业的客户热点信息 请求参数[ClientTransId]不能为空");
        LambdaLogger.info(log, l -> l.info("后管更新个人/企业的客户热点信息 客户流水号:{} >> 请求报文：{}", manageClientTransId, JSON.toJSONString(bankClientAccountInfoDTO)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> personOrOrgHotspotService.updatePersonOrOrgHotspot(bankClientAccountInfoDTO, 1))
                .whenCompleteAsync((r, e) -> {
                    ServerResponseDTO serverResponseDTO;
                    if (e == null) {
                        serverResponseDTO = r;
                    } else if (e instanceof ProductException) {
                        ProductException productException = (ProductException) e;
                        serverResponseDTO = new ServerResponseDTO(String.valueOf(productException.getStatus()), productException.getMessage());
                    } else {
                        serverResponseDTO = new ServerResponseDTO(HttpRespStatus.BAD_REQUEST.valueStr(), e.getMessage());
                    }
                    LambdaLogger.info(log, "后管更新个人/企业的客户热点信息 客户流水号:{} << 响应报文：{}", manageClientTransId, JSON.toJSONString(serverResponseDTO));
                    dr.setResult(serverResponseDTO);
                });
        return dr;
    }

    /**
     * 查询单笔交易流水状态
     */
    @PostMapping("querySingleTransStatus")
    public DeferredResult<Object> querySingleTransStatus(@RequestBody QuerySingleTransStatusReqDTO req) {
        LambdaLogger.info(log, l -> l.info("查询单笔交易流水状态 请求报文：{}", JSON.toJSONString(req)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture
                .supplyAsync(() -> querySingleTransStatusService.query(req))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO = buildInnerManageResp(r, e);
                    LambdaLogger.info(log, "查询单笔交易流水状态 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 查询客户或商户图片信息
     */
    @PostMapping("queryIndustryMerchantImages")
    public DeferredResult<Object> queryIndustryMerchantImages(@RequestBody QueryIndustryMerchantImagesReqDTO req) {
        LambdaLogger.info(log, l -> l.info("查询客户或商户图片信息 请求报文：{}", JSON.toJSONString(req)));
        DeferredResult<Object> dr = new DeferredResult<>();
        CompletableFuture
                .supplyAsync(() -> pictureService.queryImages(req))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO = buildInnerManageResp(r, e);
                    LambdaLogger.info(log, "查询客户或商户图片信息 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 上传客户或商户图片信息
     */
    @PostMapping("uploadIndustryMerchantImages")
    public DeferredResult<Object> uploadIndustryMerchantImages(@RequestBody UploadIndustryMerchantImagesReqDTO req) {
        LambdaLogger.info(log, l -> l.info("上传客户或商户图片信息 请求报文：{}", JSON.toJSONString(req)));
        DeferredResult<Object> dr = new DeferredResult<>();
        CompletableFuture
                .supplyAsync(() -> pictureService.uploadImages(req))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO = buildInnerManageResp(r, e);
                    LambdaLogger.info(log, "上传客户或商户图片信息 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

    /**
     * 下载PDF
     */
    @PostMapping("downloadPdf")
    public DeferredResult<Object> downloadPdf(@RequestBody DownloadPdfReqDTO req) {
        LambdaLogger.info(log, l -> l.info("后管下载PDF 请求报文：{}", JSON.toJSONString(req)));
        DeferredResult<Object> dr = new DeferredResult<>();
        CompletableFuture
                .supplyAsync(() -> downloadPdfService.download(req))
                .whenCompleteAsync((r, e) -> {
                    BaseInnerManageRespDTO respDTO = buildInnerManageResp(r, e);
                    LambdaLogger.info(log, "后管下载PDF 响应报文：{}", JSON.toJSONString(respDTO));
                    dr.setResult(respDTO);
                });
        return dr;
    }

}
