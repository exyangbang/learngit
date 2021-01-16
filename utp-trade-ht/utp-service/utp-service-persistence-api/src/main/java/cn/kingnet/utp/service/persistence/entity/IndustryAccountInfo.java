package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.IndustryAccountInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_industry_account_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.IndustryAccountInfoMapper")
public class IndustryAccountInfo extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 平台号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    @TableField(value = "account_no")
    private String accountNo;

    @TableField(value = "account_name")
    private String accountName;

    /**
     * 开户行行号
     */
    @TableField(value = "bank_code")
    private String bankCode;

    /**
     * 开户行行名称
     */
    @TableField(value = "bank_name")
    private String bankName;

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
     * 1:平台|行业账户,4-手续费收入账户 5-手续费支出账户
     */
    @TableField(value = "industry_type")
    private String industryType;

    public IndustryAccountInfoVo buildVo() {
        return new IndustryAccountInfoVo(id, industryCode, accountNo, accountName, bankCode, bankName, gmtCreate, gmtModified, userCreate, userModified, industryType);
    }

    public static IndustryAccountInfo of(IndustryAccountInfoVo vo) {
        return new IndustryAccountInfo(vo.getId(), vo.getIndustryCode(), vo.getAccountNo(), vo.getAccountName(), vo.getBankCode(), vo.getBankName(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getIndustryType());
    }
}