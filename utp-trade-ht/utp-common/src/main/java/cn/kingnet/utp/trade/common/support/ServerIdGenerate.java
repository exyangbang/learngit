package cn.kingnet.utp.trade.common.support;

import cn.kingnet.utp.trade.common.utils.IdGenerate;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/14
 */
public class ServerIdGenerate {

    private String chlDfa;
    private String chlSystemId;

    private String utpSystemId;
    private String utpServiceId;

    public ServerIdGenerate(String chlDfa, String chlSystemId, String utpSystemId, String utpServiceId) {
        this.chlDfa = chlDfa;
        this.chlSystemId = chlSystemId;
        this.utpSystemId = utpSystemId;
        this.utpServiceId = utpServiceId;
    }

    /**
     * 生成服务端流水号：同时也是渠道入参的请求流水号
     *
     * @return
     */
    public String generateServerTransId() {
        return IdGenerate.generateServerTransId(this.chlDfa, this.chlSystemId);
    }

    /**
     * 生成客户端流水号
     *
     * @return
     */
    public String generateClientTransId() {
        return IdGenerate.generateServerTransId(this.utpSystemId, this.utpServiceId);
    }

}
