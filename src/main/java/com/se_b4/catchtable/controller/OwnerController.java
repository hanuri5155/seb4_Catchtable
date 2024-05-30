package com.se_b4.catchtable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    @GetMapping("/BusinessPage")
    public String BusinessPage() {return "owners/BusinessPage";}
}
