package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.FreezingFundsOpeApprovalVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_freezing_funds_ope_approval")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.FreezingFundsOpeApprovalMapper")
public class FreezingFundsOpeApproval extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 虚拟账户账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户）
     */
    @TableField(value = "obj_type")
    private String objType;

    /**
     * 证件号
     */
    @TableField(value = "bus_lic_code")
    private String busLicCode;

    /**
     * 账户名称
     */
    @TableField(value = "obj_name")
    private String objName;

    /**
     * 客户号
     */
    @TableField(value = "code")
    private String code;

    /**
     * 客户名称
     */
    @TableField(value = "ind_name")
    private String indName;

    /**
     * 操作类型：0-冻结 1-解冻
     */
    @TableField(value = "operation_type")
    private String operationType;

    /**
     * 冻结金额（单位分）
     */
    @TableField(value = "frozen_amount")
    private Long frozenAmount;

    /**
     * 后管 审核备注
     */
    @TableField(value = "audit_remark")
    private String auditRemark;

    /**
     * 服务端交易流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 客户端交易流水号
     */
    @TableField(value = "clinet_trans_id")
    private String clinetTransId;

    /**
     * 发起人：0-后管 1-联机
     */
    @TableField(value = "add_usr")
    private String addUsr;

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
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     */
    @TableField(value = "audit_status")
    private String auditStatus;

    /**
     * 联机 返回备注信息
     */
    @TableField(value = "resp_msg")
    private String respMsg;

    /**
     * 冻结的id
     */
    @TableField(value = "freeze_id")
    private Long freezeId;

    /**
     * 冻结状态（0-待审核 1-审核通过 2-审核驳回）
     */
    @TableField(value = "unfreeze_status")
    private String unfreezeStatus;

    public FreezingFundsOpeApprovalVo buildVo() {
        return new FreezingFundsOpeApprovalVo(id, account, objType, busLicCode, objName, code, indName, operationType, frozenAmount, auditRemark, serverTransId, clinetTransId, addUsr, userCreate, gmtCreate, userModified, gmtModified, auditStatus, respMsg, freezeId, unfreezeStatus);
    }

    public static FreezingFundsOpeApproval of(FreezingFundsOpeApprovalVo vo) {
        return new FreezingFundsOpeApproval(vo.getId(), vo.getAccount(), vo.getObjType(), vo.getBusLicCode(), vo.getObjName(), vo.getCode(), vo.getIndName(), vo.getOperationType(), vo.getFrozenAmount(), vo.getAuditRemark(), vo.getServerTransId(), vo.getClinetTransId(), vo.getAddUsr(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getAuditStatus(), vo.getRespMsg(), vo.getFreezeId(), vo.getUnfreezeStatus());
    }
}