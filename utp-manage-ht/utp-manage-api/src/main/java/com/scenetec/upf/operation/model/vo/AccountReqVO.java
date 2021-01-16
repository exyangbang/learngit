package com.scenetec.upf.operation.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@ApiModel(description = "账户管理")
@Data
public class AccountReqVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 账号
     * mysqlType: varchar(20)
     */
//    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 归属对象类型
     * mysqlType: varchar(10)
     */
//    @NotNull(message = "归属对象类型不能为空")
    private String objType;

    /**
     * 归属对象编号
     * mysqlType: varchar(20)
     */
//    @NotNull(message = "归属对象编号不能为空")
    private String objCode;

    /**
     * 归属对象名称
     * mysqlType: varchar(200)
     */
//    @NotNull(message = "归属对象名称不能为空")
    private String objName;
    /**
     * 资金账户
     */
//    @NotNull(message = "资金账户不能为空")
    private String fundAccount;


    private List<Long> idList;
}