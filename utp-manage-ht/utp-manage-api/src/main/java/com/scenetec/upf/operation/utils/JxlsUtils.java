package com.scenetec.upf.operation.utils;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/26 13:49
 */
public class JxlsUtils {

    public static String getSolveStatusName(String solveStatus){
        if("1".equals(solveStatus)){
            return "已处理";
        }else {
            return "未处理";
        }
    }
}
