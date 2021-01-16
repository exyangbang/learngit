package com.scenetec.upf.operation.filter;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * druid监控视图配置
 * @author luoxianjun@scenetec.com
 * 2018/7/20 上午11:50
 */
@WebServlet(urlPatterns = "/druid/*", initParams={
    @WebInitParam(name="allow",value=""),// IP白名单 (没有配置或者为空，则允许所有访问)
    @WebInitParam(name="deny",value="192.168.1.73"),
    @WebInitParam(name="loginUsername",value="admin"),// 用户名
    @WebInitParam(name="loginPassword",value="admin"),// 密码
    @WebInitParam(name="resetEnable",value="true")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
}
