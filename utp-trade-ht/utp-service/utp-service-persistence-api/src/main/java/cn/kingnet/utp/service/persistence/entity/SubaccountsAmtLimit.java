package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.SubaccountsAmtLimitVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_subaccounts_amt_limit")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.SubaccountsAmtLimitMapper")
public class SubaccountsAmtLimit extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

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
     * 代付客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 代付客户id
     */
    @TableField(value = "industry_id")
    private Long industryId;

    /**
     * 子账号 名称
     */
    @TableField(value = "sub_obj_name")
    private String subObjName;

    /**
     * 子账号 虚拟账户账号
     */
    @TableField(value = "sub_account")
    private String subAccount;

    /**
     * 子账户单笔限额（单位分）
     */
    @TableField(value = "subaccounts_individual_amt")
    private Long subaccountsIndividualAmt;

    /**
     * 子账户单日限额（单位分）
     */
    @TableField(value = "subaccounts_date_amt")
    private Long subaccountsDateAmt;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    public SubaccountsAmtLimitVo buildVo() {
        return new SubaccountsAmtLimitVo(id, gmtCreate, gmtModified, userCreate, userModified, industryCode, industryId, subObjName, subAccount, subaccountsIndividualAmt, subaccountsDateAmt, remark);
    }

    public static SubaccountsAmtLimit of(SubaccountsAmtLimitVo vo) {
        return new SubaccountsAmtLimit(vo.getId(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getIndustryCode(), vo.getIndustryId(), vo.getSubObjName(), vo.getSubAccount(), vo.getSubaccountsIndividualAmt(), vo.getSubaccountsDateAmt(), vo.getRemark());
    }
}