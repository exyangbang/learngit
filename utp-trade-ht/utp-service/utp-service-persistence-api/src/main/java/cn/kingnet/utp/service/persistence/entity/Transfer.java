package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.TransferVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_trans_transfer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.TransferMapper")
public class Transfer extends BaseEntity {
    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 客户端流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 交易日期
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 交易时间
     */
    @TableField(value = "trans_time")
    private String transTime;

    /**
     * 转出代付客户号
     */
    @TableField(value = "payer_industry_code")
    private String payerIndustryCode;

    /**
     * 转出账户
     */
    @TableField(value = "payer_acc_no")
    private String payerAccNo;

    /**
     * 转出账户名称
     */
    @TableField(value = "payer_acc_name")
    private String payerAccName;

    /**
     * 转入代付客户号
     */
    @TableField(value = "payee_industry_code")
    private String payeeIndustryCode;

    /**
     * 转入账户
     */
    @TableField(value = "payee_acc_no")
    private String payeeAccNo;

    /**
     * 转入账户名称
     */
    @TableField(value = "payee_acc_name")
    private String payeeAccName;

    /**
     * 转入清算行号
     */
    @TableField(value = "payee_bank_code")
    private String payeeBankCode;

    /**
     * 转账金额
     */
    @TableField(value = "pay_amt")
    private Long payAmt;

    /**
     * 回调地址
     */
    @TableField(value = "callback_url")
    private String callbackUrl;

    /**
     * 备注说明
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    public TransferVo buildVo() {
        return new TransferVo(id, clientTransId, serverTransId, transDate, transTime, payerIndustryCode, payerAccNo, payerAccName, payeeIndustryCode, payeeAccNo, payeeAccName, payeeBankCode, payAmt, callbackUrl, remark, status);
    }

    public static Transfer of(TransferVo vo) {
        return new Transfer(vo.getId(), vo.getClientTransId(), vo.getServerTransId(), vo.getTransDate(), vo.getTransTime(), vo.getPayerIndustryCode(), vo.getPayerAccNo(), vo.getPayerAccName(), vo.getPayeeIndustryCode(), vo.getPayeeAccNo(), vo.getPayeeAccName(), vo.getPayeeBankCode(), vo.getPayAmt(), vo.getCallbackUrl(), vo.getRemark(), vo.getStatus());
    }
}