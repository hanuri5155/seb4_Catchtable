package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}