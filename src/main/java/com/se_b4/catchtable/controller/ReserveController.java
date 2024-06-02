package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.dto.DiningDTO;
import com.se_b4.catchtable.dto.ReserveDTO;
import com.se_b4.catchtable.entity.DiningData;
import com.se_b4.catchtable.entity.ReserveData;
import com.se_b4.catchtable.service.ReserveService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reserves")
@RequiredArgsConstructor
public class ReserveController
{
    private final ReserveService reserveService;

    @GetMapping("/reserve")
    public String OnReserveStarted(Model _model, HttpSession session, @RequestParam(value = "dining_uid") int dining_uid)
    {
        String logMessage = String.format("Reserve page #%d requested from user.", dining_uid);
        System.out.println(logMessage);

        DiningData diningData = reserveService.getDiningData(dining_uid).get(0);
        DiningDTO diningDTO = DiningDTO.toDTO(diningData);
        System.out.println(diningData);

        ReserveDTO reserveDTO = new ReserveDTO();
        reserveDTO.setDining_dto(diningDTO);
        reserveDTO.setReserver_uuid(1);

        session.setAttribute("reserveDTO", reserveDTO);
        _model.addAttribute("reserveDTO", reserveDTO);

        return "/reserves/reserve-t";
    }

    @PostMapping("/try-reserve")
    public String _OnReserveRequested(@ModelAttribute("reserveDTO") ReserveDTO reserveDTO, HttpSession session)
    {
        ReserveDTO sessionReserveDTO = (ReserveDTO) session.getAttribute("reserveDTO");

        if(sessionReserveDTO != null)
        {
            sessionReserveDTO.setReserve_date(reserveDTO.getReserve_date());
            sessionReserveDTO.setReserve_time(reserveDTO.getReserve_time());
            sessionReserveDTO.setCount_person(reserveDTO.getCount_person());
            // 예약 처리 로직
            System.out.println(reserveDTO);
        }

        return "/reserves/success";
    }

    @PostMapping("/reserve")
    public String OnReserveRequested(Model _model, @RequestParam("dining_uid") Long dining_uid)
    {
        String logMessage = String.format("Reserve requested from user on dining id #%d.", dining_uid);
        System.out.println(logMessage);

        _model.addAttribute("dining_uid", dining_uid);

        List<ReserveData> data = reserveService.GetReserveDataByReserverUUID(1L);

        if(data == null)
            System.out.println("null reserve data");
        else if(data.size() == 0)
            System.out.println("0 reserve data");
        else
        {
            for(int i = 0; i < data.size(); ++i)
            {
                System.out.println(data.get(i).toString());
            }
        }

        // TEST: 임시 값을 데이터베이스에 삽입합니다.
        // ReserveData data = new ReserveData();
        // data.setReserverUUID(1);
        // data.setCountPerson(6);
        // data.setTimeBegin(LocalDateTime.now().toLocalTime());
        // data.setReserveDate(LocalDateTime.now());
        // data.setDate(Timestamp.valueOf(LocalDateTime.now()));

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
