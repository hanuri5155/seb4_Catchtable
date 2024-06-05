package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.dto.BusinessAuthDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    @GetMapping("/BusinessPage")
    public String BusinessPage(HttpSession session, Model model) {
        Long loggedUuid = (Long) session.getAttribute("loggedUuid");        // uuid 받아오기
        String loggedUserid = (String) session.getAttribute("loggedUserid");// userid 받아오기 (로그인 시 id 표시하기 위함)
        if (loggedUuid == null || loggedUserid == null) {
            return "redirect:/signin";
        }

        model.addAttribute("loggedUuid", loggedUuid);

        // 세션 전달 확인
        System.out.println("uuid: " + loggedUuid);
        System.out.println("userid: " + loggedUserid);

        return "owners/BusinessPage";}
}