package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 查询客户或商户图片信息
 * @Author sheqingquan@scenetec.com
 * @Create 2020/5/11 15:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UploadIndustryMerchantImagesRespDTO extends BaseInnerManageRespDTO {

    /**
     * 营业执照图片路径
     */
    private String busLicPicPath;
    /**
     * 法人证件正面图片路径
     */
    private String personPicPath;
    /**
     * 法人证件反面图片路径
     */
    private String personReversePicPath;
    /**
     * 开户许可证路径
     */
    private String licensePicPath;

}