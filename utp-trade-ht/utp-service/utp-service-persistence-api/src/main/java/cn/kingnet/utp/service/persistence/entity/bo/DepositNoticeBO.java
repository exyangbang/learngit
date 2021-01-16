package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.vo.AccountDetailVo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * @author zhongli
 * @date 2019-02-25 
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepositNoticeBO extends AccountDetailVo {
    private Long id;
    /**
     * 通知状态  0=未通知 2=已通知
     */
    private int noticeStatus;

    /**
     * 远程调用异常
     */
    private int remoteExceptionCount = 0;
    /**
     * 通知次数
     */
    private int noticeCount = 0;

    private String time;

    /**
     * 报文内容
     */
    private Map<String, String> content;

}
