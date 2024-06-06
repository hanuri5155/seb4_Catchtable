package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import com.se_b4.catchtable.service.BusinessRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admins")
public class BusinessApprovalController {
    private final BusinessRegistrationService businessRegistrationService;

    @GetMapping("/BusinessApprovalPage")
    public String BusinessApprovalPage(Model model) {
        List<BusinessAuthEntity> businessAuthEntityList = businessRegistrationService.findAll();
        model.addAttribute("businessAuthEntityList", businessAuthEntityList);
        return "admins/BusinessApprovalPage";
    }
}