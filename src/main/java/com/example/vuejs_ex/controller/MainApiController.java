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

    @ResponseBody
    @GetMapping("")
    public List<UserVO> getAllUsers() throws Exception {
        return mainService.getUser();
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
        return mainService.deleteUser(id);
    }

}
