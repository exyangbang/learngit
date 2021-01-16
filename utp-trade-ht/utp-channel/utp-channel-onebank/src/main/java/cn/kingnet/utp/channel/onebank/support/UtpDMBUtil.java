package cn.kingnet.utp.channel.onebank.support;

import cn.kingnet.utp.trade.common.enums.DFA;
import cn.kingnet.utp.trade.common.enums.FundAccType;
import cn.onebank.gns.api.query.GnsQueryApi;
import cn.onebank.gns.common.message.GetCDfaNumReq;
import cn.onebank.gns.common.message.GetCDfaNumResp;
import cn.onebank.gns.common.message.GetRDfaListReq;
import cn.onebank.gns.common.message.GetRDfaListResp;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/25
 */
@Slf4j
public class UtpDMBUtil {

    /**
     * 获取对私 targetDFA
     */
    public static String getRDfaListSync() {
        GetRDfaListResp resp = GnsQueryApi.getRDfaListSync(new GetRDfaListReq());
        log.debug("GnsQueryApi 获取对私targetDFA 响应内容：<< {}", JSON.toJSONString(resp));
        if (resp != null) {
            return Optional.ofNullable(resp.getDfaList()).map(l -> l.stream().findFirst().orElse(null)).orElse(null);
        }
        return null;
    }

    /**
     * 获取对公 targetDFA
     */
    public static String getCDfaNumSync() {
        GetCDfaNumResp resp = GnsQueryApi.getCDfaNumSync(new GetCDfaNumReq());
        log.debug("GnsQueryApi 获取对公targetDFA 响应内容：<< {}", JSON.toJSONString(resp));
        if (resp != null) {
            return Optional.ofNullable(resp.getDfaNum()).orElse(null);
        }
        return null;
    }

    /**
     * @param fundAccType 资金账户性质
     * @return
     */
    public static String getTargetDfaByFundAccType(FundAccType fundAccType) {
        String targetDFA = null;
        if (FundAccType.INNER_ACC == fundAccType) {
            targetDFA = getRDfaListSync();
        } else if (FundAccType.GENERAL_ACC == fundAccType) {
            targetDFA = getCDfaNumSync();
        }
        if (targetDFA == null) {
            log.error("GnsQueryApi 获取资金账户[] 的targetDFA 失败", fundAccType.getDesc());
            throw new RuntimeException("GnsQueryApi 获取targetDFA 失败");
        }
        return targetDFA;
    }

    /**
     * @param dfa 华通行内数据区域
     * @return
     */
    public static String getTargetDfaByDFA(DFA dfa) {
        String targetDFA = null;
        if (DFA.RDFA == dfa) {
            targetDFA = getRDfaListSync();
        } else if (DFA.CDFA == dfa) {
            targetDFA = getCDfaNumSync();
        } else {
            //默认取值对公区
            targetDFA = getCDfaNumSync();
        }
        if (targetDFA == null) {
            log.error("GnsQueryApi 获取的targetDFA 失败");
            throw new RuntimeException("GnsQueryApi 获取targetDFA 失败");
        }
        return targetDFA;
    }
}
