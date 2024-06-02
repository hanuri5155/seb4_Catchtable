package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.ReserveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ReserveRepository extends JpaRepository<ReserveData, Integer>
{
    @Query(value = "select * from reserve_entity where uid = :reserve_uid", nativeQuery = true)
    List<ReserveData> getDataByReserveUID(@Param("reserve_uid") Long reserve_uid);

    @Query(value = "select * from reserve_entity where reserver_uuid = :reserver_uuid", nativeQuery = true)
    List<ReserveData> getDataByReserverUUID(@Param("reserver_uuid") Long reserver_uuid);
}
