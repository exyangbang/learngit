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
public class TransOrderRelationVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 客户请求流水号
     */
    private String clientTransId;

    /**
     * 服务端流水号
     */
    private String serverTransId;

    /**
     * 关联外部支付订单表ID
     */
    private Long outsideTransOrderId;

    /**
     * 外部支付订单号
     */
    private String transOrderId;

    /**
     * 交易金额(分)
     */
    private Long transAmount;

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
}