package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description
 * 根据客户号、交易日期下载平台下所有子账户的日终余额。（D+1日00:30分以后可以下载D日的余额对账单，数据最多保留10天）
 * @Author WJH
 * @Date 2018年11月07日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DownloadIndustrySubAccountDailyBalanceFileReqDTO extends BaseRequestDTO {


    /**
     * 交易日期（yyyyMMdd）
     */
    private String txDate;

}
