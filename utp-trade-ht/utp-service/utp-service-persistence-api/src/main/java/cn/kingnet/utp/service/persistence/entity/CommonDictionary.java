package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.CommonDictionaryVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_common_dictionary")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.CommonDictionaryMapper")
public class CommonDictionary extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    @TableField(value = "type")
    private String type;

    @TableField(value = "description")
    private String description;

    @TableField(value = "system_id")
    private Long systemId;

    @TableField(value = "key")
    private String key;

    @TableField(value = "value")
    private String value;

    public CommonDictionaryVo buildVo() {
        return new CommonDictionaryVo(id, type, description, systemId, key, value);
    }

    public static CommonDictionary of(CommonDictionaryVo vo) {
        return new CommonDictionary(vo.getId(), vo.getType(), vo.getDescription(), vo.getSystemId(), vo.getKey(), vo.getValue());
    }
}