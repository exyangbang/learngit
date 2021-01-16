package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.MerchantBatchRecordVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_merchant_batch_record")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.MerchantBatchRecordMapper")
public class MerchantBatchRecord extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 渠道编号
     */
    @TableField(value = "channel_code")
    private String channelCode;

    /**
     * 渠道名称
     */
    @TableField(value = "channel_name")
    private String channelName;

    /**
     * 渠道返回代码
     */
    @TableField(value = "channel_resp_code")
    private String channelRespCode;

    /**
     * 渠道返回流水号。单笔交易渠道交易流水号（暂中信无返回此值）；批量交易渠道交易批次号。
     */
    @TableField(value = "channel_resp_id")
    private String channelRespId;

    @TableField(value = "channel_resp_msg")
    private String channelRespMsg;

    /**
     * 渠道返回时间
     */
    @TableField(value = "channel_resp_time")
    private String channelRespTime;

    /**
     * 客户请求流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 服务端批处理号
     */
    @TableField(value = "server_batch_no")
    private String serverBatchNo;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 交易日期(yyyyMMdd)
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 批次状态对象Json字符串
     */
    @TableField(value = "cn_tr_batch")
    private String cnTrBatch;

    /**
     * 批次状态 0-上送文件成功 1-已能够下载批次文件  2-已下载批次回执文件 3-已处理批次回执文件 9-上送文件失败
     */
    @TableField(value = "batch_status")
    private String batchStatus;

    /**
     * 交易时间(HHmmss)
     */
    @TableField(value = "trans_time")
    private String transTime;

    /**
     * 商户编号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 企业入网时分配的企业账号
     */
    @TableField(value = "acc_no")
    private String accNo;

    /**
     * 入网分配的用户名
     */
    @TableField(value = "user_code")
    private String userCode;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 批量文件名称.txt
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 总笔数
     */
    @TableField(value = "count")
    private Long count;

    /**
     * 批次总金额
     */
    @TableField(value = "sum_amount")
    private Long sumAmount;

    public MerchantBatchRecordVo buildVo() {
        return new MerchantBatchRecordVo(id, channelCode, channelName, channelRespCode, channelRespId, channelRespMsg, channelRespTime, clientTransId, serverBatchNo, serverTransId, transDate, cnTrBatch, batchStatus, transTime, merNo, accNo, userCode, gmtCreate, gmtModified, userCreate, fileName, userModified, count, sumAmount);
    }

    public static MerchantBatchRecord of(MerchantBatchRecordVo vo) {
        return new MerchantBatchRecord(vo.getId(), vo.getChannelCode(), vo.getChannelName(), vo.getChannelRespCode(), vo.getChannelRespId(), vo.getChannelRespMsg(), vo.getChannelRespTime(), vo.getClientTransId(), vo.getServerBatchNo(), vo.getServerTransId(), vo.getTransDate(), vo.getCnTrBatch(), vo.getBatchStatus(), vo.getTransTime(), vo.getMerNo(), vo.getAccNo(), vo.getUserCode(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getFileName(), vo.getUserModified(), vo.getCount(), vo.getSumAmount());
    }
}