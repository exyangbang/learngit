package cn.kingnet.utp.product.common.service;

import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.trade.common.model.AuthConfigInfo;

/**
 * @Description : 获取证书配置信息接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/31 15:24
 */
public interface IAuthConfigInfoService {

    /**
     * 获取证书配置信息
     * @param tradeContext
     * @return
     */
    public AuthConfigInfo gainAuthConfigInfo(TradeContext tradeContext);
}
