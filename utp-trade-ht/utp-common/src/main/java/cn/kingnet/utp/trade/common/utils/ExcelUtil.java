package cn.kingnet.utp.trade.common.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2018年09月08日
 */
public class ExcelUtil {


    public static List<List<String>> readExcel(InputStream in) {

        List<List<String>> list = new ArrayList<List<String>>();
        try {
            Workbook wb = WorkbookFactory.create(in);
            Sheet sheet = wb.getSheetAt(0);
            int sIndex = 0;
            for (int j = sIndex; j < sheet.getLastRowNum() + 1; j++) {
                Row row = sheet.getRow(j);
                if (row == null)
                    continue;
                List<String> rowList = new ArrayList<String>();
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if (cell == null) {
                        rowList.add("");
                    } else {
                        String value = cell.getCellTypeEnum().toString() == "NUMERIC" ?
                                String.valueOf(cell.getNumericCellValue())
                                : cell.getRichStringCellValue().toString();

                        rowList.add(value);
                    }
                }
                if (!"".equals(rowList.get(0))) {
                    list.add(rowList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



}
