package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.scheduler.data.entity.vo.AccountVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_account")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.AccountMapper")
public class Account extends BaseEntity {
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
     * 虚拟账户账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户）
     */
    @TableField(value = "obj_type")
    private String objType;

    /**
     * 归属对象编号（行业或商户编码）
     */
    @TableField(value = "obj_code")
    private String objCode;

    /**
     * 归属对象名称
     */
    @TableField(value = "obj_name")
    private String objName;

    /**
     * 资金账户
     */
    @TableField(value = "fund_account")
    private String fundAccount;

    /**
     * 账户余额（单位分）=冻结金额+可用余额
     */
    @TableField(value = "balance")
    private Long balance;

    /**
     * 冻结金额（单位分）
     */
    @TableField(value = "frozen_amount")
    private Long frozenAmount;

    /**
     * 可用金额（单位分）
     */
    @TableField(value = "avail_amount")
    private Long availAmount;

    /**
     * 状态（0-冻结 1-正常）
     */
    @TableField(value = "status")
    private String status;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Long version;

    /**
     * 手续费模板id
     */
    @TableField(value = "fee_template_id")
    private Long feeTemplateId;

    /**
     * 平台信息id
     */
    @TableField(value = "industry_id")
    private Long industryId;

    /**
     * 银行客户号
     */
    @TableField(value = "bank_client_no")
    private String bankClientNo;

    public AccountVo buildVo() {
        return new AccountVo(id, userCreate, gmtCreate, userModified, gmtModified, account, objType, objCode, objName, fundAccount, balance, frozenAmount, availAmount, status, version, feeTemplateId, industryId, bankClientNo);
    }

    public static Account of(AccountVo vo) {
        return new Account(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getAccount(), vo.getObjType(), vo.getObjCode(), vo.getObjName(), vo.getFundAccount(), vo.getBalance(), vo.getFrozenAmount(), vo.getAvailAmount(), vo.getStatus(), vo.getVersion(), vo.getFeeTemplateId(), vo.getIndustryId(), vo.getBankClientNo());
    }
}