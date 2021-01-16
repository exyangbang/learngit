package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : 描述枚举
 * @Author : linkaigui
 * @Create : 2019/3/15 15:52
 */
public enum OneBankVirtualAccountQueryRespCode {

    SUCCESS("0000", "00","成功"),
    R01("APA000001", "01", "账户不存在"),
    R02("APA000002", "02", "账户姓名不匹配"),
    R03("APA000003", "03", "账户已注销"),
    R04("APA000004", "04", "限额检查未通过"),
    R05("APA000005", "05","未激活或激活金额错误"),
    R06("APA000006","06", "渠道无权限调用此业务"),
    R07("APA000007", "07","机构实体账户不存在"),
    R08("APA000008","08", "参数[acctNo]错误"),
    R09("APA000009","09", "参数[amt]错误"),
    R10("APA000010","10", "参数[exAcctNo]错误"),
    R11("APA000011","11", "参数[exAcctName]错误"),
    R12("APA000012","12", "参数[reqchid]错误"),
    R13("APA000013","13", "根据账号在批量开户明细表中没有找到记录"),
    R14("APA000014","14", "参数格式错误"),
    R99("APA000099","99", "其他");

    private String headRspCode; //头部响应码
    private String rspCode; //body响应码
    private String desc; //描述

    OneBankVirtualAccountQueryRespCode(String headRspCode, String rspCode, String desc) {
        this.headRspCode = headRspCode;
        this.rspCode = rspCode;
        this.desc = desc;
    }

    public String getHeadRspCode() {
        return headRspCode;
    }

    public String getRspCode() {
        return rspCode;
    }

    public String getDesc() {
        return desc;
    }
}
