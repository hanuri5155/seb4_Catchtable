package com.se_b4.catchtable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/searches")
public class SearchController
{
    @GetMapping("/")
    public String OnSearchEntered()
    {
        return "searches/main";
    }
}
