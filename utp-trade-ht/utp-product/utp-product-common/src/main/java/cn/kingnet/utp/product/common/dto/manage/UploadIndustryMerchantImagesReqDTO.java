package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 查询客户或商户图片信息
 * @Author sheqingquan@scenetec.com
 * @Create 2020/5/11 15:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UploadIndustryMerchantImagesReqDTO extends BaseInnerManageReqDTO {

    /**
     * 代付客户号 M
     */
    private String industryCode;
    /**
     * 用户虚拟账号 O
     * 保存商户图片时，需要传值
     */
    private String account;
    /**
     * 营业执照图片(base64字符串) O
     */
    private String busLicPic;
    /**
     * 法人证件正面图片(base64字符串) O
     */
    private String personPic;
    /**
     * 法人证件反面图片(base64字符串) O
     */
    private String personReversePic;
    /**
     * 开户许可证(base64字符串) O
     */
    private String licensePic;

    @Override
    public String[] toSHA1() {
        return new String[]{"appid=" + appid, "secret=" + secret,
                "industryCode=" + industryCode,
                "account=" + account,
                "busLicPic=" + busLicPic,
                "personPic=" + personPic,
                "personReversePic=" + personReversePic,
                "licensePic=" + licensePic
        };
    }
}