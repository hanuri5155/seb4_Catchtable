package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.entity.ReserveData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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

        ReserveData data = new ReserveData();

        // TEST: 임시 값을 데이터베이스에 삽입합니다.
        data.setReserverUUID(1);
        data.setCountPerson(6);
        data.setTimeBegin(LocalDateTime.now().toLocalTime());
        data.setReserveDate(LocalDateTime.now());
        data.setDate(Timestamp.valueOf(LocalDateTime.now()));

        // TODO: Model 클래스에서 값을 가져올 수 있을 때 아래 코드를 활성화합니다.
        // data.setReserverUUID((int)_model.getAttribute("reserverUUID"));
        // data.setCountPerson((int)_model.getAttribute("countPerson"));
        // data.setTimeBegin((LocalTime)_model.getAttribute("timeBegin"));
        // data.setReserveDate(LocalDateTime.now());
        // data.setDate((Date)_model.getAttribute("date"));

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
