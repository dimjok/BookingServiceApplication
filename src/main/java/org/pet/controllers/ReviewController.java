package org.pet.controllers;

import org.pet.entities.ReviewEntity;
import org.pet.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ReviewEntity createReview(@RequestBody ReviewEntity review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<ReviewEntity> getReviewsByHotel(@PathVariable Long hotelId) {
        return reviewService.getReviewsByHotel(hotelId);
    }
}
