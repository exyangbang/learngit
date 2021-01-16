package cn.kingnet.utp.reconciliation.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_merchant_reconcile_record")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.reconciliation.data.mapper.MerchantReconcileRecordMapper")
public class MerchantReconcileRecord extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 对账日期
     */
    @TableField(value = "reconcile_date")
    private String reconcileDate;

    /**
     * 渠道标识
     */
    @TableField(value = "channel_key")
    private String channelKey;

    /**
     * 商户号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 对账状态 0未对账 1已对账
     */
    @TableField(value = "reconcile_status")
    private String reconcileStatus;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 对账关联任务
     */
    @TableField(value = "job_name")
    private String jobName;

    /**
     * 任务启动参数 json 字符串
     */
    @TableField(value = "job_params")
    private String jobParams;
}