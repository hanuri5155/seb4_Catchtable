package com.se_b4.catchtable.repository;

import com.se_b4.catchtable.entity.DiningData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface DiningInfoRepository extends JpaRepository<DiningData, Integer>
{
    @Query(value = "select * from dining_entity where uid = :dining_uid", nativeQuery = true)
    List<DiningData> getDiningData(@Param("dining_uid") int dining_uid);

    // TODO: 검색 기능을 추가할 때 쿼리 방식을 고민해야 합니다.
    // List<DiningData> getDiningData(String _diningNameSubstring, String[] _keywords);
}
