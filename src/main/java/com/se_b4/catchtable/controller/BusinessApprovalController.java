package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import com.se_b4.catchtable.service.BusinessApprovalService;
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
    private final BusinessApprovalService businessApprovalService;

    @GetMapping("/BusinessApprovalPage")
    public String BusinessApprovalPage(Model model) {
        List<BusinessAuthEntity> businessAuthEntityList = businessApprovalService.BusinessApproval();
        model.addAttribute("businessAuthEntityList", businessAuthEntityList);
        return "admins/BusinessApprovalPage";
    }
}