package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.ChannelRespcodeVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_channel_respcode")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.ChannelRespcodeMapper")
public class ChannelRespcode extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中 
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 渠道响应码
     */
    @TableField(value = "channel_respcode")
    private String channelRespcode;

    /**
     * 渠道响应码描述
     */
    @TableField(value = "channel_respdesc")
    private String channelRespdesc;

    /**
     * 启用状态 0:不启用 1：启用
     */
    @TableField(value = "status")
    private String status;

    /**
     * 备注说明
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

    public ChannelRespcodeVo buildVo() {
        return new ChannelRespcodeVo(id, transStatus, channelRespcode, channelRespdesc, status, remark, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static ChannelRespcode of(ChannelRespcodeVo vo) {
        return new ChannelRespcode(vo.getId(), vo.getTransStatus(), vo.getChannelRespcode(), vo.getChannelRespdesc(), vo.getStatus(), vo.getRemark(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}