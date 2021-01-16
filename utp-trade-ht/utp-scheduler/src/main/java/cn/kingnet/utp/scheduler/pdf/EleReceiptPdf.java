package cn.kingnet.utp.scheduler.pdf;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.ChannelIncomeFlow;
import cn.kingnet.utp.scheduler.data.entity.ElectronicReceipts;
import cn.kingnet.utp.scheduler.data.entity.TransHistory;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.utils.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhongli
 * @date 2019-03-19
 */
public class EleReceiptPdf {
    private final RedisAtomicLong redisAtomicLong;

    @Value("${cn.kingnet.utp.schedule.pdf-font}")
    private String pdfFontPath;
    @Value("${cn.kingnet.utp.schedule.logo}")
    private String logoPath;
    @Value("${cn.kingnet.utp.schedule.official-seal}")
    private String officialSealImgPtah;
    @Value("${cn.kingnet.utp.pdf.file-dir}")
    private String fileDir;

    private BaseFont bfChinese;
    private Font fontZH;
    private Font redFontZH;
    private Image logoImg;
    private Image officialSealImg;


    public EleReceiptPdf(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Long.class));
        redisTemplate.setExposeConnection(true);
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.afterPropertiesSet();
        this.redisAtomicLong = new RedisAtomicLong(RedisKey.ELE_RECEIPT_NO_SEGMENT_KEY.name(), redisTemplate);
    }

    @PostConstruct
    public void init() throws IOException, DocumentException {
        String path = System.getProperty("user.dir");
        if (pdfFontPath.startsWith("file:")) {
            pdfFontPath = new StringBuilder(path).append(pdfFontPath.replaceFirst("file:", "")).toString();
        }
        if (logoPath.startsWith("file:")) {
            logoPath = new StringBuilder(path).append(logoPath.replaceFirst("file:", "")).toString();
        }
        if (officialSealImgPtah.startsWith("file:")) {
            officialSealImgPtah = new StringBuilder(path).append(officialSealImgPtah.replaceFirst("file:", "")).toString();
        }
        this.bfChinese = BaseFont.createFont(pdfFontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        this.fontZH = new Font(bfChinese, 9, Font.NORMAL);
        this.redFontZH = new Font(bfChinese, 9, Font.NORMAL);
        this.redFontZH.setColor(BaseColor.RED);
        this.logoImg = Image.getInstance(logoPath);
        this.logoImg.setAlignment(Image.ALIGN_CENTER | Image.MIDDLE);
        this.officialSealImg = Image.getInstance(officialSealImgPtah);
        this.officialSealImg.setAlignment(Image.ALIGN_CENTER | Image.MIDDLE);
        this.officialSealImg.scaleToFit(90, 90);
    }

    @Transactional(rollbackFor = Throwable.class)
    public byte[] build(TransHistory bo) throws Exception {
        TradeType tradeType = TradeType.resolve(bo.getTradeType());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        writer.setLinearPageMode();
        document.open();

        PdfPTable table = new PdfPTable(8);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.setTotalWidth(PageSize.A4.getWidth() - 100);
        table.setLockedWidth(true);
        //第一组
        PdfPCell cell = new PdfPCell();
        cell.setPadding(3);
        cell.setFixedHeight(28);
        cell.setImage(this.logoImg);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setColspan(2);
        table.addCell(cell);
        Font title_font = new Font(bfChinese, 11, Font.BOLD);
        Paragraph paragraph12 = new Paragraph(String.format("客户电子回单(%s)", this.getTitleDes(tradeType)), title_font);
        PdfPCell cell12 = new PdfPCell(paragraph12);
        cell12.setColspan(6);
        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell12);
        //第二组
        String ELE_NO = getNO(bo.getTransDate());
        table.addCell(colspanCenterPdfPCell("币种：人民币", 2));
        LocalDate date = LocalDate.parse(StringUtil.isNotEmpty(bo.getReconcileDate()) ? bo.getReconcileDate() : bo.getTransDate(), DateTimeFormatter.BASIC_ISO_DATE);
        table.addCell(colspanCenterPdfPCell(String.format("记账日期：%s", date.format(DateTimeFormatter.ofPattern("yyyy年M月d日"))), 4));
        table.addCell(colspanCenterPdfPCell(String.format("回单号：%s", ELE_NO), 2));

        //第三组
        table.addCell(rowspanCenterPdfPCell("收款人", 3));
        table.addCell(rightPdfPCell("户名："));
        table.addCell(leftPdfPCell(this.getPayeeAccountName(tradeType, bo), 2));
        table.addCell(rowspanCenterPdfPCell("付款人", 3));
        table.addCell(rightPdfPCell("户名："));
        table.addCell(leftPdfPCell(this.getPayerAccountName(tradeType, bo), 2));

        //第四组
        table.addCell(rightPdfPCell("账号："));
        table.addCell(leftPdfPCell(this.getPayeeAccountNO(tradeType, bo), 2));
        table.addCell(rightPdfPCell("账号："));
        table.addCell(leftPdfPCell(this.getPayerAccountNO(tradeType, bo), 2));
        //第五组
        table.addCell(rightPdfPCell("开户银行："));
        table.addCell(leftPdfPCell(bo.getPayeeOpbkName() == null ? "" : bo.getPayeeOpbkName(), 2));
        table.addCell(rightPdfPCell("开户银行："));
        table.addCell(leftPdfPCell(bo.getPayerOpbkName() == null ? "" : bo.getPayerOpbkName(), 2));

        //第六组
        table.addCell(centerPdfPCell("金额"));
        String amount = BigDecimal.valueOf(bo.getTransAmount()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        table.addCell(leftPdfPCell(String.format("人民币（大写）%s ￥%s元", RMBConvert.convert(amount), amount), 5));
        //盖章

        PdfPCell defaultCell1 = new PdfPCell(this.officialSealImg);
        defaultCell1.setRowspan(5);
        defaultCell1.setColspan(2);
        defaultCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        defaultCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(defaultCell1);
        //第7组
        table.addCell(centerPdfPCell("摘要"));
        table.addCell(leftPdfPCell(bo.getSummaryDescription() == null ? "" : bo.getSummaryDescription(), 5));
        //第8组
        table.addCell(centerPdfPCell("用途"));
        table.addCell(leftPdfPCell("", 5));
        //第9组
        table.addCell(centerPdfPCell("打印时间"));
        date = LocalDate.parse(bo.getTransDate(), DateTimeFormatter.BASIC_ISO_DATE);
        LocalTime time = LocalTime.parse(bo.getTransTime(), DateTimeFormatter.ofPattern("HHmmss"));
        String dateTime = date.format(DateTimeFormatter.ISO_LOCAL_DATE).concat(" ").concat(time.format(DateTimeFormatter.ofPattern("HH.mm.ss")));
        table.addCell(leftPdfPCell(dateTime, 5));
        //第10组
        table.addCell(centerPdfPCell(new Paragraph("重要提示", redFontZH)));
        table.addCell(leftPdfPCell(new Paragraph("本回单不作为收款方发货依据，并请勿重复记账", redFontZH), 5));
        document.add(table);
        document.close();

        byte[] bytes = byteArrayOutputStream.toByteArray();
        IOUtils.closeQuietly(byteArrayOutputStream);

        //电子回单文件保存到本地，返回保存路径
        String pdfPath = savePdfFile(bytes, bo.getIndustryCode(), bo.getMerNo());

        String md5Hex = DigestUtils.md5Hex(bytes);
        ElectronicReceipts electronicReceipt = ElectronicReceipts.builder().serverTransId(bo.getServerTransId())
                .orderNo(ELE_NO)
                .tradeType(bo.getTradeType())
                .md5Hex(md5Hex)
                .industryCode(bo.getIndustryCode())
                .clientTransId(bo.getClientTransId())
                .gmtCreate(new Date())
                .filePath(pdfPath)
                .build();
        MybatisDaoImpl.run().insert(electronicReceipt);
        if ("9090".equals(bo.getUserType())) {
            MybatisDaoImpl.run().updateById(ChannelIncomeFlow.builder().id(bo.getId()).elcMakeFlag(ElcMakeFlag.MAKE.getFlag()).build());
        } else {
            MybatisDaoImpl.run().updateById(TransHistory.builder().id(bo.getId()).elcMakeFlag(ElcMakeFlag.MAKE.getFlag()).build());
        }
        return null;
    }

    PdfPCell leftPdfPCell(String text, int colspan) {
        Paragraph paragraph = new Paragraph(text, fontZH);
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }

    PdfPCell leftPdfPCell(Paragraph paragraph, int colspan) {
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setNoWrap(true);
        return cell;
    }

    PdfPCell rightPdfPCell(String text) {
        Paragraph paragraph = new Paragraph(text, fontZH);
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setNoWrap(true);
        return cell;
    }

    PdfPCell centerPdfPCell(String text) {
        Paragraph paragraph = new Paragraph(text, fontZH);
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setNoWrap(true);
        return cell;
    }

    PdfPCell centerPdfPCell(Paragraph paragraph) {
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setNoWrap(true);
        return cell;
    }

    PdfPCell colspanCenterPdfPCell(String text, int colspan) {
        Paragraph paragraph = new Paragraph(text, fontZH);
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setNoWrap(true);
        return cell;
    }

    PdfPCell rowspanCenterPdfPCell(String text, int rowspan) {
        Paragraph paragraph = new Paragraph(text, fontZH);
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setRowspan(rowspan);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setNoWrap(true);
        return cell;
    }

    PdfPCell commonPdfPCell(Paragraph paragraph) {
        PdfPCell cell = new PdfPCell(paragraph);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(2);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        return cell;
    }

    String getNO(String pref) {
        long sec = this.redisAtomicLong.incrementAndGet();
        String seqNoStr = String.format("%08d", sec);
        return pref.concat(seqNoStr);
    }

    private String getTitleDes(TradeType tradeType) {
        switch (tradeType) {
            case TRANSFER:
            case TRANSFER_USER2USER:
            case TRANSFER_USER2INDUSTRY:
                return "虚转";
            case SGL_PAYMENT:
            case WITHDRAW:
            case UPLOAD_ACCOUNT_SETTLE:
            case BALANCE_PAYMENT:
            case ACC_PAYMENT:
                return "出款";
            case REFUND_ORDERID:
            case BALANCE_PAYMENT_REFUND:
                return "退款";
            case SPLIT_PAYMENT:
            case SUBACCOUNT_SPLIT_PAYMENT:
                return "分账";
            default:
                return "收款";
        }
    }

    /**
     * 收款人账户号
     * @param tradeType
     * @param bo
     * @return
     */
    private String getPayeeAccountNO(TradeType tradeType, TransHistory bo) {
        return StringUtils.isNotBlank(bo.getShowPayeeAccountNo()) ? bo.getShowPayeeAccountNo() : "";
    }

    /**
     * 收款人账户名
     * @param tradeType
     * @param bo
     * @return
     */
    private String getPayeeAccountName(TradeType tradeType, TransHistory bo) {
        return StringUtils.isNotBlank(bo.getShowPayeeAccountName()) ? bo.getShowPayeeAccountName() : "";
    }

    /**
     * 付款人账户号
     * @param tradeType
     * @param bo
     * @return
     */
    private String getPayerAccountNO(TradeType tradeType, TransHistory bo) {
        return StringUtils.isNotBlank(bo.getShowPayerAccountNo()) ? bo.getShowPayerAccountNo() : "";
    }

    /**
     * 付款人账户名
     * @param tradeType
     * @param bo
     * @return
     */
    private String getPayerAccountName(TradeType tradeType, TransHistory bo) {
        return StringUtils.isNotBlank(bo.getShowPayerAccountName()) ? bo.getShowPayerAccountName() : "";
    }

    /**
     * 保存PDF文件到本地
     * @param bytes        pdf内容
     * @param industryCode 代付客户号
     * @param merNo        商户号
     * @return
     */
    private String savePdfFile(byte[] bytes, String industryCode, String merNo) {
        if (fileDir.contains("\\")) {
            fileDir = fileDir.replaceAll("\\\\", "/").replaceAll("//", "/");
        }
        //文件保存目录：基本路径 + 客户号/ or 客户号/商户号/
        StringBuffer basePath = new StringBuffer(fileDir);
        if(StringUtil.isNotBlank(industryCode)){
            basePath.append("/").append(industryCode);
        }
        if (StringUtil.isNotBlank(merNo)) {
            basePath.append("/").append(merNo);
        }
        //判断文件夹是否存在，不存在则创建
        File file = new File(basePath.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        //生成 随机16位UUID + 当天日期 的文件名
        String fileName = IdGenerate.getUUID16().concat("_").concat(DateUtil.getCurrentDate()).concat(".").concat(FileType.PDF.getType());
        String targetPath = basePath.append("/").append(fileName).toString();
        return DataUtil.base64ContentToFile(bytes, targetPath);
    }
}