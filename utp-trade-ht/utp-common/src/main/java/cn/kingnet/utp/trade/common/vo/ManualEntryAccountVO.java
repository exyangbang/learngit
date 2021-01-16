package cn.kingnet.utp.trade.common.vo;

/**
 * @Description : 描述
 * @Author : linkaigui
 * @Create : 2019/3/22 18:31
 */
public class ManualEntryAccountVO {

    /**银行账户明细ID*/
    private Long transId;

    /**虚拟账户*/
    private String account;

    /**修改用户*/
    private String userModified;

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserModified() {
        return userModified;
    }

    public void setUserModified(String userModified) {
        this.userModified = userModified;
    }
}
