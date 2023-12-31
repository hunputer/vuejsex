package com.example.vuejs_ex.controller;


import com.example.vuejs_ex.util.YmlPropertyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/propertyEx")
public class PropertyController {

    private final YmlPropertyUtil ymlPropertyUtil;

    @GetMapping("")
    public String propertyEx() throws Exception {

        System.out.println(ymlPropertyUtil.getProperty("test.name"));
        System.out.println(ymlPropertyUtil.getProperty("extern.yml.test"));

        return "configEx";
    }
}
