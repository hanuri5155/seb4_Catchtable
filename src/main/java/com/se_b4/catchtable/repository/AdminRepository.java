package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
}