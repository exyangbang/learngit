package com.scenetec.upf.operation.utils;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
@Service
public class DownloadExcelTool {
    @Autowired
    private ResourceLoader resourceLoader;

    public void download(String path, String filename, HttpServletResponse response, List items, Map total){
        if (items.size() > 15000){
            throw new SystemRuntimeException(ErrorCode.BSMST004);
        }
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:" + path);
        InputStream iss = null;
        try (InputStream is = resource.getInputStream()) {
            Context context = new Context();
            context.putVar("items", items);
            context.putVar("total", total);
            response.setHeader("Content-type", "application/vnd.ms-excel");
            // 解决导出文件名中文乱码
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8"), "ISO-8859-1") + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
            iss=is;


        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemRuntimeException(ErrorCode.BSMST001);
        }finally {
            try {
                response.getOutputStream().close();
                response.getOutputStream().flush();
                iss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
