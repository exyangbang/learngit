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
public class SubaccountsAmtLimitVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 代付客户号
     */
    private String industryCode;

    /**
     * 代付客户id
     */
    private Long industryId;

    /**
     * 子账号 名称
     */
    private String subObjName;

    /**
     * 子账号 虚拟账户账号
     */
    private String subAccount;

    /**
     * 子账户单笔限额（单位分）
     */
    private Long subaccountsIndividualAmt;

    /**
     * 子账户单日限额（单位分）
     */
    private Long subaccountsDateAmt;

    /**
     * 备注
     */
    private String remark;
}