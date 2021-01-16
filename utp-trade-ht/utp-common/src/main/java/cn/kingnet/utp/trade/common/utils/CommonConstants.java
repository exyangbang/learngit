package cn.kingnet.utp.trade.common.utils;

/**
 * 公共常量类
 * Created on 2018/5/16
 *
 * @author by Benjamin.Huang
 */
public class CommonConstants {

    ////////////////////////////////////////// 请求头信息定义 start //////////////////////////////////////////
    public static final String HEAD_PARAM_AUTHORIZATION = "Authorization";
    public static final String HEAD_PARAM_CONTENT_TYPE = "Content-Type";
    ////////////////////////////////////////// 请求头信息定义 end ///////////////////////////////////////////

    ////////////////////////////////////////// 签验签类型定义 start //////////////////////////////////////////
    public static final String AUTHORIZATION_TYPE_PASSWORD = "PASSWORD";
    public static final String AUTHORIZATION_TYPE_MD5 = "MD5";
    public static final String AUTHORIZATION_TYPE_RSA = "RSA";
    public static final String AUTHORIZATION_TYPE_HTSIGN = "HTSIGN";
    ////////////////////////////////////////// 签验签类型定义 end //////////////////////////////////////////

    ////////////////////////////////////////// 参数分隔符定义 start //////////////////////////////////////////
    public static final String SEPARATER_COMMA = ",";// 逗号分隔符
    public static final String SEPARATER_COLON = ":";// 冒号分隔符
    public static final String SEPARATER_SINGLE_BLANK = " ";// 单空格分隔符
    ////////////////////////////////////////// 参数分隔符定义 end ///////////////////////////////////////////
    // 证书表：xx证书类型定义
    //机构证书
    public static final String ORG_CERT_TYPE = "1";
    //渠道证书
    public static final String CHANNEL_CERT_TYPE = "2";

    //货币标识
    public final static String CURRENCY156 = "156";

    /**
     * 撤销状态0-未撤销 1-已撤销
     */
    public final static String REVOKE_STATUS_UNDO = "0";
    public final static String REVOKE_STATUS_OK = "1";


    /**
     * 退货状态0-未退货 1-部分退货 2-已全部退货
     */
    public final static String REFUND_STATUS_UNDO = "0";
    public final static String REFUND_STATUS_PART_OK = "1";
    public final static String REFUND_STATUS_OK = "2";

    /**
     * 对账状态 0未对账 1已对账
     */
    public final static String RECONCILE_STATUS_UNDO = "0";
    public final static String RECONCILE_STATUS_OK = "1";

    /**
     * 余额支付 结算状态 0未结算 1已结算
     */
    public final static String PAYMENT_SETTLE_STATUS_UNDO = "0";
    public final static String PAYMENT_SETTLE_STATUS_OK = "1";

    /**
     * 能够提取批量上送回执文件
     * 批量回执状态为81或91时，才有回执明细
     */
    public static boolean canExtractBatchData(String batchStatus) {
        return "81".equals(batchStatus) || "90".equals(batchStatus);
    }

    /**
     * 虚拟账户类型 1平台(行业) 2商户/个人
     */
    public final static String ACCOUNT_INDUSTRY = "1";
    public final static String ACCOUNT_MERCHANT = "2";

    /**
     * 状态标识
     */
    public final static String STATUS_DISABLED = "0";
    public final static String STATUS_NORMAL = "1";

    /**基础配置信息对象KEY*/
    public final static String BASIC_CONFIG_INFO_KEY = "BASIC_CONFIG_INFO_KEY";

    public final static String DEFAULT_ORG_CODE = "DEFAULT_ORG_CODE";

    public final static String payerOpbkName = "福建华通银行";
    /**走华通银联代付默认 法人编号 8888 **/
    public final static String DEFAULT_HT_PERSON_CODE = "8888";
}
