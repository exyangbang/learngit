package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : 描述枚举
 * @Author : linkaigui
 * @Create : 2019/3/16 14:14
 */
public enum OneBankAccountIncomeNoticeRespCode {

    SUCCESS("0000","成功"),
    ER1031001("ER1031001","渠道号为空,或者渠道无此操作权限"),
    ER1031002("ER1031002","请求业务流水号重复"),
    ER1031003("ER1031003","充值金额必须大于0"),
    ER1031004("ER1031004","账号不存在"),
    ER1031005("ER1031005","客户账号已经冻结"),
    ER1031006("ER1031006","客户账号已经注销"),
    ER1031007("ER1031007","三类账户余额必须小于1000元"),
    ER1031008("ER1031008","充值后账户余额超出余额限制"),
    ER1031009("ER1031009","他行来账支付通道未配置"),
    ER1031010("ER1031010","跨转退账核心流水号不能为空"),
    ER1031011("ER1031011","参数[acctNo]错误"),
    ER1031012("ER1031012","参数[amt]错误"),
    ER1031013("ER1031013","参数[rid]错误"),
    ER1031014("ER1031014","参数[exAcctNo]错误"),
    ER1031015("ER1031015","参数[exAcctName]错误"),
    ER1031016("ER1031016","参数[clearBankno]错误"),
    ER1031017("ER1031017","参数[bankName]错误"),
    ER1031018("ER1031018","参数[reqchid]错误"),
    ER1031019("ER1031019","渠道无权限调用此业务"),
    ER1031020("ER1031020","参数[tranDate]错误"),
    ER1031021("ER1031021","参数[tranNo]错误"),
    ER1031022("ER1031022","参数[bizFlag]错误"),
    ER1031023("ER1031023","入账账户有误"),
    ER1031024("ER1031024","参数格式错误"),
    ER1031025("ER1031025","其他");

    private String headRspCode; //头部响应码
    private String desc; //描述

    OneBankAccountIncomeNoticeRespCode(String headRspCode, String desc) {
        this.headRspCode = headRspCode;
        this.desc = desc;
    }

    public String getHeadRspCode() {
        return headRspCode;
    }

    public String getDesc() {
        return desc;
    }
}
