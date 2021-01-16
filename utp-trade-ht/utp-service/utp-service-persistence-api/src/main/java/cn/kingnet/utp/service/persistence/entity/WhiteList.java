package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.WhiteListVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_white_list")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.WhiteListMapper")
public class WhiteList extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 客户名称
     */
    @TableField(value = "mer_name")
    private String merName;

    /**
     * 客户简称
     */
    @TableField(value = "mer_abb")
    private String merAbb;

    /**
     * 代付客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 来款方户名
     */
    @TableField(value = "account_name")
    private String accountName;

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

    public WhiteListVo buildVo() {
        return new WhiteListVo(id, merName, merAbb, industryCode, accountName, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static WhiteList of(WhiteListVo vo) {
        return new WhiteList(vo.getId(), vo.getMerName(), vo.getMerAbb(), vo.getIndustryCode(), vo.getAccountName(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}