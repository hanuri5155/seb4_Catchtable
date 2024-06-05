package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.dto.BlacklistDTO;
import com.se_b4.catchtable.dto.UserDTO;
import com.se_b4.catchtable.repository.BlacklistRegistrationRepository;
import com.se_b4.catchtable.service.BlacklistRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners")
public class BlacklistRegistrationController {
    private final BlacklistRegistrationService blacklistRegistrationService;

    @GetMapping("/BlacklistRegistrationPage")
    public String BlacklistRegistrationPage(Model model) {
        model.addAttribute("blacklist", new BlacklistDTO());
        return "owners/BlacklistRegistrationPage";
    }

    @PostMapping("/BlacklistRegistrationPage")
    public String blacklistRegistration(@Valid @ModelAttribute("blacklist") BlacklistDTO blacklistDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("blacklist", blacklistDTO);  // 유효성 검사 실패 시 모델에 다시 추가
            return "owners/BlacklistRegistrationPage";
        }
        blacklistRegistrationService.BlacklistRegistration(
                blacklistDTO.getUsername(),
                blacklistDTO.getPhone_number()
        );
        model.addAttribute("successMessage", "등록이 완료 되었습니다");
        model.addAttribute("blacklist", new BlacklistDTO());
        return "owners/BlacklistRegistrationPage";
    }
}
