package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitDetail;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitLog;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountSettleSplitInfoBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 子账户清算分账处理
 * @author sheqingquan@scenetec.com
 * @create 2020/2/11 18:29
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/subAccountSettleSplit")
public interface ISubAccountSettleSplitHandler {

    /**
     * 子账户清算分账信息：是否存在
     * @param settleDate 清算日期
     * @param userAccount 用户账户
     * @param batchNo 批次号
     * @param industryCode 代付客户号
     * @return
     */
    @GetMapping("/isExistSubAccountSettleSplitInfo")
    boolean isExistSubAccountSettleSplitInfo(
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "userAccount", required = false) String userAccount,
            @RequestParam(value = "batchNo", required = false) String batchNo,
            @RequestParam(value = "industryCode", required = false) String industryCode
    );

    /**
     * 查询子账户清算分账信息明细
     * @param settleDate 清算日期
     * @param userAccount 用户账户
     * @param batchNo 批次号
     * @param industryCode 代付客户号
     * @return
     */
    @GetMapping("/querySubAccountSettleSplitDetail")
    List<UploadSubAccountSettleSplitDetail> querySubAccountSettleSplitDetail(
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "userAccount", required = false) String userAccount,
            @RequestParam(value = "batchNo", required = false) String batchNo,
            @RequestParam(value = "industryCode", required = false) String industryCode
    );

    /**
     * 持久化 子账户分账文件文件
     *
     * @param subAccountSettleSplitInfoBo
     */
    @PostMapping("/saveSubAccountSettleSplit")
    void saveSubAccountSettleSplit(@RequestBody(required = false) SubAccountSettleSplitInfoBo subAccountSettleSplitInfoBo);

    /**
     * 持久化 子账户分账文件文件
     *
     * @param subAccountSettleSplitDetail
     */
    @PostMapping("/processSubAccountSettleSplitDetail4Tn")
    void processSubAccountSettleSplitDetail4Tn(@RequestBody(required = false) UploadSubAccountSettleSplitDetail subAccountSettleSplitDetail);


    /**
     * 更新 子账户分账文件上送纪录状态
     *
     * @param uploadSubAccountSettleSplitLog
     */
    @PutMapping("/updateSubAccountSettleSplitLogStatus")
    void updateSubAccountSettleSplitLogStatus(@RequestBody(required = false) UploadSubAccountSettleSplitLog uploadSubAccountSettleSplitLog);


    /**
     * 子账户分账文件信息：是否存在
     *
     * @param industryCode
     * @param userAccount
     * @param batchNo
     * @return
     */
    @GetMapping("/isExistSubAccountSettleSplitLog")
    boolean isExistSubAccountSettleSplitLog(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "userAccount", required = false) String userAccount,
            @RequestParam(value = "batchNo", required = false) String batchNo
    );

}
