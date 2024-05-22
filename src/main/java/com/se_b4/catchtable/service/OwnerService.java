package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.OwnerEntity;
import com.se_b4.catchtable.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    // 사업장 등록 로직
    public void registerBusiness(Long ownerId, String businessDetails) {
        OwnerEntity owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setBusinessDetails(businessDetails);
        ownerRepository.save(owner);
    }

    // 식당 관리 로직
    public void manageRestaurant(Long ownerId, String restaurantManagementInfo) {
        OwnerEntity owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setRestaurantManagementInfo(restaurantManagementInfo);
        ownerRepository.save(owner);
    }
}
