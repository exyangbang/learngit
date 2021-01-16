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
public class SplitInfoVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

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
     * 清算日期 格式为yyyyMMdd
     */
    private String settleDate;

    /**
     * 商户号
     */
    private String merNo;

    /**
     * 金额		M	单位:分   无小数点
     */
    private Long amount;

    /**
     * M	数字， 例如： 1 表示账期为 T+1
     */
    private Integer period;

    /**
     * 入账日期 格式yyyyMMdd(清算日期+实际账期天数)
     */
    private String splitDate;

    /**
     * 账户类型		M	0-对私 1-对公
     */
    private String accountType;

    /**
     * 收款人账号		M
     */
    private String accountNo;

    /**
     * 收款人名称	M
     */
    private String accountName;

    /**
     * 收款人清算行行号		M	
     */
    private String bankCode;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 扩展字段1
     */
    private String extend1;

    /**
     * 扩展字段2
     */
    private String extend2;

    /**
     * 扩展字段3
     */
    private String extend3;

    /**
     * 虚账户分账入账状态（0-未入账 1-已入账）
     */
    private String status;

    /**
     * 文件提供商
     */
    private String providerCode;

    /**
     * 批次Id
     */
    private String batchId;

    /**
     * 发起提现交易日期yyyyMMdd
     */
    private String transDate;

    /**
     * 服务端交易流水号
     */
    private String serverTransId;

    /**
     * 客户端交易流水号
     */
    private String clientTransId;

    /**
     * 交易状态|同交易表状态
     */
    private String transStatus;

    /**
     * 提现结果查询次数
     */
    private Integer queryTimes;

    /**
     * 提现结果描述
     */
    private String transDesc;

    /**
     * 分账主体0-个人 1商户
     */
    private String subject;

    /**
     * 华通清算对账日
     */
    private String reconcileDate;

    /**
     * 用户账户
     */
    private String userAccount;

    /**
     * 结算方式0=代付结算 1=记账结算
     */
    private String settleMode;

    /**
     * 代付客户号
     */
    private String industryCode;
}