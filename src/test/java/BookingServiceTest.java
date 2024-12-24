import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pet.repositories.BookingRepository;
import org.pet.repositories.HotelRepository;
import org.pet.repositories.ReviewRepository;
import org.pet.repositories.RoomRepository;
import org.pet.services.BookingServiceImpl;
import org.pet.statistics.BookingStatistics;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BookingServiceTest {
    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private HotelRepository hotelRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBookingStatistics() {

        when(hotelRepository.findAll()).thenReturn(Collections.emptyList());

        List<BookingStatistics> statistics = bookingService.getBookingStatistics();

        assertThat(statistics).isEmpty();
    }
}
