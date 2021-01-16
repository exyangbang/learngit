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
public class AccountEntryDetailVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 入账日期 格式为yyyyMMdd
     */
    private String entryDate;

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
     * 账户类型 0-对私 1-对公
     */
    private String accountType;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 卡标记(0-不记名卡,1-记名卡)
     */
    private String cardFlag;

    /**
     * 姓名
     */
    private String accountName;

    /**
     * 身份证号
     */
    private String certNo;

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
     * 入账处理状态（0-未处理 1-已处理）
     */
    private String handleStatus;

    /**
     * 交易状态|同交易表状态
     */
    private String transStatus;

    /**
     * 入账结果描述
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