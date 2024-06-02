package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.ReserveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IReverveRepository extends JpaRepository<ReserveData, Long>
{

}
