package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : PDF自动化合成模板业务数据接口
 * 合成业务数据到模板生成单据，业务数据包括文本、图片；不返回合成后pdf文件，只返回保存在临时表中的pdfId
 * @Author : linkaigui
 * @Create : 2020/7/6 13:42
 */
@Setter
@Getter
public class OneBankSynthesizeTemplateWithPdfIdRespDTO extends SpBaseResponse {

    /**
     * 合成后pdf文件保存到临时表中的pdfId，符合唯一约束，如果不上送，则服务端生成
     */
    private String savedPdfId;
}
