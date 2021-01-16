package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.CollectAccountWithdrawVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_collect_account_withdraw")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.CollectAccountWithdrawMapper")
public class CollectAccountWithdraw extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 提现客户端流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 归集账户客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 归集客户号名称
     */
    @TableField(value = "industry_name")
    private String industryName;

    /**
     * 归集账户虚拟账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 提现金额（单位分）
     */
    @TableField(value = "amount")
    private Long amount;

    /**
     * 收款方银行账号
     */
    @TableField(value = "recive_account_no")
    private String reciveAccountNo;

    /**
     * 收款方名称
     */
    @TableField(value = "recive_account_name")
    private String reciveAccountName;

    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     */
    @TableField(value = "audit_status")
    private String auditStatus;

    /**
     * 状态（0-不可用 1-可用）
     */
    @TableField(value = "status")
    private String status;

    /**
     * 提现请求日期yyyyMMdd
     */
    @TableField(value = "req_date")
    private String reqDate;

    /**
     * 提现请求时间HHmmss
     */
    @TableField(value = "req_time")
    private String reqTime;

    /**
     * 收款方开户行号
     */
    @TableField(value = "recive_op_bank_code")
    private String reciveOpBankCode;

    /**
     * 收款方开户行名称
     */
    @TableField(value = "recive_op_bank_name")
    private String reciveOpBankName;

    /**
     * 收款方清算行号
     */
    @TableField(value = "recive_cl_bank_code")
    private String reciveClBankCode;

    /**
     * 资金账号
     */
    @TableField(value = "fund_account_no")
    private String fundAccountNo;

    /**
     * 资金账户名称
     */
    @TableField(value = "fund_account_name")
    private String fundAccountName;

    /**
     * 交易状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 交易状态描述
     */
    @TableField(value = "trans_desc")
    private String transDesc;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    public CollectAccountWithdrawVo buildVo() {
        return new CollectAccountWithdrawVo(id, gmtCreate, gmtModified, userCreate, userModified, clientTransId, industryCode, industryName, account, amount, reciveAccountNo, reciveAccountName, auditStatus, status, reqDate, reqTime, reciveOpBankCode, reciveOpBankName, reciveClBankCode, fundAccountNo, fundAccountName, transStatus, transDesc, serverTransId);
    }

    public static CollectAccountWithdraw of(CollectAccountWithdrawVo vo) {
        return new CollectAccountWithdraw(vo.getId(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getClientTransId(), vo.getIndustryCode(), vo.getIndustryName(), vo.getAccount(), vo.getAmount(), vo.getReciveAccountNo(), vo.getReciveAccountName(), vo.getAuditStatus(), vo.getStatus(), vo.getReqDate(), vo.getReqTime(), vo.getReciveOpBankCode(), vo.getReciveOpBankName(), vo.getReciveClBankCode(), vo.getFundAccountNo(), vo.getFundAccountName(), vo.getTransStatus(), vo.getTransDesc(), vo.getServerTransId());
    }
}