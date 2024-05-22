package com.se_b4.catchtable.service;

import com.se_b4.catchtable.entity.MemberEntity;
import com.se_b4.catchtable.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 리뷰 등록 로직
    public void registerReview(Long memberId, String reviewContent) {
        MemberEntity member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        member.setReviewContent(reviewContent);
        memberRepository.save(member);
    }

    // 리뷰 수정 로직
    public void updateReview(Long memberId, String reviewContent) {
        MemberEntity member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        member.setReviewContent(reviewContent);
        memberRepository.save(member);
    }

    // 리뷰 삭제 로직
    public void deleteReview(Long memberId) {
        MemberEntity member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        member.setReviewContent(null);
        memberRepository.save(member);
    }

    // 식당 신고 등록 로직
    public void reportRestaurant(Long memberId, String reportReason) {
        MemberEntity member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        member.setReportReason(reportReason);
        memberRepository.save(member);
    }
}
