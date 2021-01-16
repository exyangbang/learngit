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
public class IndustryAccountInfoVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 平台号
     */
    private String industryCode;

    private String accountNo;

    private String accountName;

    /**
     * 开户行行号
     */
    private String bankCode;

    /**
     * 开户行行名称
     */
    private String bankName;

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
     * 1:平台|行业账户,4-手续费收入账户 5-手续费支出账户
     */
    private String industryType;
}