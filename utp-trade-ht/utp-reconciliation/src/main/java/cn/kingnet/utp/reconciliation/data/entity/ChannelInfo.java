package cn.kingnet.utp.reconciliation.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_channel_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.reconciliation.data.mapper.ChannelInfoMapper")
public class ChannelInfo extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

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
     * 渠道标识
     */
    @TableField(value = "channel_key")
    private String channelKey;

    /**
     * 渠道名称
     */
    @TableField(value = "channel_name")
    private String channelName;

    /**
     * 渠道编码
     */
    @TableField(value = "channel_code")
    private String channelCode;

    /**
     * 支付产品编码
     */
    @TableField(value = "product_no")
    private String productNo;

    /**
     * 渠道额度
     */
    @TableField(value = "amount")
    private Long amount;

    /**
     * 接入类型
     */
    @TableField(value = "join_type")
    private String joinType;

    /**
     * 请求前台地址
     */
    @TableField(value = "front_url")
    private String frontUrl;

    /**
     * 请求后台地址
     */
    @TableField(value = "back_url")
    private String backUrl;

    /**
     * trid参数
     */
    @TableField(value = "trid")
    private String trid;

    /**
     * trtp参数
     */
    @TableField(value = "trtp")
    private String trtp;

    /**
     * 机构号
     */
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 渠道手续费模板Id
     */
    @TableField(value = "chn_fee_template_id")
    private Long chnFeeTemplateId;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 企业账户
     */
    @TableField(value = "acc_no")
    private String accNo;

    /**
     * 用户编码
     */
    @TableField(value = "user_code")
    private String userCode;
}