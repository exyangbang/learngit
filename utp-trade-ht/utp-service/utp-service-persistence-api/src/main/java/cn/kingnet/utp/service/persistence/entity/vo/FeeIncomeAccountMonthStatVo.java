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
public class FeeIncomeAccountMonthStatVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 统计月份yyyyMM
     */
    private String statMonth;

    /**
     * 手续费收益账户号
     */
    private String account;

    /**
     * 手续费收益账户名称
     */
    private String name;

    /**
     * 归集划款状态 0未划转 1已划转
     */
    private String collectionStatus;

    /**
     * 入金金额（单位分）
     */
    private Long incomeAmount;

    /**
     * 出金金额（单位分）
     */
    private Long outcomeAmount;

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
     * 更新用户
     */
    private String userModified;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 交易状态
     */
    private String transStatus;

    /**
     * 交易状态描述
     */
    private String transDesc;

    /**
     * 服务端流水号
     */
    private String serverTransId;
}