package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.TransOrderRelationVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_trans_order_relation")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.TransOrderRelationMapper")
public class TransOrderRelation extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 客户请求流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 关联外部支付订单表ID
     */
    @TableField(value = "outside_trans_order_id")
    private Long outsideTransOrderId;

    /**
     * 外部支付订单号
     */
    @TableField(value = "trans_order_id")
    private String transOrderId;

    /**
     * 交易金额(分)
     */
    @TableField(value = "trans_amount")
    private Long transAmount;

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

    public TransOrderRelationVo buildVo() {
        return new TransOrderRelationVo(id, clientTransId, serverTransId, outsideTransOrderId, transOrderId, transAmount, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static TransOrderRelation of(TransOrderRelationVo vo) {
        return new TransOrderRelation(vo.getId(), vo.getClientTransId(), vo.getServerTransId(), vo.getOutsideTransOrderId(), vo.getTransOrderId(), vo.getTransAmount(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}