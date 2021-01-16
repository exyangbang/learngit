package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.SplitInfoUploadLogVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_split_info_upload_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.SplitInfoUploadLogMapper")
public class SplitInfoUploadLog extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

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

    /**
     * 平台编码/客户号
     */
    @TableField(value = "provider_code")
    private String providerCode;

    /**
     * 清算日期 格式为yyyyMMdd
     */
    @TableField(value = "settle_date")
    private String settleDate;

    /**
     * 批次Id
     */
    @TableField(value = "batch_id")
    private String batchId;

    /**
     * 总笔数	
     */
    @TableField(value = "count")
    private Long count;

    /**
     * 交易状态|同交易表状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 备注说明
     */
    @TableField(value = "remark")
    private String remark;

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

    public SplitInfoUploadLogVo buildVo() {
        return new SplitInfoUploadLogVo(id, userCreate, gmtCreate, userModified, gmtModified, providerCode, settleDate, batchId, count, transStatus, remark, callbackUrl, transDate, transTime, callbackTimes);
    }

    public static SplitInfoUploadLog of(SplitInfoUploadLogVo vo) {
        return new SplitInfoUploadLog(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getProviderCode(), vo.getSettleDate(), vo.getBatchId(), vo.getCount(), vo.getTransStatus(), vo.getRemark(), vo.getCallbackUrl(), vo.getTransDate(), vo.getTransTime(), vo.getCallbackTimes());
    }
}