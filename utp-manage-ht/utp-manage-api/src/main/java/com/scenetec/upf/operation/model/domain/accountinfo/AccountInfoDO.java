package com.scenetec.upf.operation.model.domain.accountinfo;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2020/05/18
 */
@Data
@ApiModel(description = "账户信息")
public class AccountInfoDO {

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
     * 账号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "账号")
	private String account;
	
    /**
     * 归属对象类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "归属对象类型")
	private String objType;
	
    /**
     * 经营范围
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "经营范围")
	private String businessScope;
	
    /**
     * 企业注册资金
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "企业注册资金")
	private String registerFund;
	
    /**
     * 营业执照有效期（yyyy-MM-dd）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "营业执照有效期（yyyy-MM-dd）")
	private String businessIndate;
	
    /**
     * 法人证件有效期（yyyy-MM-dd）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "法人证件有效期（yyyy-MM-dd）")
	private String legalIndate;
	
    /**
     * 控股股东或者实际控制人姓名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "控股股东或者实际控制人姓名")
	private String controlName;
	
    /**
     * 控股股东或者实际控制人证件类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "控股股东或者实际控制人证件类型")
	private String controlCerfileType;
	
    /**
     * 控股股东或者实际控制人证件号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "控股股东或者实际控制人证件号")
	private String controlCerfileNo;
	
    /**
     * 控股股东或者实际控制人证件有效期（yyyy-MM-dd）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "控股股东或者实际控制人证件有效期（yyyy-MM-dd）")
	private String controlIndate;
	
    /**
     * 负责人姓名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "负责人姓名")
	private String chargeName;
	
    /**
     * 负责人证件类型
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "负责人证件类型")
	private String chargeCerfileType;
	
    /**
     * 负责人证件号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "负责人证件号")
	private String chargeCerfileNo;
	
    /**
     * 负责人证件有效期（yyyy-MM-dd）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "负责人证件有效期（yyyy-MM-dd）")
	private String chargeIndate;
	
    /**
     * 授权办理业务人员姓名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "授权办理业务人员姓名")
	private String authBusName;
	
    /**
     * 授权办理业务人员证件类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "授权办理业务人员证件类型")
	private String authBusType;
	
    /**
     * 授权办理业务人员证件号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "授权办理业务人员证件号")
	private String authBusNo;
	
    /**
     * 授权办理业务人员证件有效期（yyyy-MM-dd)
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "授权办理业务人员证件有效期（yyyy-MM-dd)")
	private String authBusIndate;
	
    /**
     * 客户经理
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "客户经理")
	private String customerManager;
	
    /**
     * 客户经理联系方式（固话或者手机号码）
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "客户经理联系方式（固话或者手机号码）")
	private String customerManagerPhone;
	
    /**
     * 企业类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "企业类型")
	private String enterpriseType;
	
    /**
     * 企业规模
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "企业规模")
	private String enterpriseSale;
	
    /**
     * 企业经济性质
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "企业经济性质")
	private String enterpriseEcoNature;
	
    /**
     * 上市类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "上市类型")
	private String listingType;
	
    /**
     * 居民类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "居民类型")
	private String residentType;
	
    /**
     * 用户类型|0-个人 1-商户
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "用户类型|0-个人 1-商户")
	private String userType;
	
}