package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.CertificateIndustryInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_certificate_industry_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.CertificateIndustryInfoMapper")
public class CertificateIndustryInfo extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 证书主键编号
     */
    @TableField(value = "cert_id")
    private String certId;

    /**
     * 平台编码、客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    public CertificateIndustryInfoVo buildVo() {
        return new CertificateIndustryInfoVo(id, certId, industryCode);
    }

    public static CertificateIndustryInfo of(CertificateIndustryInfoVo vo) {
        return new CertificateIndustryInfo(vo.getId(), vo.getCertId(), vo.getIndustryCode());
    }
}