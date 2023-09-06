package com.example.vuejs_ex.controller;

import com.example.vuejs_ex.service.MainService;
import com.example.vuejs_ex.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class MainApiController {

    private final MainService mainService;

    @GetMapping("")
    public List<UserVO> getAllUsers() throws Exception {
        return mainService.getUser();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id) throws Exception{
        mainService.deleteUser(id);
    }

    @ResponseBody
    @PostMapping("")
    public void insertUser(@RequestBody UserVO userVO) throws Exception{
        mainService.insertUser(userVO);
    }

}
