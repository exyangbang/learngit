package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.ISubAccountSettleSplitHandler;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitDetail;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitDetailCondition;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitLog;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitLogCondition;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountSettleSplitInfoBo;
import cn.kingnet.utp.service.persistence.service.SubAccountSettleSplitService;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author sheqingquan@scenetec.com
 * @description: 子账户清算分账处理
 * @create 2020/2/11 18:28
 */
@RestController
@RequestMapping("/spi/persistence/subAccountSettleSplit")
@Slf4j
public class SubAccountSettleSplitHandler extends DefaultFeginExceptionHandler implements ISubAccountSettleSplitHandler {

    @Resource
    private SubAccountSettleSplitService subAccountSettleSplitService;

    @GetMapping("/isExistSubAccountSettleSplitInfo")
    @Override
    public boolean isExistSubAccountSettleSplitInfo(String settleDate, String userAccount, String batchNo, String industryCode) {
        Assert.hasText(settleDate, "参数[settleDate]不能为空");
        Assert.hasText(userAccount, "参数[userAccount]不能为空");
        Assert.hasText(batchNo, "参数[batchNo]不能为空");
        Assert.hasText(industryCode, "参数[industryCode]不能为空");
        return MybatisDaoImpl.run().selectCount(UploadSubAccountSettleSplitDetailCondition.builder()
                .andUserAccountEq(userAccount).andSettleDateEq(settleDate).andBatchNoEq(batchNo).andIndustryCodeEq(industryCode)
                .build()) > 0;
    }

    @GetMapping("/querySubAccountSettleSplitDetail")
    @Override
    public List<UploadSubAccountSettleSplitDetail> querySubAccountSettleSplitDetail(String settleDate, String userAccount,
                                                                                    String batchNo, String industryCode) {
        Assert.hasText(settleDate, "参数[settleDate]不能为空");
        Assert.hasText(userAccount, "参数[userAccount]不能为空");
        Assert.hasText(batchNo, "参数[batchNo]不能为空");
        Assert.hasText(industryCode, "参数[industryCode]不能为空");
        return MybatisDaoImpl.run().selectList(UploadSubAccountSettleSplitDetailCondition.builder()
                .andSettleDateEq(settleDate).andUserAccountEq(userAccount).andBatchNoEq(batchNo).andIndustryCodeEq(industryCode)
                .build());
    }

    /**
     * 持久化log detail 以及 线程处理子账户分账业务
     *
     * @param subAccountSettleSplitInfoBo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/saveSubAccountSettleSplit")
    public void saveSubAccountSettleSplit(@RequestBody(required = false) SubAccountSettleSplitInfoBo subAccountSettleSplitInfoBo) {
        Assert.notNull(subAccountSettleSplitInfoBo, "参数[subAccountSettleSplitInfoBo]不能为空");
        Date curDate = new Date();
        UploadSubAccountSettleSplitLog settleSplitLog = UploadSubAccountSettleSplitLog.builder()
                .id(IdGenerate.getId()).industryCode(subAccountSettleSplitInfoBo.getIndustryCode())
                .userAccount(subAccountSettleSplitInfoBo.getUserAccount())
                .batchNo(subAccountSettleSplitInfoBo.getBatchNo())
                .settleDate(subAccountSettleSplitInfoBo.getSettleDate())
                .callbackUrl(subAccountSettleSplitInfoBo.getCallbackUrl())
                .period(subAccountSettleSplitInfoBo.getPeriod())
                .reqDate(subAccountSettleSplitInfoBo.getReqDate())
                .reqTime(subAccountSettleSplitInfoBo.getReqTime())
                .transStatus(TransStatus.PRE_CREATE.name())
                .gmtCreate(curDate).gmtModified(curDate)
                .build();
        MybatisDaoImpl.run().insert(settleSplitLog);
        MybatisDaoImpl.run().insertBatch(subAccountSettleSplitInfoBo.getSubAccountSettleSplitDetailList(), 100);

        //账期为0，则实时处理
        if ("0".equals(subAccountSettleSplitInfoBo.getPeriod())) {
            //异步执行 保存明细及实时处理
            CompletableFuture.runAsync(() -> {
                subAccountSettleSplitService.processSubAccountSettleSplit(settleSplitLog, subAccountSettleSplitInfoBo.getSubAccountSettleSplitDetailList());
            });
        }

    }

    /**
     * 处理 子账户Tn分账
     *
     * @param subAccountSettleSplitDetail
     */
    @Override
    @PostMapping("/processSubAccountSettleSplitDetail4Tn")
    public void processSubAccountSettleSplitDetail4Tn(@RequestBody(required = false) UploadSubAccountSettleSplitDetail subAccountSettleSplitDetail) {
        Assert.notNull(subAccountSettleSplitDetail, "subAccountSettleSplitDetail 参数不能为空");
        UploadSubAccountSettleSplitLog settleSplitLog = UploadSubAccountSettleSplitLog.builder()
                .industryCode(subAccountSettleSplitDetail.getIndustryCode()).batchNo(subAccountSettleSplitDetail.getBatchNo())
                .userAccount(subAccountSettleSplitDetail.getUserAccount()).transStatus(subAccountSettleSplitDetail.getTransStatus()).build();
        subAccountSettleSplitService.processSubAccountSettleSplit(settleSplitLog, Lists.newArrayList(subAccountSettleSplitDetail));
    }


    @Override
    public void updateSubAccountSettleSplitLogStatus(@RequestBody(required = false) UploadSubAccountSettleSplitLog uploadSubAccountSettleSplitLog) {
        Assert.notNull(uploadSubAccountSettleSplitLog, "参数[subAccountSettleSplitInfoBo]不能为空");
        MybatisDaoImpl.run().updateById(uploadSubAccountSettleSplitLog);
    }

    @Override
    public boolean isExistSubAccountSettleSplitLog(String industryCode, String userAccount, String batchNo) {
        Assert.hasText(userAccount, "参数[userAccount]不能为空");
        Assert.hasText(batchNo, "参数[batchNo]不能为空");
        int count = MybatisDaoImpl.run().selectCount(UploadSubAccountSettleSplitLogCondition.builder()
                .andUserAccountEq(userAccount).andBatchNoEq(batchNo).build());
        return count > 0;
    }
}
