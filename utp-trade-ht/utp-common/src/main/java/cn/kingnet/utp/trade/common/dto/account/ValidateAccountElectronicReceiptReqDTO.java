package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : 开户电子回单验证
 * @Author : linkaigui
 * @Create : 2020/3/13 15:52
 */
@Setter
@Getter
public class ValidateAccountElectronicReceiptReqDTO extends BaseRequestDTO {

    /**
     * 账户电子回单号
     */
    private String accountReceiptNo;

    /**
     * 电子回单PDF文件流
     */
    private String content;
}
