package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description : orc身份识别
 * @Author : WJH
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class OneBankOnlineCheckRespDTO extends SpBaseResponse implements Serializable {

    /**
     * 交易码
     */
    private String transCode;
    /**
     * 是否简项核查
     */
    private String isSimpleCheck;
    /**
     * 渠道编码
     */
    private String chlCode;
    /**
     * 业务发生地
     */
    private String businessPlace;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 是否返回照片
     */
    private String doReturnPhoto;
    /**
     * 返回信息
     */
    private String returnMsg;
    /**
     * 返回编码
     */
    private String returnCode;
    /**
     * 服务异常描述
     */
    private String msgServError;
    /**
     * 证件数组
     */
    private List<idArray> idArray;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class idArray implements Serializable {
        /**
         * 证件类型
         */
        private String idType;
        /**
         * 公民姓名
         */
        private String personName;
        /**
         * 公民证件号码
         */
        private String personId;
        /**
         * 查询结果描述
         */
        private String msgIdError;
        /**
         * 证件号码核查结果
         */
        private String resultPersonId;
        /**
         * 姓名核查结果
         */
        private String resultPersonName;

    }
}