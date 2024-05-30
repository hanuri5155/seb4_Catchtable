package com.se_b4.catchtable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners")
public class BusinessRegistrationController {
    @GetMapping("/BusinessRegistrationPage")
    public String BusinessRegistrationPage() {return "owners/BusinessRegistrationPage";}


}
