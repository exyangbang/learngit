package com.scenetec.upf.operation.model.vo.certificate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shendunyuan@scenetec.com
 * @date 2018/7/23
 */
@ApiModel(description = "公私钥信息")
@Data
public class SecretInfoVo {

	@ApiModelProperty(value = "证书序列号")
	private String certificateSeq;
	@ApiModelProperty(value = "证书名称")
	private String certificateName;
	@ApiModelProperty(value = "证书类型")
	private String certificateType;
	@ApiModelProperty(value = "渠道编号")
	private String channelKey;
	@ApiModelProperty(value = "产品编号")
	private String productCode;
	@ApiModelProperty(value = "所属收单机构代码")
	private String orgCode;
	@ApiModelProperty(value = "私钥信息")
	private String privateKey;
	@ApiModelProperty(value = "私钥密码")
	private String privateKeyPassword;
	@ApiModelProperty(value = "私钥store密码")
	private String privateStorePassword;
	@ApiModelProperty(value = "公钥信息")
	private String publicKey;
	@ApiModelProperty(value = "生效日期")
	private String effectiveDate;
	@ApiModelProperty(value = "失效日期")
	private String expirationDate;

}
