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
public class QueryIndustryMerchantImagesReqDTO extends BaseInnerManageReqDTO {

    /**
     * 用户虚拟账号
     */
    private String code;
    /**
     * 请求类型 M
     * 1：查询客户图片信息
     * 2：查询商户图片信息
     */
    private String queryType;
    /**
     * 返回图片类型(为空不进行转换，默认返回数据库里的原值) O
     * 1：图片url地址
     * 2：图片base64字符串(未带前缀：data:image/jpg;base64,)
     */
    private String imageType;

    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "code=".concat(code),
                "queryType=".concat(queryType),
                "imageType=".concat(imageType)
        };
    }
}
