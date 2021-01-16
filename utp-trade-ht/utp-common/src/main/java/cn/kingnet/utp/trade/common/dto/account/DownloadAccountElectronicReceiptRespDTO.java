package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : 开户电子回单下载
 * @Author : linkaigui
 * @Create : 2020/3/13 10:18
 */
@Getter
@Setter
public class DownloadAccountElectronicReceiptRespDTO extends BaseResponseDTO {

    /**
     * 账户电子回单号
     */
    private String accountReceiptNo;

    /**
     * 账户电子回单pdf文件流
     */
    private String content;
}
