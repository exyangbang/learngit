package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.configuration.PersistenceProperties;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrderCondition;
import cn.kingnet.utp.service.persistence.entity.vo.OutsideTransOrderVo;
import cn.kingnet.utp.service.persistence.handler.CodeDictionaryHandler;
import cn.kingnet.utp.service.persistence.mapper.OutsideTransOrderCustomMapper;
import cn.kingnet.utp.service.persistence.mapper.OutsideTransOrderMapper;
import cn.kingnet.utp.trade.common.dto.account.UploadIndustryMixPayFlowCallbackDTO;
import cn.kingnet.utp.trade.common.enums.FileBatchStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.PayMode;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.security.RsaUtils;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/16
 */
@Service
@Slf4j
public class OutsideTransOrderService {

    @Resource
    private CommonRedisService commonRedisService;
    @Resource
    private CodeDictionaryHandler codeDictionaryHandler;
    @Resource
    private RsaUtils rsaUtils;
    @Resource
    private PersistenceProperties persistenceProperties;
    @Resource
    private MsgNoticeService msgNoticeService;
    @Resource
    private OutsideTransOrderCustomMapper outsideTransOrderCustomMapper;


    public Integer queryLinkedSplitNumByTransOrderId(String industryCode, String transOrderId) {
        Integer resNum = 0;
        OutsideTransOrder outsideTransOrder = selectByTransOrderIdAndSuccess(industryCode, transOrderId);
        if (outsideTransOrder != null && outsideTransOrder.getLinkedSplitNum() != null) {
            resNum = outsideTransOrder.getLinkedSplitNum();
        }
        return resNum;
    }

    public OutsideTransOrder selectByTransOrderIdAndSuccess(String industryCode, String transOrderId) {
        ValidateUtils.hasText(industryCode, "客户号");
        ValidateUtils.hasText(transOrderId, "支付订单号");
        return this.getOutsideTransOrder(industryCode, transOrderId);
    }


    public boolean isExistIndustryANdBatchId(String industryCode, String batchId) {
        return MybatisDaoImpl.run().selectCount(OutsideTransOrderCondition.builder().andIndustryCodeEq(industryCode)
                .andBatchIdEq(batchId).build()) > 0;
    }

    public boolean isExistIndustryANdTransOrderId4Success(String industryCode, String transOrderId) {
        boolean tf = commonRedisService.isExistOutSideTransOrderIdByRedis(industryCode, transOrderId);
        return tf ? true : MybatisDaoImpl.run().selectCount(OutsideTransOrderCondition.builder().andIndustryCodeEq(industryCode)
                .andTransOrderIdEq(transOrderId).andUploadStatusEq("SUCCESS").build()) > 0;
    }

    /**
     * 缓存取-db取同时设置缓存
     */
    private OutsideTransOrder getOutsideTransOrder(String industryCode, String transOrderId) {
        OutsideTransOrder outsideTransOrder;
        Object obj = commonRedisService.getRedisTemplate().boundHashOps(commonRedisService.genOutSideTransOrderHashKey(industryCode, transOrderId, false)).get(transOrderId);

        if (obj instanceof OutsideTransOrder) {
            outsideTransOrder = (OutsideTransOrder) obj;
        } else {
            //兼容原存储值非OutsideTransOrder对象处理
            PlusEntityWrapper<OutsideTransOrder> plusEntityWrapper = OutsideTransOrderCondition.builder().andIndustryCodeEq(industryCode).andTransOrderIdEq(transOrderId).andUploadStatusEq("SUCCESS").build();
            outsideTransOrder = MybatisDaoImpl.run().selectOne(plusEntityWrapper);

            if (outsideTransOrder != null) {
                commonRedisService.addOutSideTransOrderByRedis(industryCode, transOrderId, outsideTransOrder);
            }
        }
        return outsideTransOrder;
    }

