package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.AccountOrderLogVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_account_order_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.AccountOrderLogMapper")
public class AccountOrderLog extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 请求日期yyyyMMdd
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 请求时间HHmmss
     */
    @TableField(value = "trans_time")
    private String transTime;

    /**
     * 客户端流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 虚拟账户账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 虚拟账户客户姓名
     */
    @TableField(value = "account_name")
    private String accountName;

    /**
     * 充值金额,单位:分 无小数点
     */
    @TableField(value = "amt")
    private Long amt;

    /**
     * 订单号即入金通知核心主交易流水
     */
    @TableField(value = "order_id")
    private String orderId;

    /**
     * 回调地址
     */
    @TableField(value = "callback_url")
    private String callbackUrl;

    /**
     * 交易状态|同流水表一致
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 交易类型|同流水表一致
     */
    @TableField(value = "trade_type")
    private String tradeType;

    /**
     * 响应信息描述
     */
    @TableField(value = "resp_desc")
    private String respDesc;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

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

    public AccountOrderLogVo buildVo() {
        return new AccountOrderLogVo(id, transDate, transTime, clientTransId, serverTransId, account, accountName, amt, orderId, callbackUrl, transStatus, tradeType, respDesc, remark, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static AccountOrderLog of(AccountOrderLogVo vo) {
        return new AccountOrderLog(vo.getId(), vo.getTransDate(), vo.getTransTime(), vo.getClientTransId(), vo.getServerTransId(), vo.getAccount(), vo.getAccountName(), vo.getAmt(), vo.getOrderId(), vo.getCallbackUrl(), vo.getTransStatus(), vo.getTradeType(), vo.getRespDesc(), vo.getRemark(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}