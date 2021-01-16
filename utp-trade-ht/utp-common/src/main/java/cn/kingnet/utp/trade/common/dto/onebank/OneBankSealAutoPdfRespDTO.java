package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : PDF自动化签章接口
 * @Author : linkaigui
 * @Create : 2020/7/6 14:24
 */
@Setter
@Getter
public class OneBankSealAutoPdfRespDTO extends SpBaseResponse {

    /**
     * PDF文件数据(压缩后再base64编码)
     */
    private String sealedPdfData;
}
