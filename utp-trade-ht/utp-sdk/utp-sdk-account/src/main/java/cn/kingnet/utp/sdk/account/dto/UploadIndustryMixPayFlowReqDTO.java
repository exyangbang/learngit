package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/***
 * @Description
 * @Author WJH
 * @Date 2020/12/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadIndustryMixPayFlowReqDTO extends BaseRequestDTO {

    /***reqDate	请求日期	varchar(8)	M		按自然日(yyyyMMdd)*/
    @Pattern(regexp = "^\\d{8}$", message = "请求日期格式必须yyyyMMdd")
    @NotNull
    private String reqDate;
    /**
     * reqTime	请求时间	varchar(6)	M		HHmmss
     */
    @Pattern(regexp = "^\\d{6}$", message = "请求时间格式必须HHmmss")
    @NotNull
    private String reqTime;
    /**
     * batchNo	批次号	varchar(64)	M		全局唯一
     */
    @Length(min = 1, max = 64, message = "批次号长度范围[{min},{max}]")
    @NotNull
    private String batchNo;
    /**
     * mixTransId	融合支付流水	varchar(64)	M
     */
    @Length(min = 1, max = 64, message = "融合支付流水号范围[{min},{max}]")
    @NotNull
    private String mixTransId;
    /**
     * mixTransAmount	融合交易总金额	varchar(20)	M		单位分  融合总金额必须与明细金额累计一致
     */
    @Pattern(regexp = "^\\d{1,20}$", message = "融合交易总金额必须20位内数值")
    @NotNull
    private String mixTransAmount;
    /**
     * transDate	交易日期	varchar(8)	M		yyyyMMdd
     */
    @Pattern(regexp = "^\\d{8}$", message = "交易日期格式必须yyyyMMdd")
    @NotNull
    private String transDate;
    /**
     * transTime	交易时间	varchar(6)	M		HHmmss
     */
    @Pattern(regexp = "^\\d{6}$", message = "交易时间格式必须yyyyMMdd")
    @NotNull
    private String transTime;
    /**
     * sftpPath	sftp完整路径(包含文件名)	varchar(100)	M		融合订单的具体明细txt文件sftp完整路径
     */
    @Length(min = 1, max = 100, message = "sftp完整路径长度范围[{min},{max}]")
    @NotNull
    private String sftpPath;

    @NotNull
    @URL(message = "结果回调通知地址格式不正确")
    private String callbackUrl;


}
