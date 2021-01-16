package cn.kingnet.utp.product.common.model;

import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.model.AuthConfigInfo;
import cn.kingnet.utp.trade.common.security.AuthInfo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * 交易服务上下文
 * Created on 2018/9/6
 *
 * @author by linkaigui
 */

@SuppressWarnings("unchecked")
public class TradeContext<REQ extends BaseRequestDTO, RESP extends BaseResponseDTO> implements Serializable {

    /**
     * 交易注解类
     */
    private TradeService tradeService;
    /**
     * 服务端流水号
     */
    private String serverTransId;
    /**
     * 客户端流水号
     */
    private String clientTradeId;
    /**
     * 交易请求日期
     */
    private String transDate;
    /**
     * 交易请求时间
     */
    private String transTime;
    /**
     * 客户端请求信息
     */
    private REQ requestDTO;
    /**
     * 转接平台响应客户端信息
     */
    private RESP responseDTO;
    /**
     * 头部：Authoriztion
     */
    private AuthInfo authInfo;
    /**
     * 证书配置信息
     */
    private AuthConfigInfo authConfigInfo;
    /**
     * 渠道响应信息
     */
    private ChannelResponseDTO channelResponseDTO;
    /**
     * 其他参数容器
     */
    private Map<String, Object> attribute = new HashMap<>();
    /**
     * 客户端请求Ip
     */
    private String remoteIp;
    /**
     * 头部：请求客户号
     */
    private String industryCode;


    public TradeContext(String serverTransId, String clientTradeId, String transDate, String transTime, REQ requestDTO) {
        this.serverTransId = serverTransId;
        this.clientTradeId = clientTradeId;
        this.transDate = transDate;
        this.transTime = transTime;
        this.requestDTO = requestDTO;
    }

    public TradeService getTradeService() {
        return tradeService;
    }

    public void setTradeService(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    public String getServerTransId() {
        return serverTransId;
    }

    public String getTransDate() {
        return transDate;
    }

    public String getTransTime() {
        return transTime;
    }


    public REQ getRequestDTO() {
        return requestDTO;
    }

    public RESP getResponseDTO() {
        return responseDTO;
    }

    public void setResponseDTO(RESP responseDTO) {
        this.responseDTO = responseDTO;
    }

    public AuthInfo getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    public AuthConfigInfo getAuthConfigInfo() {
        return authConfigInfo;
    }

    public void setAuthConfigInfo(AuthConfigInfo authConfigInfo) {
        this.authConfigInfo = authConfigInfo;
    }

    public ChannelResponseDTO getChannelResponseDTO() {
        return channelResponseDTO;
    }

    public void setChannelResponseDTO(ChannelResponseDTO channelResponseDTO) {
        this.channelResponseDTO = channelResponseDTO;
    }

    public String getClientTradeId() {
        return clientTradeId;
    }

    public <T> T getAttribute(String key) {
        Object object = ofNullable(key).map((k) -> this.attribute.get(k)).orElse(null);
        return object != null ? (T) object : null;
    }

    public TradeContext setAttribute(String key, Object value) {
        ofNullable(key).ifPresent((keys) -> this.attribute.put(keys, value));
        return this;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }
}
