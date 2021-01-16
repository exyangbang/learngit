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
public class UploadSplitPayFlowVo implements java.io.Serializable {
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
     * 备注说明
     */
    private String remark;

    /**
     * 关联支付订单号列表 trans_order_ids
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

    /**
     * 上送状态成功：SUCCESS | 失败：FAILURE
     */
    private String uploadStatus;

    /**
     * 上送状态描述
     */
    private String uploadDesc;
}