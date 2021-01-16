package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.ElectronicTemplateKey;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @Description : PDF自动化合成模板业务数据接口
 *  合成业务数据到模板生成单据，业务数据包括文本、图片；返回合成后pdf文件
 * @Author : linkaigui
 * @Create : 2020/7/7 10:20
 */
@Setter
@Getter
public class OneBankSynthesizeAutoTemplateReqDTO extends SpBaseRequest {

    /**
     * 模板KEY
     */
    private ElectronicTemplateKey electronicTemplateKey;

    /**
     * 合成后pdf文件保存到临时表中的pdfId，符合唯一约束，如果不上送，则服务端生成
     */
    private String savedPdfId;

    /**
     * 合成业务数据
     */
    private Map<String,Object> fieldMap;
}
