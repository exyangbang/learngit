package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.dto.manage.ValidAccountInfoReqDTO;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.ICardBinHandler;
import cn.kingnet.utp.service.persistence.entity.CardBinInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountInfoQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountInfoQueryRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountBalanceQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountBalanceQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.DFA;
import cn.kingnet.utp.trade.common.enums.FundAccType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/07/24
 */
@Service
@Slf4j
public class ValidAccountInfoService {

    private IPaymentService paymentService;
    private ProductAccountProperties productAccountProperties;
    private ICardBinHandler cardBinHandler;

    public ValidAccountInfoService(ProductAccountProperties productAccountProperties, IPaymentService paymentService, ICardBinHandler cardBinHandler) {
        this.productAccountProperties = productAccountProperties;
        this.paymentService = paymentService;
        this.cardBinHandler = cardBinHandler;
    }

    public ServerResponseDTO validAccountInfo(ValidAccountInfoReqDTO reqDTO) {

        if (reqDTO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数不能为空");
        }
        FundAccType fundAccType = FundAccType.resolve(reqDTO.getFundAccType());
        if (fundAccType == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "资金账户类型有误[" + reqDTO.getFundAccType() + "]");
        }
        if (StringUtil.isBlank(reqDTO.getFundAccNo()) || StringUtil.isBlank(reqDTO.getFundAccName())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "资金账号或账户名称不能为空");
        }
        if (!SHA1.genWithAmple(reqDTO.toSHA1()).equals(reqDTO.getSign())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }
        ServerResponseDTO serverResponseDTO;
        if (fundAccType == FundAccType.GENERAL_ACC) {
            serverResponseDTO = validGeneralAcc(reqDTO);
        } else if (fundAccType == FundAccType.INNER_ACC) {
            serverResponseDTO = validInnerAcc(reqDTO);
        } else {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "资金账户类型有误[" + reqDTO.getFundAccType() + "]");
        }

        return serverResponseDTO;
    }

    private ServerResponseDTO validGeneralAcc(ValidAccountInfoReqDTO reqDTO) {
        ServerResponseDTO serverResponseDTO = null;
        OneBankAccountInfoQueryReqDTO onebankReqDTO = new OneBankAccountInfoQueryReqDTO();
        onebankReqDTO.setAcctType(productAccountProperties.getPublicAccount().getSysHeaderAcctType());
        onebankReqDTO.setAcctNo(reqDTO.getFundAccNo());
        onebankReqDTO.setClientTradeId(generateServerTransId());
        onebankReqDTO.setCustAccountNo(reqDTO.getFundAccNo());
        onebankReqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        onebankReqDTO.setReqDate(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        // 一般户信息查询 需要根据对公|对私账户来上送 targetDfa，一般户转账接口应该也有类似问题，行内建议一般户转账暂不处理
        CardBinInfo cardBinInfo = cardBinHandler.getCardBinInfo(onebankReqDTO.getCustAccountNo());
        // 卡bin匹配中即为 对私账户 其他默认对公账户 || 行内联调指导 对私账户走对私区 对公账户走对公区 卡bin匹配中则为对私账户否则对公账户
        if (cardBinInfo == null) {
            LambdaLogger.warn(log, "一般户[{}]未能在卡bin表中匹配，则默认为对公账户，targetDFA走CDFA区", onebankReqDTO.getCustAccountNo());
        }
        onebankReqDTO.setDfa(cardBinInfo != null ? DFA.RDFA : DFA.CDFA);
        ChannelResponseDTO channelResponseDTO = paymentService.accountInfoQuery(onebankReqDTO);
        if (channelResponseDTO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "渠道响应报文为空");
        }
        if (channelResponseDTO != null) {
            log.info("校验一般户基础信息 << 资金账户{}[{}] 响应报文：{}", reqDTO.getFundAccNo(), reqDTO.getFundAccName(), JSON.toJSONString(channelResponseDTO));
        }
        if (channelResponseDTO.getSpRespMsg() == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("渠道响应业务数据内容为空.[%s]:%s", channelResponseDTO.getStatus(), channelResponseDTO.getMessage()));
        }
        OneBankAccountInfoQueryRespDTO onebankRespDTO = JSON.parseObject(JSON.toJSONString(channelResponseDTO.getSpRespMsg()), OneBankAccountInfoQueryRespDTO.class);
        if (onebankRespDTO != null && reqDTO.getFundAccNo().equals(onebankRespDTO.getCustAccountNo()) && reqDTO.getFundAccName().equals(onebankRespDTO.getAccountName())) {
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.OK.valueStr(), "一般户信息校验成功");
        } else if (onebankRespDTO != null) {
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.NOT_FOUND.valueStr(), String.format("一般户信息校验失败.[%s] %s", reqDTO.getFundAccNo(), reqDTO.getFundAccName()));
        } else {
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.NOT_FOUND.valueStr(), String.format("一般户信息校验失败.[%s] %s", channelResponseDTO.getStatus(), channelResponseDTO.getMessage()));
        }

        return serverResponseDTO;
    }

    private ServerResponseDTO validInnerAcc(ValidAccountInfoReqDTO reqDTO) {
        ServerResponseDTO serverResponseDTO = null;

        OneBankInnerAccountBalanceQueryReqDTO onebankReqDTO = new OneBankInnerAccountBalanceQueryReqDTO();
        onebankReqDTO.setSubAccount(reqDTO.getFundAccNo());
        onebankReqDTO.setStartingRow("0");
        onebankReqDTO.setFirstInquiryFlg("1");
        onebankReqDTO.setPerReturnRows("100");

        onebankReqDTO.setReqDate(DateUtil.getCurrentDate());
        onebankReqDTO.setReqTime(DateUtil.getCurrentTime());
        onebankReqDTO.setClientTradeId(generateServerTransId());
        ChannelResponseDTO channelResponseDTO = paymentService.innerAccountBalanceQuery(onebankReqDTO);
        if (channelResponseDTO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "渠道响应报文为空");
        }
        if (channelResponseDTO != null) {
            log.info("校验内部户基础信息 << 资金账户{}[{}] 响应报文：{}", reqDTO.getFundAccNo(), reqDTO.getFundAccName(), JSON.toJSONString(channelResponseDTO));
        }
        //查询成功
        if (channelResponseDTO != null && HttpRespStatus.OK.valueStr().equals(channelResponseDTO.getStatus())) {
            JSONObject reJson = new JSONObject(channelResponseDTO.getSpRespMsg());
            String data = reJson.getString("data");
            if (StringUtil.isNotEmpty(data)) {
                List<OneBankInnerAccountBalanceQueryRespDTO> respDTOList = JSON.parseArray(data, OneBankInnerAccountBalanceQueryRespDTO.class);
                if (respDTOList != null) {
                    OneBankInnerAccountBalanceQueryRespDTO onebankRespDTO = respDTOList.get(0);
                    if (onebankRespDTO != null && reqDTO.getFundAccNo().equals(onebankRespDTO.getSubaccount()) && reqDTO.getFundAccName().equals(onebankRespDTO.getAccountName())) {
                        serverResponseDTO = new ServerResponseDTO(HttpRespStatus.OK.valueStr(), "内部户信息校验成功");
                    } else if (onebankRespDTO != null) {
                        serverResponseDTO = new ServerResponseDTO(HttpRespStatus.NOT_FOUND.valueStr(), String.format("内部户信息校验失败.[%s] %s", onebankRespDTO.getSubaccount(), onebankRespDTO.getAccountName()));
                    } else {
                        serverResponseDTO = new ServerResponseDTO(HttpRespStatus.NOT_FOUND.valueStr(), String.format("内部户信息校验失败.[%s] %s", channelResponseDTO.getStatus(), channelResponseDTO.getMessage()));
                    }
                }
            }
        } else {
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.NOT_FOUND.valueStr(), String.format("内部户信息校验失败.[%s] %s", channelResponseDTO.getStatus(), channelResponseDTO.getMessage()));
        }
        return serverResponseDTO;
    }


    protected String generateServerTransId() {
        return IdGenerate.generateServerTransId(this.productAccountProperties.getDfa(), this.productAccountProperties.getSystemId());
    }

}
