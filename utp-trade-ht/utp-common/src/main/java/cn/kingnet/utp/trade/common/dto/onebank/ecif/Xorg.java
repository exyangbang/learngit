package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.*;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/10/30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Xorg implements Serializable {
    /**
     * 客户内部序号	INT(8)	O 创建成功时返回
     */
    private String clientId;
    /**
     * 客户类型	STRING(1)	O P=个人账户 O=企业账户
     */
    private String clientCode = "O";
    /**
     * 企业类型	STRING(20)	O
     */
    private String orgTpCd;
    /**
     * 注册国家	STRING(20)	O CHN
     */
    private String rgstCountryTpCd;
    /**
     * 建立柜员	STRING(20)	O
     */
    private String createTlr;
    /**
     * 境内外类型	STRING(20)	O 1
     */
    private String abroadTpCd = "1";
    /**
     * 客户名称	STRING(200)	O
     */
    private String clientName;
    /**
     * 行业类型	STRING(20)	O
     */
    private String industryTpCd;
    /**
     * 经营范围	STRING(1000)	Y
     */
    private String businessScope;
    /**
     * 注册登记日期	DATE	O yyyyMMdd
     */
    private String registerDt;
    /**
     * 税务登记银行 取值 企业银行名称
     */
    private String taxregAcctBankname;
    /**
     * 客户分类	STRING(20)	O
     * 01	标准
     * 02	非标准
     */
    private String clientCatTpCd = "01";
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
     * 客户地址信息
     */
    private Address[] address;
    /**
     * 客户联系信息
     */
    private ContactMethod[] contactMethod;
    /**
     * 企业客户注册资金信息
     */
    private RegisterCapital[] registerCapital;
    /**
     * 建立时间戳	TIMESTAMP	O	yyyy-MM-dd HH:mm:ss
     */
    private String createTms;


    /**
     * 所属客户经理
     */
    private String customerManager;

    /**
     * 行内：企业规模
     */
    private String spdbScaleTpCd;

    /**
     * 企业经营性质：企业性质 暂没用到
     */
    private String ownershipTpCd;

    /**
     * 企业经营性质：即经济类型
     */
    private String economicTpCd;


    /**
     * 上市类型
     */
    private String listedTpCd;

    /**
     * 居民类型：0非居民 1居民
     */
    private String residentTpCd;

    private RelatedPerson[] relatedPerson;
}
