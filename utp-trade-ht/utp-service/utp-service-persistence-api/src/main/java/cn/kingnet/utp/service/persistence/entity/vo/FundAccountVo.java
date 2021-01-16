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
public class FundAccountVo implements java.io.Serializable {
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
     * 资金账户编号
     */
    private String accountNum;

    /**
     * 清算行行号
     */
    private String bankCode;

    /**
     * 状态（0-不可用 1-可用）
     */
    private String status;

    /**
     * 华通客户账号|内部户账号
     */
    private String bankAccountNo;

    /**
     * 华通客户账号名称|内部户名称
     */
    private String bankAccountName;

    /**
     * 最新同步时间
     */
    private Date synchronizationTime;

    /**
     * 当前余额
     */
    private Long currentBalance;

    /**
     * 1:内部户，2:一般户
     */
    private String accountType;

    /**
     * 使用类型(0-普通用途 1-归集用途)
     */
    private String useType;

    /**
     * 是否与其他系统共享实体账户0=否 1=是
     */
    private String shareFlag;
}