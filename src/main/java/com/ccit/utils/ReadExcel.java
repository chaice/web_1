package com.ccit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.ccit.bean.StoreInfo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

public class ReadExcel {

    private static String xlsx2007 = "/Users/7x-networks/Desktop/box.xlsx";

    public static Map<String, StoreInfo> readStoreInfoFromXLSX(String filePath) {
        File excelFile = null;// Excel文件对象
        InputStream is = null;// 输入流对象
        String cellStr = null;// 单元格，最终按字符串处理
        Map<String, StoreInfo> storeInfoMap = new HashMap<>();
        StoreInfo storeInfo = null;
        try {
            excelFile = new File(filePath);
            is = new FileInputStream(excelFile);// 获取文件输入流
            Workbook workbook2007 = WorkbookFactory.create(is);
            Sheet sheet = workbook2007.getSheetAt(0);
            // 开始循环遍历行，表头不处理，从1开始
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                storeInfo = new StoreInfo();// 实例化Student对象
                Row row = sheet.getRow(i);// 获取行对象
                if (row == null) {// 如果为空，不处理
                    continue;
                }
                // 循环遍历单元格
                for (int j = 0; j < row.getLastCellNum(); j++) {
//                    XSSFCell cell = row.getCell(j);// 获取单元格对象
                    Cell cell = row.getCell(j);// 获取单元格对象
                    if (cell == null) {// 单元格为空设置cellStr为空串
                        cellStr = "";
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理
                        cellStr = String.valueOf(cell.getBooleanCellValue());
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理
                        int cellValue = (int) cell.getNumericCellValue();
                        cellStr = cellValue + "";
                    } else {// 其余按照字符串处理
                        cellStr = cell.getStringCellValue();
                    }
                    // 下面按照数据出现位置封装到bean中
                    if (j == 1) {
                        storeInfo.setStoreID(cellStr);
                    } else if (j == 3) {
                        storeInfo.setSubnet(cellStr);
                    } else if (j == 4) {
                        storeInfo.setGateway(cellStr);
                    } else if (j == 7) {
                        storeInfo.setVlan10("Y".equals(cellStr) ? true : false);
                    } else if (j == 8) {
                        storeInfo.setVlan20("Y".equals(cellStr) ? true : false);
                    }
                }
                storeInfoMap.put(storeInfo.getStoreID(), storeInfo);// 数据装入List
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {

        } finally {// 关闭文件流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return storeInfoMap;
    }


}

