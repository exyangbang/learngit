package cn.kingnet.utp.sdk.account.tools;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author WJH
 * @Date 2020/08/13
 */

@Getter
@Setter
public class SftpConfig {
    private String userName;
    private String password;
    private String privateKey;
    private String host;
    private int port;

}
