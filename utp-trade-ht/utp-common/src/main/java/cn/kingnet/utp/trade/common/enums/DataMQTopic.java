package cn.kingnet.utp.trade.common.enums;

/**
 * Created on 2018/5/16
 *
 * @author by linkaigui
 */
public enum DataMQTopic {

    //交易流水表处理
    MqTopic_TransFlow,
    //交易请求报文保存
    MqTopic_TransMsg,
    //回调交易请求报文保存
    MqTopic_TransCallBackMsg;

    DataMQTopic() {
    }
}
