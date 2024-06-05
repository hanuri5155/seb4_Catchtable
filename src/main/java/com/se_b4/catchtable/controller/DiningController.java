package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.entity.DiningData;
import com.se_b4.catchtable.service.DiningInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class DiningController
{
    private final DiningInfoService diningInfoService;

    @GetMapping("/DiningPageBase")
    public String DiningPageBase(Model _model, @RequestParam("dining_uid") int dining_uid)
    {
        DiningData diningData = diningInfoService.getDiningData(dining_uid).get(0);

        _model.addAttribute("dining_uid", dining_uid);
        _model.addAttribute("dining_name", diningData.getName());
        _model.addAttribute("dining_tel", diningData.getTel());
        _model.addAttribute("dining_address", diningData.getAddress());

        String description = diningData.getDescription();
        if(description == null || description.trim().isEmpty())
            _model.addAttribute("dining_description", "- 등록된 식당 설명이 없습니다. -");
        else
            _model.addAttribute("dining_description", diningData.getDescription());

        return "users/DiningPageBase";
    }
}
