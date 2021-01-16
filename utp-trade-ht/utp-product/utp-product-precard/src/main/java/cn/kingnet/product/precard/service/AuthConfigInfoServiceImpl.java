package cn.kingnet.product.precard.service;

import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.AuthConfigInfo;
import cn.kingnet.utp.trade.common.security.AuthorizationUtil;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.collect.Maps;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

/**
 * @Description : 获取证书配置信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/31 16:07
 */
@Component
public class AuthConfigInfoServiceImpl implements IAuthConfigInfoService {

    private IBasicConfigHandler basicConfigHandler;

    private String platformPrivateKey;

    private String platformPublicKey;

    private UtpConfigProperties utpConfigProperties;

    private static Map<String, AuthConfigInfo> authConfigInfoMap = Maps.newHashMap();

    @Value("${cn.kingnet.utp.auth-cache-timeout}")
    private int authCacheTimeout = 5;

    public AuthConfigInfoServiceImpl(IBasicConfigHandler basicConfigHandler, UtpConfigProperties utpConfigProperties) {
        this.basicConfigHandler = basicConfigHandler;
        this.platformPrivateKey = utpConfigProperties.getPrivateKey();
        this.platformPublicKey = utpConfigProperties.getPublicKey();
        this.utpConfigProperties = utpConfigProperties;
    }

    @Override
    public AuthConfigInfo gainAuthConfigInfo(TradeContext tradeContext) {
        String authNo = tradeContext.getAuthInfo().getAuthNo();
        ValidateUtils.hasText(authNo, "授权编号");
        try {

            AuthConfigInfo authConfigInfo = authConfigInfoMap.get(authNo);
            if (authConfigInfo != null && !authConfigInfo.isTimeout(authCacheTimeout)) {
                return authConfigInfo;
            }

            if(CommonConstants.AUTHORIZATION_TYPE_HTSIGN.equals(utpConfigProperties.getSignType())){
                ValidateUtils.hasText(utpConfigProperties.getVerifyCertName(), "平台核签证书名称配置");
                ValidateUtils.hasText(utpConfigProperties.getSignCertName(), "平台加签证书名称配置");
                authConfigInfo = new AuthConfigInfo();
                authConfigInfo.setSignType(CommonConstants.AUTHORIZATION_TYPE_HTSIGN);
                authConfigInfo.setVerifyCertName(utpConfigProperties.getVerifyCertName());
                authConfigInfo.setSignCertName(utpConfigProperties.getSignCertName());
            }else {
                authConfigInfo = basicConfigHandler.getAuthConfigInfoByIndustry(authNo);
                if(authConfigInfo == null){
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无关联证书[失效或者未生效]，请联系管理员核实。");
                }
                authConfigInfo.setUtpSignPriKey(AuthorizationUtil.genPriKey(authConfigInfo.getUtpSignPrivatekey()));
                authConfigInfo.setMer4UtpPubKey(AuthorizationUtil.genPubKey(authConfigInfo.getMer4UtpPublickey()));
                //平台公私钥赋值
                try {
                    ValidateUtils.hasText(platformPrivateKey, "平台私钥配置");
                    ValidateUtils.hasText(platformPublicKey, "平台公钥配置");
                    authConfigInfo.setPlatformPriKey(AuthorizationUtil.genPriKey(platformPrivateKey));
                    authConfigInfo.setPlatformPubKey(AuthorizationUtil.genPubKey(platformPublicKey));
                } catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
                    throw new TradeException(HttpRespStatus.UNAUTHORIZED, "平台公私钥信息有误，请联系管理员。");
                }
            }
            authConfigInfoMap.put(authNo, authConfigInfo);
            return authConfigInfo;
        } catch (NoSuchAlgorithmException e) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "获取配置连接异常!");
        } catch (InvalidKeySpecException e) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "公私钥信息有误，请联系管理员。");
        } catch (RetryableException e) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "公私钥信息有误，请联系管理员。");
        }
    }
}