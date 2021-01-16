package cn.kingnet.utp.trade.common.enums;

/**
 * @Description 已有服务信息
 * @Author WJH
 * @Date 2019/08/14
 */
public enum UtpServiceId {
    DISCOVERY("101", "utp-trade-discovery", 9761, "注册中心服务"),
    CONFIG("201", "utp-config-server", 9803, "配置中心服务"),
    PERSISTENCE("301", "utp-service-persistence", 9806, "持久化服务"),
    CHANNEL("401", "utp-channel-onebank", 9808, "华通渠道服务"),
    PRODUCT("501", "utp-product-account", 9807, "代付+记账产品服务"),
    RECONCILIATION("601", "utp-reconciliation", 9802, "渠道侧对账服务"),
    SCHEDULER("701", "utp-scheduler", 9809, "任务调度服务"),
    MANAGE("801", "utp-manage-api", 9083, "后管API服务"),
    ;
    private String id;
    private String name;
    private String desc;
    private int port;
    public static final String SYSTEM_ID = "UTP";
    public static final String SYSTEM_VERSION = "2.5.5";

    UtpServiceId(String id, String name, int port, String desc) {
        this.id = id;
        this.name = name;
        this.port = port;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return String.format("==========华通簿记平台[%s:%s]启动成功===版本[%s]=======", getDesc(), getPort(), SYSTEM_VERSION);
    }
}
