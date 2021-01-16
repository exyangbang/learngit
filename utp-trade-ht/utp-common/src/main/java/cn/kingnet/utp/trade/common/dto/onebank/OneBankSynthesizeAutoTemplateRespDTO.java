package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : PDF自动化合成模板业务数据接口
 * 合成业务数据到模板生成单据，业务数据包括文本、图片；返回合成后pdf文件
 * @Author : linkaigui
 * @Create : 2020/7/7 10:21
 */
@Setter
@Getter
public class OneBankSynthesizeAutoTemplateRespDTO extends SpBaseResponse {

    /**
     * PDF文件数据(压缩后再base64编码)
     */
    private String sealedPdfData;
}
