package com.scenetec.upf.operation.model.domain.certificate;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2018/08/01
 */
@Data
@ApiModel(description = "证书信息表")
public class CertificateInfoDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    
	
    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    @JsonIgnore
	private String userCreate;
	
    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
	private Date gmtCreate;
	
    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    @JsonIgnore
	private String userModified;
	
    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
	private Date gmtModified;
	
    /**
     * 证书号
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "证书号")
	private String certificateNo;
	
    /**
     * 证书序列号
     * mysqlType: varchar(128)
     */
    @ApiModelProperty(value = "证书序列号")
	private String certificateSeq;
	
    /**
     * 证书名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "证书名称")
	private String certificateName;
	
    /**
     * 渠道编号
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "渠道编号")
	private String channelKey;

	/**
	 * 产品编号
	 * mysqlType: varchar(64)
	 */
	@ApiModelProperty(value = "产品编号")
	private String productCode;
    /**
     * 所属收单机构代码
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "所属收单机构代码")
	private String orgCode;
	
    /**
     * 所属收单机构名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "所属收单机构名称")
	private String orgName;
	
    /**
     * 证书类型
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "证书类型")
	private String certificateType;
	
    /**
     * 私钥信息
     * mysqlType: text
     */
    @ApiModelProperty(value = "私钥信息")
	private String privateKey;
	
    /**
     * 私钥证书密码
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "私钥证书密码")
	private String privateKeyPassword;
	
    /**
     * 私钥store密码
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "私钥store密码")
	private String privateStorePassword;
	
    /**
     * 公钥信息
     * mysqlType: text
     */
    @ApiModelProperty(value = "公钥信息")
	private String publicKey;
	
    /**
     * 证书生效日期
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "证书生效日期")
	private String effectiveDate;
	
    /**
     * 证书失效日期
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "证书失效日期")
	private String expirationDate;
	
    /**
     * 二进制证书文件
     * mysqlType: blob
     */
    @ApiModelProperty(value = "二进制证书文件")
	private byte[] certificateFile;
	
    /**
     * 证书存放路径
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "证书存放路径")
	private String certificatePath;
	
    /**
     * 状态
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "状态")
	private String status;
	
    /**
     * 备注信息
     * mysqlType: varchar(500)
     */
    @ApiModelProperty(value = "备注信息")
	private String remark;


    @Override
	public String toString() {
		return "CertificateInfoDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", certificateNo = [" + certificateNo +"]"
              + ", certificateSeq = [" + certificateSeq +"]"
              + ", certificateName = [" + certificateName +"]"
              + ", channelId = [" + channelKey +"]"
				+ ", productCode = [" + productCode +"]"
              + ", orgCode = [" + orgCode +"]"
              + ", orgName = [" + orgName +"]"
              + ", certificateType = [" + certificateType +"]"
              + ", privateKey = [" + privateKey +"]"
              + ", privateKeyPassword = [" + privateKeyPassword +"]"
              + ", privateStorePassword = [" + privateStorePassword +"]"
              + ", publicKey = [" + publicKey +"]"
              + ", effectiveDate = [" + effectiveDate +"]"
              + ", expirationDate = [" + expirationDate +"]"
              + ", certificateFile = [" + certificateFile +"]"
              + ", certificatePath = [" + certificatePath +"]"
              + ", status = [" + status +"]"
              + ", remark = [" + remark +"]"
              ;
	}
	
}