package cn.kingnet.utp.trade.common.enums;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 描述枚举
 * @Author : linkaigui
 * @Create : 2019/3/15 15:38
 */
public enum OneBankRespCode {
    /**
     * 成功
     */
    PCC00000,
    /**
     * 平台自定义：平台返回渠道回调响应码：接收回调通知内容为空
     */
    PCC000001,
    /**
     * 平台自定义：平台返回渠道回调响应码：接收回调通知内容解析处理异常
     */
    PCC000002,

    /**
     * 通讯失败
     **/
    PCC90001,
    /**
     * 通讯超时
     **/
    PCC90002,
    /**
     * 交易金额超限[上限或下限]
     **/
    PCC02220,
    /**
     * 日交易总金额超限
     **/
    PCC02222,
    /**
     * 日交易总次数超限
     **/
    PCC02223,
    /**
     * 月交易总金额超限
     **/
    PCC02224,
    /**
     * 月交易总次数超限
     **/
    PCC02225,
    /**
     * 失败次数超限
     **/
    PCC02226,
    /**
     * 发卡行交易权限受限
     **/
    PCC02227,
    /**
     * 输入的密码不正确
     **/
    PCC02245,
    /**
     * 身份验证信息不正确
     **/
    PCC02246,
    /**
     * 无效帐户
     **/
    PCC02250,
    /**
     * 账户已超过有效期
     **/
    PCC02251,
    /**
     * 账户状态不正确
     **/
    PCC02252,
    /**
     * 账户已挂失
     **/
    PCC02253,
    /**
     * 账户已冻结
     **/
    PCC02254,
    /**
     * 账户类型错误或不支持
     **/
    PCC02255,
    /**
     * 账户不允许交易
     **/
    PCC02256,
    /**
     * 账户余额不足
     **/
    PCC02257,
    /**
     * 动态口令或短信验证码校验失败
     **/
    PCC02270,
    /**
     * 商户号未配置,不允许交易
     **/
    PCC02293,
    /**
     * 合作方标识不识别
     **/
    PCC02294,
    /**
     * 密码已锁定
     **/
    PCC10181,
    /**
     * 商户状态已停用，无法受理此交易
     **/
    PCC20002,
    /**
     * 未签约或签约不通过
     **/
    PCC20032,
    /**
     * 交易金额超限
     **/
    PCC22006,
    /**
     * 绑定关系检查失败
     **/
    PCC22007,
    /**
     * 输入的卡号无效，请确认后输入
     **/
    PCC22009,
    /**
     * 卡状态不正确
     **/
    PCC22010,
    /**
     * 动态口令或短信验证码校验失败
     **/
    PCC22016,
    /**
     * 支付卡已超过有效期
     **/
    PCC22017,
    /**
     * 月累计交易笔数(金额)超限
     **/
    PCC22018,
    /**
     * 认证失败未知错误
     **/
    PCC30010,
    /**
     * 银行卡与姓名不符
     **/
    PCC30020,
    /**
     * 此卡受限制,请联系发卡行
     **/
    PCC30030,
    /**
     * 此卡已过期
     **/
    PCC30050,
    /**
     * 账号不存在
     **/
    PCC30060,
    /**
     * 证件与姓名不符
     **/
    PCC30070,
    /**
     * 银行卡与手机不符
     **/
    PCC30080,
    /**
     * 银行卡有效期错误
     **/
    PCC30090,
    /**
     * 银行卡cvv2错误
     **/
    PCC30100,
    /**
     * 银行卡与证件不符
     **/
    PCC30110,
    /**
     * 单笔金额超限
     **/
    PCC40803,
    /**
     * 单日已用额度大于邮路上限
     **/
    PCC40804,
    /**
     * 单月已用额度大于邮路上限
     **/
    PCC40805,
    /**
     * 单日已用笔数大于邮路日笔数
     **/
    PCC40806,
    /**
     * 单月已用笔数大于邮路月笔数
     **/
    PCC40807,
    /**
     * 此商户不存在或未启用
     **/
    PCC41101,
    /**
     * 户名错误
     **/
    PCC41114,
    /**
     * 账号错误
     **/
    PCC41115,
    /**
     * 交易通讯超时，请发起查询交易
     **/
    PCC42003,
    /**
     * 交易状态未明，请查询对账结果
     **/
    PCC42004,
    /**
     * 交易已受理，请稍后查询交易结果
     **/
    PCC42005,
    /**
     * 交易未通过，请尝试使用其他银联卡支付或联系95516
     **/
    PCC42007,
    /**
     * 交易不在受理时间范围内
     **/
    PCC42009,
    /**
     * 扣款成功但交易超过规定支付时间
     **/
    PCC42010,
    /**
     * 交易失败，详情请咨询您的发卡行
     **/
    PCC42011,
    /**
     * 交易失败，发卡银行不支持该商户，请更换其他银行卡
     **/
    PCC42012,
    /**
     * 您的输入超时，交易失败
     **/
    PCC42013,
    /**
     * 交易已跳转，等待持卡人输入
     **/
    PCC42014,
    /**
     * 您尚未在银行网点柜面或个人网银签约加办银联无卡支付业务，请去柜面或网银开通或拨打
     **/
    PCC42015,
    /**
     * 需要验密开通
     **/
    PCC42018,
    /**
     * 银行卡未开通认证支付
     **/
    PCC42019,
    /**
     * 发卡行交易权限受限，详情请咨询您的发卡行
     **/
    PCC42020,
    /**
     * 此卡可用，但发卡行暂不支持短信验证
     **/
    PCC42021,
    /**
     * 交易失败，Token 已过期
     **/
    PCC42022,
    /**
     * 失败已冲正
     **/
    PCC42037,
    /**
     * 账务处理成功
     **/
    PCC42038,
    /**
     * 单笔扣款流水同时只受理一笔退款
     **/
    PCC43001,
    /**
     * 退款金额与原交易金额不符
     **/
    PCC43002,
    /**
     * 退款总金额大于原交易金额
     **/
    PCC43003,
    /**
     * 原交易非成功状态不能退款
     **/
    PCC43004,
    /**
     * 未实名认证或认证不通过
     **/
    PCC02231,
    /**
     * 账号或户名不正确
     **/
    PCC02240,
    /**
     * 证件号码或类型不正确
     **/
    PCC02241,
    /**
     * 银行预留手机号不正确
     **/
    PCC02242,
    /**
     * 证件类型不正确，或暂不支持该类型
     **/
    PCC02243,
    /**
     * 输入的密码、有效期或CVN2不正确
     **/
    PCC02244,
    /**
     * 密码错误
     **/
    PCC10180,
    /**
     * 卡上的余额不足
     **/
    PCC22011,
    /**
     * 输入的密码、有效期或CVN2有误，交易失败
     **/
    PCC22012,
    /**
     * 持卡人身份信息或手机号输入不正确，验证失败
     **/
    PCC22013,
    /**
     * 密码输入次数超限
     **/
    PCC22014,
    /**
     * 您的银行卡暂不支持该业务，请向您的银行或95516咨询
     **/
    PCC22015,
    /**
     * 身份信息或手机号输入不正确，验证失败
     **/
    PCC30120,
    /**
     * 账户状态异常
     **/
    PCC10200,
    /**
     * 付款人账号异常
     **/
    PCC41104,
    /**
     * 收款人账号异常
     **/
    PCC41105,
    /**
     * 实际付款人账号异常
     **/
    PCC41112,
    /**
     * 账号存在可疑
     **/
    PCC41113,
    /**
     * 已超过最大查询次数或操作过于频繁
     **/
    PCC32004,
    /**
     * 客户账户存在限制，不允许支取
     **/
    PCC50031,
    /**
     * 账户余额不足
     **/
    PCC50034,
    /**
     * 核心记账失败
     **/
    PCC50001,
    /**
     * 路由为空
     **/
    PCC40801,
    /**
     * 原交易不存在
     **/
    PCC80002,
    /**
     * 必输项为空
     **/
    PCC90008,
    /**
     * 系统错误
     **/
    PCC10001,;


