/* Copyright ©北京银河摩尔信息技术有限公司 right reserved.*/

package cn.buyforyou.sign.util;

import cn.buyforyou.sign.crypto.api.UnionUAS;
import cn.buyforyou.sign.crypto.api.UnionUAS.Recv;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.union.utils.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 * 概述：华通银行数据签名核签 ASC(A)和HEX(H)-厂商:江南科友
 * </p>
 *
 * @author 创建人： ryl
 * @copyRight 所有权©： 北京银河摩尔信息技术有限公司 All right reserved.
 * @date 创建时间：2018年7月27日 下午4:17:46
 */
public class HTSignUtils {
    /**
     * <b> 设置字符集编码</b>
     */
    private static final String CHAR_ENCODING_UTF8 = "UTF-8";
    private static Logger logger = LoggerFactory.getLogger(HTSignUtils.class);
    private static UnionUAS usa = BeanApplicationContext.getBean(UnionUAS.class);


    /**
     * <p>
     * 概述： 数字签名
     * </p>
     *
     * @param prvCertName 签名证书名称
     * @param data：       待签名摘要信息
     * @return 返回： String
     * @author 创建人： ryl
     * @date 创建时间： 2018年8月18日 下午3:12:59
     */
    public static String u012(String prvCertName, String data) {
        String sign = "";
        Recv recv;
        try {
            byte[] dataAy = Hex.encode(data).getBytes(CHAR_ENCODING_UTF8);
            recv = usa.servU012(prvCertName, dataAy);
            if (recv != null) {
                if (recv.getResponseCode() == 0) {
                    sign = new String(recv.getSign());
                    logger.debug("行内加密机加签成功 >> 响应码:[{}] >> 加签信息:[{}]", recv.getResponseCode(), sign);
                    return sign;
                } else {
                    logger.error("行内加密机加签失败 >> 响应码:[{}] >> 响应描述:[{}] 待加签数据:[{}]", recv.getResponseCode(), recv.getResponseRemark(), data);
                }
            } else {
                logger.error("调用行内加密机加签失败 >> 加密机加签返回 null 待加签数据:[{}]", data);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("待签名摘要信息转换字节数组编码异常:{},待加签数据:[{}]", e.getMessage(), data, e);
        } catch (Exception e) {
            logger.error("待签名摘要信息签名异常:{},待加签数据:[{}]", e.getMessage(), data, e);
        }

        return sign;
    }

    /**
     * <p>
     * 概述： 数字签名核签(验签)
     * </p>
     *
     * @param pubCertName 公钥证书名称
     * @param data        待核签摘要数据
     * @param sign        签名数据
     * @return 返回： boolean
     * @throws UnsupportedEncodingException
     * @author 创建人： ryl
     * @date 创建时间： 2018年8月18日 下午3:13:12
     */
    public static boolean u013(String pubCertName, String data, byte[] sign) {
        // 数字签名核签
        byte[] pkCert = "".getBytes();
        Recv recv;
        try {
            byte[] validDataAy = Hex.encode(data).getBytes(CHAR_ENCODING_UTF8);
            recv = usa.servU013(pubCertName, pkCert, validDataAy, sign);
            if (recv != null) {
                if (recv.getResponseCode() == 0) {
                    logger.debug("行内加密机核签成功 >> 响应码:[{}] >> 加签信息:[{}]", recv.getResponseCode(), recv.getResponseRemark());
                    return true;
                } else {
                    logger.error("行内加密机核签失败 >> 响应码:[{}] >> 响应描述:[{}]  待核签数据:[{}]", recv.getResponseCode(), recv.getResponseRemark(), data);
                    return false;
                }
            } else {
                logger.error("调用行内加密机核签失败 >> 加密机核签返回 null 待核签数据:[{}]", data);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("待核签摘要信息转换字节数组编码异常:{},待核签数据:[{}]", e.getMessage(), data, e);
        } catch (Exception e) {
            logger.error("待核签摘要信息核签异常:{},待核签数据:[{}]", e.getMessage(), data, e);
        }
        return false;
    }

    /**
     * 固定DN格式：CN=CFCA@厦门帝网信息科技有限公司@N91350200556207664B@1, OU=Organizational-1, OU=CFCA OCA31, O=CFCA ACS OCA31, C=CN
     * 业务规定：取N91350200556207664B即 统一社会信用代码
     *
     * @param P7SignData 客户端上送签名信息
     * @return DN信息
     */
    public static String getDNFromP7SignData(String P7SignData) {
        return usa.getDNFromP7SignData(P7SignData);
    }

    /**
     * 从证书中提取DN下的 统一社会信用代码
     * 业务规定：取N91350200556207664B即 统一社会信用代码
     *
     * @param P7SignData 客户端上送签名信息
     * @return 证书中提取DN下的 统一社会信用代码
     */
    public static String getDN4CreditCode(String P7SignData) {
        String creditCode ;
        try {
            String DN = getDNFromP7SignData(P7SignData);
            logger.debug("签名信息中提取DN信息:{}", DN);
            if (StringUtil.isEmpty(DN)) {
                throw new RuntimeException("证书提取DN异常:DN is null ");
            }
            String[] dnAy = DN.split("@");
            if (dnAy.length < 3) {
                throw new RuntimeException("证书提取DN信息格式错误：DN= " + DN);
            }
            creditCode = dnAy[2];
        } catch (Exception e) {
            throw new RuntimeException("证书提取DN中统一社会信用代码失败:" + e.getMessage(), e);
        }
        return creditCode;
    }


    /**
     * <p>
     * 概述： 测试用例
     * </p>
     *
     * @return 返回： void
     * @throws UnsupportedEncodingException
     * @author 创建人： ryl
     * @date 创建时间： 2018年8月18日 下午1:26:03
     */
    public static void main(String[] args) {
        String certPfx = "JFJT_sign";
        // data 8192H 签名数据
        String data = "12z中国";
        // sign 4096H 数字签名
        String sign = u012(certPfx, Hex.encode(data));
        System.out.println("u012==>" + new String(sign));
        System.out.println("u012长度==>" + sign.length());

        // sign="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";

        System.out.println("签名==>" + sign);
        System.out.println("签名长度==>" + sign.length());

        // certName 128A 签发者证书名称 根证书，用于验证公钥证书的合法性
        String certName = "CFCA_TEST_OCA1";// CFCA_TEST_OCA1 CFCA_TEST_CS_CA
        // String certName = "JFJT";
        // pkCert 4096A 公钥证书（签名者）可选，pem格式,当sign中包含公钥证书时，不能传送
        // 拼接一个核签证书文件路径

        System.out.println("核签==>" + u013(certName, Hex.encode(data), sign.getBytes()));
    }
}