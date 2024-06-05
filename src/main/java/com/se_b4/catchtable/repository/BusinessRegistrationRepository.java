package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface BusinessRegistrationRepository extends JpaRepository<BusinessAuthEntity, Long> {
    Optional<BusinessAuthEntity> findByOuuid(Long ouuid);
}
