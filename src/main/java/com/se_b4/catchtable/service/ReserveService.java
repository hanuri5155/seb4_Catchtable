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

    public int tryReserve(ReserveData reserveData)
    {
        DiningData diningData = diningInfoService.getDiningData(reserveData.getDining_uid()).get(0);

        boolean canReserve = reserveData.getCount_person() > 0 && reserveRepository.canReserve(
                reserveData.getCount_person(),
                diningData.getCount_seat(),
                diningData.getUid(),
                reserveData.getDate(),
                reserveData.getTime_begin()
        ) > 0;

        boolean canPurchase = purchaseService.tryPurchase();

        int returnFlags = 0;
        returnFlags |= canPurchase ? 1 : 0;
        returnFlags |= canReserve ? 2 : 0;

        if(returnFlags == 3)
        {
            reserveRepository.save(reserveData);
        }

        return returnFlags;
    }
}
