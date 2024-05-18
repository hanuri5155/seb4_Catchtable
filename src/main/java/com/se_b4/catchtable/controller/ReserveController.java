package com.se_b4.catchtable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/reserves")
public class ReserveController
{
    @GetMapping("/reserve")
    public String OnReserveStarted(Model _model, @RequestParam(value = "dining_id") int _diningId)
    {
        String logMessage = String.format("Reserve page #%d requested from user.", _diningId);
        System.out.println(logMessage);

        _model.addAttribute("dining_id", _diningId);

        return "/reserves/reserve";
    }

    @PostMapping("/reserve")
    public String OnReserveRequested(Model _model, @RequestParam("dining_id") Long _diningId)
    {
        String logMessage = String.format("Reserve requested from user on dining id #%d.", _diningId);
        System.out.println(logMessage);

        _model.addAttribute("dining_id", _diningId);

        // TEST: '식당 예약하기' 버튼을 누르는 즉시 결제 성공 페이지로 이동합니다.
        // TODO: 결제 페이지를 출력할 수 있도록 코드를 수정합니다.
        return "/reserves/success";
    }

    @GetMapping("/success")
    public String OnReserveSucceed(Model _model)
    {
        int diningId = (int)_model.getAttribute("dining_id");
        String logMessage = String.format("Dining #%d successfully reserved.", diningId);
        System.out.println(logMessage);

        return "/reserves/success";
    }
}
