package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.DiningData;
import com.se_b4.catchtable.entity.ReserveData;
import com.se_b4.catchtable.repository.DiningInfoRepository;
import com.se_b4.catchtable.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReserveService
{
    private final ReserveRepository reserveRepository;

    private final DiningInfoService diningInfoService;

    public List<ReserveData> GetReserveDataByReserverUUID(Long _reserverUUID)
    {
        // return null;
        return reserveRepository.getDataByReserverUUID(_reserverUUID);
    }

    public List<DiningData> getDiningData(int _diningUID)
    {
        return diningInfoService.getDiningData(_diningUID);
    }

    public void tryReserve(int _reserverUUID, int _diningUID, LocalDateTime _date, int _countPerson)
    {
        ReserveData reserveData = new ReserveData();

        reserveData.setReserver_uuid(_reserverUUID);
        reserveData.setDining_uid(_diningUID);
        reserveData.setCount_person(_countPerson);
        reserveData.setDate(Timestamp.valueOf(_date));
        reserveData.setTime_begin(_date.toLocalTime());

        reserveRepository.save(reserveData);
    }
}
