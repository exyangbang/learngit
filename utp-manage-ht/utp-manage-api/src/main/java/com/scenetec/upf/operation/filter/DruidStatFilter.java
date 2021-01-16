package com.scenetec.upf.operation.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="druidWebStatFilter",
    urlPatterns="/*",
    initParams={
        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
    })
/**
 * druid监控视图配置
 * @author luoxianjun@scenetec.com
 * 2018/7/20 上午11:50
 */
public class DruidStatFilter extends WebStatFilter {

}


