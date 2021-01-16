package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.SubPayPayeeWhiteListVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_sub_pay_payee_white_list")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.SubPayPayeeWhiteListMapper")
public class SubPayPayeeWhiteList extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 收款账号
     */
    @TableField(value = "payee_account")
    private String payeeAccount;

    /**
     * 收款户名
     */
    @TableField(value = "payee_name")
    private String payeeName;

    /**
     * t_industry表id
     */
    @TableField(value = "industry_id")
    private Long industryId;

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

    public SubPayPayeeWhiteListVo buildVo() {
        return new SubPayPayeeWhiteListVo(id, payeeAccount, payeeName, industryId, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static SubPayPayeeWhiteList of(SubPayPayeeWhiteListVo vo) {
        return new SubPayPayeeWhiteList(vo.getId(), vo.getPayeeAccount(), vo.getPayeeName(), vo.getIndustryId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}