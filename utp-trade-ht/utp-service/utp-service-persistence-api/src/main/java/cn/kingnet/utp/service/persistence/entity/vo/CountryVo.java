package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CountryVo implements java.io.Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 二位字母
     */
    private String twoBitLetters;

    /**
     * 三位字母
     */
    private String threeBitLetters;

    /**
     * 数字代码
     */
    private Integer numCode;

    /**
     * 英文名称
     */
    private String engName;

    /**
     * 中文名称
     */
    private String chName;
}