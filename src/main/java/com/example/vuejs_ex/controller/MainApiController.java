package com.example.vuejs_ex.controller;

import com.example.vuejs_ex.service.MainService;
import com.example.vuejs_ex.util.ExcelUtil;
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
    public void excelDownload(HttpServletResponse response) throws Exception {
        List<UserVO> list = mainService.getAllUsers();

        ExcelUtil.excelDownload(response, list);
//
    }

}
