package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.SubAccountMulTiSettleDetail;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountMultiSettleDetailBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WJH
 * @description: 子账户多级清算处理
 * @create 2020/03/27
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/subAccountMultiSettleDetail")
public interface ISubAccountMultiSettleDetailHandler {

    /**
     * 子账户多级清算信息：是否存在
     *
     * @param industryCode 代付客户号
     * @param settleDate   清算日期
     * @param batchNo      批次号
     * @return
     */
    @GetMapping("/existsSubAccountMultiSettleDetail")
    boolean existsSubAccountMultiSettleDetail(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchNo", required = false) String batchNo
    );

    @GetMapping("/existsTransStatusSubAccountMultiSettleDetail")
    boolean existsTransStatusSubAccountMultiSettleDetail(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchNo", required = false) String batchNo,
            @RequestParam(value = "transStatus", required = false) String transStatus
    );


    /**
     * 查询子账户清算分账信息明细
     *
     * @param settleDate   清算日期
     * @param batchNo      批次号
     * @param industryCode 代付客户号
     * @return
     */
    @GetMapping("/querySubAccountMultiSettleDetail")
    List<SubAccountMulTiSettleDetail> querySubAccountMultiSettleDetail(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchNo", required = false) String batchNo
    );

    /**
     * 持久化 子账户分账文件文件
     *
     * @param subAccountMultiSettleDetailBo
     */
    @PostMapping("/saveSubAccountMultiSettleDetail")
    void saveSubAccountMultiSettleDetail(@RequestBody(required = false) SubAccountMultiSettleDetailBo subAccountMultiSettleDetailBo);


}
