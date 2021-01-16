package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zhongli
 * @date 2019-02-25
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CallbackNoticeBO implements Serializable {
    private Long id;
    private String industryCode;
    private String serverTransId;
    /**
     * 回调地址
     */
    private String callbackUrl;
    /**
     * 通知状态  0=未通知 2=已通知
     */
    private int noticeStatus;
    /**
     * 远程调用异常
     */
    private int remoteExceptionCount;
    private String remoteExceptionMsg;
    /**
     * 通知次数
     */
    private int noticeCount;

    private String time;
    /**
     * 下次执行时间 yyyyMMddHHmmss
     */
    private String nextScore;

    /**
     * 报文内容
     */
    private Map<String, Object> content;

}
