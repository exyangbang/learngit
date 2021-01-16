package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : 开户电子回单下载
 * @Author : linkaigui
 * @Create : 2020/3/13 10:18
 */
@Getter
@Setter
public class DownloadAccountElectronicReceiptReqDTO extends BaseRequestDTO {

    /**
     * 用户账户
     */
    private String userAccount;

    /**
     * 证件号码(
     * 个人/个体工商：身份证号码
     * 企业开户：营业执照)
     */
    private String certificateNo;

}
