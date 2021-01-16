package cn.kingnet.utp.sdk.precard.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月07日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownloadIndustryReconcileFileRespDTO extends BaseResponseDTO {

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
