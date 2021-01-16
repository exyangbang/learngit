package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import java.io.Serializable;

/**
 * @Description 客户联系信息
 * @Author WJH
 * @Date 2019/10/30
 */
public class ContactMethod implements Serializable {

    /**
     * 联系类型	STRING(20)	Y	开户必输
     * 103移动电话  302 电子邮件
     */
    private String ctcmthTpCd = "103";
    /**
     * 联系信息	STRING(85)	Y	开户必输 移动电话
     */
    private String ctcmthNum;

    public ContactMethod() {
    }

    public ContactMethod(String ctcmthTpCd, String ctcmthNum) {
        this.ctcmthTpCd = ctcmthTpCd;
        this.ctcmthNum = ctcmthNum;
    }

    public String getCtcmthTpCd() {
        return ctcmthTpCd;
    }

    public void setCtcmthTpCd(String ctcmthTpCd) {
        this.ctcmthTpCd = ctcmthTpCd;
    }

    public String getCtcmthNum() {
        return ctcmthNum;
    }

    public void setCtcmthNum(String ctcmthNum) {
        this.ctcmthNum = ctcmthNum;
    }
}
