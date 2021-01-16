package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description PR03:处理成功 PR02:处理失败 PR00:处理中；PR07：部分退汇；PR08：全部退汇
 * @Author WJH
 * @Date 2019/04/02
 */
public enum HTPayTranStatus {


    PR00("处理中"),

    PR03("处理成功"),

    PR02("处理失败"),

    PR07("部分退汇"),

    PR08("全部退汇"),;

    private String desc;

    HTPayTranStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static HTPayTranStatus resolve(String transStatus) {
       return Stream.of(values()).filter(o -> o.name().equals(transStatus)).findFirst().orElseThrow(() -> new RuntimeException("未知华通交易状态:" + transStatus));
    }
}
