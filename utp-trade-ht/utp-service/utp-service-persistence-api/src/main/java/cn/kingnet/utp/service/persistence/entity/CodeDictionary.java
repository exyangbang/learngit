package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.CodeDictionaryVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_code_dictionary")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.CodeDictionaryMapper")
public class CodeDictionary extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 字典类型 0001:支付机构 0002:行业 0003:职业
     */
    @TableField(value = "type")
    private String type;

    /**
     * key值
     */
    @TableField(value = "code")
    private String code;

    /**
     * 信息名称
     */
    @TableField(value = "value")
    private String value;

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
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    public CodeDictionaryVo buildVo() {
        return new CodeDictionaryVo(id, type, code, value, userCreate, gmtCreate, userModified, gmtModified, remark);
    }

    public static CodeDictionary of(CodeDictionaryVo vo) {
        return new CodeDictionary(vo.getId(), vo.getType(), vo.getCode(), vo.getValue(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getRemark());
    }
}