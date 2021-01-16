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
public class BlackListVo implements java.io.Serializable {
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号
     */
    private String idCode;

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

    /**
     * 1:个人2:企业
     */
    private String objType;

    /**
     * 营业执照号
     */
    private String busLicCode;

    /**
     * 企业名称
     */
    private String entName;
}