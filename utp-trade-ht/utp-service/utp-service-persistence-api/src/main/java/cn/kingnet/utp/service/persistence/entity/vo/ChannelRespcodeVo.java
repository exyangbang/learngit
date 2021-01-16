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
public class ChannelRespcodeVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中 
     */
    private String transStatus;

    /**
     * 渠道响应码
     */
    private String channelRespcode;

    /**
     * 渠道响应码描述
     */
    private String channelRespdesc;

    /**
     * 启用状态 0:不启用 1：启用
     */
    private String status;

    /**
     * 备注说明
     */
    private String remark;

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