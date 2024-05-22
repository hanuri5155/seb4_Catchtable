package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
}