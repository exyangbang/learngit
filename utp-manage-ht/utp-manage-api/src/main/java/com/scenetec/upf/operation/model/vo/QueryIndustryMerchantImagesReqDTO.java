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
public class QueryIndustryMerchantImagesReqDTO extends BaseInnerManageReqDTO {

    /**
     * 客户号 | 虚拟账户号 M
     */
    private String code;
    /**
     * 请求类型 M
     * 1：查询客户图片信息
     * 2：查询商户图片信息
     *
     *  ==1 代付客户号
     *  ==2 虚拟账号
     */
    private String queryType;
    /**
     * 返回图片类型 M
     * 1：图片url地址
     * 2：图片base64字符串(未带前缀：data:image/jpg;base64,)
     */
    private String imageType;

    @Override
    public String[] toSHA1() {
        return new String[]{"appid="+appid, "secret="+secret,
                "code="+code,
                "queryType="+queryType,
                "imageType="+imageType
        };
    }
}
