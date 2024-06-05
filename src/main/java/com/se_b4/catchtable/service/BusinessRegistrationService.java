package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import com.se_b4.catchtable.repository.BusinessRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BusinessRegistrationService {
    private final BusinessRegistrationRepository businessRegistrationRepository;

    // 사업장 파일 저장
    public void saveBusinessDetails(Long ouuid, String filename) throws IOException {
        BusinessAuthEntity entity = BusinessAuthEntity.builder()
                .ouuid(ouuid)
                .businessDetailsFile(filename)
                .build();
        businessRegistrationRepository.save(entity);
    }

    public List<BusinessAuthEntity> findAll() {
        return businessRegistrationRepository.findAll();
    }

//    // 사업장 파일 조회
//    public String getBusinessDetails(Long ouuid) {
//        Optional<BusinessAuthEntity> entityOptional = businessRegistrationRepository.findByOuuid(ouuid);
//        return entityOptional.map(BusinessAuthEntity::getBusinessDetailsFile).orElse(null);
//    }
}
