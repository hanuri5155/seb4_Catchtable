package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.DiningData;
import com.se_b4.catchtable.repository.DiningInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiningInfoService
{
    private final DiningInfoRepository diningInfoRepository;

    public List<DiningData> getDiningData(int _diningUID)
    {
        return diningInfoRepository.getDiningData(_diningUID);
    }
}
