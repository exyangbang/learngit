package cn.kingnet.utp.trade.common.enums;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月18日
 */
public enum SplitStatus {

    /**
     * 分账未处理
     */
    SPLIT_UNDO("0"),
    /**
     * 分账已处理
     */
    SPLIT_OK("1");

    private String status;

    SplitStatus(String status) {
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
