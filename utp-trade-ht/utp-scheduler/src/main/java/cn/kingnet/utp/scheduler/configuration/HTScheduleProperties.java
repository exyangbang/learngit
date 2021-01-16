package cn.kingnet.utp.scheduler.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description : 调度任务配置
 */
@ConfigurationProperties(prefix = HTScheduleProperties.SCHEDULER_PREFIX)
@Setter
@Getter
public class HTScheduleProperties {

    public static final String SCHEDULER_PREFIX = "cn.kingnet.utp.schedule.ht-properties";

    /**
     * 清算分账文件存储根目录
     */
    private String settleSplitDir;

    /**
     * 回调文件存储根目录
     */
    private String resultDir;

    /**
     * 通用核心线程数
     */
    private int threadPoolNum ;
    /**
     * 通用最大线程数
     */
    private int maxThreadPoolNum;

    /**
     * 通用等待队列数
     */
    private int blockingQueueNum;



}
