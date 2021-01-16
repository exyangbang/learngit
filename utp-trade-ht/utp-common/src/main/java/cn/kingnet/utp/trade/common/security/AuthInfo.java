package cn.kingnet.utp.trade.common.security;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description 头部授权信息载体
 * @Author WJH
 * @Date 2018年09月06日
 */
@Data
public class AuthInfo {

    public AuthInfo(){}
    /**
     * 授权开头部分
     */
    private String startStr;

    /**
     * 授权编号
     */
    private String authNo;
    /**
     * 签名信息
     */
    private String sign;
    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * headers里Authorization字段UTP01:merNo:sign的base64编码:timestamp
     * 标识签名验签采用RSA算法
     */
    public AuthInfo(String head_authorization) {
        if (StringUtil.isEmpty(head_authorization)) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "Authorization 信息不能为空");
        }
        List<String> authArray = Splitter.on(CharMatcher.anyOf(CommonConstants.SEPARATER_COLON)).omitEmptyStrings().trimResults().splitToList(head_authorization);
        if (CollectionUtils.isEmpty(authArray) || authArray.size() < 4) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "Authorization 信息参数有误");
        }
        ValidateUtils.abcValid(authArray.get(1),true,"Authorization信息");
        this.setStartStr(authArray.get(0));
        this.setAuthNo(authArray.get(1).trim());
        this.setSign(authArray.get(2));
        this.setTimestamp(authArray.get(3));
    }

}
