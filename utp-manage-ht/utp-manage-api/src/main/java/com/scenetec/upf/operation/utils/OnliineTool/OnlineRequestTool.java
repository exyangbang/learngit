package com.scenetec.upf.operation.utils.OnliineTool;

import com.alibaba.fastjson.JSON;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OnlineRequestTool {
    private Logger logger = LoggerFactory.getLogger(OnlineRequestTool.class);

    public ServerResponseDTO postResquest(String url, Object obj) {
        RestTemplate restTemplate = new RestTemplate();
        ServerResponseDTO resultMap = new ServerResponseDTO();
        try {
            resultMap = restTemplate.postForObject(url, obj, ServerResponseDTO.class);
        } catch (Exception e) {
            logger.error("请求地址：" + url + "====服务器出错" + e);
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "服务器出错");
        }
        if (resultMap == null) {
            logger.error("请求地址：" + url + "====" + JSON.toJSONString(obj));
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机问题。返回空" + url);
        }
        if (!resultMap.getStatus().equals("200")) {
            if (resultMap.getMessage() != null) {
                logger.error("请求地址：" + url + "====" + resultMap.getMessage() + "====" + JSON.toJSONString(obj));
                throw new SystemRuntimeException(ErrorCode.BSMPS001, resultMap.getMessage());
            }
            logger.error("请求地址：" + url + "====" + JSON.toJSONString(obj));
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机处理失败");
        }
        return resultMap;
    }

    /***
     * 提现审核
     * @param url
     * @param obj
     * @return
     */
    public CollectionAccountWithdrawRespDTO collectionpostResquest(String url, Object obj) {
        CollectionAccountWithdrawRespDTO resultMap;
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(30000);// 设置超时
        requestFactory.setReadTimeout(30000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        resultMap = restTemplate.postForObject(url, obj, CollectionAccountWithdrawRespDTO.class);
        pubMeth(resultMap, url, obj);
        return resultMap;
    }

    /**
     * 刷新提现状态
     *
     * @param url
     * @param obj
     * @return
     */
    public QueryCollectionAccountWithdrawRespDTO queryCollectionpostResquest(String url, Object obj) {
        QueryCollectionAccountWithdrawRespDTO resultMap;
        try {
            RestTemplate restTemplate = new RestTemplate();
            resultMap = restTemplate.postForObject(url, obj, QueryCollectionAccountWithdrawRespDTO.class);
        } catch (Exception e) {
            logger.error("请求地址：" + url + "====" + JSON.toJSONString(obj));
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机处理失败");
        }
        pubMeth(resultMap, url, obj);
        return resultMap;
    }

    /**
     * 归集查询
     *
     * @param url
     * @param obj
     * @return
     */
    public QueryFeeIncomeAccountCollectionRespDTO queryFeeIncomeAccountCollectionResquest(String url, Object obj) {
        RestTemplate restTemplate = new RestTemplate();

        QueryFeeIncomeAccountCollectionRespDTO resultMap = new QueryFeeIncomeAccountCollectionRespDTO();
        try {
            resultMap = restTemplate.postForObject(url, obj, QueryFeeIncomeAccountCollectionRespDTO.class);
        } catch (Exception e) {
            logger.error("请求地址：" + url + "====服务器出错" + e);
        }
        pubMeth(resultMap, url, obj);
        return resultMap;
    }

    public void pubMeth(BaseInnerManageRespDTO resultMap, String url, Object obj) {
        if (resultMap == null) {
            logger.error("请求地址：" + url + "====" + JSON.toJSONString(obj));
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机问题。返回空" + url);
        }
        if (!resultMap.getStatus().equals("200")) {

            if (resultMap.getMessage() != null) {
                logger.error("请求地址：" + url + "====" + resultMap.getMessage() + "====" + JSON.toJSONString(obj));
                throw new SystemRuntimeException(ErrorCode.BSMPS001, resultMap.getMessage());
            }
            logger.error("请求地址：" + url + "====" + JSON.toJSONString(obj));
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机处理失败");
        }
    }


    /**
     * 重新归集和划转
     *
     * @param url
     * @param map
     * @return
     */
    public Map postResquestCollection(String url, MultiValueMap<String, String> map) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<Map> res;
        try {
            res = restTemplate.postForEntity(url, request, Map.class);
        } catch (Exception e) {
            logger.error("请求地址：" + url + "====服务器出错" + e);
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "服务器出错");
        }
        if (res == null) {
            logger.error("请求地址：" + url + "====服务器出错");
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "调用服务错误！");
        }
        if (res.getBody() == null || !res.getBody().get("status").equals("200")) {
            Map resBody = res.getBody();
            if (resBody.containsKey("message") || resBody.get("message") != null) {
                logger.error("请求地址：" + url + "====服务器出错" + resBody.get("message").toString() + ":" + resBody.getOrDefault("data", ""));
                throw new SystemRuntimeException(ErrorCode.BSMPS001, resBody.get("message").toString());
            }
            logger.error("请求地址：" + url + "====调用服务错误");
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "调用服务错误！");
        }
        if (res.getStatusCode().is2xxSuccessful()) {
            return res.getBody();
        } else {
            logger.error("请求地址：" + url + "====调用服务错误");
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "调用服务错误！");
        }
    }

    /**
     * 资金冻结解冻
     *
     * @param url
     * @param obj
     */
    public FreezenBalanceRespDTO freezenBalanceReuqet(String url, Object obj) {
        FreezenBalanceRespDTO resultMap;
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(30000);// 设置超时
        requestFactory.setReadTimeout(30000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        resultMap = restTemplate.postForObject(url, obj, FreezenBalanceRespDTO.class);
        pubMeth(resultMap, url, obj);
        return resultMap;
    }

    /**
     * 上报银行系统
     */
    public void reportBankReuqet(String url, Object obj) {
        BaseInnerManageRespDTO resultMap;
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(30000);// 设置超时
        requestFactory.setReadTimeout(30000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        resultMap = restTemplate.postForObject(url, obj, BaseInnerManageRespDTO.class);
        pubMeth(resultMap, url, obj);
    }
}
