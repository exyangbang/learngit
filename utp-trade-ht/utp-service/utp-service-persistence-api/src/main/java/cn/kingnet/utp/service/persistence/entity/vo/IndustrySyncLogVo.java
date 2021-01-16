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
public class IndustrySyncLogVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 平台号 客户号
     */
    private String industryCode;

    /**
     * 资金账户表中的资金账号
     */
    private String fundAccountNo;

    /**
     * 上次同步日期 yyyyMMdd
     */
    private String lastDate;

    /**
     * 来款账户名称
     */
    private String remark;

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