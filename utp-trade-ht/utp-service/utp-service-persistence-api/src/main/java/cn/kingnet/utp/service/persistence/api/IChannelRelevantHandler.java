package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 渠道信息及路由获取服务
 * @Author : linkaigui
 * @Create : 2019/2/22 11:35
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/channelRelevant")
public interface IChannelRelevantHandler {

    /**
     * 获取渠道信息 仅查询关联信息不校验渠道剩余额度
     * @param industryCode
     * @param productNo
     * @param channelKey 如有值只查询指定值的渠道信息
     * @return
     */
    @PostMapping("/findChannelInfoBO")
    ChannelInfoBO findChannelInfoBO(@RequestParam(value = "industryCode", required = false) String industryCode,
                                    @RequestParam(value = "productNo", required = false) String productNo,
                                    @RequestParam(value = "channelKey", required = false) String channelKey);


    /**
     * A=》对方账户[企业public、个人private]   B=》付款方资金账户类型[内部户、一般户]   C=》渠道优先顺序集合
     * 企业账户仅能走人行大小额,银联渠道不支持对公
     * 个人账户优选走银联渠道，渠道剩余额度不足走其他渠道
     * 内部户调用华通的RDFA异步对私
     * 一般户调用华通CDFA异步对公
     *
     * @param industryCode 代付客户号
     * @param productNo 产品编码
     * @param payeeAccType 对方账户类型
     * @param payAmt  交易金额
     * @param tradeDateTime 交易时间 yyyyMMddHHmmss
     * @return
     */
     @PostMapping("/selectChannelInfoBo")
     ChannelInfoBO selectChannelInfoBo( @RequestParam(value = "industryCode") String industryCode, @RequestParam(value = "productNo") String productNo,@RequestParam(value = "payeeAccType")String payeeAccType, @RequestParam(value = "payAmt")long payAmt, @RequestParam(value = "tradeDateTime")String tradeDateTime);

}
