package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import java.io.Serializable;

/**
 * @Description 客户证件信息
 * @Author WJH
 * @Date 2019/10/30
 */
public class Identifier implements Serializable {
    /**
     * 证件类型	STRING(20)	Y	开户必输
     */
    private String idTpCd;
    /**
     * 证件号码	STRING(30)	Y	开户必输
     */
    private String idNum;
    /**
     * StartDt	启用日期	DATE	O	yyyyMMdd 不做限制即透传，前端控制
     */
    private String startDt;
    /**
     * 过期日期	DATE	O	yyyyMMdd（开户必输）
     */
    private String expiryDt;

    public Identifier() {
    }

    public Identifier(String idTpCd, String idNum, String expiryDt) {
        this.idTpCd = idTpCd;
        this.idNum = idNum;
        this.expiryDt = expiryDt;
    }
    public Identifier(String idTpCd, String idNum, String startDt,String expiryDt) {
        this.idTpCd = idTpCd;
        this.idNum = idNum;
        this.startDt = startDt;
        this.expiryDt = expiryDt;
    }

    public String getIdTpCd() {
        return idTpCd;
    }

    public void setIdTpCd(String idTpCd) {
        this.idTpCd = idTpCd;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getExpiryDt() {
        return expiryDt;
    }

    public void setExpiryDt(String expiryDt) {
        this.expiryDt = expiryDt;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }
}
