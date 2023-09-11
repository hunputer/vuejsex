package com.example.vuejs_ex.controller;

import com.example.vuejs_ex.service.MainService;
import com.example.vuejs_ex.vo.UserVO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class MainApiController {

    private final MainService mainService;

    @ResponseBody
    @GetMapping("")
    public List<UserVO> getAllUsers() throws Exception {
        return mainService.getAllUsers();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public UserVO getUser(@PathVariable("id") String id) throws Exception {
        return mainService.getUser(id);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable("id") String id) throws Exception{
        return mainService.deleteUser(id);
    }

    @ResponseBody
    @PostMapping("")
    public int insertUser(@RequestBody UserVO userVO) throws Exception{
        return mainService.insertUser(userVO);
    }

    @ResponseBody
    @PatchMapping("/{id}")
    public int modifyUser(@PathVariable("id") String id, @RequestBody UserVO userVO) throws Exception{
        return mainService.updateUser(id, userVO);
    }

    @GetMapping("/excel/download")
    public void excelDownload(HttpServletResponse response) throws IOException {
//        Workbook wb = new HSSFWorkbook();
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("첫번째 시트");
        Row row = null;
        Cell cell = null;
        int rowNum = 0;

        // Header
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue("번호");
        cell = row.createCell(1);
        cell.setCellValue("이름");
        cell = row.createCell(2);
        cell.setCellValue("제목");

        // Body
        for (int i=0; i<3; i++) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue(i);
            cell = row.createCell(1);
            cell.setCellValue(i+"_name");
            cell = row.createCell(2);
            cell.setCellValue(i+"_title");
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
