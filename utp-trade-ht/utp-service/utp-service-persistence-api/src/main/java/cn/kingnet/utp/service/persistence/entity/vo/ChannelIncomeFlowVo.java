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
public class ChannelIncomeFlowVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 虚拟账户账号
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
     * 核心主交易流水(订单号)
     */
    private String coreNo;

    /**
     * 请求业务流水号
     */
    private String rid;

    /**
     * 来账账号
     */
    private String exAcctNo;

    /**
     * 来账户名
     */
    private String exAcctName;

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
     * 入账账户
     */
    private String autoPayeeAcctAo;

    /**
     * 入账户名
     */
    private String autoPayeeAcctName;

    /**
     * 手工提入账户
     */
    private String manualPayeeAcctNo;

    /**
     * 手工提入户名
     */
    private String manualPayeeAcctName;

    /**
     * 业务状态,(01-已入账,02-已挂账,03-已退账,04-已手工入账)
     */
    private String bizFlag;

    /**
     * 电子回单生成标识0未生成 1已生成
     */
    private String elcMakeFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 处理状态,(0-未入账,1-已入账)
     */
    private String handleFlag;

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
     * 关联或归属平台客户号
     */
    private String industryCode;

    /**
     * 关联或归属平台客户名称
     */
    private String industryName;

    /**
     * acc_No账户类型1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户 8-个体工商户账户 9-待结算账户
     */
    private String accountType;
}