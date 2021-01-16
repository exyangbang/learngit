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
public class FreezingFundsOpeApprovalVo implements java.io.Serializable {
    private Long id;

    /**
     * 虚拟账户账号
     */
    private String account;

    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户）
     */
    private String objType;

    /**
     * 证件号
     */
    private String busLicCode;

    /**
     * 账户名称
     */
    private String objName;

    /**
     * 客户号
     */
    private String code;

    /**
     * 客户名称
     */
    private String indName;

    /**
     * 操作类型：0-冻结 1-解冻
     */
    private String operationType;

    /**
     * 冻结金额（单位分）
     */
    private Long frozenAmount;

    /**
     * 后管 审核备注
     */
    private String auditRemark;

    /**
     * 服务端交易流水号
     */
    private String serverTransId;

    /**
     * 客户端交易流水号
     */
    private String clinetTransId;

    /**
     * 发起人：0-后管 1-联机
     */
    private String addUsr;

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
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     */
    private String auditStatus;

    /**
     * 联机 返回备注信息
     */
    private String respMsg;

    /**
     * 冻结的id
     */
    private Long freezeId;

    /**
     * 冻结状态（0-待审核 1-审核通过 2-审核驳回）
     */
    private String unfreezeStatus;
}