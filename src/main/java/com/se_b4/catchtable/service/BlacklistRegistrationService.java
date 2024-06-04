package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.BlacklistEntity;
import com.se_b4.catchtable.repository.BlacklistRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlacklistRegistrationService {
    private final BlacklistRegistrationRepository blacklistRegistrationRepository;

    // 사업장 정보(PDF) 저장
    public void BlacklistRegistration(String username, String phoneNumber) {
        BlacklistEntity blacklist = BlacklistEntity.builder()
                .username(username)
                .phone_number(phoneNumber)
                .build();
        blacklistRegistrationRepository.save(blacklist);
    }
}
