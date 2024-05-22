package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.AdminEntity;
import com.se_b4.catchtable.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    // 사업장 검토 및 승인 로직
    public void reviewAndApproveBusiness(Long adminId, String businessReviewDetails) {
        AdminEntity admin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setBusinessReviewDetails(businessReviewDetails);
        adminRepository.save(admin);
    }
}
