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
public class MerchantDaySumVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 对账日期
     */
    private String reconcileDate;

    /**
     * 机构编号
     */
    private String orgCode;

    /**
     * 商户号
     */
    private String merNo;

    /**
     * 交易日期
     */
    private String transDate;

    private String productCode;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 交易总笔数
     */
    private Long totalCount;

    /**
     * 交易总金额(分)
     */
    private Long totalAmount;

    /**
     * 总手续费（分）
     */
    private Long totalFee;

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
}