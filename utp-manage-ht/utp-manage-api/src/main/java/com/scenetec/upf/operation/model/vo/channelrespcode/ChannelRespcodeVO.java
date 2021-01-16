package com.scenetec.upf.operation.model.vo.channelrespcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/06/18
 */
@ApiModel(description = "错误码管理")
@Data
public class ChannelRespcodeVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
	
    /**
     * TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中")
	@NotNull(message = "交易状态不能为空")
	@Size(min=1,max = 32,message = "交易状态最大长度不能超过32")
	private String transStatus;
	
    /**
     * 渠道响应码
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道响应码")
	@NotNull(message = "渠道响应码不能为空")
	@Size(min=1,max = 20,message = "渠道响应码最大长度不能超过20")
	private String channelRespcode;
	
    /**
     * 渠道响应码描述
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "渠道响应码描述")
	@NotNull(message = "渠道响应码描述不能为空")
	@Size(min=1,max = 200,message = "渠道响应码描述最大长度不能超过200")
	private String channelRespdesc;
	
    /**
     * 启用状态 0:不启用 1：启用'
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "启用状态 0:不启用 1：启用'")
	@NotNull(message = "启用状态不能为空")
	@Size(min=1,max = 10,message = "启用状态最大长度不能超过10")
	private String status;
	
    /**
     * 备注说明
     * mysqlType: bigint(200)
     */
    @ApiModelProperty(value = "备注说明")
	@Size(min=1,max = 200,message = "备注说明最大长度不能超过200")
	private String remark;


}