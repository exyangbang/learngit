package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.UploadSubAccountSettleSplitLogVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_upload_subaccount_settle_split_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.UploadSubAccountSettleSplitLogMapper")
public class UploadSubAccountSettleSplitLog extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 请求日期yyyyMMdd
     */
    @TableField(value = "req_date")
    private String reqDate;

    /**
     * 请求时间HHmmss
     */
    @TableField(value = "req_time")
    private String reqTime;

    /**
     * 清算日期 格式为yyyyMMdd
     */
    @TableField(value = "settle_date")
    private String settleDate;

    /**
     * 清算出金子账户
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 批次Id
     */
    @TableField(value = "batch_no")
    private String batchNo;

    /**
     * 整批次交易状态|同交易表状态
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
     * 已回调次数
     */
    @TableField(value = "callback_times")
    private Integer callbackTimes;

    /**
     * 批次账期0=T0 n=Tn
     */
    @TableField(value = "period")
    private String period;

    /**
     * 回调状态 0未回调 1已回调
     */
    @TableField(value = "callback_status")
    private String callbackStatus;

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

    public UploadSubAccountSettleSplitLogVo buildVo() {
        return new UploadSubAccountSettleSplitLogVo(id, industryCode, reqDate, reqTime, settleDate, userAccount, batchNo, transStatus, remark, callbackUrl, callbackTimes, period, callbackStatus, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static UploadSubAccountSettleSplitLog of(UploadSubAccountSettleSplitLogVo vo) {
        return new UploadSubAccountSettleSplitLog(vo.getId(), vo.getIndustryCode(), vo.getReqDate(), vo.getReqTime(), vo.getSettleDate(), vo.getUserAccount(), vo.getBatchNo(), vo.getTransStatus(), vo.getRemark(), vo.getCallbackUrl(), vo.getCallbackTimes(), vo.getPeriod(), vo.getCallbackStatus(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}