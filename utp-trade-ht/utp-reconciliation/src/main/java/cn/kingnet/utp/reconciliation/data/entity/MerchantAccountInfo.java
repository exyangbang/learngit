package cn.kingnet.utp.reconciliation.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.reconciliation.data.entity.vo.MerchantAccountInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_merchant_account_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.reconciliation.data.mapper.MerchantAccountInfoMapper")
public class MerchantAccountInfo extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 商户号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 虚拟账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 账户类型
     */
    @TableField(value = "account_type")
    private String accountType;

    /**
     * 账号
     */
    @TableField(value = "account_no")
    private String accountNo;

    /**
     * 账户名称
     */
    @TableField(value = "account_name")
    private String accountName;

    /**
     * 开户行行号
     */
    @TableField(value = "bank_code")
    private String bankCode;

    /**
     * 开户行行名称
     */
    @TableField(value = "bank_name")
    private String bankName;

    /**
     * 接收行号/结算结构代码
     */
    @TableField(value = "receive_bank_code")
    private String receiveBankCode;

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
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 随机小额打款金额
     */
    @TableField(value = "auth_amt")
    private Long authAmt;

    /**
     * 绑卡状态0=正常 1=打款处理中 2=打款失败 3=打款成功待验证 4=验证失败 5冻结 6解绑
     */
    @TableField(value = "bind_status")
    private String bindStatus;

    /**
     * 验证次数
     */
    @TableField(value = "auth_count")
    private Integer authCount;

    /**
     * 请求绑卡时间
     */
    @TableField(value = "req_bind_date")
    private Date reqBindDate;

    /**
     * 冻结时间
     */
    @TableField(value = "freeze_date")
    private Date freezeDate;

    /**
     * 渠道打款响应码
     */
    @TableField(value = "channel_resp_code")
    private String channelRespCode;

    /**
     * 渠道打款响应描述
     */
    @TableField(value = "channel_resp_msg")
    private String channelRespMsg;

    public MerchantAccountInfoVo buildVo() {
        return new MerchantAccountInfoVo(id, merNo, account, accountType, accountNo, accountName, bankCode, bankName, receiveBankCode, gmtCreate, gmtModified, userCreate, userModified, authAmt, bindStatus, authCount, reqBindDate, freezeDate, channelRespCode, channelRespMsg);
    }

    public static MerchantAccountInfo of(MerchantAccountInfoVo vo) {
        return new MerchantAccountInfo(vo.getId(), vo.getMerNo(), vo.getAccount(), vo.getAccountType(), vo.getAccountNo(), vo.getAccountName(), vo.getBankCode(), vo.getBankName(), vo.getReceiveBankCode(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getAuthAmt(), vo.getBindStatus(), vo.getAuthCount(), vo.getReqBindDate(), vo.getFreezeDate(), vo.getChannelRespCode(), vo.getChannelRespMsg());
    }
}
