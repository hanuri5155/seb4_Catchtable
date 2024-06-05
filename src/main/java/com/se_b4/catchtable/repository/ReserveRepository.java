package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.ReserveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ReserveRepository extends JpaRepository<ReserveData, Integer>
{
    @Query(value = "select * from reserve_entity where uid = :reserve_uid", nativeQuery = true)
    List<ReserveData> getDataByReserveUID(@Param("reserve_uid") Long reserve_uid);

    @Query(value = "select * from reserve_entity where reserver_uuid = :reserver_uuid", nativeQuery = true)
    List<ReserveData> getDataByReserverUUID(@Param("reserver_uuid") Long reserver_uuid);

    @Query(value =
            "select coalesce((sum(count_person) + :reserve_count_person <= :seat_count), 1) " +
            "from reserve_entity " +
            "where date = :reserve_date " +
            "and dining_uid = :dining_uid " +
            "and timediff(time_begin, :reserve_time_begin) <= '01:00:00' " +
            "and timediff(:reserve_time_begin, time_begin) <= '01:00:00'"
            , nativeQuery = true)
    Integer canReserve(
            @Param("reserve_count_person") int reserveCountPerson,
            @Param("seat_count") int seatCount,
            @Param("dining_uid") int diningUid,
            @Param("reserve_date") Date reserveDate,
            @Param("reserve_time_begin") LocalTime reserveTimeBegin
    );
}
