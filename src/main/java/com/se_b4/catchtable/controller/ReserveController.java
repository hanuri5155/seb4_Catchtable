package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.constants.SessionAttrKey;
import com.se_b4.catchtable.dto.ReserveDTO;
import com.se_b4.catchtable.entity.DiningData;
import com.se_b4.catchtable.entity.ReserveData;
import com.se_b4.catchtable.service.ReserveService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

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
        // String logMessage = String.format("Reserve page #%d requested from user.", dining_uid);
        // System.out.println(logMessage);

        DiningData diningData = reserveService.getDiningData(dining_uid).get(0);
        // System.out.println(diningData);

        _model.addAttribute("dining_uid", dining_uid);
        _model.addAttribute("dining_name", diningData.getName());
        _model.addAttribute("dining_tel", diningData.getTel());
        _model.addAttribute("dining_address", diningData.getAddress());
        _model.addAttribute("dining_description", diningData.getDescription());

        _model.addAttribute("reserveDTO", new ReserveDTO());

        return "/reserves/reserve";
    }

    @PostMapping("/try-reserve")
    public String OnPurchaseRequested(@ModelAttribute("reserveDTO") ReserveDTO reserveDTO, HttpSession session, @RequestParam("dining_uid") int dining_uid)
    {
        Long reserver_uuid = (Long)session.getAttribute("loggedUuid");

        ReserveData reserveData = new ReserveData();
        reserveData.setReserver_uuid(reserver_uuid);
        reserveData.setDining_uid(dining_uid);
        reserveData.setCount_person(reserveDTO.getCount_person());
        reserveData.setDate(java.sql.Date.valueOf(reserveDTO.getReserve_date()));
        reserveData.setTime_begin(reserveDTO.getReserve_time());

        reserveDTO.setReserver_uuid(reserver_uuid);

        int canReserveFlags = reserveService.tryReserve(reserveData);
        reserveDTO.setCanPurchase((canReserveFlags & 1) > 0);
        reserveDTO.setCanReserve((canReserveFlags & 2) > 0);

        if(canReserveFlags == 3)
        {
            session.setAttribute("reserveDTO", reserveDTO);
            return "redirect:/reserves/success";
        }
        else
        {
            session.setAttribute("reserveDTO", reserveDTO);
            return "redirect:/reserves/failure";
        }
    }

    // NOTE: 클래스 다이어그램, 시퀀스 다이어그램과 흐름을 맞추기 위한 PRG 패턴 적용입니다.
    // NOTE: PRG Pattern == Post-Redirect-Get Pattern.
    @GetMapping("/success")
    public String OnReserveSucceed(Model _model, HttpSession session)
    {
        ReserveDTO reserveDTO = (ReserveDTO)session.getAttribute("reserveDTO");

        if(reserveDTO == null)
            return "redirect:/reserves/reserve";

        session.removeAttribute("reserveDTO");

        _model.addAttribute("reserveDTO", reserveDTO);

        // TEST: 디버깅용 로그.
        int dining_uid = reserveDTO.getDining_uid();
        String logMessage = String.format("Dining #%d reserve succeed.", dining_uid);
        System.out.println(logMessage);

        return "/reserves/success";
    }

    // NOTE: 클래스 다이어그램, 시퀀스 다이어그램과 흐름을 맞추기 위한 PRG 패턴 적용입니다.
    // NOTE: PRG Pattern == Post-Redirect-Get Pattern.
    @GetMapping("/failure")
    public String OnReserveFailure(Model _model, HttpSession session)
    {
        ReserveDTO reserveDTO = (ReserveDTO)session.getAttribute("reserveDTO");

        if(reserveDTO == null)
            return "redirect:/reserves/reserve";

        session.removeAttribute("reserveDTO");

        _model.addAttribute("reserveDTO", reserveDTO);

        // TEST: 디버깅용 로그.
        int dining_uid = reserveDTO.getDining_uid();
        String logMessage = String.format("Dining #%d reserve failed.", dining_uid);
        System.out.println(logMessage);

        return "/reserves/failure";
    }
}
