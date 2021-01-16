package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description : 更新个人客户信息
 * @Author : WJH
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OneBankUpdatePersonReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 银行客户号
     */
    private String clientId;

    /**
     * 个人/法人证件类型 101 身份证，102 护照  103 军官证
     */
    private String idType ;
    /**
     * 个人/法人证件号
     */
    private String idCode;
    /**
     * 证件有效期yyyyMMdd
     */
    private String idIndate;

    /**
     * 客户名称	STRING(200)	O 姓名	开户必输
     */
    private String realName;

    /**
     * 联系信息	STRING(85)	Y	开户必输 移动电话
     */
    @NotNull
    private String telephone;

    /**
     * 出生日期	DATE	O	yyyyMMdd（开户必输） 暂无
     */
    private String birthDt;

    /**
     * 性别	STRING(20)	O	开户必输 取值 sex
     */
    private String genderTpCd;

    /**
     * 国籍代码 STRING(20)	O	开户必输 取值 country
     */
    private String countryTpCd;

    /**
     * 职业	STRING(20)	O	开户必输 取值prosession
     */
    private String occupationTpCd;

    /**
     * 详细地址	STRING(200)	Y	开户必输 取值address
     */
    private String address;

    /**
     * 居民类型：0非居民 1居民
     */
    private String cdResidentTp;
}
