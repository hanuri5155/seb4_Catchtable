package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BusinessRegistrationRepository
        extends JpaRepository<BusinessAuthEntity, Long> {
}

