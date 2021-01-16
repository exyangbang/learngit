package com.scenetec.upf.operation.model.vo;

import lombok.Data;

/**
 * @Description
 * @Author WJH
 * @Date 2019/07/24
 */
@Data
public class ValidAccountInfoReqDTO  extends BaseInnerManageReqDTO{
    /**
     * 华通账号
     */
    private String fundAccNo;
    /**
     * 华通账户名称
     */
    private String fundAccName;
    /**
     * 账户类型：1=内部户类型 2=一般户类型
     */
    private String fundAccType;


    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "fundAccNo=".concat(fundAccNo), "fundAccName=".concat(fundAccName), "fundAccType=".concat(fundAccType)};
    }
}
