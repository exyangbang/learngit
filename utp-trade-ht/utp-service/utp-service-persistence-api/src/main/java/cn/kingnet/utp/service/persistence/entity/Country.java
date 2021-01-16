package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.CountryVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_country")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.CountryMapper")
public class Country extends BaseEntity {
    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER)
    private Integer id;

    /**
     * 二位字母
     */
    @TableField(value = "two_bit_letters")
    private String twoBitLetters;

    /**
     * 三位字母
     */
    @TableField(value = "three_bit_letters")
    private String threeBitLetters;

    /**
     * 数字代码
     */
    @TableField(value = "num_code")
    private Integer numCode;

    /**
     * 英文名称
     */
    @TableField(value = "eng_name")
    private String engName;

    /**
     * 中文名称
     */
    @TableField(value = "ch_name")
    private String chName;

    public CountryVo buildVo() {
        return new CountryVo(id, twoBitLetters, threeBitLetters, numCode, engName, chName);
    }

    public static Country of(CountryVo vo) {
        return new Country(vo.getId(), vo.getTwoBitLetters(), vo.getThreeBitLetters(), vo.getNumCode(), vo.getEngName(), vo.getChName());
    }
}