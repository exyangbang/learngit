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
public class AccountSettleDetailVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 清算日期 格式为yyyyMMdd
     */
    private String settleDate;

    /**
     * 批次Id
     */
    private String batchId;

    /**
     * 平台编码/客户号
     */
    private String industryCode;

    /**
     * 付款虚拟账户
     */
    private String payerAccount;

    /**
     * 用户号
     */
    private String merNo;

    /**
     * 用户虚拟账户
     */
    private String userAccount;

    /**
     * 金额,单位:分 无小数点
     */
    private Long amount;

    /**
     * 数字， 例如:1 表示账期为 T+1
     */
    private Integer period;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 展示付款账号
     */
    private String showPayerAcctNo;

    /**
     * 展示付款户名
     */
    private String showPayerName;

    /**
     * 清算收款账号
     */
    private String payeeAcctNo;

    /**
     * 清算收款户名
     */
    private String payeeName;

    /**
     * 清算行行号
     */
    private String payeeOpbk;

    /**
     * 备注信息
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
     * 清算处理状态（0-未处理 1-已处理）
     */
    private String handleStatus;

    /**
     * 是否计入提现（0-否 1-是）
     */
    private String provisionFlag;

    /**
     * 交易状态|同交易表状态
     */
    private String transStatus;

    /**
     * 清算结果描述
     */
    private String transDesc;

    /**
     * 渠道标识
     */
    private String channelKey;

    /**
     * 渠道编号
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

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