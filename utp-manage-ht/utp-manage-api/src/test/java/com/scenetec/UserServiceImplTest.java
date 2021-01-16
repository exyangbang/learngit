package com.scenetec;

import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.Sha256;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @Description
 * @Author WJH
 * @Date 2018/12/24
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = OperationManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//
//@ActiveProfiles("dev")
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void loginUm() {
        String userName = "guanwenchao02";
        String password = "$2a$10$AmQuWggx9UHv243jHUZ2Vub5JL/DaURsOg.xIKsr2MKvOO22E9TJe";
        userService.loginUm(userName,password);
    }

    public static void main(String[] args) {
        String fPwd = Sha256.shaEncode("123456", "qiang.qi");
        System.out.println(" 前端加密后密码= " + fPwd);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String dbPwd = encoder.encode(fPwd);
        System.out.println(" 前端加密后保存库表密码= " + dbPwd);
        System.out.println("fPwd = dbPwd " + encoder.matches(fPwd, dbPwd));

    }


}
