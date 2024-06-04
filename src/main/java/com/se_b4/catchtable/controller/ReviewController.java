package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.dto.ReviewDTO;
import com.se_b4.catchtable.entity.ReviewEntity;
import com.se_b4.catchtable.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reviews")
@Controller
@RequiredArgsConstructor
public class ReviewController
{
    private final ReviewService reviewService;

    @GetMapping("")
    public String OnReviewPageRequested(Model _model, @RequestParam("dining_uid") int dining_uid)
    {
        _model.addAttribute("dining_uid", dining_uid);
        _model.addAttribute("reviewDTO", new ReviewDTO());

        return "/users/review";
    }

    @PostMapping("")
    public String OnReviewSubmitted(@ModelAttribute("reviewDTO") ReviewDTO reviewDTO, HttpSession session, @RequestParam("dining_uid") int dining_uid)
    {
        int reviewer_uuid = 1; // TODO: 세션에서 사용자 uuid를 가져올 수 있을 때 이 코드를 수정합니다.
        // int reviewer_uuid = (int)session.getAttribute("loggedUuid");

        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setDining_uid(dining_uid);
        reviewEntity.setReviewer_uuid(reviewer_uuid);
        reviewEntity.setDescription(reviewDTO.getDescription());
        reviewEntity.setRating(reviewDTO.getRating());

        if(reviewService.ReviewRegistration(reviewEntity))
        {
            // TODO: 이 곳에 리뷰 등록에 성공했을 때 수행할 동작을 작성합니다.
            System.out.println("Review Registration Succeed.");

            return "redirect:/"; // TODO: 리뷰 등록에 성공했을 때 돌아갈 페이지를 반환합니다.
        }
        else
        {
            // TODO: 이 곳에 리뷰 등록에 실패했을 때 수행할 동작을 작성합니다.
            System.out.println("Review Registration Failed.");

            return "redirect:/"; // TODO: 리뷰 등록에 실패했을 때 돌아갈 페이지를 반환합니다.
        }
    }
}
