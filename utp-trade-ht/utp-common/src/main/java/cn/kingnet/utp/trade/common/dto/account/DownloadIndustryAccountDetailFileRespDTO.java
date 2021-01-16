package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
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
public class DownloadIndustryAccountDetailFileRespDTO extends BaseResponseDTO {

    /**
     * 是否成功 success true,false
     */
    private String success;

    /**
     * 提示信息
     */
    private String desc;


    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;

}
