package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : orc身份识别
 * @Author : WJH
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class OneBankOrcIdentityRespDTO extends SpBaseResponse implements Serializable {

    /**
     * 交易返回码
     */
    private String retCode;
    /**
     * 交易返回信息描述
     */
    private String retMsg;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     * 男/女
     */
    private String sex;
    /**
     * 民族
     */
    private String people;
    /**
     * 生日
     * 分年月日，都是一个字符串
     */
    private String birthday;
    /**
     * 地址
     */
    private String address;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 正面反面
     */
    private String type;
    /**
     * 签发机关
     */
    private String issueAuthority;
    /**
     * 有效日期
     * 表示内容如下YYYY.MM.DD-yyyy.mm.dd，或是YYYY.MM.DD-长期。
     */
    private String validity;
}
