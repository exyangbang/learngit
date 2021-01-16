package com.scenetec.upf.operation.model.vo.codedictionary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/10/30
 */
@Data
public class CodeDictionaryVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 字典类型 0001:支付机构 0003:行业 0003:职业
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "字典类型 0001:支付机构 0002:行业 0003:职业")
	@Size(min=1,max = 255,message = "字典类型最大长度不能超过255")
	@NotNull(message = "字典类型不能为空")
	private String type;
	
    /**
     * key值
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "子项目编码")
	@Size(min=1,max = 100,message = "子项目编码最大长度不能超过100")
	@NotNull(message = "子项目编码不能为空")
	private String code;
	
    /**
     * 信息名称
     * mysqlType: varchar(1000)
     */
    @ApiModelProperty(value = "子项目含义")
	@Size(min=1,max = 1000,message = "子项目含义长度不能超过1000")
	@NotNull(message = "子项目含义不能为空")
	private String value;
	
    /**
     * 备注信息
     * mysqlType: varchar(1000)
     */
    @ApiModelProperty(value = "备注信息")
	private String remark;
	
}