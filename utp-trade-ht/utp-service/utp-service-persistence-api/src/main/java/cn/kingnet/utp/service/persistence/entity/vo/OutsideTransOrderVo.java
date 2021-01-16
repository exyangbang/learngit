package cn.kingnet.utp.service.persistence.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OutsideTransOrderVo implements java.io.Serializable {
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
     * 平台编码
     */
    private String industryCode;

    /**
     * 批次号
     */
    private String batchId;

    /**
     * 请求日期yyyyMMdd
     */
    private String reqDate;

    /**
     * 请求时间HHmmss
     */
    private String reqTime;

    /**
     * 交易日期yyyyMMdd
     */
    private String transDate;

    /**
     * 交易时间HHmmss
     */
    private String transTime;

    /**
     * 交易支付订单号
     */
    private String transOrderId;

    /**
     * 交易商户号
     */
    private String merNo;

    /**
     * 支付方式|0支付宝 1微信 2银联  3无正向支付流水  9其他支付方式 99客户初始化
     */
    private String payMode;

    /**
     * 交易金额单位分
     */
    private Long transAmount;

    /**
     * 卖方名称
     */
    private String sellerName;

    /**
     * 买方名称
     */
    private String buyerName;

    /**
     * 商品信息(描述)
     */
    private String goodsInfo;

    /**
     * 上送状态成功：SUCCESS | 失败：FAILURE
     */
    private String uploadStatus;

    /**
     * 上送状态描述
     */
    private String uploadDesc;

    /**
     * 是否已被关联分账标志
     */
    private String splitStatus;

    /**
     * 已关联分账记录数
     */
    private Integer linkedSplitNum;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 商户手机号码
     */
    private String merPhone;

    /**
     * 支付机构编号
     */
    private String txnChannel;

    /**
     * 收单机构生成的订单编号
     */
    private String txnChannelTradeNo;

    /**
     * 优惠金额
     */
    private Long discountAmount;

    /**
     * 付款方ID
     */
    private String buyerId;

    /**
     * 付款方手机号码
     */
    private String buyerPhone;

    /**
     * 物流信息
     */
    private String logistics;

    /**
     * remark文件sftp完整地址转换完成标识 0未转换 1已转换 2转换异常 3无需转换
     */
    private Integer fileConvertFlag;

    /**
     * 转换说明
     */
    private String fileConvertDesc;

    /**
     * 回调通知地址
     */
    private String callbackUrl;

    /**
     * 备注信息
     */
    private String remark;
}
