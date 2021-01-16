package cn.kingnet.product.account.service.inner;

import cn.kingnet.product.account.service.inner.manage.ManageException;
import cn.kingnet.utp.product.common.dto.manage.QueryIndustryMerchantImagesReqDTO;
import cn.kingnet.utp.product.common.dto.manage.QueryIndustryMerchantImagesRespDTO;
import cn.kingnet.utp.product.common.dto.manage.UploadIndustryMerchantImagesReqDTO;
import cn.kingnet.utp.product.common.dto.manage.UploadIndustryMerchantImagesRespDTO;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.enums.FileType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.File;

/**
 * @Description: 图片处理服务
 * @Author sheqingquan@scenetec.com
 * @Create 2020/5/9 17:03
 */
@Slf4j
@Service
public class PictureService {

    @Value("${cn.kingnet.utp.picture.file-dir}")
    private String imagesDir;
    @Value("${cn.kingnet.utp.pdf.file-dir}")
    private String pdfDir;

    @Resource
    private IAccountHandler accountHandler;

    /**
     * 将base64内容保存到磁盘本地
     * @param base64Code   源文件base64字符串 M
     * @param industryCode 代付客户号 M
     * @param fileType     文件类型 M
     * @return 图片保存路径
     */
    public String base64ContentToFile(String base64Code, String industryCode, FileType fileType) {
        return base64ContentToFile(base64Code, industryCode, null, fileType);
    }

    /**
     * 将base64内容保存到磁盘本地
     * @param base64Code   源文件base64字符串 M
     * @param industryCode 代付客户号 M
     * @param otherCode    用户虚拟账号|支付订单号  O
     * @param fileType     文件类型 M
     * @return 图片保存路径
     */
    public String base64ContentToFile(String base64Code, String industryCode, String otherCode, FileType fileType) {

        //判断是否为空
        if (StringUtil.isBlank(base64Code)) {
            return null;
        }
        //判断是否为base64编码格式
        if (!DataUtil.isBase64Format(base64Code)) {
            return base64Code;
        }

        Assert.hasText(industryCode, "参数[industryCode]不能为空");
        FileType type = FileType.getFileType(fileType.getType());
        Assert.notNull(type, () -> String.format("暂不支持此[%s]类型的文件", fileType));

        try {
            String filePath = null;
            if (fileType.equals(FileType.JPG)) {
                filePath = imagesDir;
            } else if (fileType.equals(FileType.PDF)) {
                filePath = pdfDir;
            }

            if (filePath.contains("\\")) {
                filePath = filePath.replaceAll("\\\\", "/").replaceAll("//", "/");
            }
            //文件保存目录：基本路径 + 客户号/ or 客户号/用户虚拟账号或者支付订单号/
            StringBuffer basePath = new StringBuffer(filePath.concat("/").concat(industryCode));
            if (StringUtil.isNoneBlank(otherCode)) {
                basePath.append("/").append(otherCode);
            }
            //判断文件夹是否存在，不存在则创建
            File file = new File(basePath.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            //生成 随机16位UUID + 当天日期 的文件名
            String fileName = IdGenerate.getUUID16().concat("_").concat(DateUtil.getCurrentDate()).concat(".").concat(fileType.getType());
            String targetPath = basePath.append("/").append(fileName).toString();
            String base64Content = base64Code;
            if (FileType.JPG.equals(type)) {
                //如果是图片，则去掉前缀，例如：data:image/png;base64,
                base64Content = base64Code.replaceAll("data:image.+?base64,", "");
            }
            return DataUtil.base64ContentToFile(base64Content, targetPath);
        } catch (Exception e) {
            log.error("base64图片保存异常==>{}", e.getMessage(), e);
            throw new ProductException(HttpRespStatus.FORBIDDEN, "图片保存异常");
        }
    }

    /**
     * 查询客户或商户图片信息
     * @param req 请求对象
     * @return
     */
    public QueryIndustryMerchantImagesRespDTO queryImages(QueryIndustryMerchantImagesReqDTO req) {
        if (null == req) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "请求报文不能为空");
        }
        //参数校验
        ValidateUtils.maxLength(req.getCode(), 32, true, "客户号或虚账号");
        ValidateUtils.hasText(req.getQueryType(), "请求类型");

