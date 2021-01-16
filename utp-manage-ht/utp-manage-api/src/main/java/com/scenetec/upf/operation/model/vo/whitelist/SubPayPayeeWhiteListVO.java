package com.scenetec.upf.operation.model.vo.whitelist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author scenetec
 * @date 2020/05/07
 */
@Data
public class SubPayPayeeWhiteListVO {

	@NotNull(message = "id不能为空")
    private Long id;

    /**
     * 收款账号
     * mysqlType: varchar(100)
     */
	@NotNull(message = "收款账号不能为空")
	@Size(min=1,max = 100,message = "收款账号收款户名最大长度不能超过100")
	@Pattern(regexp = "^[0-9]*$",message = "收款账号只能纯数字!")
	private String payeeAccount;
	
    /**
     * 收款户名
     * mysqlType: varchar(250)
     */
	@NotNull(message = "收款户名不能为空")
	@Size(min=1,max = 200,message = "收款户名最大长度不能超过200")
	private String payeeName;
	
    /**
     * 代付客户号
     * mysqlType: int(20)
     */
	@NotNull(message = "客户号id不能为空")
	private Long industryId;

}