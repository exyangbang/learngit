package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月07日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DownloadIndustrySubAccountDailyBalanceFileRespDTO extends BaseResponseDTO {

    /**
     * 是否下载成功标志	varchar(10)		M	成功标志，
     * 成功：true
     * 失败：false
     */
    private String success;

    /**
     * 提示信息
     */
    private String desc;


    /**
     * D日对账单文件域 必填
     * 回执文件byte[]经过
     * defalter压缩后再Base64编码字符串
     * 回执文件格式详见：
     * D日对账文件内容格式
     */
    private String content;

}
