import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pet.entities.ReviewEntity;
import org.pet.repositories.ReviewRepository;
import org.pet.services.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ReviewServiceTest {
    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReviewsByHotelId_NoReviewsFound() {
        when(reviewRepository.findByHotelId(1L)).thenReturn(Collections.emptyList());

        ResponseStatusException thrown = assertThrows(ResponseStatusException.class, () ->
                reviewService.getReviewsByHotel(1L));

        assertThat(thrown.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(thrown.getReason()).isEqualTo("Нет отзывов для этого отеля.");
    }

    @Test
    public void testCreateReview() {
        ReviewEntity review = new ReviewEntity();
        review.setRating(5);
        review.setComment("Отлично!");

        when(reviewRepository.save(review)).thenReturn(review);

        ReviewEntity createdReview = reviewService.createReview(review);

        assertThat(createdReview).isNotNull();
        assertThat(createdReview.getRating()).isEqualTo(5);
    }
}
