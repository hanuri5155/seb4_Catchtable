package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.dto.BusinessAuthDTO;
import com.se_b4.catchtable.service.BusinessRegistrationService;
import com.se_b4.catchtable.service.FileStoreService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners")
public class BusinessRegistrationController {
    private final BusinessRegistrationService businessRegistrationService;
    private final FileStoreService fileStoreService;

    @GetMapping("/BusinessRegistrationPage")
    public String BusinessRegistrationPage(HttpSession session, Model model) {
        Long loggedUuid = (Long) session.getAttribute("loggedUuid"); // 세션 받아오기
        if (loggedUuid == null) {
            return "redirect:/signin";
        }

        model.addAttribute("loggedUuid", loggedUuid); // 세션 전달
        model.addAttribute("businessAuth", new BusinessAuthDTO());
        return "owners/BusinessRegistrationPage";
    }

    @PostMapping("/upload")
    public String uploadBusinessDetails(@Valid @ModelAttribute("businessAuth")
                                            BusinessAuthDTO businessAuthDTO,
                                        HttpSession session, @RequestParam(value="file")
                                            MultipartFile file,
                                        Model model) throws IOException {
        Long loggedUuid = (Long) session.getAttribute("loggedUuid");
        if (loggedUuid == null) {
            return "redirect:/";
        }

        model.addAttribute("loggedUuid", loggedUuid);
        System.out.println("세션 전달 확인(ouuid): " + loggedUuid);

        // 파일 이름이 겹치면 덮어씌워지므로 업로드 후 고유한 이름으로 변환
        String businessDetailsFile = fileStoreService.storeFile(file);

        businessRegistrationService.saveBusinessDetails(
                loggedUuid,         // 세션으로 전달 받은 uuid
                businessDetailsFile // 고유한 파일명
        );
        model.addAttribute("successMessage",
                "파일 업로드가 성공적으로 완료되었습니다.");
        model.addAttribute("businessDetailsFile", businessDetailsFile); // 로그 확인용

        // 로그 출력
        System.out.println("업로드된 파일 경로: " + businessDetailsFile);
        return "owners/BusinessRegistrationPage";
    }
}
