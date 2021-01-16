package cn.kingnet.utp.scheduler.pdf;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.AccountElectronicReceipt;
import cn.kingnet.utp.scheduler.data.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.enums.FileType;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.codec.digest.DigestUtils;
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
import java.util.Date;

/**
 * @Description : 开户电子回单
 * @Author : linkaigui
 * @Create : 2020/3/14 13:53
 */
public class AccountEleReceiptPdf {

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

    public AccountEleReceiptPdf(RedisConnectionFactory connectionFactory) {
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
        this.fontZH = new Font(bfChinese, 10, Font.NORMAL);
        this.redFontZH = new Font(bfChinese, 10, Font.NORMAL);
        this.redFontZH.setColor(BaseColor.RED);
        this.logoImg = Image.getInstance(logoPath);
        this.logoImg.setAlignment(Image.ALIGN_CENTER | Image.MIDDLE);
        this.officialSealImg = Image.getInstance(officialSealImgPtah);
        this.officialSealImg.setAlignment(Image.ALIGN_CENTER | Image.MIDDLE);
        this.officialSealImg.scaleToFit(90, 90);
    }

    @Transactional(rollbackFor = Throwable.class)
    public byte[] buildPdf(MerchantInfo merchantInfo) throws Exception {
        //获取创建日期
        String createDate = DateUtil.getStringFromDate(merchantInfo.getGmtCreate(),DateUtil.FORMAT_TRADEDATE);
        //开户电子回单号
        String receiptNo = getNO(createDate);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        writer.setLinearPageMode();
        document.open();

        PdfPTable table = new PdfPTable(7);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.setTotalWidth(PageSize.A4.getWidth() - 100);
        table.setLockedWidth(true);

        //第一行
        PdfPCell cell = new PdfPCell();
        cell.setPadding(3);
        cell.setFixedHeight(28);
        cell.setImage(this.logoImg);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setColspan(2);
        table.addCell(cell);

        Font title_font = new Font(bfChinese, 11, Font.BOLD);
        Paragraph paragraph12 = new Paragraph("客户电子回单(注册会员号开立)", title_font);
        PdfPCell cell12 = new PdfPCell(paragraph12);
        cell12.setColspan(5);
        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell12);

        //第二行
        table.addCell(rightPdfPCell("回 单 号:",1));
        table.addCell(leftPdfPCell(receiptNo, 4));

        //盖章
        PdfPCell defaultCell1 = new PdfPCell(this.officialSealImg);
        defaultCell1.setRowspan(5);
        defaultCell1.setColspan(2);
        defaultCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        defaultCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(defaultCell1);

        //第三行
        table.addCell(rightPdfPCell("注册会员名称:",1));
        table.addCell(leftPdfPCell(merchantInfo.getMerName(), 4));

        //第四行
        table.addCell(rightPdfPCell("注册会员号码:",1));
        table.addCell(leftPdfPCell(merchantInfo.getAccount(), 4));

        //第五行
        table.addCell(rightPdfPCell("启用日期:",1));
        table.addCell(leftPdfPCell(createDate, 4));
        document.add(table);
        document.close();

        byte[] bytes = byteArrayOutputStream.toByteArray();
        IOUtils.closeQuietly(byteArrayOutputStream);

        //电子回单文件保存到本地，返回保存路径
        String pdfPath = savePdfFile(bytes, merchantInfo.getIndustryCode(), merchantInfo.getMerNo());

        String md5Hex = DigestUtils.md5Hex(bytes);
        AccountElectronicReceipt accountElectronicReceipt = AccountElectronicReceipt.builder()
                .receiptNo(receiptNo)
                .md5Hex(md5Hex)
                .account(merchantInfo.getAccount())
                .filePath(pdfPath)
                .gmtCreate(new Date())
                .gmtModified(new Date())
                .build();
        MybatisDaoImpl.run().insert(accountElectronicReceipt);
        return null;
    }

    String getNO(String pref) {
        long sec = this.redisAtomicLong.incrementAndGet();
        String seqNoStr = String.format("%08d", sec);
        return pref.concat(seqNoStr);
    }

    PdfPCell leftPdfPCell(String text, int colspan) {
        Paragraph paragraph = new Paragraph(text, fontZH);
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }

    PdfPCell rightPdfPCell(String text, int colspan) {
        Paragraph paragraph = new Paragraph(text, fontZH);
        PdfPCell cell = commonPdfPCell(paragraph);
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
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
        StringBuffer basePath = new StringBuffer(fileDir.concat("/").concat(industryCode));
        if (StringUtil.isNoneBlank(merNo)) {
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
