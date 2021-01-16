package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.ClearBankCodeVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_clear_bank_code")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.ClearBankCodeMapper")
public class ClearBankCode extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

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

    /**
     * 开户行号
     */
    @TableField(value = "op_bank_code")
    private String opBankCode;

    /**
     * 开户行行名
     */
    @TableField(value = "op_bank_name")
    private String opBankName;

    /**
     * 清算行代码
     */
    @TableField(value = "cl_bank_code")
    private String clBankCode;

    /**
     * 清算行行名
     */
    @TableField(value = "cl_bank_name")
    private String clBankName;

    public ClearBankCodeVo buildVo() {
        return new ClearBankCodeVo(id, userCreate, gmtCreate, userModified, gmtModified, opBankCode, opBankName, clBankCode, clBankName);
    }

    public static ClearBankCode of(ClearBankCodeVo vo) {
        return new ClearBankCode(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getOpBankCode(), vo.getOpBankName(), vo.getClBankCode(), vo.getClBankName());
    }
}