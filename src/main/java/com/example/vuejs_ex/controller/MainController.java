package com.example.vuejs_ex.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(HttpServletRequest request){

        return "main";
    }

    @GetMapping("/ex2")
    public String ex2(HttpServletRequest request){

        return "ex2";
    }

}
