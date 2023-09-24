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

    @GetMapping("/ex3")
    public String ex3(HttpServletRequest request){

        return "ex3";
    }

    @GetMapping("/ex4")
    public String ex4(HttpServletRequest request){

        return "ex4";
    }

    @GetMapping("/ex5")
    public String ex5(HttpServletRequest request){

        return "ex5";
    }

    @GetMapping("/ex6")
    public String ex6(HttpServletRequest request){

        return "ex6";
    }

    @GetMapping("/axiosEx")
    public String axiosEx(HttpServletRequest request){

        return "axiosEx";
    }

    @GetMapping("/axiosComponent")
    public String axiosComponentEx(HttpServletRequest request){

        request.setAttribute("var1", "변수1");
        request.setAttribute("var2", "변수2");

        return "axiosComponent";
    }
}
