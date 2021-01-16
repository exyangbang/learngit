package com.scenetec.upf.operation.model.domain.country;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/10/09
 */
@ApiModel(description = "国家代码")
@Data
public class CountryDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
	
    /**
     * 账号
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "账号")
	private String twoBitLetters;
	
    /**
     * 归属对象类型
     * mysqlType: varchar(3)
     */
    @ApiModelProperty(value = "归属对象类型")
	private String threeBitLetters;
	
    /**
     * 数字代码
     * mysqlType: varchar(3)
     */
    @ApiModelProperty(value = "数字代码")
	private String numCode;
	
    /**
     * 英文名称
     * mysqlType: varchar(256)
     */
    @ApiModelProperty(value = "英文名称")
	private String engName;
	
    /**
     * 中文名称
     * mysqlType: bigint(256)
     */
    @ApiModelProperty(value = "中文名称")
	private String chName;
	
}