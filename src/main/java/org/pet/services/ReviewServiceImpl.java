package org.pet.services;

import lombok.AllArgsConstructor;
import org.pet.entities.ReviewEntity;
import org.pet.repositories.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    @Override
    public ReviewEntity createReview(ReviewEntity review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewEntity> getReviewsByHotel(Long hotelId) {
        List<ReviewEntity> reviews = reviewRepository.findByHotelId(hotelId);
        if (reviews.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Нет отзывов для этого отеля.");
        }
        return reviews;
    }
}
