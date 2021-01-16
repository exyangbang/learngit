package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.*;

import java.io.Serializable;

/**
 * @Description 个人客户信息
 * @Author WJH
 * @Date 2019/10/30
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Xperson implements Serializable {
    /**
     * 客户内部序号	INT(8)	O 创建成功时返回
     */
    private String clientId;
    /**
     * 客户类型	STRING(1)	O P=个人账户 O=企业账户
     */
    private String clientCode = "P";
    /**
     * 建立柜员	STRING(20)	O
     */
    private String createTlr;
    /**
     * 住宅类型	STRING(20)	O
     */
    private String houseTpCd = "10";
    /**
     * 客户联系信息	COMPLEX		Occur[0,N]
     */
    private ContactMethod[] contactMethod;
    /**
     * 出生日期	DATE	O	yyyyMMdd（开户必输） 暂无
     */
    private String birthDt;
    /**
     * 客户分类	STRING(20)	O
     * 01	标准
     * 02	非标准
     */
    private String clientCatTpCd = "01";
    /**
     * 客户名称	STRING(200)	O	开户必输
     */
    private String clientName;
    /**
     * 建立机构	STRING(20)	O
     */
    private String createInst;
    /**
     * 通讯语言	STRING(20)	O
     */
    private String langTpCd = "E01";
    /**
     * 客户状态	STRING(20)	O
     * 01	正常客户
     * 02	潜在客户
     * 03	销户客户
     */
    private String clientStTpCd;
    /**
     * 客户证件信息
     */
    private Identifier[] identifier;
    /**
     * Address	客户地址信息
     */
    private Address[] address;
    /**
     * 建立时间戳	TIMESTAMP	O	yyyy-MM-dd HH:mm:ss
     */
    private String createTms;
    /**
     * 国籍	STRING(20)	O	开户必输
     */
    private String countryTpCd;
    /**
     * 性别	STRING(20)	O	开户必输
     */
    private String genderTpCd;
    /**
     * 职业	STRING(20)	O	开户必输
     */
    private String occupationTpCd;

    /**
     * 客户信息级别	STRING(1)	Y	0：九要素必输1：九要素非必输
     */
    private String clientInfoType = "1";

    /**
     * 居民类型：0非居民 1居民
     */
    private String residentTpCd;

}
