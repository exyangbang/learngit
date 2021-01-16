package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IMerchantBatchRecordHandler;
import cn.kingnet.utp.service.persistence.entity.MerchantBatchRecord;
import cn.kingnet.utp.service.persistence.entity.MerchantBatchRecordCondition;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.mapper.MerchantBatchRecordMapper;
import cn.kingnet.utp.trade.common.enums.BatchStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * @Description : 交易流水数据处理实现
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 15:57
 */
@RestController
@RequestMapping("/spi/persistence/merchantBatchRecord")
public class MerchantBatchRecordHandler extends DefaultFeginExceptionHandler implements IMerchantBatchRecordHandler {

    @Resource
    private MerchantBatchRecordMapper batchRecordMapper;

    /**
     * 保留流水
     *
     * @param merchantBatchRecord
     */
    @Override
    @PostMapping("/saveMerchantBatchRecord")
    public void saveMerchantBatchRecord(@RequestBody(required = false) MerchantBatchRecord merchantBatchRecord) {
        if (merchantBatchRecord != null) {
            batchRecordMapper.insert(merchantBatchRecord);
        }
    }

    /**
     * 根据 商户号+服务端流水号 更新流水
     *
     * @param merchantBatchRecord 更新对象
     * @param merNo               商户号
     * @param serverTransId       服务端流水号
     */
    @PostMapping("/updateByMernoAndServerTradeId")
    @Override
    public void updateByMernoAndServerTransId(@RequestBody(required = false) MerchantBatchRecord merchantBatchRecord,
                                              @RequestParam(value = "merNo", required = false) String merNo,
                                              @RequestParam(value = "serverTransId", required = false) String serverTransId) {
        if (StringUtil.isEmpty(merNo) || StringUtil.isEmpty(serverTransId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "请求参数有误");
        }
        if (merchantBatchRecord != null) {
            Wrapper wrapper = new EntityWrapper<TransCurrent>()
                    .where("mer_no = {0}", merNo)
                    .andNew(" server_trans_id = {0}", serverTransId);
            batchRecordMapper.update(merchantBatchRecord, wrapper);
        }

    }

    /**
     * 根据 商户号+客户端流水号 或者 商户号+服务端流水号查询 交易流水
     *
     * @param merNo
     * @param clientTransId
     * @param serverTransId
     * @return
     */
    @Override
    @PostMapping("/queryByMernoAndClientTransIdOrServerTransId")
    public MerchantBatchRecord queryByMernoAndClientTransIdOrServerTransId(@RequestParam(value = "merNo", required = false) String merNo,
                                                                           @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                           @RequestParam(value = "serverTransId", required = false) String serverTransId) {

        if (StringUtil.isEmpty(merNo)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "商户号不能为空");
        }
        if (StringUtil.isEmpty(clientTransId) && StringUtil.isEmpty(serverTransId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水与服务端流水不能同时为空");
        }
        List<MerchantBatchRecord> list = batchRecordMapper.selectList(new EntityWrapper<MerchantBatchRecord>()
                .where("mer_no = {0}", merNo)
                .andNew(StringUtils.isNotEmpty(clientTransId) &&
                                StringUtils.isNotEmpty(serverTransId),
                        "client_trans_id = {0} And server_trans_id = {1}", clientTransId, serverTransId)
                .andNew(StringUtils.isNotEmpty(clientTransId) &&
                                StringUtils.isEmpty(serverTransId),
                        "client_trans_id = {0}", clientTransId)
                .andNew(StringUtils.isNotEmpty(serverTransId) &&
                                StringUtils.isEmpty(clientTransId),
                        "server_trans_id = {0}", serverTransId)
                .orderBy("trans_date", false)
        );
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    /**
     * 根据 商户号+批次号 更新流水
     *
     * @param merchantBatchRecord 更新对象属性
     * @param merNo               商户条件
     * @param batchNo             批次号条件
     */
    @PostMapping("/updateByMerNoAndBatchNo")
    @Override
    public void updateByMerNoAndBatchNo(@RequestBody(required = false) MerchantBatchRecord merchantBatchRecord,
                                        @RequestParam(value = "merNo", required = false) String merNo,
                                        @RequestParam(value = "batchNo", required = false) String batchNo) {
        if (StringUtil.isEmpty(merNo) || StringUtil.isEmpty(batchNo)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "商户号或批次号不能为空");
        }
        if (merchantBatchRecord != null) {
            batchRecordMapper.update(merchantBatchRecord, new EntityWrapper<MerchantBatchRecord>()
                    .where("mer_no = {0}", merNo).and("server_batch_no = {0}", batchNo)
            );
        }
    }


    /**
     * 根据 商户号+批次号查询 交易流水
     *
     * @param merNo
     * @param batchId
     * @return
     */
    @Override
    @PostMapping("/queryByMernoAndBatchId")
    public MerchantBatchRecord queryByMernoAndBatchId(@RequestParam(value = "merNo", required = false) String merNo,
                                                      @RequestParam(value = "batchId", required = false) String batchId) {
        if (StringUtil.isEmpty(merNo) || StringUtil.isEmpty(batchId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "商户号或批次号不能为空");
        }
        List<MerchantBatchRecord> list = batchRecordMapper.selectList(new EntityWrapper<MerchantBatchRecord>()
                .where("mer_no = {0}", merNo)
                .and("server_batch_no = {0}", batchId)
        );

        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    /**
     * 查询交易时间大于min后未完成处理的流水记录
     *
     * @param min
     * @return
     */
    @GetMapping("/queryUncompletedAndGtMin")
    @Override
    public List<MerchantBatchRecord> queryUncompletedAndGtMin(@RequestParam("min") int min) {

        List<MerchantBatchRecord> list = batchRecordMapper.selectList(MerchantBatchRecordCondition.builder()
                .andBatchStatusNotIn(BatchStatus.UPLOAD_FAILURE.getCode(), BatchStatus.COMPLETED.getCode())
                .andGmtModifiedLt(Date.from(LocalDateTime.now().minusMinutes(min).toInstant(ZoneOffset.of("+8"))))
                .build()
        );

        return list;
    }

    @GetMapping("/isExistByMerNoAndBatchNo")
    @Override
    public boolean isExistByMerNoAndBatchNo(@RequestParam(value = "merNo", required = false) String merNo,
                                            @RequestParam(value = "batchNo", required = false) String batchNo) {
        if (StringUtil.isEmpty(merNo) || StringUtil.isEmpty(batchNo)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "商户号或批次号不能为空");
        }
        return batchRecordMapper.selectCount(MerchantBatchRecordCondition.builder()
                .andMerNoEq(merNo)
                .andServerBatchNoEq(batchNo).build()) > 0 ? true : false;
    }
}
