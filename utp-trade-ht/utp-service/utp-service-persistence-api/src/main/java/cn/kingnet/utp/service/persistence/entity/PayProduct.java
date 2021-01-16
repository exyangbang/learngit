package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.PayProductVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_pay_product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.PayProductMapper")
public class PayProduct extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    @TableField(value = "user_create")
    private String userCreate;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "user_modified")
    private String userModified;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

    @TableField(value = "code")
    private String code;

    @TableField(value = "name")
    private String name;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "status")
    private String status;

    public static PayProduct of(PayProductVo vo) {
        return new PayProduct(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getCode(), vo.getName(), vo.getRemark(), vo.getStatus());
    }

    public PayProductVo buildVo() {
        return new PayProductVo(id, userCreate, gmtCreate, userModified, gmtModified, code, name, remark, status);
    }
}