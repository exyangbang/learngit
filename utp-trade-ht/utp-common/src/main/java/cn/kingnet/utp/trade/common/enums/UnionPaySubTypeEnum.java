package cn.kingnet.utp.trade.common.enums;

/**
 * 银联全渠道交易子类型
 *
 * @author zhongli
 */
public enum UnionPaySubTypeEnum {
    /**
     * 账户验证
     */
    BIND("个人账户四要素认证"),
    /**
     * 单笔代付
     */
    SINGLE_PAY("单笔实时代付"),
    /**
     * 交易查询
     */
    QUERY("转账交易结果查询"),
    /**
     * 单笔对私
     */
    PRIVATE("单笔对私区转账"),
    /**
     * 单笔对公
     */
    PUBLIC("单笔对公区转账"),
    /**
     * 批量对私
     */
    BATCH_PRIVATE("批量对私"),
    /**
     * 批量对私查询
     */
    BATCH_PRIVATE_QUERY("批量对私查询"),
    /**
     * 批量对公
     */
    BATCH_PUBLIC("批量对公"),
    /**
     * 对账文件下载
     */
    STATEMENT_DOWNLOAD("渠道对账文件下载"),
    /**
     * 银联加密公钥更新
     */
    ENCRYPT_PUBLIC_KEY_QUERY("银联加密公钥更新"),
    /**
     * 客户账号余额查询
     */
    ACCOUNT_BALANCE_QUERY("一般户余额查询"),
    /**
     * 客户账户交易明细查询
     */
    ACCOUNT_TRANS_DETAIL_QUERY("一般户交易资金明细查询"),
    /**
     * 内部户余额查询|及内部基本信息查询
     */
    INNER_ACCOUNT_BALANCE_QUERY("内部户余额查询|内部户基本信息查询"),
    /**
     * 内部户交易明细查询
     */
    INNER_ACCOUNT_TRANS_DETAIL_QUERY("内部户交易资金明细查询"),
    /**
     * 对私交易结果查询
     */
    PRIVATE_TRANS_QUERY("对私区交易结果查询"),
    /**
     * 对私交易结果查询
     */
    PUBLIC_TRANS_QUERY("对公区交易结果查询"),
    /**
     * 一般户账户信息查询
     */
    ACCOUNT_INFO_QUERY("一般户基本新查询"),

    /**
     * 查询个人客户热点信息
     */
    GET_PERSON_HOTSPOT("查询个人客户热点信息"),
    /**
     * 查询企业客户热点信息
     */
    GET_ORG_HOTSPOT("查询企业客户热点信息"),
    /**
     * 建立个人客户信息
     */
    ADD_PERSON("建立个人客户信息"),
    /**
     * 建立企业客户信息
     */
    ADD_ORG("建立企业客户信息"),
    /**
     * 更新个人客户信息
     */
    UPDATE_PERSON("更新个人客户信息"),
    /**
     * 建立企业客户信息
     */
    UPDATE_ORG("更新企业客户信息"),
    /**
     * ORC身份识别
     */
    ORC_IDENTITY("ORC身份识别"),
    /**
     * 联网核查
     */
    ONLINE_CHECK("联网核查"),
    /**
     * PDF自动化合成模板业务数据接口new
     * (合成业务数据到模板生成单据，业务数据包括文本、图片；不返回合成后pdf文件，只返回保存在临时表中的pdfId。)
     */
    SYNTHESIZE_TEMPLATE_WITH_PDF_ID("PDF自动化合成模板业务数据接口new"),
    /**
     * PDF自动化合成模板业务数据接口
     * (合成业务数据到模板生成单据，业务数据包括文本、图片；返回合成后pdf文件)
     */
    SYNTHESIZE_AUTO_TEMPLATE("PDF自动化合成模板业务数据接口"),
    /**
     * PDF自动化签章接口
     */
    SEAL_AUTO_PDF("PDF自动化签章接口"),
    ;

    private String desc;

    UnionPaySubTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
