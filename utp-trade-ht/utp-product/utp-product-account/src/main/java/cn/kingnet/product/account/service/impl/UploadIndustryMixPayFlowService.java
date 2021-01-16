package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.product.account.service.inner.SftpService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IOutsideTransOrderHandler;
import cn.kingnet.utp.service.persistence.entity.vo.OutsideTransOrderVo;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.service.persistence.vo.MixTransInfoAndFilePathVO;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadIndustryMixPayFlowReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadIndustryMixPayFlowRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

/**
 * @Description 融合支付订单的 明细通过 sftp文件上送，同时融合支付订单的金额必须和文件内的订单明细金额累计相等
 * 融合支付订单作为一笔正常的虚拟支付订单，参与分账等关联的支付流水使用规则。
 * 注意：针对该融合支付订单流水的明细文件需要解析落库为反洗钱中心供数，融合支付订单流水作为明细文件落库时的批次号
 * @Author WJH
 * @Date 2020/12/24
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UPLOAD_INDUSTRY_MIXPAY_FLOW,
        reqClass = UploadIndustryMixPayFlowReqDTO.class,
        respClass = UploadIndustryMixPayFlowRespDTO.class
)
@Slf4j
public class UploadIndustryMixPayFlowService extends AbstractAccountTradeService<UploadIndustryMixPayFlowReqDTO, UploadIndustryMixPayFlowRespDTO> {

    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;
    @Resource
    private SftpService sftpService;
    @Value("${cn.kingnet.utp.pdf.file-dir}")
    private String pdfDir;

    @Resource
    private CommonRedisService commonRedisService;

    public UploadIndustryMixPayFlowService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadIndustryMixPayFlowReqDTO, UploadIndustryMixPayFlowRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        UploadIndustryMixPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();

        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        if (!DateUtil.getCurrentDate().equals(reqDTO.getReqDate())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前系统日期");
        }

        ValidateUtils.validate(reqDTO);

        boolean isExist = outsideTransOrderHandler.isExistIndustryANdBatchId(tradeContext.getIndustryCode(), reqDTO.getBatchNo());
        if (isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "批次号已存在");
        }

        boolean isExistOrderId = outsideTransOrderHandler.isExistIndustryANdTransOrderId4Success(tradeContext.getIndustryCode(), reqDTO.getMixTransId());
        if (isExistOrderId) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "支付订单号已存在");
        }

    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadIndustryMixPayFlowReqDTO, UploadIndustryMixPayFlowRespDTO> tradeContext) {
        UploadIndustryMixPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();

        UploadIndustryMixPayFlowRespDTO.UploadIndustryMixPayFlowRespDTOBuilder builder = UploadIndustryMixPayFlowRespDTO.builder();
        builder.batchNo(reqDTO.getBatchNo()).mixTransId(reqDTO.getMixTransId());

        OutsideTransOrderVo outsideTransOrderVo = OutsideTransOrderVo.builder()
                .id(IdGenerate.getId()).industryCode(tradeContext.getIndustryCode())
                .reqDate(reqDTO.getReqDate()).reqTime(reqDTO.getReqTime())
                .transDate(reqDTO.getTransDate()).transTime(reqDTO.getTransTime()).transAmount(Long.valueOf(reqDTO.getMixTransAmount()))
                .batchId(reqDTO.getBatchNo()).transOrderId(reqDTO.getMixTransId()).callbackUrl(reqDTO.getCallbackUrl())
                .payMode(PayMode.MIXPAYFLOW.getType()).remark(reqDTO.getSftpPath())
                .build();

        try {
            Path localPath = downloadDetailFile(tradeContext.getIndustryCode(), reqDTO);

            //简单校验融合订单和订单明细金额及文件格式
            validMixTransAndDetailFile(reqDTO, localPath);

            //业务确认，上送最终状态待文件解析后赋值
            outsideTransOrderVo.setUploadStatus(FileBatchStatus.PROCESSING.name());
            outsideTransOrderVo.setUploadDesc("txt文件已下载待解析");
            outsideTransOrderVo.setGmtCreate(Date.from(Instant.now()));
            outsideTransOrderVo.setGmtModified(outsideTransOrderVo.getGmtCreate());

            outsideTransOrderHandler.saveOutsideTransOrder(outsideTransOrderVo, false);

            //异步多线程解析txt文件及落库，明确结果回调通知
            MixTransInfoAndFilePathVO vo = MixTransInfoAndFilePathVO.of(outsideTransOrderVo, localPath, tradeContext.getClientTradeId(), tradeContext.getServerTransId());

            outsideTransOrderHandler.parseMixTransDetailTxtFileAsync(vo);

            UploadIndustryMixPayFlowRespDTO respDTO = builder.build();
            respDTO.setMessage("txt文件已下载待解析");
            return ChannelResponseUtil.build(respDTO, null, null, HttpRespStatus.OK, "受理成功待结果通知");
        } catch (Exception e) {
            log.error("融合支付订单上送异常：{}", e.getMessage(), e);
            outsideTransOrderVo.setUploadStatus(FileBatchStatus.FAILURE.name());
            outsideTransOrderVo.setUploadDesc("融合支付订单上送失败:" + StringUtil.truncate(e.getMessage(), 100));
            outsideTransOrderVo.setGmtCreate(Date.from(Instant.now()));
            outsideTransOrderVo.setGmtModified(outsideTransOrderVo.getGmtCreate());

            outsideTransOrderHandler.saveOutsideTransOrder(outsideTransOrderVo, true);

            UploadIndustryMixPayFlowRespDTO respDTO = builder.build();
            respDTO.setMessage(outsideTransOrderVo.getUploadDesc());
            return ChannelResponseUtil.exception(builder.build(), HttpRespStatus.BAD_REQUEST, "受理失败", e.getMessage());
        }

    }


    /**
     * headMark	String	1	文件头标志位	固定值：H	Y
     * txType	String	50	业务类型	标志文件类型 mixpay_flow	Y
     * sumAmount	long	   8	明细金额汇总	单位分	Y
     * rowCount	long	10	明细中记录数	订单明细记录行数	Y
     * 首行 headMark|txType|sumAmount|rowCount
     */
    private void validMixTransAndDetailFile(UploadIndustryMixPayFlowReqDTO reqDTO, Path localPath) {
        try {
            List<String> list = Files.readAllLines(localPath, StandardCharsets.UTF_8);
            if (list == null || list.isEmpty()) {
                throw new RuntimeException("txt文件为空");
            }
            List<String> headRow = Splitter.on("|").splitToList(list.get(0));
            if (headRow == null || headRow.size() < 4) {
                throw new RuntimeException("txt文件首行格式错误");
            }
            Assert.isTrue(UDPSettleSplitFeature.HEADMARK.equals(headRow.get(0)), "文件头标志位必须H");
            Assert.isTrue(UDPSettleSplitFeature.TxType.MIXPAY_FLOW.getType().equals(headRow.get(1)), "标志文件类型必须" + UDPSettleSplitFeature.TxType.MIXPAY_FLOW.getType());
            ValidateUtils.isPositiveInteger(headRow.get(2), 15, true, "明细金额汇总");
            ValidateUtils.isPositiveInteger(headRow.get(3), 15, true, "订单明细记录行数");

            long sumAmount = Long.valueOf(headRow.get(2));
            long rowCount = Long.valueOf(headRow.get(3));
            Assert.isTrue(rowCount == list.size() - 1, "首行明细记录数与实际文件记录数不一致");

            Assert.isTrue(Long.valueOf(reqDTO.getMixTransAmount()) == sumAmount, "首行明细汇总金额与融合交易总金额不一致");

        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "txt文件格式错误:" + e.getMessage(), e);
        }
    }

    @Override
    public void initTransFlow(TradeContext<UploadIndustryMixPayFlowReqDTO, UploadIndustryMixPayFlowRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadIndustryMixPayFlowReqDTO, UploadIndustryMixPayFlowRespDTO> tradeContext) {

    }

    private Path downloadDetailFile(String industryCode, UploadIndustryMixPayFlowReqDTO reqDTO) {
        String sftpPath = reqDTO.getSftpPath();
        try {
            if (StringUtil.isBlank(sftpPath)) {
                throw new RuntimeException("sftpPath为空");
            }
            Path origPath = Paths.get(sftpPath.trim());
            String remoteDir = origPath.getNameCount() == 1 ? null : origPath.getParent().toFile().toString();
            String remoteFileName = origPath.toFile().getName();

            SftpService.Sftp sftp = sftpService.connectSftp();
            Path localSavePath = buildDetailTextFilePath(industryCode, reqDTO.getReqDate(), reqDTO.getBatchNo(), reqDTO.getMixTransId());
            try {
                if (localSavePath != null && Files.exists(localSavePath) && Files.size(localSavePath) > 0) {
                    log.warn("已下载txt文件[{}],无需再下载处理", localSavePath.getFileName().toFile().getName());
                    return localSavePath;
                }

                sftp.download(remoteDir, remoteFileName, localSavePath);
                if (localSavePath != null && Files.exists(localSavePath) && Files.size(localSavePath) > 0) {
                    log.info("成功下载mixTransId明细文件[{}]", localSavePath.getFileName().toFile().getName());
                    return localSavePath;
                } else {
                    throw new RuntimeException("txt文件不存在或格式有误");
                }

            } catch (Exception e) {
                log.error("mixTransId[{}] sftp下载txt明细失败：{}", reqDTO.getMixTransId(), e.getMessage(), e);
                throw new RuntimeException("sftp下载txt明细失败:" + e.getMessage());
            } finally {
                sftp.closeSFTP();
            }
        } catch (Exception e) {
            log.error("mixTransId[{}] 下载融合订单明细文件 异常：{}", reqDTO.getMixTransId(), e.getMessage(), e);
            throw new TradeException(HttpRespStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    private Path buildDetailTextFilePath(String industry, String reqDate, String batchId, String mixTransId) throws IOException {
        Path parentPath = Paths.get(pdfDir, "transDetail", industry, reqDate);
        if (Files.notExists(parentPath)) {
            Files.createDirectories(parentPath);
        }
        String parentDir = parentPath.toFile().getCanonicalPath();
        String fileName = batchId.concat("_").concat(mixTransId).concat(".").concat(FileType.TXT.getType());
        return Paths.get(parentDir, fileName);
    }
}
