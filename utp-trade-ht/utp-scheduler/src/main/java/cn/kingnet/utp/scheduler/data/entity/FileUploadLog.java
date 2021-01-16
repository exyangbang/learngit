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

@TableName("t_file_upload_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.FileUploadLogMapper")
public class FileUploadLog extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 产品类型/编码
     */
    @TableField(value = "product_code")
    private String productCode;

    /**
     * 交易类型
     */
    @TableField(value = "trade_type")
    private String tradeType;

    /**
     * 平台编码/客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 付款虚拟账户
     */
    @TableField(value = "payer_account")
    private String payerAccount;

    /**
     * 业务日期 格式为yyyyMMdd
     */
    @TableField(value = "biz_date")
    private String bizDate;

    /**
     * 数字， 例如:1 表示账期为 T+1
     */
    @TableField(value = "period")
    private Integer period;

    /**
     * 批次Id
     */
    @TableField(value = "batch_id")
    private String batchId;

    /**
     * 总笔数
     */
    @TableField(value = "total_count")
    private Long totalCount;

    /**
     * 总金额
     */
    @TableField(value = "total_amount")
    private Long totalAmount;

    /**
     * 交易状态|同交易表状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 描述
     */
    @TableField(value = "trans_desc")
    private String transDesc;

    /**
     * 实际发生总笔数
     */
    @TableField(value = "real_count")
    private Long realCount;

    /**
     * 实际发生总金额
     */
    @TableField(value = "real_amount")
    private Long realAmount;

    /**
     * 结果回调地址
     */
    @TableField(value = "callback_url")
    private String callbackUrl;

    /**
     * 上送交易日期yyyyMMdd
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 上送交易时间HHmmss
     */
    @TableField(value = "trans_time")
    private String transTime;

    /**
     * 已回调次数
     */
    @TableField(value = "callback_times")
    private Integer callbackTimes;

    /**
     * 服务端交易流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 客户端交易流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 渠道标识
     */
    @TableField(value = "channel_key")
    private String channelKey;

    /**
     * 渠道编号
     */
    @TableField(value = "channel_code")
    private String channelCode;

    /**
     * 渠道名称
     */
    @TableField(value = "channel_name")
    private String channelName;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;
}