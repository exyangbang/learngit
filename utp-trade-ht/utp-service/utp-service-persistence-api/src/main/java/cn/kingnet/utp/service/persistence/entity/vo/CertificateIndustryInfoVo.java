package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CertificateIndustryInfoVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 证书主键编号
     */
    private String certId;

    /**
     * 平台编码、客户号
     */
    private String industryCode;
}