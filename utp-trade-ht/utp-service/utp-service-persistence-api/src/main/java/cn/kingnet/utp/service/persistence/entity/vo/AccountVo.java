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
public class AccountVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

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
     * 虚拟账户账号
     */
    private String account;

    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户 8-个体工商户账户 9-待结算账户 10-小额打款支出账户）
     */
    private String objType;

    /**
     * 归属对象编号（行业或商户编码）
     */
    private String objCode;

    /**
     * 归属对象名称
     */
    private String objName;

    /**
     * 资金账户
     */
    private String fundAccount;

    /**
     * 账户余额（单位分）=冻结金额+可用余额
     */
    private Long balance;

    /**
     * 冻结金额（单位分）
     */
    private Long frozenAmount;

    /**
     * 可用金额（单位分）
     */
    private Long availAmount;

    /**
     * 状态（0-冻结 1-正常）
     */
    private String status;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 手续费模板id
     */
    private Long feeTemplateId;

    /**
     * 平台信息id
     */
    private Long industryId;

    /**
     * 银行客户号
     */
    private String bankClientNo;

    /**
     * 银行客户号关联标识0开户未上报 1开户已上报 2更新未上报 3更新已上报 4销户未上报
     */
    private Integer bankClientStatus;

    /**
     * 银行客户号开户渠道标识 0簿记自有渠道 1簿记其他渠道
     */
    private Integer bankClientChnFlag;
}