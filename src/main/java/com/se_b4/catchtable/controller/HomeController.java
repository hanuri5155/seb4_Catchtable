package com.se_b4.catchtable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 메인 페이지 요청
    @GetMapping("/")
    public String home() {return "HomePage";}
}
