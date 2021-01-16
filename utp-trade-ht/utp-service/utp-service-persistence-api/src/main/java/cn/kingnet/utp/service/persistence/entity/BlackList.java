package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.BlackListVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_blacklist")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.BlackListMapper")
public class BlackList extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 证件号
     */
    @TableField(value = "id_code")
    private String idCode;

    /**
     * 备注
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

    /**
     * 1:个人2:企业
     */
    @TableField(value = "obj_type")
    private String objType;

    /**
     * 营业执照号
     */
    @TableField(value = "bus_lic_code")
    private String busLicCode;

    /**
     * 企业名称
     */
    @TableField(value = "ent_name")
    private String entName;

    public BlackListVo buildVo() {
        return new BlackListVo(id, name, idCode, remark, userCreate, gmtCreate, userModified, gmtModified, objType, busLicCode, entName);
    }

    public static BlackList of(BlackListVo vo) {
        return new BlackList(vo.getId(), vo.getName(), vo.getIdCode(), vo.getRemark(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getObjType(), vo.getBusLicCode(), vo.getEntName());
    }
}