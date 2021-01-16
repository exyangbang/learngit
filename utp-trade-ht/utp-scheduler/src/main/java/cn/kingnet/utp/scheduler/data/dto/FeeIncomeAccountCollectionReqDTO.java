package cn.kingnet.utp.scheduler.data.dto;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/15
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeeIncomeAccountCollectionReqDTO extends BaseRequestDTO {
    /**
     * 手续费归集统计表主键ID
     */
    private Long feeStatId;
    /**
     * 交易表主键ID
     */
    private Long transId;

    /**
     * 统计月份yyyyMMdd
     */
    private String statMonth;
    /**
     * 归集划转金额 入金-出金
     */
    private long transAmount;
    /**
     * 统计手续费收益账户：虚账户
     */
    private String account;
    /**
     * 备注说明：收益账户+statMont+归集划转
     */
    private String remark;

    private String feeIndustryCode;
    private String feeIndustryName;
    private String feeIndustryAccount;
    private String feeOrgCode;
    private String feeOrgName;
    private String feeFundAccType;
    private String feeFundAccNo;
    private String feeFundAccName;
    private String feeFundOpBankCode;

    private String collectionIndustryCode;
    private String collectionIndustryName;
    private String collectionIndustryAccount;
    private String collectionFundAccType;
    private String collectionFundAccNo;
    private String collectionFundAccName;
    private String collectionFundOpBankCode;


}
