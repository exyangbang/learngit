package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FeeTemplateVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改用户
     */
    private String userModified;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 结算类型
     */
    private String settleType;

    /**
     * 收费模式
     */
    private String chargeMode;

    /**
     * 计算方式
     */
    private String calculateMode;

    /**
     * 手续费
     */
    private Long fee;

    /**
     * 最小手续费
     */
    private Long minFee;

    /**
     * 最大手续费
     */
    private Long maxFee;

    /**
     * 区间内容
     */
    private String content;

    /**
     * 备注信息
     */
    private String remark;
}