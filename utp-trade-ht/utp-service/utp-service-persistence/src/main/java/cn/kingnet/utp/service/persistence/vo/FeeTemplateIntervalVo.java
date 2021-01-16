package cn.kingnet.utp.service.persistence.vo;

import java.io.Serializable;

/**
 * @Description : 手续费区间信息
 * @Author : linkaigui
 * @Create : 2019/2/26 11:20
 */
public class FeeTemplateIntervalVo implements Serializable {

    /**
     * 区间最小值（不包含）
     */
    private Long firstSection;

    /**
     * 区间最大值（包含）
     */
    private Long secondSection;

    /**
     * 手续费
     */
    private Long priceSection;

    /**
     * 类型，可为空，值为"amount"表式固定金额 单位：分
     */
    private String type;

    public Long getFirstSection() {
        return firstSection;
    }

    public void setFirstSection(Long firstSection) {
        this.firstSection = firstSection;
    }

    public Long getSecondSection() {
        return secondSection;
    }

    public void setSecondSection(Long secondSection) {
        this.secondSection = secondSection;
    }

    public Long getPriceSection() {
        return priceSection;
    }

    public void setPriceSection(Long priceSection) {
        this.priceSection = priceSection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
