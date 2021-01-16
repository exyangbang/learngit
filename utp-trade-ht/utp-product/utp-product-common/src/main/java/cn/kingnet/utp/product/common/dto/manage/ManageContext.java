package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.utils.StringUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/14
 */
public class ManageContext<REQ extends BaseInnerManageReqDTO, RESP extends BaseInnerManageRespDTO> implements Serializable {

    private final String serverTransId;
    private final String clientTransId;
    private final String reqDate;
    private final String reqTime;

    private final REQ requestDTO;
    private RESP responseDTO;

    /**
     * 其他参数容器
     */
    private Map<String, Object> attribute = new HashMap<>();
    private ChannelResponseDTO channelResponseDTO;


    public ManageContext(String serverTransId, String clientTransId, String reqDate, String reqTime, REQ requestDTO) {
        this.serverTransId = serverTransId;
        this.clientTransId = clientTransId;
        this.reqDate = reqDate;
        this.reqTime = reqTime;
        this.requestDTO = requestDTO;
    }


    public String getServerTransId() {
        return serverTransId;
    }

    public String getClientTransId() {
        return clientTransId;
    }

    public String getReqDate() {
        return reqDate;
    }

    public String getReqTime() {
        return reqTime;
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

    public ChannelResponseDTO getChannelResponseDTO() {
        return channelResponseDTO;
    }

    public void setChannelResponseDTO(ChannelResponseDTO channelResponseDTO) {
        this.channelResponseDTO = channelResponseDTO;
    }

    public <V> V getAttribute(String key) {
        Object value = Optional.ofNullable(key).map(this.attribute::get).orElse(null);
        return value == null ? null : (V) value;
    }

    public ManageContext setAttribute(String key, Object value) {
        Optional.ofNullable(key).ifPresent(k -> this.attribute.put(k, value));
        return this;
    }


    public String getTransStatus() {
        TransStatus status = TransStatus.PROCESSING;
        RESP sctrpResp = this.getResponseDTO();
        if (sctrpResp != null) {
            if (StringUtil.isNotBlank(sctrpResp.getStatus())) {
                HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(sctrpResp.getStatus()));
                if (httpRespStatus.is2xxSuccessful()) {
                    status = TransStatus.PROCESSING;
                } else if (httpRespStatus.is4xxClientError()) {
                    status = TransStatus.TRADE_FAILURE;
                } else if (httpRespStatus.is5xxServerError()) {
                    status = TransStatus.PROCESSING;
                }
            } else {
                status = TransStatus.PROCESSING;
            }
        } else {
            status = TransStatus.TRADE_FAILURE;
        }
        return status.toString();
    }

}