    public List<OutsideTransOrder> selectByTransOrderIdsAndSuccess(String industryCode, String transOrderIds) {
        List<OutsideTransOrder> reList = null;
        //pipeline
        if (StringUtil.isNoneBlank(industryCode, transOrderIds)) {
            List<String> transOrderIdList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(transOrderIds);

            RedisTemplate redis = commonRedisService.getRedisTemplate();
            List<OutsideTransOrder> batchList = redis.executePipelined((RedisCallback<OutsideTransOrder>) conn -> {
                conn.openPipeline();
                transOrderIdList.stream().forEach(l -> {
                    //原先非obj的存量缓存需要事先转换成 obj存储
                    conn.hashCommands().hGet(commonRedisService.genOutSideTransOrderHashKey(industryCode, l, false).getBytes(), l.getBytes());
                });
                return null;
            }, redis.getHashValueSerializer());

            //pipeline 查无数据返回null list
            if (batchList != null) {
                //若pipeline批量查询结果存在null值则 再次查询db验证设置
                OutsideTransOrder curTransOrder;
                String curTransOrderId;
                for (int index = 0; index < transOrderIdList.size(); index++) {
                    curTransOrder = batchList.get(index);
                    if (curTransOrder == null) {
                        //再次查询db验证
                        curTransOrderId = transOrderIdList.get(index);
                        curTransOrder = getOutsideTransOrder(industryCode, curTransOrderId);
                        batchList.set(index, curTransOrder);
                    }
                }

                //过滤掉空值
                reList = batchList.stream().filter(Objects::nonNull).collect(Collectors.toList());
            }

        }
        return CollectionUtils.isEmpty(reList) ? null : reList;
    }

    /**
     * 缓存查无记录则 查询db
     */
    private List<OutsideTransOrder> selectByTransOrderIdsAndSuccessByFindInSetOfDB(String industryCode, String transOrderIds) {
        List<OutsideTransOrder> reList;

        HashMap<String, String> paramMap = new HashMap<>(8);
        paramMap.put("industryCode", industryCode);
        paramMap.put("transOrderIds", transOrderIds);

        reList = MybatisDaoImpl.of(OutsideTransOrderMapper.class).selectListBySql("selectByTransOrderIdsAndSuccess", paramMap);

        return reList;
    }

