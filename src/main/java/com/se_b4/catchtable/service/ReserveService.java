package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.DiningData;
import com.se_b4.catchtable.entity.ReserveData;
import com.se_b4.catchtable.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReserveService
{
    private final ReserveRepository reserveRepository;

    private final DiningInfoService diningInfoService;
    private final PurchaseService purchaseService;

    // NOTE: 사용자 uuid를 입력하면 해당 사용자의 모든 예약 내역을 반환합니다.
    public List<ReserveData> getReserveDataByReserverUUID(Long _reserverUUID)
    {
        return reserveRepository.getDataByReserverUUID(_reserverUUID);
    }

    public List<DiningData> getDiningData(int _diningUID)
    {
        return diningInfoService.getDiningData(_diningUID);
    }

    public boolean tryReserve(ReserveData reserveData)
    {
        DiningData diningData = diningInfoService.getDiningData(reserveData.getDining_uid()).get(0);

        boolean canReserve = reserveRepository.canReserve(
                reserveData.getCount_person(),
                diningData.getCount_seat(),
                reserveData.getDate(),
                reserveData.getTime_begin()
        ) > 0;

        boolean canPurchase = purchaseService.tryPurchase();

        if(canPurchase && canReserve)
        {
            reserveRepository.save(reserveData);
            return true;
        }

        return false;
    }
}
