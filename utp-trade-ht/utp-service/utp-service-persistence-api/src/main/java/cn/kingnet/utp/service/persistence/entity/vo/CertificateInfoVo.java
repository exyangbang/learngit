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
public class CertificateInfoVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 证书号
     */
    private String certificateNo;

    /**
     * 证书序列号
     */
    private String certificateSeq;

    /**
     * 证书名称
     */
    private String certificateName;

    /**
     * 渠道编号
     */
    private String channelKey;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 所属收单机构代码
     */
    private String orgCode;

    /**
     * 机构ID
     */
    private String orgName;

    /**
     * 证书类型
     */
    private String certificateType;

    /**
     * 私钥证书密码
     */
    private String privateKeyPassword;

    /**
     * 私钥store密码
     */
    private String privateStorePassword;

    /**
     * 证书生效日期
     */
    private String effectiveDate;

    /**
     * 证书失效日期
     */
    private String expirationDate;

    /**
     * 证书存放路径
     */
    private String certificatePath;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注信息
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

    /**
     * 私钥信息
     */
    private String privateKey;

    /**
     * 公钥信息
     */
    private String publicKey;

    /**
     * 二进制证书文件
     */
    private byte[] certificateFile;
}