package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.trade.common.model.AuthConfigInfo;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 基础信息，通用服务
 * @Author : linkaigui
 * @Create : 2019/2/22 15:22
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/basicConfig")
public interface IBasicConfigHandler {

    /**
     * 获取平台关联证书信息，主要公私钥
     * @param industryCode 代付客户号
     * @return
     */
    @PostMapping("/getAuthConfigInfoByIndustry")
    AuthConfigInfo getAuthConfigInfoByIndustry(@RequestParam(value = "industryCode") String industryCode);

    /**
     * 获取平台关联的基础配置信息
     * 参数非空校验都下放业务各自处理
     *
     * @param industryCode 平台代码
     * @param userAccount  用户账号
     * @param productCode  产品类型
     * @return
     */
    @PostMapping("/getBasicConfigInfoByIndustry")
    BasicConfigInfo getBasicConfigInfoByIndustry(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "userAccount", required = false) String userAccount, @RequestParam(value = "productCode", required = false) String productCode);

    @PostMapping("/getIndustryByIndustryCode")
    Industry getIndustryByIndustryCode(@RequestParam(value = "industryCode", required = false) String industryCode);
}
