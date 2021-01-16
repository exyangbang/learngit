package cn.kingnet.utp.channel.onebank.configuration;

import cn.kingnet.utp.trade.common.enums.ElectronicTemplateKey;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 电子印章系统参数
 * @Author : linkaigui
 * @Create : 2020/7/6 15:13
 */
@ConfigurationProperties(prefix = "cn.kingnet.utp.channel.onebank.electronic")
@Setter
@Getter
public class OnebankElectronicProperties {

    /**
     * 请求地址
     */
    private String url;

    /**
     * 连接超时
     */
    private int connectTimeout = 10000;

    /**
     * 请求超时
     */
    private int readTimeout = 60000;

    /**
     * 请求机构编码
     */
    private String operatorCode;

    /**
     * 请求渠道编码
     */
    private String channelCode;

    /**
     * 印章编码
     */
    private String sealCode;

    /**
     * 印章密码
     */
    private String sealPassword;

    /**
     * 是否加密
     */
    private String encrypt = "true";

    /**
     * 获取时间戳的方式。默认值为0。0：实时访问CFCA 时间戳服务；1：使用从CFCA购置并在本地部署的时间戳服务器产品
     */
    private String timestampChannel = "0";

    /**
     * 模版参数配置列表
     */
    private Map<String, TemplateConfig> templateConfigMap = new HashMap<>();

    /**
     * 模版参数配置
     */
    @Setter
    @Getter
    public static class TemplateConfig {
        /**
         * 模版代码
         */
        private String templateCode;
        /**
         * 签章类型(1=空白标签签章,2=坐标签章,3=关键字签章，4=位置标识)
         */
        private String signLocationType;

        //=====================2=按坐标签章 参数=======================
        /**
         * 页数
         */
        private int page = 1;
        /**
         * 左侧的x坐标（单位：像素）
         */
        private int leftX;
        /**
         * 左侧的y坐标（单位：像素）
         */
        private int leftY;
        //=====================2=按坐标签章 参数=======================

        //=====================3=按关键字签章 参数=======================
        /**
         * 关键字
         */
        private String keyword;
        /**
         * 位置风格：（上:U；下:D；左:L；右:R；中:C）；默认：C；
         */
        private String locationStyle = "C";
        /**
         * 横轴偏移，默认为0（单位：像素）
         */
        private int offsetX = 0;
        /**
         * 纵轴偏移，默认为0（单位：像素）
         */
        private int offsetY = 0;
        /**
         * 关键字位置索引（1：第一个位置；2：第二个位置；0：默认全部位置盖章，支持1、2、1-3、3-9格式，如果输入非法数字或者负数当做0处理，如果输入的数字大于关键字数量时就在最后一个位置盖章处理）
         */
        private String keywordPositionIndex = "0";
        //=====================3=按关键字签章 参数=======================

        //=====================4=按位置标识签章 参数=======================
        /**
         * 签章位置标识编码
         */
        private String locationCode;
        //=====================4=按位置标识签章 参数=======================

    }

    public OnebankElectronicProperties.TemplateConfig getTemplateConfig(final ElectronicTemplateKey electronicTemplateKey) {
        if (templateConfigMap.containsKey(electronicTemplateKey.getCode())) {
            return templateConfigMap.get(electronicTemplateKey.getCode());
        } else {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "未找到模版参数配置:" + electronicTemplateKey.getCode());
        }
    }
}
