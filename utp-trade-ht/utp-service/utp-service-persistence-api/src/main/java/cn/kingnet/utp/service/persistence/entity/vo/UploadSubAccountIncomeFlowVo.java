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
public class UploadSubAccountIncomeFlowVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 客户号
     */
    private String industryCode;

    /**
     * 入金子账户
     */
    private String subAccount;

    /**
     * 入金批次Id
     */
    private String batchNo;

    /**
     * 批次内序号
     */
    private Integer seqNo;

    /**
     * 入金流水id
     */
    private String incomeFlowId;

    /**
     * 入金金额单位分
     */
    private Long incomeAmount;

    /**
     * 备注说明
     */
    private String remark;

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

    private String payFlowIds;
}