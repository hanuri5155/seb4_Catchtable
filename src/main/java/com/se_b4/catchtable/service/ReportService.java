package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.ReportEntity;
import com.se_b4.catchtable.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService
{
    private final ReportRepository reportRepository;

    public void ReportRegistration(ReportEntity _report)
    {
        reportRepository.save(_report);
    }
}
