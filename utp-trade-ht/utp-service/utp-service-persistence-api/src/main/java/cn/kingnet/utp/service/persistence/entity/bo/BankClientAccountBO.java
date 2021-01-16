package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 银行客户号关联信息
 * @Author WJH
 * @Date 2020/05/14
 */
@Data
public class BankClientAccountBO implements Serializable {

    /**
     * 虚账号
     */
    private String account;

    /**
     * 银行客户号
     */
    private String bankClientNo;

    /**
     * 银行客户号关联标识0开户未上报 1开户已上报 2更新未上报 3更新已上报 4销户未上报
     */
    private Integer bankClientStatus;

    /**
     * 银行客户号开户渠道标识 0簿记自有渠道 1簿记其他渠道
     */
    private Integer bankClientChnFlag;

}
