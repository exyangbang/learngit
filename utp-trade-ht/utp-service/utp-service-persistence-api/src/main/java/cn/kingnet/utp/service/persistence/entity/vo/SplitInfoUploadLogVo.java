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
public class SplitInfoUploadLogVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

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

    /**
     * 平台编码/客户号
     */
    private String providerCode;

    /**
     * 清算日期 格式为yyyyMMdd
     */
    private String settleDate;

    /**
     * 批次Id
     */
    private String batchId;

    /**
     * 总笔数	
     */
    private Long count;

    /**
     * 交易状态|同交易表状态
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
     * 上送交易日期yyyyMMdd
     */
    private String transDate;

    /**
     * 上送交易时间HHmmss
     */
    private String transTime;

    /**
     * 已回调次数
     */
    private Integer callbackTimes;
}