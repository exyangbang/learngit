package cn.kingnet.utp.service.persistence.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UploadSubAccountSettleSplitLogVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 客户号
     */
    private String industryCode;

    /**
     * 请求日期yyyyMMdd
     */
    private String reqDate;

    /**
     * 请求时间HHmmss
     */
    private String reqTime;

    /**
     * 清算日期 格式为yyyyMMdd
     */
    private String settleDate;

    /**
     * 清算出金子账户
     */
    private String userAccount;

    /**
     * 批次Id
     */
    private String batchNo;

    /**
     * 整批次交易状态|同交易表状态
     */
    private String transStatus;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 结果回调地址
     */
    private String callbackUrl;

    /**
     * 已回调次数
     */
    private Integer callbackTimes;

    /**
     * 批次账期0=T0 n=Tn
     */
    private String period;

    /**
     * 回调状态 0未回调 1已回调
     */
    private String callbackStatus;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改用户
     */
    private String userModified;

    /**
     * 修改时间
     */
    private Date gmtModified;
}
