package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.product.common.dto.manage.RefreshRedisDTO;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.IRedisCacheHandler;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author WJH
 * @Date 2019/07/24
 */
@Service
@Slf4j
public class RedisCacheService {

    private ProductAccountProperties productAccountProperties;

    private IRedisCacheHandler redisCacheHandler;


    public RedisCacheService(ProductAccountProperties productAccountProperties, IRedisCacheHandler redisCacheHandler) {
        this.productAccountProperties = productAccountProperties;
        this.redisCacheHandler = redisCacheHandler;
    }

    public ServerResponseDTO refreshRedisCache(RefreshRedisDTO refreshRedisDTO) {
        if (refreshRedisDTO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数 refreshRedisDTO 不能为空");
        }
        if (StringUtil.isBlank(refreshRedisDTO.getType())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数 type 不能为空");
        }
        if (StringUtil.isBlank(refreshRedisDTO.getTime()) || refreshRedisDTO.getTime().length()!=14) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数 time 格式错误");
        }
        if (StringUtil.isBlank(refreshRedisDTO.getOperateType())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数 operateType 不能为空");
        }
        if (!SHA1.genWithAmple(refreshRedisDTO.toSHA1()).equals(refreshRedisDTO.getSign())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }
        ServerResponseDTO serverResponseDTO;
        try {
            redisCacheHandler.refreshRedisCache(refreshRedisDTO);
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.OK.toString(), "刷新成功");
        } catch (Exception e) {
            log.error("刷新缓存异常：{}", e.getMessage(), e);
            throw new ProductException(HttpRespStatus.SERVER_ERROR, String.format("刷新失败:%s", e.getMessage()));
        }
        return serverResponseDTO;
    }


}