    private static Set<String> failureRespcodeSet = new HashSet<>(100);

    static {
        failureRespcodeSet.add(PCC02220.name());
        failureRespcodeSet.add(PCC02222.name());
        failureRespcodeSet.add(PCC02223.name());
        failureRespcodeSet.add(PCC02224.name());
        failureRespcodeSet.add(PCC02225.name());
        failureRespcodeSet.add(PCC02226.name());
        failureRespcodeSet.add(PCC02227.name());
        failureRespcodeSet.add(PCC02245.name());
        failureRespcodeSet.add(PCC02246.name());
        failureRespcodeSet.add(PCC02250.name());
        failureRespcodeSet.add(PCC02251.name());
        failureRespcodeSet.add(PCC02252.name());
        failureRespcodeSet.add(PCC02253.name());
        failureRespcodeSet.add(PCC02254.name());
        failureRespcodeSet.add(PCC02255.name());
        failureRespcodeSet.add(PCC02256.name());
        failureRespcodeSet.add(PCC02257.name());
        failureRespcodeSet.add(PCC02270.name());
        failureRespcodeSet.add(PCC02293.name());
        failureRespcodeSet.add(PCC02294.name());
        failureRespcodeSet.add(PCC10181.name());
        failureRespcodeSet.add(PCC20002.name());
        failureRespcodeSet.add(PCC20032.name());
        failureRespcodeSet.add(PCC22006.name());

        failureRespcodeSet.add(PCC22007.name());
        failureRespcodeSet.add(PCC22009.name());
        failureRespcodeSet.add(PCC22010.name());
        failureRespcodeSet.add(PCC22016.name());
        failureRespcodeSet.add(PCC22017.name());
        failureRespcodeSet.add(PCC22018.name());
        failureRespcodeSet.add(PCC30010.name());

        failureRespcodeSet.add(PCC30010.name());
        failureRespcodeSet.add(PCC30020.name());
        failureRespcodeSet.add(PCC30030.name());
        failureRespcodeSet.add(PCC30050.name());
        failureRespcodeSet.add(PCC30060.name());
        failureRespcodeSet.add(PCC30070.name());
        failureRespcodeSet.add(PCC30080.name());
        failureRespcodeSet.add(PCC30090.name());

        failureRespcodeSet.add(PCC30100.name());
        failureRespcodeSet.add(PCC30110.name());
        failureRespcodeSet.add(PCC40803.name());

        failureRespcodeSet.add(PCC40804.name());
        failureRespcodeSet.add(PCC40805.name());
        failureRespcodeSet.add(PCC40806.name());
        failureRespcodeSet.add(PCC40807.name());
        failureRespcodeSet.add(PCC41101.name());
        failureRespcodeSet.add(PCC41114.name());
        failureRespcodeSet.add(PCC41115.name());
        failureRespcodeSet.add(PCC42007.name());
        failureRespcodeSet.add(PCC42009.name());
        failureRespcodeSet.add(PCC42011.name());
        failureRespcodeSet.add(PCC42012.name());
        failureRespcodeSet.add(PCC42013.name());
        failureRespcodeSet.add(PCC42014.name());
        failureRespcodeSet.add(PCC42015.name());
        failureRespcodeSet.add(PCC42018.name());
        failureRespcodeSet.add(PCC42019.name());
        failureRespcodeSet.add(PCC42020.name());
        failureRespcodeSet.add(PCC42021.name());
        failureRespcodeSet.add(PCC42022.name());
        failureRespcodeSet.add(PCC42037.name());
        failureRespcodeSet.add(PCC43001.name());
        failureRespcodeSet.add(PCC43002.name());
        failureRespcodeSet.add(PCC43003.name());
        failureRespcodeSet.add(PCC43004.name());
        failureRespcodeSet.add(PCC02231.name());
        failureRespcodeSet.add(PCC02240.name());
        failureRespcodeSet.add(PCC02241.name());
        failureRespcodeSet.add(PCC02242.name());
        failureRespcodeSet.add(PCC02243.name());
        failureRespcodeSet.add(PCC02244.name());
        failureRespcodeSet.add(PCC10180.name());
        failureRespcodeSet.add(PCC22011.name());
        failureRespcodeSet.add(PCC22012.name());
        failureRespcodeSet.add(PCC22013.name());
        failureRespcodeSet.add(PCC22014.name());
        failureRespcodeSet.add(PCC22015.name());
        failureRespcodeSet.add(PCC30120.name());
        failureRespcodeSet.add(PCC10200.name());
        failureRespcodeSet.add(PCC41104.name());
        failureRespcodeSet.add(PCC41105.name());
        failureRespcodeSet.add(PCC41112.name());
        failureRespcodeSet.add(PCC41113.name());
        failureRespcodeSet.add(PCC32004.name());
        failureRespcodeSet.add(PCC50031.name());
        failureRespcodeSet.add(PCC50034.name());
        failureRespcodeSet.add(PCC50001.name());
        failureRespcodeSet.add(PCC40801.name());
        failureRespcodeSet.add(PCC80002.name());
        failureRespcodeSet.add(PCC90008.name());


    }

    public static boolean isFailureRespcode(String respCode) {
        return failureRespcodeSet.contains(respCode);
    }
}
