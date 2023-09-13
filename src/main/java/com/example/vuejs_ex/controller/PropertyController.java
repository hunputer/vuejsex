package com.example.vuejs_ex.controller;


import com.example.vuejs_ex.util.YmlConstants;
import com.example.vuejs_ex.util.YmlPropertyUtil;
import com.example.vuejs_ex.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/propertyEx")
public class PropertyController {

    private final YmlPropertyUtil ymlPropertyUtil;

    @GetMapping("")
    public String propertyEx() throws Exception {

        System.out.println(ymlPropertyUtil.getProperty("test.name"));
        System.out.println(ymlPropertyUtil.getProperty("test.name"));

        return "configEx";
    }
}
