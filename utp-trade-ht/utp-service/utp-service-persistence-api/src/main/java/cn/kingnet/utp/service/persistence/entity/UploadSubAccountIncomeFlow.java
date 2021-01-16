package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.UploadSubAccountIncomeFlowVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_upload_subaccount_income_flow")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.UploadSubAccountIncomeFlowMapper")
public class UploadSubAccountIncomeFlow extends BaseEntity {
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
     * 入金子账户
     */
    @TableField(value = "sub_account")
    private String subAccount;

    /**
     * 入金批次Id
     */
    @TableField(value = "batch_no")
    private String batchNo;

    /**
     * 批次内序号
     */
    @TableField(value = "seq_no")
    private Integer seqNo;

    /**
     * 入金流水id
     */
    @TableField(value = "income_flow_id")
    private String incomeFlowId;

    /**
     * 入金金额单位分
     */
    @TableField(value = "income_amount")
    private Long incomeAmount;

    /**
     * 备注说明
     */
    @TableField(value = "remark")
    private String remark;

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

    @TableField(value = "pay_flow_ids")
    private String payFlowIds;

    public UploadSubAccountIncomeFlowVo buildVo() {
        return new UploadSubAccountIncomeFlowVo(id, industryCode, subAccount, batchNo, seqNo, incomeFlowId, incomeAmount, remark, userCreate, gmtCreate, userModified, gmtModified, payFlowIds);
    }

    public static UploadSubAccountIncomeFlow of(UploadSubAccountIncomeFlowVo vo) {
        return new UploadSubAccountIncomeFlow(vo.getId(), vo.getIndustryCode(), vo.getSubAccount(), vo.getBatchNo(), vo.getSeqNo(), vo.getIncomeFlowId(), vo.getIncomeAmount(), vo.getRemark(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getPayFlowIds());
    }
}