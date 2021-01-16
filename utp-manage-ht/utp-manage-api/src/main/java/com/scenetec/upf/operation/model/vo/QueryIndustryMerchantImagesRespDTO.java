package com.scenetec.upf.operation.model.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 查询客户或商户图片信息
 * @Author sheqingquan@scenetec.com
 * @Create 2020/5/11 15:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryIndustryMerchantImagesRespDTO extends BaseInnerManageRespDTO {

    /**
     * 营业执照图片
     */
    private String busLicPic;
    /**
     * 法人证件正面图片
     */
    private String personPic;
    /**
     * 法人证件反面图片
     */
    private String personReversePic;
    /**
     * 开户许可证
     */
    private String licensePic;

}