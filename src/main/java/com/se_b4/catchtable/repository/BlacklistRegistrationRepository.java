package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.BlacklistEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BlacklistRegistrationRepository extends JpaRepository<BlacklistEntity, Long> {

}
