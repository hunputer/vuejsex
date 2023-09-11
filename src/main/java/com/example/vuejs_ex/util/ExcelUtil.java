package com.example.vuejs_ex.util;

import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtil {

    public static void excelDownload(HttpServletResponse response, List<?> list, @NonNull String fileName) throws Exception{
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet(fileName);

        Row row = null;
        Cell cell = null;
        int rowNum = 0;
        int columnNum = 0;

        //제목 스타일 지정
        CellStyle styleOfBoardFillFontRedBold = wb.createCellStyle();
        styleOfBoardFillFontRedBold.setAlignment(HorizontalAlignment.CENTER);
        styleOfBoardFillFontRedBold.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        styleOfBoardFillFontRedBold.setFillPattern(FillPatternType.BRICKS);
        styleOfBoardFillFontRedBold.setBorderRight(BorderStyle.THIN);
        styleOfBoardFillFontRedBold.setBorderLeft(BorderStyle.THIN);
        styleOfBoardFillFontRedBold.setBorderTop(BorderStyle.THIN);
        styleOfBoardFillFontRedBold.setBorderBottom(BorderStyle.THIN);

        //리스트 스타일 지정
        CellStyle styleOfBoardFillFontRedBold2 = wb.createCellStyle();
        styleOfBoardFillFontRedBold2.setAlignment(HorizontalAlignment.CENTER);
        styleOfBoardFillFontRedBold2.setBorderRight(BorderStyle.THIN);
        styleOfBoardFillFontRedBold2.setBorderLeft(BorderStyle.THIN);
        styleOfBoardFillFontRedBold2.setBorderTop(BorderStyle.THIN);
        styleOfBoardFillFontRedBold2.setBorderBottom(BorderStyle.THIN);

        //vo의 제목 셋팅
        row = sheet.createRow(rowNum++);
        for(Field field : list.get(0).getClass().getDeclaredFields()){
            field.setAccessible(true);
            Object value = field.get(list.get(0));

            cell = row.createCell(columnNum);
            cell.setCellStyle(styleOfBoardFillFontRedBold);
            cell.setCellValue(field.getName());

            columnNum += 1;
        }

        // vo의 리스트 셋팅
        for (int i=0; i<list.size(); i++) {
            columnNum = 0;
            row = sheet.createRow(rowNum++);
            for(Field field : list.get(i).getClass().getDeclaredFields()){
                field.setAccessible(true);
                Object value = field.get(list.get(i));

                cell = row.createCell(columnNum);
                cell.setCellStyle(styleOfBoardFillFontRedBold2);
                cell.setCellValue((String)value);
                columnNum += 1;
            }
        }

        // 컨텐츠 타입과 파일명 지정
        response.setContentType("ms-vnd/excel");

        // 정규식 사용하여 파일명에 .@$^공백이 있을경우 _로 대체
        fileName = fileName.replaceAll("[.@$^\\s]", "_");
        // 헤더에 한글 셋팅
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xlsx");

        // Excel File Output
        wb.write(response.getOutputStream());
        wb.close();
    }

}
