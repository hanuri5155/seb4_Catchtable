package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.dto.ReportDTO;
import com.se_b4.catchtable.entity.ReportEntity;
import com.se_b4.catchtable.service.ReportService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reports")
@Controller
@RequiredArgsConstructor
public class ReportController
{
    private final ReportService reportService;

    @GetMapping("")
    public String OnReportPageRequested(Model _model, @RequestParam("dining_uid") int dining_uid)
    {
        _model.addAttribute("dining_uid", dining_uid);
        _model.addAttribute("reportDTO", new ReportDTO());

        return "/users/report";
    }

    @PostMapping("")
    public String OnReportSubmitted(@ModelAttribute("reportDTO") ReportDTO reportDTO, HttpSession session, @RequestParam("dining_uid") int dining_uid)
    {
        int reporter_uuid = 1; // TODO: 세션에서 사용자 uuid를 가져올 수 있을 때 이 코드를 수정합니다.
        // int reporter_uuid = (int)session.getAttribute("loggedUuid");

        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setDining_uid(dining_uid);
        reportEntity.setReporter_uuid(reporter_uuid);
        reportEntity.setIllegal_service(reportDTO.isIllegal_service());
        reportEntity.setPoor_hygiene(reportDTO.isPoor_hygiene());
        reportEntity.setUnkind(reportDTO.isUnkind());
        reportEntity.setEtc(reportDTO.isEtc());
        reportEntity.setReason(reportDTO.getReason());

        reportService.ReportRegistration(reportEntity);

        return "redirect:/"; // TODO: 신고 절차 이후에 이동할 페이지를 반환해야 합니다.
    }
}
