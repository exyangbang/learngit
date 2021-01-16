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
public class FileUploadLogVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 产品类型/编码
     */
    private String productCode;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 平台编码/客户号
     */
    private String industryCode;

    /**
     * 付款虚拟账户
     */
    private String payerAccount;

    /**
     * 业务日期 格式为yyyyMMdd
     */
    private String bizDate;

    /**
     * 数字， 例如:1 表示账期为 T+1
     */
    private Integer period;

    /**
     * 批次Id
     */
    private String batchId;

    /**
     * 总笔数
     */
    private Long totalCount;

    /**
     * 总金额
     */
    private Long totalAmount;

    /**
     * 交易状态|同交易表状态
     */
    private String transStatus;

    /**
     * 描述
     */
    private String transDesc;

    /**
     * 实际发生总笔数
     */
    private Long realCount;

    /**
     * 实际发生总金额
     */
    private Long realAmount;

    /**
     * 结果回调地址
     */
    private String callbackUrl;

    /**
     * 上送交易日期yyyyMMdd
     */
    private String transDate;

    /**
     * 上送交易时间HHmmss
     */
    private String transTime;

    /**
     * 已回调次数
     */
    private Integer callbackTimes;

    /**
     * 服务端交易流水号
     */
    private String serverTransId;

    /**
     * 客户端交易流水号
     */
    private String clientTransId;

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