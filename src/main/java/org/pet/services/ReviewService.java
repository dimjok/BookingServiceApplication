package org.pet.services;

import org.pet.entities.ReviewEntity;

import java.util.List;

public interface ReviewService {
    ReviewEntity createReview(ReviewEntity review);

    List<ReviewEntity> getReviewsByHotel(Long hotelId);

}
