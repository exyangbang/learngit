package com.scenetec.upf.operation.model.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 下载PDF
 * @author sheqingquan@scenetec.com
 * @create 2020/5/11 15:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DownloadPdfRespDTO extends BaseInnerManageRespDTO {

    /**
     * PDF文件内容
     */
    private byte[] content;
}