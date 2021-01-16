package com.scenetec.upf.operation.model.vo.certificate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author shendunyuan@scenetec.com
 * @date 2018/7/28
 */
@ApiModel(description = "证书对象")
@Data
public class CertificateVO {

	@ApiModelProperty(value = "主键ID")
	private Long id;

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
				+ ", status = [" + status +"]"
				+ ", remark = [" + remark +"]"
				;
	}

	public void convertStringNullToNull() {
		if (StringUtils.isBlank(covertToNull(certificateName))) {
			certificateName = null;
		}
		if (StringUtils.isBlank(covertToNull(orgName))) {
			orgName = null;
		}
		if (StringUtils.isBlank(covertToNull(privateKey))) {
			privateKey = null;
		}
		if (StringUtils.isBlank(covertToNull(privateKeyPassword))) {
			privateKeyPassword = null;
		}
		if (StringUtils.isBlank(covertToNull(privateStorePassword))) {
			privateStorePassword = null;
		}
		if (StringUtils.isBlank(covertToNull(publicKey))) {
			publicKey = null;
		}
		if (StringUtils.isBlank(covertToNull(remark))) {
			remark = null;
		}
	}

	private String covertToNull(String obj) {
		String nullStr = "null";
		if (nullStr.equals(obj)) {
			return null;
		} else {
			return obj;
		}
	}
}
