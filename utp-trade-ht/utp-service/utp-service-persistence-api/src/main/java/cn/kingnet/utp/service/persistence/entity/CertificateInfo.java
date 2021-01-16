package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.CertificateInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_certificate_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.CertificateInfoMapper")
public class CertificateInfo extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 证书号
     */
    @TableField(value = "certificate_no")
    private String certificateNo;

    /**
     * 证书序列号
     */
    @TableField(value = "certificate_seq")
    private String certificateSeq;

    /**
     * 证书名称
     */
    @TableField(value = "certificate_name")
    private String certificateName;

    /**
     * 渠道编号
     */
    @TableField(value = "channel_key")
    private String channelKey;

    /**
     * 产品编号
     */
    @TableField(value = "product_code")
    private String productCode;

    /**
     * 所属收单机构代码
     */
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 机构ID
     */
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 证书类型
     */
    @TableField(value = "certificate_type")
    private String certificateType;

    /**
     * 私钥证书密码
     */
    @TableField(value = "private_key_password")
    private String privateKeyPassword;

    /**
     * 私钥store密码
     */
    @TableField(value = "private_store_password")
    private String privateStorePassword;

    /**
     * 证书生效日期
     */
    @TableField(value = "effective_date")
    private String effectiveDate;

    /**
     * 证书失效日期
     */
    @TableField(value = "expiration_date")
    private String expirationDate;

    /**
     * 证书存放路径
     */
    @TableField(value = "certificate_path")
    private String certificatePath;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 私钥信息
     */
    @TableField(value = "private_key")
    private String privateKey;

    /**
     * 公钥信息
     */
    @TableField(value = "public_key")
    private String publicKey;

    /**
     * 二进制证书文件
     */
    @TableField(value = "certificate_file")
    private byte[] certificateFile;

    public static CertificateInfo of(CertificateInfoVo vo) {
        return new CertificateInfo(vo.getId(), vo.getCertificateNo(), vo.getCertificateSeq(), vo.getCertificateName(), vo.getChannelKey(), vo.getProductCode(), vo.getOrgCode(), vo.getOrgName(), vo.getCertificateType(), vo.getPrivateKeyPassword(), vo.getPrivateStorePassword(), vo.getEffectiveDate(), vo.getExpirationDate(), vo.getCertificatePath(), vo.getStatus(), vo.getRemark(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getPrivateKey(), vo.getPublicKey(), vo.getCertificateFile());
    }

    public CertificateInfoVo buildVo() {
        return new CertificateInfoVo(id, certificateNo, certificateSeq, certificateName, channelKey, productCode, orgCode, orgName, certificateType, privateKeyPassword, privateStorePassword, effectiveDate, expirationDate, certificatePath, status, remark, gmtCreate, gmtModified, userCreate, userModified, privateKey, publicKey, certificateFile);
    }
}