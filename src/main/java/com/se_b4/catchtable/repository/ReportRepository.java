package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.ReportEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ReportRepository extends JpaRepository<ReportEntity, Long>
{

}
