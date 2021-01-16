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
public class CollectAccountWithdrawVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 提现客户端流水号
     */
    private String clientTransId;

    /**
     * 归集账户客户号
     */
    private String industryCode;

    /**
     * 归集客户号名称
     */
    private String industryName;

    /**
     * 归集账户虚拟账号
     */
    private String account;

    /**
     * 提现金额（单位分）
     */
    private Long amount;

    /**
     * 收款方银行账号
     */
    private String reciveAccountNo;

    /**
     * 收款方名称
     */
    private String reciveAccountName;

    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     */
    private String auditStatus;

    /**
     * 状态（0-不可用 1-可用）
     */
    private String status;

    /**
     * 提现请求日期yyyyMMdd
     */
    private String reqDate;

    /**
     * 提现请求时间HHmmss
     */
    private String reqTime;

    /**
     * 收款方开户行号
     */
    private String reciveOpBankCode;

    /**
     * 收款方开户行名称
     */
    private String reciveOpBankName;

    /**
     * 收款方清算行号
     */
    private String reciveClBankCode;

    /**
     * 资金账号
     */
    private String fundAccountNo;

    /**
     * 资金账户名称
     */
    private String fundAccountName;

    /**
     * 交易状态
     */
    private String transStatus;

    /**
     * 交易状态描述
     */
    private String transDesc;

    /**
     * 服务端流水号
     */
    private String serverTransId;
}