package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.ChannelIncomeFlowVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_channel_income_flow")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.ChannelIncomeFlowMapper")
public class ChannelIncomeFlow extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 虚拟账户账号
     */
    @TableField(value = "acc_no")
    private String accNo;

    /**
     * 虚拟账户客户姓名
     */
    @TableField(value = "acc_name")
    private String accName;

    /**
     * 充值金额,单位:分 无小数点
     */
    @TableField(value = "amt")
    private Long amt;

    /**
     * 核心主交易流水(订单号)
     */
    @TableField(value = "core_no")
    private String coreNo;

    /**
     * 请求业务流水号
     */
    @TableField(value = "rid")
    private String rid;

    /**
     * 来账账号
     */
    @TableField(value = "ex_acct_no")
    private String exAcctNo;

    /**
     * 来账户名
     */
    @TableField(value = "ex_acct_name")
    private String exAcctName;

    /**
     * 来账账号清算行号
     */
    @TableField(value = "clear_bankno")
    private String clearBankno;

    /**
     * 来账账号行名
     */
    @TableField(value = "bank_name")
    private String bankName;

    /**
     * 支付系统业务流水号
     */
    @TableField(value = "tran_no")
    private String tranNo;

    /**
     * 对账日期,yyyyMMdd
     */
    @TableField(value = "tran_date")
    private String tranDate;

    /**
     * 入账账户
     */
    @TableField(value = "auto_payee_acct_ao")
    private String autoPayeeAcctAo;

    /**
     * 入账户名
     */
    @TableField(value = "auto_payee_acct_name")
    private String autoPayeeAcctName;

    /**
     * 手工提入账户
     */
    @TableField(value = "manual_payee_acct_no")
    private String manualPayeeAcctNo;

    /**
     * 手工提入户名
     */
    @TableField(value = "manual_payee_acct_name")
    private String manualPayeeAcctName;

    /**
     * 业务状态,(01-已入账,02-已挂账,03-已退账,04-已手工入账)
     */
    @TableField(value = "biz_flag")
    private String bizFlag;

    /**
     * 电子回单生成标识0未生成 1已生成
     */
    @TableField(value = "elc_make_flag")
    private String elcMakeFlag;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 处理状态,(0-未入账,1-已入账)
     */
    @TableField(value = "handle_flag")
    private String handleFlag;

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
     * 关联或归属平台客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 关联或归属平台客户名称
     */
    @TableField(value = "industry_name")
    private String industryName;

    /**
     * acc_No账户类型1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户 8-个体工商户账户 9-待结算账户
     */
    @TableField(value = "account_type")
    private String accountType;

    public ChannelIncomeFlowVo buildVo() {
        return new ChannelIncomeFlowVo(id, accNo, accName, amt, coreNo, rid, exAcctNo, exAcctName, clearBankno, bankName, tranNo, tranDate, autoPayeeAcctAo, autoPayeeAcctName, manualPayeeAcctNo, manualPayeeAcctName, bizFlag, elcMakeFlag, remark, handleFlag, userCreate, gmtCreate, userModified, gmtModified, industryCode, industryName, accountType);
    }

    public static ChannelIncomeFlow of(ChannelIncomeFlowVo vo) {
        return new ChannelIncomeFlow(vo.getId(), vo.getAccNo(), vo.getAccName(), vo.getAmt(), vo.getCoreNo(), vo.getRid(), vo.getExAcctNo(), vo.getExAcctName(), vo.getClearBankno(), vo.getBankName(), vo.getTranNo(), vo.getTranDate(), vo.getAutoPayeeAcctAo(), vo.getAutoPayeeAcctName(), vo.getManualPayeeAcctNo(), vo.getManualPayeeAcctName(), vo.getBizFlag(), vo.getElcMakeFlag(), vo.getRemark(), vo.getHandleFlag(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getIndustryCode(), vo.getIndustryName(), vo.getAccountType());
    }
}