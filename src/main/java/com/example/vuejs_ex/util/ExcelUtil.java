package com.example.vuejs_ex.util;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ExcelUtil {

    public static void excelDownload(HttpServletResponse response, List<?> list) throws Exception{
//        Workbook wb = new HSSFWorkbook();
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("첫번째 시트");
        Row row = null;
        Cell cell = null;
        int rowNum = 0;
        int columnNum = 0;

        row = sheet.createRow(rowNum++);
        for(Field field : list.get(0).getClass().getDeclaredFields()){
            field.setAccessible(true);
            Object value = field.get(list.get(0));

            cell = row.createCell(columnNum);
            cell.setCellValue(field.getName());
            columnNum += 1;
        }

        // Body
        for (int i=0; i<list.size(); i++) {
            columnNum = 0;
            row = sheet.createRow(rowNum++);
            for(Field field : list.get(i).getClass().getDeclaredFields()){
                field.setAccessible(true);
                Object value = field.get(list.get(i));

                cell = row.createCell(columnNum);
                cell.setCellValue((String)value);
                columnNum += 1;
            }
        }

        // 컨텐츠 타입과 파일명 지정
        response.setContentType("ms-vnd/excel");
//        response.setHeader("Content-Disposition", "attachment;filename=example.xls");
        response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

        // Excel File Output
        wb.write(response.getOutputStream());
        wb.close();
    }

}