        if (!(req.getQueryType().equals("1") || req.getQueryType().equals("2"))) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, String.format("请求类型[%s]不正确", req.getQueryType()));
        }
        if (StringUtil.isNoneBlank(req.getImageType())) {
            if (!(req.getImageType().equals("1") || req.getImageType().equals("2"))) {
                throw new ManageException(HttpRespStatus.BAD_REQUEST, String.format("图片类型[%s]不正确", req.getImageType()));
            }
        }
        //签名校验
        if (!SHA1.genWithAmple(req.toSHA1()).equals(req.getSign())) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }
        //根据查询类型判断
        if (req.getQueryType().equals("1")) {
            // 1：查询客户图片信息
            Industry industry = accountHandler.findIndustryAll(req.getCode());
            if (null == industry) {
                throw new ManageException(HttpRespStatus.BAD_REQUEST, "客户信息不存在");
            }
            return buildQueryResp(industry.getBusLicPic(), industry.getLicensePic(), industry.getPersonPic(), industry.getPersonReversePic(), req.getImageType());
        } else if (req.getQueryType().equals("2")) {
            // 2：查询商户图片信息
            MerchantInfo merchantInfo = accountHandler.findMerchantByAccountAll(req.getCode());
            if (null == merchantInfo) {
                throw new ManageException(HttpRespStatus.BAD_REQUEST, "商户信息不存在");
            }
            return buildQueryResp(merchantInfo.getBusLicPic(), merchantInfo.getLicensePic(), merchantInfo.getPersonPic(), merchantInfo.getPersonReversePic(), req.getImageType());
        } else {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "无效的请求类型");
        }
    }

    /**
     * 上传图片
     * @param req
     * @return
     */
    public UploadIndustryMerchantImagesRespDTO uploadImages(UploadIndustryMerchantImagesReqDTO req) {
        if (null == req) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "请求报文不能为空");
        }
        //参数校验
        ValidateUtils.maxLength(req.getIndustryCode(), 32, true, "客户号");
        ValidateUtils.maxLength(req.getAccount(), 32, false, "用户虚拟账号");
        ValidateUtils.base64Valid(req.getBusLicPic(), false, "营业执照图片");
        ValidateUtils.base64Valid(req.getPersonPic(), false, "法人证件正面");
        ValidateUtils.base64Valid(req.getPersonReversePic(), false, "法人证件反面");
        ValidateUtils.base64Valid(req.getLicensePic(), false, "开户许可证");
        //签名校验
        if (!SHA1.genWithAmple(req.toSHA1()).equals(req.getSign())) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }
        if (imagesDir.contains("\\")) {
            imagesDir = imagesDir.replaceAll("\\\\", "/").replaceAll("//", "/");
        }
        //文件保存目录：基本路径 + 客户号/ or 客户号/用户虚拟账号/
        StringBuffer baseBuffer = new StringBuffer(imagesDir.concat("/").concat(req.getIndustryCode()));
        if (StringUtil.isNoneBlank(req.getAccount())) {
            baseBuffer.append("/").append(req.getAccount());
        }

        String basePath = baseBuffer.toString();
        UploadIndustryMerchantImagesRespDTO respDTO = new UploadIndustryMerchantImagesRespDTO();
        //保存图片
        if (StringUtil.isNoneBlank(req.getBusLicPic())) {
            respDTO.setBusLicPicPath(upload(req.getBusLicPic(), basePath));
        }
        if (StringUtil.isNoneBlank(req.getPersonPic())) {
            respDTO.setPersonPicPath(upload(req.getPersonPic(), basePath));
        }
        if (StringUtil.isNoneBlank(req.getPersonReversePic())) {
            respDTO.setPersonReversePicPath(upload(req.getPersonReversePic(), basePath));
        }
        if (StringUtil.isNoneBlank(req.getLicensePic())) {
            respDTO.setLicensePicPath(upload(req.getLicensePic(), basePath));
        }
        respDTO.setStatus(HttpRespStatus.OK.valueStr());
        return respDTO;
    }

    /**
     * 构建返回对象
     * @param busLicPic        营业执照图片
     * @param licensePic       开户许可证
     * @param personPic        法人证件正面图片
     * @param personReversePic 法人证件反面图片
     * @param imageType        1：图片url地址  2：图片base64字符串(未带前缀：data:image/jpg;base64,)
     * @return
     */
    private QueryIndustryMerchantImagesRespDTO buildQueryResp(String busLicPic, String licensePic, String personPic, String personReversePic, String imageType) {
        QueryIndustryMerchantImagesRespDTO respDTO = new QueryIndustryMerchantImagesRespDTO();
        if (StringUtil.isNoneBlank(imageType)) {
            if (imageType.equals("1")) {
                //返回图片url地址
                respDTO.setBusLicPic(busLicPic);
                respDTO.setLicensePic(licensePic);
                respDTO.setPersonPic(personPic);
                respDTO.setPersonReversePic(personReversePic);
            } else if (imageType.equals("2")) {
                //返回图片base64字符串
                respDTO.setBusLicPic(getImageToBase64(busLicPic));
                respDTO.setLicensePic(getImageToBase64(licensePic));
                respDTO.setPersonPic(getImageToBase64(personPic));
                respDTO.setPersonReversePic(getImageToBase64(personReversePic));
            }
        } else {
            //返回库表原值
            respDTO.setBusLicPic(busLicPic);
            respDTO.setLicensePic(licensePic);
            respDTO.setPersonPic(personPic);
            respDTO.setPersonReversePic(personReversePic);
        }
        respDTO.setStatus(HttpRespStatus.OK.valueStr());
        return respDTO;
    }

    /**
     * 上传图片
     * @param content  base64内容
     * @param basePath 基础路径
     * @return
     */
    private String upload(String content, String basePath) {
        String targetPath = basePath;
        String fileName = IdGenerate.getUUID16().concat("_").concat(DateUtil.getCurrentDate()).concat(".").concat(FileType.JPG.getType());
        return DataUtil.base64ContentToFile(content, targetPath.concat("/").concat(fileName));
    }

    /**
     * 根据路径转为base64图片字符串
     * @param filePath 源图片路径，包含文件名
     * @return 图片base64字符串，未带前缀：data:image/jpg;base64,
     */
    private String getImageToBase64(String filePath) {
        try {
            if (StringUtil.isBlank(filePath)) {
                return null;
            } else {
                //判断是否为base64编码字符串
                boolean isBase64Image = DataUtil.isBase64Format(filePath);
                if (isBase64Image) {
                    return null;
                } else {
                    return DataUtil.imageToBase64(filePath);
                }
            }
        } catch (Exception e) {
            log.error("路径：[{}]，图片转base64异常==>{}", filePath, e.getMessage(), e);
            return null;
        }
    }
}