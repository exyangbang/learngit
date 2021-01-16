package com.scenetec.upf.operation.model.vo.industry;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/22 12:00
 */
@Data
public class IndustrySyncLogVO {

    /**
     * 代付客户号
     */
    @ApiModelProperty(value = "代付客户号")
    private String industryCode;

    @ApiModelProperty(value = "资金账号")
    private String fundAccountNo;

    /**
     * 上次同步日期
     */
    @ApiModelProperty(value = "上次同步日期")
    private String lastDate;

    /**
     * 实体账户使用，暂时由后台直接写死000000
     */
    @ApiModelProperty(value = "上次同步时间")
    private String lastTime;
}
