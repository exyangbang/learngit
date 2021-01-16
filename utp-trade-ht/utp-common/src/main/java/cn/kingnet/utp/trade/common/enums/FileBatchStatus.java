package cn.kingnet.utp.trade.common.enums;

import java.util.Arrays;

/**
 * @Description 批处理文件状态
 * @Author WJH
 * @Date 2020/05/09
 */
public enum FileBatchStatus {
    FAILURE("0", "整批失败"),
    SUCCESS("1", "整批成功"),
    PART_SUCCESS("2", "部分成功"),
    PROCESSING("3", "处理中"),
    ;
    private String status;
    private String desc;

    FileBatchStatus(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static FileBatchStatus ofStatus(String status){
        return Arrays.stream(values()).filter(o -> o.getStatus().equals(status)).findFirst().orElse(FileBatchStatus.PROCESSING);
    }
    public static FileBatchStatus ofName(String name){
        return Arrays.stream(values()).filter(o -> o.name().equals(name)).findFirst().orElse(FileBatchStatus.PROCESSING);
    }
}
