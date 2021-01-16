package com.scenetec.upf.operation.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Pattern;

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
     * 当type==2时，为必填项
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
//        StringBuffer sBuffer = new StringBuffer();
//        sBuffer.append("appid="+appid);
//        sBuffer.append("secret="+secret);
//        sBuffer.append("industryCode="+industryCode);
//        sBuffer.append("account="+account);
//        sBuffer.append("busLicPic="+busLicPic);
//        sBuffer.append("personReversePic="+personReversePic);
//        return  sBuffer.toString();
        return new String[]{"appid="+appid, "secret="+secret,
                "industryCode="+industryCode,
                "account="+account,
                "busLicPic="+busLicPic,
                "personPic="+personPic,
                "personReversePic="+personReversePic,
                "licensePic="+licensePic
        };
    }
}