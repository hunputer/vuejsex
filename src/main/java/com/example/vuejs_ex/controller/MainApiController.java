package com.example.vuejs_ex.controller;

import com.example.vuejs_ex.service.MainService;
import com.example.vuejs_ex.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/service")
public class MainApiController {

    private final MainService mainService;

    @ResponseBody
    @GetMapping("/getUser")
    public List<UserVO> getUser() throws Exception {
        List<UserVO> userList = mainService.getUser();

        return userList;
    }

}
