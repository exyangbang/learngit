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
public class MerchantBatchRecordVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 渠道编号
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道返回代码
     */
    private String channelRespCode;

    /**
     * 渠道返回流水号。单笔交易渠道交易流水号（暂中信无返回此值）；批量交易渠道交易批次号。
     */
    private String channelRespId;

    private String channelRespMsg;

    /**
     * 渠道返回时间
     */
    private String channelRespTime;

    /**
     * 客户请求流水号
     */
    private String clientTransId;

    /**
     * 服务端批处理号
     */
    private String serverBatchNo;

    /**
     * 服务端流水号
     */
    private String serverTransId;

    /**
     * 交易日期(yyyyMMdd)
     */
    private String transDate;

    /**
     * 批次状态对象Json字符串
     */
    private String cnTrBatch;

    /**
     * 批次状态 0-上送文件成功 1-已能够下载批次文件  2-已下载批次回执文件 3-已处理批次回执文件 9-上送文件失败
     */
    private String batchStatus;

    /**
     * 交易时间(HHmmss)
     */
    private String transTime;

    /**
     * 商户编号
     */
    private String merNo;

    /**
     * 企业入网时分配的企业账号
     */
    private String accNo;

    /**
     * 入网分配的用户名
     */
    private String userCode;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 批量文件名称.txt
     */
    private String fileName;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 总笔数
     */
    private Long count;

    /**
     * 批次总金额
     */
    private Long sumAmount;
}