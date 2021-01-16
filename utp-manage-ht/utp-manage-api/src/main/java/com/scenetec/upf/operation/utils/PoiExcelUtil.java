package com.scenetec.upf.operation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author shendunyuan@scenetec.com
 * 2018/7/11 下午5:07
 */
public class PoiExcelUtil {

	private static final String EXCEL_XLS = "XLS";
	private static final String EXCEL_XLSX = "XLSX";

	/**
	 * 读取excel
	 * @param filePath 文件路径
	 * @return 返回文件内容
	 */
	@SuppressWarnings(value = "unused")
	public static Map<String, List<List<String>>> readExcel(String filePath) {
		if (StringUtils.isBlank(filePath)) {
			throw new SystemRuntimeException(ErrorCode.BSMME003);
		}
		return readExcel(new File(filePath));
	}

	/**
	 * 读取excel
	 * @param is 文件流
	 * @param fileSuffix 文件后缀
	 * @return 返回excel内容
	 */
	public static Map<String, List<List<String>>> readExcel(InputStream is, String fileSuffix) {
		// 创建返回对象
		Map<String, List<List<String>>> dataMap = new HashMap<>(16);
		Workbook wb = null;
		try {
			// 创建workbook
			if (EXCEL_XLS.equals(fileSuffix)) {
				wb = new HSSFWorkbook(is);
			} else if (EXCEL_XLSX.equals(fileSuffix)) {
				wb = new XSSFWorkbook(is);
			} else {
				throw new SystemRuntimeException(ErrorCode.BSMME004);
			}
			// 读取数据
			int count = 0;
			while (wb.getNumberOfSheets() > count) {
				Sheet sheet = wb.getSheetAt(count++);
				List<List<String>> rowList = new ArrayList<>();
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
					Row row = sheet.getRow(i);
					List<String> cellList = new ArrayList<>();
					for (int j = 0; j < row.getLastCellNum(); j++) {
						Cell cell = row.getCell(j);
						cellList.add(getValue(cell));
					}
					rowList.add(cellList);
				}
				dataMap.put(sheet.getSheetName(), rowList);
			}
		} catch (SystemRuntimeException sex) {
			throw sex;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (wb != null) {
					wb.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return dataMap;
	}

	/**
	 * 读取excel
	 * @param file 文件
	 * @return 返回excel内容
	 */
	private static Map<String, List<List<String>>> readExcel(File file) {
		// 创建返回对象
		Map<String, List<List<String>>> dataMap = new HashMap<>(16);
		InputStream fis = null;
		try {
			if (!file.exists()) {
				throw new SystemRuntimeException(ErrorCode.BSMME005);
			}
			if (!file.isFile()) {
				throw new SystemRuntimeException(ErrorCode.BSMME006);
			}
			// 获取文件后缀
			String fileSuffix = getExcelSuffix(file.getName());
			// 创建文件流
			fis = new FileInputStream(file);
			// 读取文件
			readExcel(fis, fileSuffix);
		} catch (SystemRuntimeException sex) {
			throw sex;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return dataMap;
	}

	/**
	 * 获取文件后缀
	 * @param fileName 文件名称
	 * @return 文件名后缀
	 */
	public static String getExcelSuffix(String fileName) {
		String suffix = null;
		if (StringUtils.isNotBlank(fileName)) {
			suffix = fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase();
		}
		return suffix;
	}

	/**
	 * 获取数据
	 * @param cell 列
	 * @return 返回单元格数据
	 */
	private static String getValue(Cell cell) {
		String result = "";
		if (null != cell) {
			switch (cell.getCellTypeEnum()) {
				case STRING:
					result = cell.getStringCellValue();
					break;
				case NUMERIC:
					result = String.valueOf(cell.getNumericCellValue());
					break;
				case FORMULA:
					result = cell.getCellFormula();
					break;
				case ERROR:
					result = "error";
					break;
				case BOOLEAN:
					result = String.valueOf(cell.getBooleanCellValue());
					break;
				case BLANK:
				default:
					break;
			}
		}
		return result;
	}
}
