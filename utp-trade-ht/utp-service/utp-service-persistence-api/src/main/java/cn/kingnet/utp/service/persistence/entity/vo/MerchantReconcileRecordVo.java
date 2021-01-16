package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MerchantReconcileRecordVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 对账日期
     */
    private String reconcileDate;

    /**
     * 渠道标识
     */
    private String channelKey;

    /**
     * 商户号
     */
    private String merNo;

    /**
     * 对账状态 0未对账 1已对账
     */
    private String reconcileStatus;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 对账关联任务
     */
    private String jobName;

    /**
     * 任务启动参数 json 字符串
     */
    private String jobParams;
}