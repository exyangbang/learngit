package cn.kingnet.utp.scheduler.data.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description 回盘文件DTO
 * @Author WJH
 * @Date 2018年11月02日
 */
@Getter
@Setter
public class UdpSettleResultDTO {

    /**
     * 批次标识	全局唯一	是
     */
    private String batchId;
    /**
     * 原批次标识	用于批次的回复，原批次id	否
     */
    private String replyBatchId;
    /**
     * 文件类型 是
     */
    private String type;
    /**
     * 业务日期 是
     */
    private String txnDate;
    /**
     * 服务商id
     */
    private String serviceProvider;
    /**
     * 服务商id对应校验码
     */
    private String validateCode;
    /**
     * 是否分段
     */
    private boolean enableSegment;
    /**
     * 分段总数
     */
    private String totalSegment;
    /**
     * 当前段号：段号从1开始编号
     */
    private Long segmentNo;
    /**
     * 对原文件内容的md5校验
     */
    private String md5;
    /**
     * 内容	将文件按二进制读取后进行Base64编码，md5为编码前的校验码	是
     */
    private String content;



}
