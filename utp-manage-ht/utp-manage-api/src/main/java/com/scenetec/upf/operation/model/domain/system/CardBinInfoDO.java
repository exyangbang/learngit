package com.scenetec.upf.operation.model.domain.system;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/11/08
 */
@ApiModel(description = "卡bin管理")
@Data
public class CardBinInfoDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    

    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    @JsonIgnore
	private String createor;

    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
	private Timestamp createTime;

    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    @JsonIgnore
	private String updateor;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
	private Timestamp updateTime;

    /**
     * 发卡行机构代码
     * mysqlType: varchar(14)
     */
    @ApiModelProperty(value = "发卡行机构代码")
	private String issuercode;

    /**
     * 发卡机构名称
     * mysqlType: varchar(120)
     */
    @ApiModelProperty(value = "发卡机构名称")
	private String issuername;

    /**
     * 卡名称
     * mysqlType: varchar(60)
     */
    @ApiModelProperty(value = "卡名称")
	private String cardname;

    /**
     * 主账号读取磁道
     * mysqlType: varchar(5)
     */
    @ApiModelProperty(value = "主账号读取磁道")
	private String cardnotrack;

    /**
     * 主账号起始字节
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "主账号起始字节")
	private String cardnostartPos;

    /**
     * 主账号长度
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "主账号长度")
	private String cardnolen;

    /**
     * 卡BIN号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "卡BIN号")
	private String binnum;

    /**
     * 卡BIN读取磁道
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "卡BIN读取磁道")
	private String bintrack;

    /**
     * 卡BIN起始字节
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "卡BIN起始字节")
	private String binstartpos;

    /**
     * 卡BIN长度
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "卡BIN长度")
	private String binlen;

    /**
     * 全部磁道信息
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "全部磁道信息")
	private String alltrack;

    /**
     * 全部磁道起始字节
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "全部磁道起始字节")
	private String alltrackstartpos;

    /**
     * 第2以及3磁道长度
     * mysqlType: varchar(6)
     */
    @ApiModelProperty(value = "第2以及3磁道长度")
	private String alltracklen;

    /**
     * 是否银联卡品牌
     * mysqlType: varchar(1)
     */
    @ApiModelProperty(value = "是否银联卡品牌")
	private String cuplogoflag;

    /**
     * 卡种(D-借记卡;C-贷记卡;Z-准贷记卡;Y-预付卡)
     * mysqlType: varchar(1)
     */
    @ApiModelProperty(value = "卡种(D-借记卡;C-贷记卡;Z-准贷记卡;Y-预付卡)")
	private String debitcreditflag;

    /**
     * 本期增减状态
     * mysqlType: varchar(1)
     */
    @ApiModelProperty(value = "本期增减状态")
	private String adddeletestat;

    /**
     * 人行清算行行号
     * mysqlType: varchar(14)
     */
    @ApiModelProperty(value = "人行清算行行号")
	private String clearbankno;

    /**
     * 人行清算行行名
     * mysqlType: varchar(120)
     */
    @ApiModelProperty(value = "人行清算行行名")
	private String clearbankname;

    /**
     * 状态
     * mysqlType: varchar(1)
     */
    @ApiModelProperty(value = "状态")
	private String status;

    /**
     * 保留使用
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "保留使用")
	private String adddata;

    /**
     * 备注1
     * mysqlType: varchar(60)
     */
    @ApiModelProperty(value = "备注1")
	private String remark1;

    /**
     * 备注2
     * mysqlType: varchar(60)
     */
    @ApiModelProperty(value = "备注2")
	private String remark2;

    /**
     * 备注3
     * mysqlType: varchar(60)
     */
    @ApiModelProperty(value = "备注3")
	private String remark3;

    /**
     * 所属行行号
     * mysqlType: varchar(14)
     */
    @ApiModelProperty(value = "所属行行号")
	private String bankcode;

    /**
     * 所属行行名称
     * mysqlType: varchar(140)
     */
    @ApiModelProperty(value = "所属行行名称")
	private String bankname;

    /**
     * 所属行分类标识(0-一般银行,1-村镇银行,2-港澳外资银行)
     * mysqlType: varchar(1)
     */
    @ApiModelProperty(value = "所属行分类标识(0-一般银行,1-村镇银行,2-港澳外资银行)")
	private String banktypeflag;

    @Override
	public String toString() {
		return "CardBinInfoDO:"
              + "id = ["+ id + "]"
              + ", issuercode = [" + issuercode +"]"
              + ", issuername = [" + issuername +"]"
              + ", cardname = [" + cardname +"]"
              + ", cardnotrack = [" + cardnotrack +"]"
              + ", cardnostartPos = [" + cardnostartPos +"]"
              + ", cardnolen = [" + cardnolen +"]"
              + ", binnum = [" + binnum +"]"
              + ", bintrack = [" + bintrack +"]"
              + ", binstartpos = [" + binstartpos +"]"
              + ", binlen = [" + binlen +"]"
              + ", alltrack = [" + alltrack +"]"
              + ", alltrackstartpos = [" + alltrackstartpos +"]"
              + ", alltracklen = [" + alltracklen +"]"
              + ", cuplogoflag = [" + cuplogoflag +"]"
              + ", debitcreditflag = [" + debitcreditflag +"]"
              + ", adddeletestat = [" + adddeletestat +"]"
              + ", clearbankno = [" + clearbankno +"]"
              + ", clearbankname = [" + clearbankname +"]"
              + ", status = [" + status +"]"
              + ", adddata = [" + adddata +"]"
              + ", remark1 = [" + remark1 +"]"
              + ", remark2 = [" + remark2 +"]"
              + ", remark3 = [" + remark3 +"]"
              + ", bankcode = [" + bankcode +"]"
              + ", bankname = [" + bankname +"]"
              + ", banktypeflag = [" + banktypeflag +"]"
              ;
	}
	
}