package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.scheduler.data.entity.vo.OutsideTransOrderVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_outside_trans_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.OutsideTransOrderMapper")
public class OutsideTransOrder extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 平台编码
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 批次号
     */
    @TableField(value = "batch_id")
    private String batchId;

    /**
     * 请求日期yyyyMMdd
     */
    @TableField(value = "req_date")
    private String reqDate;

    /**
     * 请求时间HHmmss
     */
    @TableField(value = "req_time")
    private String reqTime;

    /**
     * 交易日期yyyyMMdd
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 交易时间HHmmss
     */
    @TableField(value = "trans_time")
    private String transTime;

    /**
     * 交易支付订单号
     */
    @TableField(value = "trans_order_id")
    private String transOrderId;

    /**
     * 交易商户号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 支付方式|0支付宝 1微信 2银联  3无正向支付流水  9其他支付方式 99客户初始化
     */
    @TableField(value = "pay_mode")
    private String payMode;

    /**
     * 交易金额单位分
     */
    @TableField(value = "trans_amount")
    private Long transAmount;

    /**
     * 卖方名称
     */
    @TableField(value = "seller_name")
    private String sellerName;

    /**
     * 买方名称
     */
    @TableField(value = "buyer_name")
    private String buyerName;

    /**
     * 商品信息(描述)
     */
    @TableField(value = "goods_info")
    private String goodsInfo;

    /**
     * 上送状态成功：SUCCESS | 失败：FAILURE
     */
    @TableField(value = "upload_status")
    private String uploadStatus;

    /**
     * 上送状态描述
     */
    @TableField(value = "upload_desc")
    private String uploadDesc;

    /**
     * 是否已被关联分账标志
     */
    @TableField(value = "split_status")
    private String splitStatus;

    /**
     * 已关联分账记录数
     */
    @TableField(value = "linked_split_num")
    private Integer linkedSplitNum;

    /**
     * 商户名称
     */
    @TableField(value = "mer_name")
    private String merName;

    /**
     * 商户手机号码
     */
    @TableField(value = "mer_phone")
    private String merPhone;

    /**
     * 支付机构编号
     */
    @TableField(value = "txn_channel")
    private String txnChannel;

    /**
     * 收单机构生成的订单编号
     */
    @TableField(value = "txn_channel_trade_no")
    private String txnChannelTradeNo;

    /**
     * 优惠金额
     */
    @TableField(value = "discount_amount")
    private Long discountAmount;

    /**
     * 付款方ID
     */
    @TableField(value = "buyer_id")
    private String buyerId;

    /**
     * 付款方手机号码
     */
    @TableField(value = "buyer_phone")
    private String buyerPhone;

    /**
     * 物流信息
     */
    @TableField(value = "logistics")
    private String logistics;

    /**
     * remark文件sftp完整地址转换完成标识 0未转换 1已转换 2转换异常 3无需转换
     */
    @TableField(value = "file_convert_flag")
    private Integer fileConvertFlag;

    /**
     * 转换说明
     */
    @TableField(value = "file_convert_desc")
    private String fileConvertDesc;

    /**
     * 回调通知地址
     */
    @TableField(value = "callback_url")
    private String callbackUrl;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    private String remark;

    public OutsideTransOrderVo buildVo() {
        return new OutsideTransOrderVo(id, userCreate, gmtCreate, userModified, gmtModified, industryCode, batchId, reqDate, reqTime, transDate, transTime, transOrderId, merNo, payMode, transAmount, sellerName, buyerName, goodsInfo, uploadStatus, uploadDesc, splitStatus, linkedSplitNum, merName, merPhone, txnChannel, txnChannelTradeNo, discountAmount, buyerId, buyerPhone, logistics, fileConvertFlag, fileConvertDesc, callbackUrl, remark);
    }

    public static OutsideTransOrder of(OutsideTransOrderVo vo) {
        return new OutsideTransOrder(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getIndustryCode(), vo.getBatchId(), vo.getReqDate(), vo.getReqTime(), vo.getTransDate(), vo.getTransTime(), vo.getTransOrderId(), vo.getMerNo(), vo.getPayMode(), vo.getTransAmount(), vo.getSellerName(), vo.getBuyerName(), vo.getGoodsInfo(), vo.getUploadStatus(), vo.getUploadDesc(), vo.getSplitStatus(), vo.getLinkedSplitNum(), vo.getMerName(), vo.getMerPhone(), vo.getTxnChannel(), vo.getTxnChannelTradeNo(), vo.getDiscountAmount(), vo.getBuyerId(), vo.getBuyerPhone(), vo.getLogistics(), vo.getFileConvertFlag(), vo.getFileConvertDesc(), vo.getCallbackUrl(), vo.getRemark());
    }
}
