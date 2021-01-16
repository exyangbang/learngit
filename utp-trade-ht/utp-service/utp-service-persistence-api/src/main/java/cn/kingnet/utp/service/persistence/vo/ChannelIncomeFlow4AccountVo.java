package cn.kingnet.utp.service.persistence.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 当前待处理 功能账户&子账户入账 入金通知流水VO
 * @Author WJH
 * @Date 2020/01/03
 */
@Getter
@Setter
public class ChannelIncomeFlow4AccountVo implements Serializable {
    /**
     * channelIncomeFlow.Id 主键ID
     */
    private Long id;

    /**
     * 银行实体账户资金明细同步表Id
     * bankAccountTransDetail.Id
     */
    private Long bankTransDetailId;

    /**
     * 虚拟账户账号 [功能账户&子账户]
     */
    private String accNo;

    /**
     * 虚拟账户客户姓名
     */
    private String accName;

    /**
     * 充值金额,单位:分 无小数点
     */
    private Long amt;

    /**
     * 核心主交易流水(关联 银行资金流水 refSystemNo)
     */
    private String coreNo;

    /**
     * 通知个下游的 业务流水号 要与 子账户订单入金报备 入金流水号一致
     * 请求业务流水号	N	小于等于32位的请求业务流水号，请求系统唯一
     */
    private String rid;


    /**
     * 来账账号清算行号
     */
    private String clearBankno;

    /**
     * 来账账号行名
     */
    private String bankName;

    /**
     * 支付系统业务流水号
     */
    private String tranNo;

    /**
     * 对账日期,yyyyMMdd
     */
    private String tranDate;

    /**
     * 业务状态,(01-已入账,02-已挂账,03-已退账,04-已手工入账)
     */
    private String bizFlag;

    /**
     * 处理状态,(0-未入账,1-已入账)
     */
    private String handleFlag;


    /**
     * 二级商户虚账户
     */
    private String account;
    /**
     * 功能账户&子账户的关联平台code 客户号 后管配置唯一
     */
    private String industryCode;
    /**
     * 功能账户&子账户的关联name 客户平台名称
     */
    private String industryName;
    /**
     * VirtualAccountType枚举保持一致
     * 账户性质(1-平台|行业账户,2-企业商户,3-个人,4-手续费收入账户,5-手续费支出账户,6-归集账户,7-佣金账户,8-个体工商户账户,9-待结算账户 10-打款验证支出账户)
     * 目前仅支持：1 5 10  & 2 3 7 8 9
     */
    private String nature;
    /**
     * 归属客户号 通知地址
     */
    private String innerNoticeUrl;


    /**
     * 对方账户：bankDetail
     */
    private String otherCustAccountNo;
    /**
     * 对账账户名称：bankDetail
     */
    private String otherCustName;
    /**
     * 备注信息：bankDetail
     */
    private String remarkDetail;
    /**
     * 摘要
     */
    private String summaryDescription;
    /**
     * 行内资金序号
     */
    private Long detailSerialNumber;


    /**
     * 上账处理完：标记
     * 上账状态：1已上账 其他未上账
     */
    private String operStatus;
    /**
     * 上账时间
     */
    private Date gmtModified;
}
