package com.scenetec.upf.operation.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/16 下午2:17
 */
public class UploadUtil {

    /**
     * 得到真实文件名
     * @param fileName 文件名
     * @return 无后缀文件名
     */
    public static String subFileName(String fileName){
        //查找最后一个 \ (文件分隔符)位置
        int index = fileName.lastIndexOf(File.separator);
        if(index == -1){
            //没有分隔符，说明是真实名称
            return fileName;
        }else {
            return fileName.substring(index+1);
        }
    }

    /**
     * 获得随机UUID文件名
     * @param fileName 文件名
     * @return 随机UUID文件名
     */
    public static String generateRandomFileName(String fileName){
        //首相获得扩展名，然后生成一个UUID码作为名称，然后加上扩展名
        String ext = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString()+ext;
    }

    /**
     * 获得hashcode 生成二级目录
     * @return 二级目录
     */
    public static String generateRandomDir(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/MMdd");
        return simpleDateFormat.format(new Date());
    }


}
