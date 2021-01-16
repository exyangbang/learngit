package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.ElectronicTemplateKey;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : PDF自动化签章接口
 * @Author : linkaigui
 * @Create : 2020/7/6 14:24
 */
@Setter
@Getter
public class OneBankSealAutoPdfReqDTO extends SpBaseRequest {

    /**
     * 模板KEY
     */
    private ElectronicTemplateKey electronicTemplateKey;

    /**
     * pdf文件数据或者pdf文件路径或者pdfId（pdfId表示之前保存的savedPdfId）
     */
    private String pdf;

    /**
     * 临时保存的pdfId
     */
    private String savedPdfId;
}
