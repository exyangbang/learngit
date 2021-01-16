package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TransferVo implements java.io.Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 客户端流水号
     */
    private String clientTransId;

    /**
     * 服务端流水号
     */
    private String serverTransId;

    /**
     * 交易日期
     */
    private String transDate;

    /**
     * 交易时间
     */
    private String transTime;

    /**
     * 转出代付客户号
     */
    private String payerIndustryCode;

    /**
     * 转出账户
     */
    private String payerAccNo;

    /**
     * 转出账户名称
     */
    private String payerAccName;

    /**
     * 转入代付客户号
     */
    private String payeeIndustryCode;

    /**
     * 转入账户
     */
    private String payeeAccNo;

    /**
     * 转入账户名称
     */
    private String payeeAccName;

    /**
     * 转入清算行号
     */
    private String payeeBankCode;

    /**
     * 转账金额
     */
    private Long payAmt;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 状态
     */
    private String status;
}