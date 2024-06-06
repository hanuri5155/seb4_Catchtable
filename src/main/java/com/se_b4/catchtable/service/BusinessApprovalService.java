package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BusinessApprovalService {
    private final BusinessRegistrationService businessRegistrationService;

    public List<BusinessAuthEntity>  BusinessApproval(){
        return businessRegistrationService.findAll();
    }
}
