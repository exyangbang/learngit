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
public class DownloadPdfReqDTO extends BaseInnerManageReqDTO {

    /**
     * 主键id M
     */
    private Long id;
    /**
     * 请求类型
     * 1 下载支付流水 t_outside_trans_order
     * 2 下载电子回单表 t_electronic_receipt
     * 3 下载开户电子回单 t_account_electronic_receipt
     */
    private String type;

    @Override
    public String[] toSHA1() {
        return new String[]{"appid=" + appid, "secret=" + secret,
                "id=" + id,
                "type=" + type
        };
    }
}