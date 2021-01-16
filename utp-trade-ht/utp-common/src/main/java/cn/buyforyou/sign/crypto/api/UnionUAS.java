package cn.buyforyou.sign.crypto.api;

import cfca.sadk.algorithm.common.PKIException;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.Signature;
import cfca.sadk.x509.certificate.X509Cert;
import com.union.connect.UnionComm;
import com.union.utils.Hex;
import com.union.utils.SM3;
import com.union.utils.UnionAPI;
import com.union.utils.UnionStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UnionUAS {

    private static Logger logger = LoggerFactory.getLogger(UnionComm.class);
    private String unionAPiConfigFile;
    private static final String DEVICENAME = JCrypto.JSOFT_LIB;

    public UnionUAS() {
    }

    public UnionUAS(String unionAPiConfigFile) {
        this.unionAPiConfigFile = unionAPiConfigFile;

    }

    /**
     * 步骤1 加密库初始化
     */
    private void initJCrypto() {
        try {
            boolean tf = JCrypto.getInstance().initialize(DEVICENAME, null);
            if (!tf) {
                logger.error("加密库初始化失败!");
                throw new RuntimeException("加密库初始化失败!");
            }
        } catch (PKIException e) {
            logger.error("加密库初始化异常:{}", e.getMessage(), e);
            throw new RuntimeException("加密库初始化异常:" + e.getMessage(), e);
        }
    }

    public Session openSession() throws PKIException {
        Session session;
        try {
            session = JCrypto.getInstance().openSession(DEVICENAME);
        } catch (PKIException e) {
            logger.error("加密库openSession异常:{}", e.getMessage(), e);
            throw new RuntimeException("加密库openSession异常:{}" + e.getMessage(), e);
        }
        return session;
    }

    /**
     * 获取DN信息
     *
     * @param base64P7SignedData
     * @return
     */
    public String getDNFromP7SignData(String base64P7SignedData) {
        Signature signKit = new Signature();
        String DN;
        try {
            X509Cert signX509Cert = signKit.getSignerX509CertFromP7SignData(base64P7SignedData.getBytes("utf-8"));
            DN = signX509Cert.getSubject();
        } catch (PKIException e) {
            logger.error("从上送签名信息获取签名证书异常:{}", e.getMessage(), e);
            throw new RuntimeException("从上送签名信息获取签名证书异常:{}" + e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            logger.error("上送签名信息转换字节数组编码异常:{}", e.getMessage(), e);
            throw new RuntimeException("上送签名信息转换字节数组编码异常:{}" + e.getMessage(), e);
        }
        logger.info("DN信息 >> {}", DN);
        return DN;
    }

    public boolean p7VerifyMessageDetach(String sourceData, String base64P7SignedData, Session session) {
        //步骤2 验签
        Signature signKit = new Signature();
        boolean result = false;
        try {
            byte[] sourceDataAy = sourceData.getBytes("UTF8");
            byte[] base64P7SignedDataAy = base64P7SignedData.getBytes("UTF-8");
            result = signKit.p7VerifyMessageDetach(sourceDataAy, base64P7SignedDataAy, openSession());
        } catch (UnsupportedEncodingException e) {
            logger.error("上送签名信息转换字节数组编码异常:{}", e.getMessage(), e);
            throw new RuntimeException("上送签名信息转换字节数组编码异常:{}" + e.getMessage(), e);
        } catch (PKIException e) {
            logger.error("客户端上送签名信息验签异常:{}", e.getMessage(), e);
            throw new RuntimeException("客户端上送签名信息验签异常:{}" + e.getMessage(), e);
        }
        logger.debug("客户端上送签名信息验签结果:[{}]", result);
        return result;
    }


    /**
     * U010 签发证书（UAS生成公私钥）
     *
     * @param rootCertName           128A 颁发证书名称
     * @param certAlg                3A 证书算法 RSA
     * @param pkModuleLen            公钥模长 certAlg =RSA 时存在，1024/2048/4096
     * @param pkExponent             5N 公钥指数 certAlg =RSA 时存在
     * @param pfxPwd                 6A 证书口令 certAlg =RSA时存在
     * @param hashAlg                1N 摘要算法 0=SHA_1,1=SHA_256,
     * @param validDays              6N 有效天数
     * @param userDN                 256A 证书DN 优先此域
     * @param countryName            40A 国家 userDN为空时采用
     * @param stateOrProvinceName    40A 省份 userDN为空时采用
     * @param localityName           40A 城市 userDN为空时采用
     * @param organizationName       40A 单位 userDN为空时采用
     * @param organizationalUnitName 40A 部门 userDN为空时采用
     * @param commonName             80A 用户名 UserDN为空时采用
     * @param email                  80A 邮件 userDN为空时采用
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getCertInfo()} : 证书内容，base64格式<br>
     * </blockquote>
     */
    public Recv servU010(
            String rootCertName,
            String certAlg,
            String pkModuleLen,
            String pkExponent,
            String pfxPwd,
            Integer hashAlg,
            String validDays,
            String userDN,
            String countryName,
            String stateOrProvinceName,
            String localityName,
            String organizationName,
            String organizationalUnitName,
            String commonName,
            String email) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("U010", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("rootCertName", rootCertName)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certAlg", certAlg)) != 0)
                recv.setResponseCode(ret);
            if ("RSA".equals(certAlg) == true) {
                if ((ret = api.setString("pkModuleLen", pkModuleLen)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("pkExponent", pkExponent)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("pfxPwd", pfxPwd)) != 0)
                    recv.setResponseCode(ret);
            }
            if ((ret = api.setInteger("hashAlg", hashAlg)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("validDays", validDays)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("userDN", userDN)) != 0)
                recv.setResponseCode(ret);
            if ("".equals(userDN) == true || userDN == null) {
                if ((ret = api.setString("countryName", countryName)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("stateOrProvinceName", stateOrProvinceName)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("localityName", localityName)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("organizationName", organizationName)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("organizationalUnitName", organizationalUnitName)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("commonName", commonName)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("email", email)) != 0)
                    recv.setResponseCode(ret);
            }
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setCertInfo(api.getString("certInfo"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * U011 签发证书（证书请求文件）
     *
     * @param rootCertName 128A 颁发证书名称
     * @param reqInfo      4096A 证书请求文件
     * @param validDays    6N 有效天数
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getCertInfo()} : 证书内容，base64格式<br>
     * </blockquote>
     */
    public Recv servU011(String rootCertName, byte[] reqInfo, String validDays) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("U011", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("rootCertName", rootCertName)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("reqInfo", reqInfo, reqInfo.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("validDays", validDays)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setCertInfo(api.getString("certInfo"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    // /**
    // * U012 数字签名加签
    // *
    // * @param certName 128A 证书名称 签名证书
    // * @param data 8192H 签名数据
    // * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
    // * {@link Recv#getResponseRemark()} : 响应描述<br>
    // * {@link Recv#getSign()} : 证书内容，base64格式<br>
    // * </blockquote>
    // */
    // public Recv servU012(String certName, byte[] data) {
    // try {
    // int ret = 0;
    // Recv recv = new Recv();
    // UnionAPI api = new UnionAPI();
    // /*
    // * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
    // */
    // String userInfo = "";
    // String sysID = "";
    // String appID = "";
    // if ((ret = api.start("U012", userInfo, sysID, appID)) != 0)
    // recv.setResponseCode(ret);
    // if ((ret = api.setString("certName", certName)) != 0)
    // recv.setResponseCode(ret);
    // if ((ret = api.setByte("data", data, data.length)) != 0)
    // recv.setResponseCode(ret);
    // ret = api.send();
    // recv.setResponseCode(ret);
    // if (ret != 0) {
    // recv.setResponseRemark(api.getResponseRemark());
    // return recv;
    // }
    // recv.setSign(api.getByte("sign"));
    // api.end();
    // return recv;
    // } catch (Exception e) {
    // return Recv.failed(e);
    // }
    // }
    //
    // /**
    // * U013 数字签名核签
    // *
    // * @param certName 128A 签发者证书名称 根证书，用于验证公钥证书的合法性
    // * @param pkCert 4096A 公钥证书（签名者） 可选，pem格式,当sign中包含公钥证书时，不能传送
    // * @param data 8192H 签名数据
    // * @param sign 4096H 数字签名
    // * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
    // * {@link Recv#getResponseRemark()} : 响应描述<br>
    // * </blockquote>
    // */
    // public Recv servU013(String certName, byte[] pkCert, byte[] data, byte[] sign) {
    // try {
    // int ret = 0;
    // Recv recv = new Recv();
    // UnionAPI api = new UnionAPI();
    // /*
    // * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
    // */
    // String userInfo = "";
    // String sysID = "";
    // String appID = "";
    // if ((ret = api.start("U013", userInfo, sysID, appID)) != 0)
    // recv.setResponseCode(ret);
    // if ((ret = api.setString("certName", certName)) != 0)
    // recv.setResponseCode(ret);
    // if ((ret = api.setByte("pkCert", pkCert, pkCert.length)) != 0)
    // recv.setResponseCode(ret);
    // if ((ret = api.setByte("data", data, data.length)) != 0)
    // recv.setResponseCode(ret);
    // if ((ret = api.setByte("sign", sign, sign.length)) != 0)
    // recv.setResponseCode(ret);
    // ret = api.send();
    // recv.setResponseCode(ret);
    // if (ret != 0) {
    // recv.setResponseRemark(api.getResponseRemark());
    // return recv;
    // }
    // api.end();
    // return recv;
    // } catch (Exception e) {
    // return Recv.failed(e);
    // }
    // }

    /**
     * U012 数字签名加签
     *
     * @param certName 128A 证书名称 签名证书
     * @param data     8192H 签名数据 , 当hashID为1时，为摘要值
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getSign()} : 证书内容，base64格式<br>
     * </blockquote>
     */
    public Recv servU012(String certName, byte[] data) {
        try {
            int ret = 0;
            String alg;
            int hashID = 0;
            Recv recv = new Recv();
//            UnionAPI api = new UnionAPI();
            UnionAPI api = new UnionAPI(this.unionAPiConfigFile);
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";

            if (data.length > 8192) {
                hashID = 1;
                recv = this.servU01C(certName, null, null);
                if (recv != null) {
                    if (recv.getResponseCode() != 0)
                        return recv;
                } else {
                    return recv;
                }
            }

            if ((ret = api.start("U012", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certName", certName)) != 0)
                recv.setResponseCode(ret);
            api.setInteger("hashID", hashID);

            alg = recv.getHashID();
            if (hashID == 1) {
                if (alg.equals("RSA")) {
                    MessageDigest digest;
                    try {
                        digest = MessageDigest.getInstance("SHA1");
                        final byte[] hash = digest.digest(UnionStr.aschex_to_bcdhex(new String(data)));
                        if ((ret = api.setString("data", UnionStr.bcdhex_to_aschex(hash))) != 0)
                            recv.setResponseCode(ret);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                } else {
                    SM3 sm3 = new SM3();
                    final byte[] publicKey = UnionStr.aschex_to_bcdhex(recv.getPkValue());
                    // final String hash = UnionStr.bcdhex_to_aschex(sm3.DigestForSM2SignWithPK(
                    // data, "1234567812345678".getBytes(), publicKey));
                    final byte[] hash = sm3.DigestForSM2SignWithPK(data, "1234567812345678".getBytes(), publicKey);
                    if ((ret = api.setString("data", UnionStr.bcdhex_to_aschex(hash))) != 0)
                        recv.setResponseCode(ret);
                }
            } else if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);

            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setSign(api.getByte("sign"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * U013 数字签名核签
     *
     * @param certName 128A 签发者证书名称 根证书，用于验证公钥证书的合法性
     * @param pkCert   4096A 公钥证书（签名者） 可选，pem格式,当sign中包含公钥证书时，不能传送
     * @param data     8192H 签名数据
     * @param sign     4096H 数字签名
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * </blockquote>
     */
    public Recv servU013(String certName, byte[] pkCert, byte[] data, byte[] sign) {
        try {
            int ret = 0;
            int hashID = 0;
            String alg;
            Recv recv = new Recv();
//            UnionAPI api = new UnionAPI();
            UnionAPI api = new UnionAPI(this.unionAPiConfigFile);
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";

            if (data.length > 8192) {
                hashID = 1;
                if (pkCert != null && pkCert.length != 0)
                    recv = this.servU01C(null, null, pkCert);
                else
                    recv = this.servU01C(null, sign, null);
                if (recv != null) {
                    if (recv.getResponseCode() != 0)
                        return recv;
                } else {
                    return recv;
                }
            }

            if ((ret = api.start("U013", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certName", certName)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("pkCert", pkCert, pkCert.length)) != 0)
                recv.setResponseCode(ret);
            api.setInteger("hashID", hashID);

            alg = recv.getHashID();
            if (hashID == 1) {
                if (alg.equals("RSA")) {
                    MessageDigest digest;
                    try {
                        digest = MessageDigest.getInstance("SHA1");
                        final byte[] hash = digest.digest(UnionStr.aschex_to_bcdhex(new String(data)));
                        if ((ret = api.setString("data", UnionStr.bcdhex_to_aschex(hash))) != 0)
                            recv.setResponseCode(ret);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                } else {
                    SM3 sm3 = new SM3();
                    final byte[] publicKey = UnionStr.aschex_to_bcdhex(recv.getPkValue());
                    // final String hash = UnionStr.bcdhex_to_aschex(sm3.DigestForSM2SignWithPK(
                    // data, "1234567812345678".getBytes(), publicKey));
                    final byte[] hash = sm3.DigestForSM2SignWithPK(data, "1234567812345678".getBytes(), publicKey);
                    if ((ret = api.setString("data", UnionStr.bcdhex_to_aschex(hash))) != 0)
                        recv.setResponseCode(ret);
                }
            } else if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);

            if((ret = api.setByte("sign", sign, sign.length)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * U01C 获取p7签名中的算法及公钥
     *
     * @param certName 128A 证书名称
     * @param sign     4096H p7签名
     * @param pkCert   4096H 公钥证书
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getHashID()} : 算法标识<br>
     * {@link Recv#getPkValue()} : 公钥<br>
     * </blockquote>
     */
    public Recv servU01C(String certName, byte[] sign, byte[] pkCert) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("U01C", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if (certName != null && certName.length() != 0) {
                if ((ret = api.setString("certName", certName)) != 0)
                    recv.setResponseCode(ret);
            } else if (sign != null && sign.length != 0) {
                if ((ret = api.setByte("sign", sign, sign.length)) != 0)
                    recv.setResponseCode(ret);
            } else {
                if ((ret = api.setByte("pkCert", pkCert, pkCert.length)) != 0)
                    recv.setResponseCode(ret);
            }
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setHashID(api.getString("hashID"));
            recv.setPkValue(api.getString("pkValue"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * U014 数字信封打包
     *
     * @param certName 128A 签发证书 根证书，验证公钥证书合法性
     * @param pkCert   4096A 公钥证书
     * @param data     4096H 加密数据
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getPkcs7Env()} : PKCS7加密数据信封 base64格式<br>
     * </blockquote>
     */
    public Recv servU014(String certName, byte[] pkCert, byte[] data) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("U014", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certName", certName)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("pkCert", pkCert, pkCert.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setPkcs7Env(api.getByte("pkcs7Env"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * U015 数字信封解包
     *
     * @param certName 128A 证书名称 解密公钥加密的密钥
     * @param pkcs7Env 8192A PKCS7加密数据信封
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getData()} : 明文数据<br>
     * </blockquote>
     */
    public Recv servU015(String certName, byte[] pkcs7Env) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("U015", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certName", certName)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("pkcs7Env", pkcs7Env, pkcs7Env.length)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setData(api.getByte("data"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * U016 数字信封解包
     *
     * @param certName 128A 证书名称
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getCertData()} : 证书内容<br>
     * {@link Recv#getAlgFlag()} : 算法标识<br>
     * </blockquote>
     */
    public Recv servU016(String certName) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("U016", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certName", certName)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setCertData(api.getString("certData"));
            recv.setAlgFlag(api.getString("algFlag"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * U020 更新SSL证书
     *
     * @param oldCertContent 4095A 旧证书内容 待更新的证书内容，base64编码
     * @param reqCertContent 4095A 请求文件内容 新证书的请求文件内容，base64编码
     * @param data           1024H 原文 签名数据的原文扩展后的HEX码
     * @param sign           1024H 签名结果 私钥签名后的结果扩展后的HEX码（旧证书私钥签名）
     * @param startTime      16N 证书起始时间 UTC时间戳，如1525918396
     * @param endTime        16N 证书失效时间 UTC时间戳，如1635218396
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getCertData()} : 证书内容<br>
     * {@link Recv#getNewCertContent()} : 新签发后的证书内容 旧证书验证成功且签名验证成功后签发得到的新证书，base64编码<br>
     * </blockquote>
     */
    public Recv servU020(
            String oldCertContent,
            String reqCertContent,
            byte[] data,
            byte[] sign,
            String startTime,
            String endTime) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("U020", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("oldCertContent", oldCertContent)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("reqCertContent", reqCertContent)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("sign", sign, sign.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("startTime", startTime)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("endTime", endTime)) != 0)
                recv.setResponseCode(ret);

            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setNewCertContent(api.getString("newCertContent"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA00 查询数字证书算法和公钥值
     *
     * @param serialNum 证书序列号
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()}} ：响应码 <br>
     * {@link Recv#getResponseRemark()}} ：响应描述 <br>
     * {@link Recv#getAlgFlag()}} ：算法标识 <br>
     * {@link Recv#getPkValue()}} ：公钥值 </blockquote>
     */
    public Recv servUA00(String serialNum) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA00", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("serialNum", serialNum)) != 0)
                recv.setResponseCode(ret);
            ret = api.send(); // 返回响应码
            recv.setResponseCode(ret);
            if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setAlgFlag(api.getString("algFlag"));
            if ("1".equals(recv.getAlgFlag())) {
                recv.setPkValue(api.getString("pkvalue"));
            }
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA01 数字签名加签
     *
     * @param serialNum 证书序列号
     * @param data      待签名数据
     * @param dataType  data数据类型
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getSign()} : 签名结果<br>
     * </blockquote>
     */
    public Recv servUA01(String serialNum, byte[] data, int dataType) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA01", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("serialNum", serialNum)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("dataType", dataType)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setSign(api.getByte("sign"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA02数字签名核签
     *
     * @param serialNum 证书序列号
     * @param data      待签名数据
     * @param dataType  data数据类型
     * @param sign      签名
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()}} ：响应码<br>
     * {@link Recv#getResponseRemark()}} ：响应描述 </blockquote>
     */
    public Recv servUA02(String serialNum, byte[] data, int dataType, String sign) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA02", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("serialNum", serialNum)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("dataType", dataType)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("sign", sign)) != 0)
                recv.setResponseCode(ret);

            ret = api.send(); // 返回响应码
            recv.setResponseCode(ret);
            if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }

            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA03公钥加密对称密钥
     *
     * @param mode      密钥模式
     * @param keyValue  密钥值
     * @param keyType   密钥算法类型
     * @param serialNum 证书序列号
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()}} ：响应码
     * {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getKeyByPK()} } ：公钥加密的密钥密文<br>
     * {@link Recv#getKeyValue()}} ：密钥值 </blockquote>
     */
    public Recv servUA03(int mode, String keyValue, String keyType, String serialNum) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA03", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("mode", mode)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyValue", keyValue)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyType", keyType)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("serialNum", serialNum)) != 0)
                recv.setResponseCode(ret);

            ret = api.send(); // 返回响应码
            recv.setResponseCode(ret);
            if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }

            recv.setKeyByPK(api.getString("keyByPK"));
            if (0 == mode) {
                recv.setKeyValue(api.getString("keyValue"));
            }
            api.end(); // 结束释放UnionAPI类中静态成员变量
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA04公钥加密的对称密钥转lmk加密
     *
     * @param serialNum 证书序列号
     * @param keyByPK   公钥加密的密文
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()}} ：响应码
     * {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getKeyValue()}} ：密钥密文<br>
     * {@link Recv#getKeyType()}} ：密钥类型 </blockquote>
     */
    public Recv servUA04(String serialNum, String keyByPK) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA04", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("serialNum", serialNum)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyByPK", keyByPK)) != 0)
                recv.setResponseCode(ret);

            ret = api.send(); // 返回响应码
            recv.setResponseCode(ret);
            if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }

            recv.setKeyValue(api.getString("keyValue"));
            recv.setKeyType(api.getString("keyType"));
            api.end(); // 结束释放UnionAPI类中静态成员变量

            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA05 数据加密
     *
     * @param keyValue    密钥值
     * @param keyType     密钥类型
     * @param paddingFlag 填充标识
     * @param data        待加密的数据
     * @param dataType    data数据类型
     * @param algorithmID 算法标识
     * @param iv          iv向量
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()}} ：响应码<br>
     * {@link Recv#getResponseRemark()}} ：响应描述<br>
     * {@link Recv#getData()}} ：数据密文 </blockquote>
     */
    public Recv servUA05(
            String keyValue,
            String keyType,
            int paddingFlag,
            byte[] data,
            int dataType,
            int algorithmID,
            String iv) {

        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA05", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyValue", keyValue)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyType", keyType)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("paddingFlag", paddingFlag)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("dataType", dataType)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("algorithmID", algorithmID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("iv", iv)) != 0)
                recv.setResponseCode(ret);

            ret = api.send(); // 返回响应码
            recv.setResponseCode(ret);
            if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }

            recv.setData(api.getByte("data"));
            api.end(); // 结束释放UnionAPI类中静态成员变量

            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA06 数据解密
     *
     * @param keyValue    密钥值
     * @param keyType     密钥类型
     * @param paddingFlag 填充标识
     * @param data        密文数据
     * @param exportFlag  输出明文数据标识
     * @param algorithmID 算法标识
     * @param iv          iv向量
     * @return 返回 {@link Recv} 对象 获取响应信息：<br>
     * <blockquote> {@link Recv#getResponseCode()}} ：响应码<br>
     * {@link Recv#getResponseRemark()}} ：响应描述<br>
     * {@link Recv#getData()}} ：明文数据 </blockquote>
     */
    public Recv servUA06(
            String keyValue,
            String keyType,
            int paddingFlag,
            String data,
            int exportFlag,
            int algorithmID,
            String iv) {

        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA06", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyValue", keyValue)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyType", keyType)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("paddingFlag", paddingFlag)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("data", data)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("exportFlag", exportFlag)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("algorithmID", algorithmID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("iv", iv)) != 0)
                recv.setResponseCode(ret);

            ret = api.send(); // 返回响应码
            recv.setResponseCode(ret);
            if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }

            recv.setData(api.getByte("data"));
            api.end(); // 结束释放UnionAPI类中静态成员变量
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA10 生成本行绑定报文(二代支付)
     *
     * @param pix         应用ID
     * @param bankID      非对称密钥名称
     * @param certVersion 版本号
     * @param data        签名数据
     * @param algFlag     签名算法
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getSign()} : 数字签名<br>
     * </blockquote>
     */
    public Recv servUA10(String pix, String bankID, String certVersion, byte[] data, String algFlag) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA10", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("pix", pix)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("bankID", bankID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certVersion", certVersion)) != 0)
                recv.setResponseCode(ret);
            String tmpData = UnionStr.bcdhex_to_aschex(data);
            if ((ret = api.setString("data", tmpData)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algFlag", algFlag)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setSign(api.getString("sign").getBytes());
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA11 生成本行绑定报文(二代支付)
     *
     * @param mode        模式
     * @param pix         应用ID
     * @param bankID      参与行机构号
     * @param certVersion 版本号
     * @param data        签名数据
     * @param sign        数字签名
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * </blockquote>
     */
    public Recv servUA11(String mode, String pix, String bankID, String certVersion, byte[] data, String sign) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA11", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("mode", mode)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("pix", pix)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("bankID", bankID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certVersion", certVersion)) != 0)
                recv.setResponseCode(ret);
            String tmpData = UnionStr.bcdhex_to_aschex(data);
            if ((ret = api.setString("data", tmpData)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("sign", sign)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setCertBuf(api.getString("certBuf"));
            recv.setCertDN(api.getString("certDN"));
            recv.setCertSN(api.getString("certSN"));
            recv.setCertEffdate(api.getString("certEffdate"));
            recv.setCertInvdate(api.getString("certInvdate"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA12 数字签名加签(二代支付)
     *
     * @param pix         应用ID
     * @param bankID      参与行机构号
     * @param certVersion 版本号
     * @param data        签名数据
     * @param algFlag     签名算法
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getSign()} : 签名结果,base64编码<br>
     * </blockquote>
     */
    public Recv servUA12(String pix, String bankID, String certVersion, byte[] data, String algFlag) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            String tmpData = "";
            String hashID = "";
            String pkValue = "";
            Recv recvTp = servUA17(pix, bankID, certVersion, algFlag, "");
            if (recvTp == null || recvTp.getResponseCode() != 0)
                return recvTp;
            hashID = recvTp.getHashID();
            if ("2".equals(hashID))
                pkValue = recvTp.getPkValue();
            if (hashID.equals("1")) {
                final MessageDigest digest = MessageDigest.getInstance("SHA-1");
                final byte[] hash = digest.digest(data);
                tmpData = Hex.encode(hash);
            } else {
                final byte[] pk = Hex.decode(pkValue);
                final SM3 sm3 = new SM3();
                final byte[] userId = "1234567812345678".getBytes();
                final byte[] digest = sm3.DigestForSM2SignWithPK(data, userId, pk);
                tmpData = Hex.encode(digest);
            }

            if ((ret = api.start("UA12", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("pix", pix)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("bankID", bankID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certVersion", certVersion)) != 0)
                recv.setResponseCode(ret);
            // 处理data
            if ((ret = api.setString("data", tmpData)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algFlag", algFlag)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setSign(api.getString("sign").getBytes());
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA13 数字签名核签(二代支付)
     *
     * @param pix         应用ID
     * @param bankID      参与行机构号
     * @param certVersion 版本号
     * @param data        签名数据
     * @param sign        签名结果
     * @param flag        证书输出标识
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getCertBuf()} : 公钥证书内容<br>
     * </blockquote>
     */
    public Recv servUA13(String pix, String bankID, String certVersion, byte[] data, String sign, String flag) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            String tmpData = "";
            String hashID = "";
            String pkValue = "";
            Recv recvTp = servUA17(pix, bankID, certVersion, "2", sign);
            if (recvTp == null || recvTp.getResponseCode() != 0)
                return recvTp;
            hashID = recvTp.getHashID();
            if ("2".equals(hashID))
                pkValue = recvTp.getPkValue();
            if (hashID.equals("1")) {
                final MessageDigest digest = MessageDigest.getInstance("SHA-1");
                final byte[] hash = digest.digest(data);
                tmpData = Hex.encode(hash);
            } else {
                final byte[] pk = Hex.decode(pkValue);
                final SM3 sm3 = new SM3();
                final byte[] userId = "1234567812345678".getBytes();
                final byte[] digest = sm3.DigestForSM2SignWithPK(data, userId, pk);
                tmpData = Hex.encode(digest);
            }
            if ((ret = api.start("UA13", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("pix", pix)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("bankID", bankID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certVersion", certVersion)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("data", tmpData)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("sign", sign)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("flag", flag)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            if ("1".equals(flag))
                recv.setCertBuf(api.getString("certBuf"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA15 更新证书(二代支付)
     *
     * @param pix         应用ID
     * @param bankID      参与行机构号
     * @param certVersion 版本号
     * @param certContent 证书内容,base64编码
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * </blockquote>
     */
    public Recv servUA15(String pix, String bankID, String certVersion, String certContent) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA15", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("pix", pix)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("bankID", bankID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certVersion", certVersion)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certContent", certContent)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA16 撤销证书(二代支付)
     *
     * @param pix         应用ID
     * @param bankID      参与行机构号
     * @param certVersion 版本号
     * @param algFlag     证书算法,0:RSA,1:SM2
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * </blockquote>
     */
    public Recv servUA16(String pix, String bankID, String certVersion, String algFlag) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA16", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("pix", pix)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("bankID", bankID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certVersion", certVersion)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algFlag", algFlag)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA17 获取公钥(二代支付)
     *
     * @param pix         应用ID
     * @param bankID      参与行机构号
     * @param certVersion 版本号
     * @param algFlag     证书算法,0:RSA,1:SM2
     * @param sign        签名结果，base64编码
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getHashID()} : 摘要算法标识<br>
     * {@link Recv#getPkValue()} : 公钥值<br>
     * </blockquote>
     */
    public Recv servUA17(String pix, String bankID, String certVersion, String algFlag, String sign) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA17", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("pix", pix)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("bankID", bankID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certVersion", certVersion)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algFlag", algFlag)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("sign", sign)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setHashID(api.getString("hashID", ""));
            recv.setPkValue(api.getString("pkValue", ""));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA60 产生密钥
     *
     * @param algorithm(ASCII) 密钥的算法类型：SM4，SM2，RSA DES64， DES128，DES192,AES128，AES192，AES256;
     * @param keySize(NUM)     密钥长度
     * @param exponent(HEX)    RSA的公钥指数，一般为 3 或 65537
     * @return 返回 {@link Recv} :对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getKeyValue()} : 算法为对称算法时存在,指定长度的 LMK 保护的对称密钥 ZEK<br>
     * {@link Recv#getPublicKey()} : 算法为非对称算法时存在,公钥明文，SM2 格式为 X+Y ，RSA 格式为 DER<br>
     * {@link Recv#getPrivateKey()} : 可选，算法为非对称算法时存在,LMK 加密的私钥密文<br>
     * {@link Recv#getCheckValue()} : 密钥校验值<br>
     * </blockquote>
     */
    public Recv servUA60(String algorithm, Integer keySize, String exponent) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            String tmpAlgorithm = algorithm.trim().toUpperCase();

            if ((ret = api.start("UA60", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algorithm", tmpAlgorithm)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("keySize", keySize)) != 0)
                recv.setResponseCode(ret);
            if ("RSA".equals(tmpAlgorithm) == true || "SM2".equals(tmpAlgorithm) == true) {
                if ((ret = api.setString("exponent", exponent)) != 0)
                    recv.setResponseCode(ret);
            }
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }

            recv.setKeyValue(api.getString("keyValue"));
            recv.setPrivateKey(api.getString("privateKey"));
            recv.setPublicKey(api.getString("publicKey"));
            recv.setCheckValue(api.getString("checkValue"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA61 加解密
     *
     * @param algorithm(ASCII)   密钥的算法类型：SM4，SM2，RSA DES64， DES128，DES192,AES128，AES192，AES256;
     * @param operationMode(NUM) 操作模式：1 – 加密 ,2 – 解密
     * @param keyValue(HEX)      LMK 保护的密钥。非对称算法加密时，该密钥为公钥明文。
     * @param inputData(BYTE)    待操作的数据
     * @param mode(ASCII)        对称密钥使用的运算模式：ECB/CBC/GCM/CTR
     * @param iv(HEX)            对称密钥的初始向量
     * @return 返回 {@link Recv} :对象 获取响应信息：
     *
     * <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getOutputData()} : 加密或解密后的数据<br>
     * {@link Recv#getIv()} : 可选，对称算法运算后的 IV向量值<br>
     * </blockquote>
     */
    public Recv servUA61(
            String algorithm,
            Integer operationMode,
            String certName,
            String groupID,
            String certApp,
            String keyValue,
            byte[] inputData,
            String mode,
            String iv) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            String tmpMode = null;
            String tmpAlgorithm = algorithm;

            if (algorithm == null) {
                logger.error("不存在算法标示[tmpAlgorithm]");
            } else {
                tmpAlgorithm = algorithm.trim().toUpperCase();
            }
            if (tmpAlgorithm.indexOf("DES") == 0 || tmpAlgorithm.indexOf("AES") == 0
                    || tmpAlgorithm.indexOf("SM4") == 0) {
                if (mode == null) {
                    tmpMode = "ECB";
                } else {
                    tmpMode = mode.trim().toUpperCase();
                }
            }

            if ((ret = api.start("UA61", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algorithm", tmpAlgorithm)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("operationMode", operationMode)) != 0)
                recv.setResponseCode(ret);
            if ("RSA".equals(algorithm) || operationMode == 2) {

                if (certName.length() > 0) {
                    if ((ret = api.setString("certName", certName)) != 0)
                        recv.setResponseCode(ret);
                    if ((ret = api.setString("groupID", groupID)) != 0)
                        recv.setResponseCode(ret);
                    if ((ret = api.setString("certApp", certApp)) != 0)
                        recv.setResponseCode(ret);
                } else {
                    if ((ret = api.setString("keyValue", keyValue)) != 0)
                        recv.setResponseCode(ret);
                }
            } else {
                if ((ret = api.setString("keyValue", keyValue)) != 0)
                    recv.setResponseCode(ret);
            }

            if ((ret = api.setByte("inputData", inputData, inputData.length)) != 0)
                recv.setResponseCode(ret);
            if (tmpAlgorithm.indexOf("DES") == 0 || tmpAlgorithm.indexOf("AES") == 0
                    || tmpAlgorithm.indexOf("SM4") == 0) {
                if ((ret = api.setString("mode", tmpMode)) != 0)
                    recv.setResponseCode(ret);
                if ((ret = api.setString("iv", iv)) != 0)
                    recv.setResponseCode(ret);
            }
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setOutputData(api.getByte("outputData"));
            if (tmpAlgorithm.indexOf("DES") == 0 || tmpAlgorithm.indexOf("AES") == 0
                    || tmpAlgorithm.indexOf("SM4") == 0) {
                recv.setIv(api.getString("iv"));
            }
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA62 签名验签
     *
     * @param algorithm(ASCII)   算法标识：SM2 / RSA
     * @param operationMode(NUM) 操作模式：1 – 签名,2 – 验签
     * @param userID(HEX)        用户ID,该值只能为有效值或者为空值
     * @param keyValue(HEX)      LMK 保护的密钥。验签时，该密钥为公钥明文。
     * @param data(BYTE)         待签名验签的数据
     * @param sign(HEX)          验签用的签名值
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getSign()} : 签名时返回的签名值<br>
     * </blockquote>
     */
    public Recv servUA62(
            String algorithm,
            Integer operationMode,
            String certName,
            String groupID,
            String certApp,
            String userID,
            String keyValue,
            byte[] data,
            String sign) {
        try {
            int ret = 0;
            String tmpAlgorithm = algorithm.trim().toUpperCase();
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA62", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algorithm", tmpAlgorithm)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setInteger("operationMode", operationMode)) != 0)
                recv.setResponseCode(ret);
            if ("RSA".equals(algorithm) || operationMode == 2) {

                if (certName.length() > 0) {
                    if ((ret = api.setString("certName", certName)) != 0)
                        recv.setResponseCode(ret);
                    if ((ret = api.setString("certApp", certApp)) != 0)
                        recv.setResponseCode(ret);
                } else {
                    if ((ret = api.setString("keyValue", keyValue)) != 0)
                        recv.setResponseCode(ret);
                }
            } else {
                if ((ret = api.setString("keyValue", keyValue)) != 0)
                    recv.setResponseCode(ret);
            }

            if ((ret = api.setString("userID", userID)) != 0)
                recv.setResponseCode(ret);

            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            if (operationMode == 2) {
                if ((ret = api.setString("sign", sign)) != 0)
                    recv.setResponseCode(ret);
            }
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            if (operationMode == 1) {
                recv.setSign(api.getByte("sign"));
            }
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA63 数据摘要（HASH）
     *
     * @param hashID(ASCII) 数据摘要算法： SM3 / MD5 / SHA1 / SHA224 / SHA256 / SHA384 / SHA512
     * @param data(BYTE)    待计算的数据
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * {@link Recv#getHash()} : 数据的 HASH 值<br>
     * </blockquote>
     */
    public Recv servUA63(String hashID, byte[] data) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA63", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("hashID", hashID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setHash(api.getString("hash"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA64 消息认证码（MAC & HMAC）
     *
     * @param hashID(ASCII)      数据摘要算法：SM3 / MD5 / SHA1 / SHA224 / SHA256 / SHA384 / SHA512
     * @param operationMode(NUM) 操作类型：1 – 生成 MAC,2 – 验证 MAC
     * @param data(BYTE)         待计算的数据
     * @param algorithm(ASCII)   密钥的算法类型： SM4， SM2 DES64，DES128，DES192 AES128，AES192，AES256
     * @param keyValue(HEX)      LMK 加密的密钥值，SM2 时为公钥明文
     * @param userID(HEX)        可选，SM3WithSM2 时的用户标识值
     * @param mac(HEX)           可选,当operationMode为2时存在.
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()}: 响应描述<br>
     * {@link Recv#getMac()} : MAC值<br>
     *
     * </blockquote>
     */
    public Recv servUA64(
            String hashID,
            Integer operationMode,
            byte[] data,
            String algorithm,
            String keyValue,
            String userID,
            String mac) {
        try {
            int ret = 0;
            String tmpAlgorithm = algorithm.trim().toUpperCase();
            String tmpHashID = hashID.trim().toUpperCase();
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA64", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("hashID", tmpHashID)) != 0)
                recv.setResponseCode(ret);
            if ((api.setInteger("operationMode", operationMode)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setByte("data", data, data.length)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("algorithm", tmpAlgorithm)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("keyValue", keyValue)) != 0)
                recv.setResponseCode(ret);
            if (operationMode == 2) {
                if ((ret = api.setString("mac", mac)) != 0)
                    recv.setResponseCode(ret);
            }
            if ("SM2".equals(tmpAlgorithm) == true && "SM3".equals(tmpHashID) == true) {
                if ((ret = api.setString("userID", userID)) != 0)
                    recv.setResponseCode(ret);
            }
            if (operationMode == 2) {
                if ((api.setString("mac", mac)) != 0)
                    recv.setResponseCode(ret);
            }
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            if (operationMode == 1) {
                recv.setMac(api.getString("mac"));
            }
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    /**
     * UA65 下发证书
     *
     * @param certName    证书名称
     * @param certApp 证书格式
     * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote> {@link Recv#getResponseCode()} : 响应码<br>
     * {@link Recv#getResponseRemark()} : 响应描述<br>
     * </blockquote>
     */
    public Recv servUA65(String certName, String certApp) {
        try {
            int ret = 0;
            Recv recv = new Recv();
            UnionAPI api = new UnionAPI();
            /*
             * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID: 不指定则采用配置文件中的设定
             */
            String userInfo = "";
            String sysID = "";
            String appID = "";
            if ((ret = api.start("UA65", userInfo, sysID, appID)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certName", certName)) != 0)
                recv.setResponseCode(ret);
            if ((ret = api.setString("certApp", certApp)) != 0)
                recv.setResponseCode(ret);
            ret = api.send();
            recv.setResponseCode(ret);
            if (ret != 0) {
                recv.setResponseRemark(api.getResponseRemark());
                return recv;
            }
            recv.setCertData(api.getString("certData"));
            api.end();
            return recv;
        } catch (Exception e) {
            return Recv.failed(e);
        }
    }

    // 该类用于接收报文响应域，由客户跟进接口说明文档自行定义
    public static class Recv {
        private final Map<String, String> strings = new HashMap<String, String>();
        private final Map<String, byte[]> bytes = new HashMap<String, byte[]>();
        private final Map<String, Integer> integers = new HashMap<String, Integer>();

        public Integer getResponseCode() {
            return integers.get("responseCode");
        }

        public void setKeyType(String string) {
            strings.put("keyType", string);
        }

        public void setKeyByPK(String string) {
            strings.put("keyByPK", string);

            // TODO Auto-generated method stub

        }

        public String getAlgFlag() {
            return strings.get("algFlag");
        }

        public void setNewCertContent(String string) {

            // TODO Auto-generated method stub

        }

        public void setAlgFlag(String string) {
            strings.put("algFlag", string);

        }

        public void setData(byte[] data) {
            bytes.put("data", data);
        }

        public void setPkcs7Env(byte[] pkcs7Env) {
            // TODO Auto-generated method stub
            bytes.put("pkcs7Env", pkcs7Env);
        }

        public void setCertInfo(String string) {
            // TODO Auto-generated method stub
            strings.put("certInfo", string);

        }

        public void setResponseCode(Integer responseCode) {
            integers.put("responseCode", responseCode);
        }

        public String getResponseRemark() {
            return strings.get("responseRemark");
        }

        public String getCertData() {
            return strings.get("certData");
        }

        public void setCertData(String certData) {
            strings.put("certData", certData);
        }

        public void setResponseRemark(String responseRemark) {
            strings.put("responseRemark", responseRemark);
        }

        public byte[] getSign() {
            return bytes.get("sign");
        }

        public void setSign(byte[] sign) {
            bytes.put("sign", sign);
        }

        public String getKeyValue() {
            return strings.get("keyValue");
        }

        public void setKeyValue(String keyValue) {
            strings.put("keyValue", keyValue);
        }

        public void setPublicKey(String publicKey) {
            strings.put("publicKey", publicKey);
        }

        public String getPublicKey() {
            return strings.get("publicKey");
        }

        public void setPrivateKey(String privateKey) {
            strings.put("privateKey", privateKey);
        }

        public String getPrivateKey() {
            return strings.get("privateKey");
        }

        public void setCheckValue(String checkValue) {
            strings.put("checkValue", checkValue);
        }

        public String getCheckValue() {
            return strings.get("checkValue");
        }

        public void setOutputData(byte[] outputData) {
            bytes.put("outputData", outputData);
        }

        public byte[] getOutputData() {
            return bytes.get("outputData");
        }

        public void setIv(String iv) {
            strings.put("iv", iv);
        }

        public String getIv() {
            return strings.get("iv");
        }

        public void setHash(String hash) {
            strings.put("hash", hash);
        }

        public String getHash() {
            return strings.get("hash");
        }

        public void setMac(String mac) {
            strings.put("mac", mac);
        }

        public String getMac() {
            return strings.get("mac");
        }

        public String getCertBuf() {
            return strings.get("certBuf");
        }

        public void setCertBuf(String certBuf) {
            strings.put("certBuf", certBuf);
        }

        public String getHashID() {
            return strings.get("hashID");
        }

        public void setHashID(String hashID) {
            strings.put("hashID", hashID);
        }

        public String getPkValue() {
            return strings.get("pkValue");
        }

        public void setPkValue(String pkValue) {
            strings.put("pkValue", pkValue);
        }

        public String getCertDN() {
            return strings.get("certDN");
        }

        public void setCertDN(String certDN) {
            strings.put("certDN", certDN);
        }

        public String getCertSN() {
            return strings.get("certSN");
        }

        public void setCertSN(String certSN) {
            strings.put("certSN", certSN);
        }

        public String getCertEffdate() {
            return strings.get("certEffdate");
        }

        public void setCertEffdate(String certEffdate) {
            strings.put("certEffdate", certEffdate);
        }

        public String getCertInvdate() {
            return strings.get("certInvdate");
        }

        public void setCertInvdate(String certInvdate) {
            strings.put("certInvdate", certInvdate);
        }

        public static Recv failed(Exception e) {
            final Recv recv = new Recv();
            recv.setResponseCode(-1);
            recv.setResponseRemark(e.getMessage());
            return recv;
        }

        public String getCertInfo() {
            return strings.get("certInfo");
        }

        public byte[] getPkcs7Env() {
            return bytes.get("pkcs7Env");
        }

        public byte[] getData() {
            return bytes.get("data");
        }

        public String getNewCertContent() {
            return strings.get("certContent");
        }

        public String getKeyByPK() {
            return strings.get("keyByPK");
        }

        public String getKeyType() {
            return strings.get("keyType");
        }

    }
}
