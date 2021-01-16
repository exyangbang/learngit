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
public class AccountOrderLogVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 请求日期yyyyMMdd
     */
    private String transDate;

    /**
     * 请求时间HHmmss
     */
    private String transTime;

    /**
     * 客户端流水号
     */
    private String clientTransId;

    /**
     * 服务端流水号
     */
    private String serverTransId;

    /**
     * 虚拟账户账号
     */
    private String account;

    /**
     * 虚拟账户客户姓名
     */
    private String accountName;

    /**
     * 充值金额,单位:分 无小数点
     */
    private Long amt;

    /**
     * 订单号即入金通知核心主交易流水
     */
    private String orderId;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 交易状态|同流水表一致
     */
    private String transStatus;

    /**
     * 交易类型|同流水表一致
     */
    private String tradeType;

    /**
     * 响应信息描述
     */
    private String respDesc;

    /**
     * 备注
     */
    private String remark;

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
}