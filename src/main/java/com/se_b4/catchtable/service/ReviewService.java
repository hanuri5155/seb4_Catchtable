package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.ReviewEntity;
import com.se_b4.catchtable.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService
{
    private final ReviewRepository reviewRepository;

    public boolean ReviewRegistration(ReviewEntity reviewEntity)
    {
        String desc = reviewEntity.getDescription();

        if(desc == null || desc.length() < 15)
            return false;

        reviewRepository.save(reviewEntity);
        return true;
    }
}
