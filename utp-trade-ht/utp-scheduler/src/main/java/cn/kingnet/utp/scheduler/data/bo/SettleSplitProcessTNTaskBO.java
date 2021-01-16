package cn.kingnet.utp.scheduler.data.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 清分文件T+n任务参数
 * @Author WJH
 * @Date 2019/10/17
 */
@Getter
@Setter
public class SettleSplitProcessTNTaskBO implements Serializable {

    /**
     * 分账日期
     */
    private String splitDate;

}
