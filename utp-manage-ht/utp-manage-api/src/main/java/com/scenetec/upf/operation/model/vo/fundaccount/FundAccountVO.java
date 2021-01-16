package com.scenetec.upf.operation.model.vo.fundaccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/02/20
 */
@ApiModel(description = "资金账户表")
@Data
public class FundAccountVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


    /**
     * 清算行行号
     * mysqlType: varchar(20)
     */
    @NotNull(message = "清算行行号不能为空")
    @Size(min=1,max = 12,message = "清算行行号最大长度不能超过12")
    @ApiModelProperty(value = "清算行行号")
    private String bankCode;

    /**
     * 华通客户账号|内部户账号'
     * mysqlType: varchar(40)
     */
    @NotNull(message = "华通客户账号|内部户账号不能为空")
    @Size(min=1,max = 40,message = "华通客户账号|内部户账号最大长度不能超过40")
    @ApiModelProperty(value = "华通客户账号|内部户账号")
    private String bankAccountNo;

    /**
     * 华通客户账号名称|内部户名称
     * mysqlType: bigint(100)
     */
    @NotNull(message = "华通客户账号名称|内部户名称不能为空")
    @Size(min=1,max = 200,message = "华通客户账号名称|内部户名称最大长度不能超过200")
    @ApiModelProperty(value = "华通客户账号名称|内部户名称")
    private String bankAccountName;

    /**
     * 1:内部户，2:一般户
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "1:内部户，2:一般户")
    @Size(min=1,max = 2,message = "账户类型|账户类型最大长度不能超过2")
    @NotNull(message = "账户类型|账户类型不能为空")
    private String accountType;

    @ApiModelProperty(value = "使用类型(0-普通用途 1-归集用途)")
    @Size(min=1,max = 2,message = "使用类型最大长度不能超过2")
    @NotNull(message = "使用类型不能为空")
    private String useType;

    @NotNull(message = "是否与其他系统共享实体账户0=否 1=是")
    private String shareFlag;

    @NotNull(message = "是否上报反洗钱(AML=Anti-money laundering)0=否;1=是")
    private String reportAmlFlag;

}