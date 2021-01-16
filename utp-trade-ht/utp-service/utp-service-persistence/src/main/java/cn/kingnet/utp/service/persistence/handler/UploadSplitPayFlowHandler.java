package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IUploadSplitPayFlowHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.vo.UploadSplitPayFlowVo;
import cn.kingnet.utp.service.persistence.service.OutsideTransOrderService;
import cn.kingnet.utp.trade.common.enums.SplitStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2019/05/29
 */
@RestController
@RequestMapping("/spi/persistence/uploadSplitPayFlow")
@Slf4j
public class UploadSplitPayFlowHandler extends DefaultFeginExceptionHandler implements IUploadSplitPayFlowHandler {

    @Resource
    private OutsideTransOrderService outsideTransOrderService;

    @Override
    public boolean isExistIndustryAndBatchId(String industryCode, String batchId) {
        return MybatisDaoImpl.run().selectCount(UploadSplitPayFlowCondition.builder().andIndustryCodeEq(industryCode)
                .andBatchIdEq(batchId).build()) > 0;
    }

    @Override
    public boolean isExistIndustryAndClientTransId4Success(String industryCode, String clientTransId) {
        return MybatisDaoImpl.run().selectCount(UploadSplitPayFlowCondition.builder().andIndustryCodeEq(industryCode)
                .andClientTransIdEq(clientTransId).andUploadStatusEq("SUCCESS").build()) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUploadSplitPayFlowList(@RequestBody List<UploadSplitPayFlowVo> list) {
        if (!CollectionUtils.isEmpty(list)) {
            List<UploadSplitPayFlow> uploadSplitPayFlowList = list.stream().map(UploadSplitPayFlow::of).collect(Collectors.toList());
            MybatisDaoImpl.run().insertBatch(uploadSplitPayFlowList, 100);

            //同时保存成功补登的分账流水
            List<SplitInfo> splitInfoList = uploadSplitPayFlowList.stream().filter(o -> o.getUploadStatus().equals("SUCCESS")).map(this::covert2SplitInfo).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(splitInfoList)) {
                MybatisDaoImpl.run().insertBatch(splitInfoList, 100);
            }
            //仅更新补登流水上送成功的
            uploadSplitPayFlowList.stream().filter(o -> "SUCCESS".equals(o.getUploadStatus())).forEach(o -> {
                outsideTransOrderService.updateSplitStatusAndLinkedSplitNum(o.getIndustryCode(),o.getExtend1());

//                Map<String, String> params = new HashMap<>(4);
//                params.put("transOrderIds", o.getExtend1());
//                MybatisDaoImpl.of(OutsideTransOrderMapper.class).updateBySql("updateByTransOrderIdsAndSuccess", params);
            });

        }

    }

    private SplitInfo covert2SplitInfo(UploadSplitPayFlow uploadSplitPayFlow) {
        SplitInfo splitInfo = new SplitInfo();
        BeanUtils.copyProperties(uploadSplitPayFlow, splitInfo);
        splitInfo.setStatus(SplitStatus.SPLIT_OK.getStatus());
        splitInfo.setTransDesc("分账流水补登:" + splitInfo.getTransDesc());
        return splitInfo;
    }

    @Override
    @GetMapping("getTransCurrentOrHistoryByClientTransId")
    public TransHistory getTransCurrentOrHistoryByClientTransId(String industryCode, String clientTransId) {

        TransHistory transHistory = MybatisDaoImpl.run().selectOne(TransHistoryCondition.builder().andIndustryCodeEq(industryCode).andClientTransIdEq(clientTransId).build());
        if (transHistory == null) {
            TransCurrent transCurrent = MybatisDaoImpl.run().selectOne(TransCurrentCondition.builder().andIndustryCodeEq(industryCode).andClientTransIdEq(clientTransId).build());
            if (transCurrent != null) {
                transHistory = new TransHistory();
                BeanUtils.copyProperties(transCurrent, transHistory);
            }
        }
        return transHistory;

    }

    @Override
    public List<UploadSplitPayFlow> queryUploadSplitPayFlowList(String industryCode, String batchNo) {
        return MybatisDaoImpl.run().selectList(UploadSplitPayFlowCondition.builder().andIndustryCodeEq(industryCode).andBatchIdEq(batchNo).build());
    }


}
