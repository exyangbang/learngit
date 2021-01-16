package cn.kingnet.utp.scheduler.data.entity;

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

@TableName("t_industry_sync_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.IndustrySyncLogMapper")
public class IndustrySyncLog extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 平台号 客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 资金账户表中的资金账号
     */
    @TableField(value = "fund_account_no")
    private String fundAccountNo;

    /**
     * 上次同步日期 yyyyMMdd
     */
    @TableField(value = "last_date")
    private String lastDate;

    /**
     * 最后同步时间HHmm
     */
    @TableField(value = "last_time")
    private String lastTime;

    /**
     * 来款账户名称
     */
    @TableField(value = "remark")
    private String remark;

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
}