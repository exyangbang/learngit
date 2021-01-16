package com.scenetec.upf.operation.utils.OnliineTool;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.vo.RefreshRedisDTO;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.SHA1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

@Service
public class RefreshOnlineTool {
    @Resource
    OnlineRequestTool onlineRequestTool;
    @Value("${innerManage.refreshRedisCacheByManage.url}")
    private String url;

    /**
     * 01 渠道总额度 02 客户号总限额及单笔限额 03 客户号下子账户单日|单笔限额
     * @param type
     * @param object
     */
    public void RefreshQuato(String type,RefreshRedisDTO refreshRedisDTO){
        System.out.println("刷新###################刷新"+url);
        switch (type){
            case "01":
                refreshRedisDTO.setType("01");
                break;
            case "02":
                refreshRedisDTO.setType("02");
                break;
            case "03":
                refreshRedisDTO.setType("03");
                break;
        }
        refreshRedisDTO.setTime(DateUtilities.getStringToday());
        try {
            refreshRedisDTO.setSign(SHA1.genWithAmple(refreshRedisDTO.toSHA1()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new SystemRuntimeException(ErrorCode.BSMPS001,"Sign生成错误");

        }
        onlineRequestTool.postResquest(url,refreshRedisDTO);
    }
}