    /**
     * 更新 外部订单记录分账状态及关联分账记录数
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateSplitStatusAndLinkedSplitNum(String industryCode, String transOrderIds) {
        List<OutsideTransOrder> list = selectByTransOrderIdsAndSuccess(industryCode, transOrderIds);

        if (!CollectionUtils.isEmpty(list)) {
            List<OutsideTransOrder> updateList = new ArrayList<>(list.size());
            Date date = Date.from(Instant.now());
            list.forEach(o -> {
                OutsideTransOrder update = new OutsideTransOrder();
                update.setId(o.getId());
                update.setSplitStatus(TrueOrFalseStatus.TRUE.value());
                update.setLinkedSplitNum(o.getLinkedSplitNum() == null ? 1 : o.getLinkedSplitNum() + 1);
                update.setGmtModified(date);
                updateList.add(update);

                o.setSplitStatus(update.getSplitStatus());
                o.setLinkedSplitNum(update.getLinkedSplitNum());
                o.setGmtModified(update.getGmtModified());
                //设置缓存
                commonRedisService.addOutSideTransOrderByRedis(industryCode, o.getTransOrderId(), o);
            });

            //同步更新 db数值
            MybatisDaoImpl.run().updateBatchById(updateList, 100);

        }
    }

    public void parseMixTransDetailTxtFileAsync(OutsideTransOrderVo vo, Path localPath, String clientTransId, String serverTransId) {
        String uploadStatus = "FAILURE";
        String uploadDesc = "上送失败";
        FileBatchStatus batchStatus = FileBatchStatus.FAILURE;
        try {

            //1.解析文件转换明细对象
            if (vo == null || localPath == null) {
                throw new RuntimeException("融合支付记录或txt文件 为空");
            }
            if (!Files.exists(localPath)) {
                throw new RuntimeException("txt文件不存在");
            }

            //FIXME 耗时较长待优化
            List<OutsideTransOrder> details = parseMixFile(vo, localPath);


            //2.落库及设置缓存及有效期
            saveMixTransDetail(vo, details);

            uploadStatus = "SUCCESS";
            uploadDesc = "上送处理成功";
            batchStatus = FileBatchStatus.SUCCESS;
        } catch (Exception e) {
            uploadStatus = "FAILURE";
            uploadDesc = "上送处理失败:" + StringUtil.truncate(e.getMessage(), 100);
            batchStatus = FileBatchStatus.FAILURE;
            //异常失败 回滚明细记录
            MybatisDaoImpl.run().delete(OutsideTransOrder.builder().batchId(vo.getTransOrderId()).build());
            log.error("融合支付文件明细处理异常：{}", e.getMessage(), e);
        } finally {
            //3.更新融合支付订单同时回调通知下游
            OutsideTransOrder updateObj = OutsideTransOrder.builder().id(vo.getId())
                    .uploadStatus(uploadStatus).uploadDesc(uploadDesc).gmtModified(Date.from(Instant.now())).build();
            MybatisDaoImpl.run().updateById(updateObj);

            UploadIndustryMixPayFlowCallbackDTO callbackDTO = UploadIndustryMixPayFlowCallbackDTO.builder()
                    .batchNo(vo.getBatchId()).mixTransId(vo.getTransOrderId()).batchStatus(batchStatus.getStatus())
                    .success("SUCCESS".equalsIgnoreCase(uploadStatus) ? Boolean.TRUE.toString() : Boolean.FALSE.toString()).build();
            callbackDTO.setClientTradeId(clientTransId);
            callbackDTO.setServerTradeId(serverTransId);

            msgNoticeService.saveNoticeCallbackMessage(vo.getCallbackUrl(), vo.getIndustryCode(), vo.getTransOrderId(), BeanMap.create(callbackDTO));

        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void saveMixTransDetail(OutsideTransOrderVo vo, List<OutsideTransOrder> details) {

        if (details == null || details.isEmpty()) {
            throw new RuntimeException("明细文件内容不能为空");
        }

        int batchSize = 1000;
        int pages = details.size() / batchSize + ((details.size() % batchSize) == 0 ? 0 : 1);
        for (int curPage = 0; curPage < pages; curPage++) {
            //stream流表达式，skip表示跳过前i*10000条记录，limit表示读取当前流的前10000条记录
            outsideTransOrderCustomMapper.insertBatch(details.stream().skip(curPage * batchSize).limit(batchSize).collect(Collectors.toList()));
        }
        log.info("融合支付流水[{}]明细文件流水记录[{}]落库成功.", vo.getTransOrderId(), details.size());
/*
        //todo 批量设置缓存及过期时间  FIXME 暂不设置缓存和过期时间，融合支付明细仅需落库后续 供数
        long durationHours = persistenceProperties.getMixTransMap().getOrDefault(vo.getIndustryCode(), 92L);
        String mixTransHashKey = RedisKey.COMMON.fmtKey("mixTrans", vo.getIndustryCode(), vo.getBatchId());
        BoundHashOperations boundHashOps = commonRedisService.getRedisTemplate().boundHashOps(mixTransHashKey);
        details.stream().forEach(o->{
            //FIXME 待优化批处理
            boundHashOps.put(o.getTransOrderId(),o);
        });
        */
    }

    private List<OutsideTransOrder> parseMixFile(OutsideTransOrderVo vo, Path localPath) {
        List<OutsideTransOrder> reList = null;
        try {
            List<String> list = Files.readAllLines(localPath, StandardCharsets.UTF_8);
            //按10w预算，平均2k循环使用一个线程
            ExecutorService executorService = Executors.newFixedThreadPool(list.size() / 2000 + 1);

            AtomicBoolean isBlack = new AtomicBoolean(false);
            ConcurrentLinkedQueue orderQueues = new ConcurrentLinkedQueue();

            CompletableFuture<OutsideTransOrder>[] cfs =
                    list.stream().skip(1).map(line -> CompletableFuture.supplyAsync(() -> {
                        if (isBlack.get()) {
                            return null;
                        }
                        try {
                            return buildVo(line, vo, orderQueues);
                        } catch (Exception e) {
                            isBlack.set(true);
                            throw new RuntimeException(e.getMessage(), e);
                        }
                    }, executorService)).toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(cfs).join();
            if (executorService != null && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            reList = Arrays.stream(cfs).map(CompletableFuture::join).collect(Collectors.toList());
        } catch (Exception e) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "转换异常:" + e.getMessage(), e);
        }

        return reList;
    }

    /**
     * @param line 行定义数据 ,用|分割
     *             交易日期	8	M	格式为yyyyMMdd 0
     *             交易时间	6	M	HHmmss 1
     *             支付订单号	32	M	唯一性校验 2
     *             交易商户号	15	M	交易商户号 3
     *             交易金额	15	M	单位:分   无小数点 4
     *             支付方式	20	M	0支付宝 1微信 2银联  3无正向支付流水  9其他支付方式 5
     *             卖方名称	100	M 6
     *             买方名称	100	O 7
     *             商品信息(描述)	512	M	支付方式为3时，该字段传对应的分账协议编号 8
     *             备注说明	1024	O	支付方式为3时，该字段传对应的分账协议内容 9
     *             ================ 2.1.2版本新增 ================
     *             商户手机号码	20	O	 10
     *             支付机构编码	10	M	详见支付机构编码表  11
     *             交易渠道支付订单号	50	M	指收单机构生成订单号  12
     *             付款方/买方Id	50	M 13
     *             付款方手机号码	20	O 14
     *             优惠金额	15	O	单位:分   无小数点 15
     *             物流信息	200	O 16
     * @return
     */
    private OutsideTransOrder buildVo(String line, OutsideTransOrderVo vo, Collection<String> orderIds) {
        Assert.hasText(line, () -> "数据行记录不能为空");
        List<String> lineList = Splitter.on("|").trimResults().splitToList(line);
        Assert.isTrue(lineList.size() >= 17, () -> "支付流水文件数据行格式有误[列数不足17列]");
        String[] data = lineList.toArray(new String[17]);
        String preName, uploadStatus, uploadDesc;
        String remark = null;
        String transOrderId = "";
        try {
            transOrderId = data[2];

            ValidateUtils.isYyyyMMdd(data[0], true, "交易日期");

            ValidateUtils.isHHmmss(data[1], true, "交易时间");

            ValidateUtils.abcValid(data[2], true, "支付订单号");
            ValidateUtils.maxLength(data[2], 64, true, "支付订单号");
            Assert.isTrue(!orderIds.contains(data[2]), () -> String.format("支付流水号[%s]已存在", data[2]));
            orderIds.add(data[2]);

            //2.1.2 交易商户号 修改为必须条件
            ValidateUtils.maxLength(data[3], 32, true, "交易商户号");
            ValidateUtils.isPositiveInteger(data[4], 15, true, "金额");

            ValidateUtils.maxLength(data[5], 2, true, "支付方式");
            PayMode payMode = PayMode.getPayMode(data[5]);
            Assert.notNull(payMode, () -> String.format("支付方式[%s]有误", data[5]));

            ValidateUtils.maxLength(data[6], 100, true, "交易商户/卖方名称");
            //2.1.2 付款方/买方名称 修改为必须条件
            String buyerName = rsaUtils.decrypt(data[7]);
            ValidateUtils.maxLength(buyerName, 100, true, "付款方/买方名称");

            ValidateUtils.maxLength(data[8], 512, true, "商品信息描述");
            // ====== 以下为新增 =======
            ValidateUtils.isNum(data[10], false, "商户手机号码");
            ValidateUtils.maxLength(data[10], 20, false, "商户手机号码");

            ValidateUtils.maxLength(data[11], 14, true, "支付机构编码");
            ValidateUtils.maxLength(data[12], 50, true, "交易渠道支付订单号");

            String buyerId = rsaUtils.decrypt(data[13]);
            ValidateUtils.maxLength(buyerId, 50, true, "付款方/买方Id");
            ValidateUtils.maxLength(data[14], 20, false, "付款方手机号码");
            ValidateUtils.isIntegerNegative(data[15], 15, false, "优惠金额");
            ValidateUtils.maxLength(data[16], 200, false, "物流信息");


            boolean isExistOrderId = this.isExistIndustryANdTransOrderId4Success(vo.getIndustryCode(), data[2]);
            if (isExistOrderId) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("支付订单号已存在", data[2]));
            }

            boolean isExistCodeDictionary = codeDictionaryHandler.isExistCodeDictionary("0001", StringUtil.truncate(data[11], 20));
            if (!isExistCodeDictionary) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "支付机构编号不存在");
            }
            uploadStatus = "SUCCESS";
            uploadDesc = "上送成功";
            remark = data[9];

            Date curDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
            return OutsideTransOrder.builder().id(IdGenerate.getId())
                    .industryCode(vo.getIndustryCode()).batchId(vo.getTransOrderId())
                    .reqDate(vo.getReqDate()).reqTime(vo.getReqTime())
                    .transDate(data[0]).transTime(data[1])
                    .transOrderId(data[2]).merNo(data[3])
                    .transAmount(Long.valueOf(data[4])).payMode(data[5])
                    .sellerName(data[6]).buyerName(buyerName)
                    .goodsInfo(data[8])
                    .remark(remark)
                    .gmtCreate(curDate).gmtModified(curDate)
                    .uploadStatus(uploadStatus).uploadDesc(uploadDesc)
                    .merPhone(data[10])
                    .txnChannel(data[11])
                    .txnChannelTradeNo(data[12])
                    .buyerId(buyerId)
                    .buyerPhone(data[14])
                    .discountAmount(StringUtil.isBlank(data[15]) ? 0L : Long.valueOf(data[15]))
                    .logistics(data[16])
                    .merName(data[6])
                    .build();
        } catch (Exception e) {
            log.error("支付流水号[{}]数据行信息有误.[{}]", transOrderId, line, e);
            //调整整批次处理
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("数据行[%s]信息有误:[%s]", transOrderId, e.getMessage()));
        }

    }

}
