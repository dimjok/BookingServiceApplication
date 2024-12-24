package org.pet.services;

import lombok.AllArgsConstructor;
import org.pet.entities.BookingEntity;
import org.pet.entities.HotelEntity;
import org.pet.repositories.BookingRepository;
import org.pet.repositories.HotelRepository;
import org.pet.repositories.ReviewRepository;
import org.pet.statistics.BookingStatistics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    private final ReviewRepository reviewRepository;

    private final HotelRepository hotelRepository;

    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingEntity> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    public List<BookingStatistics> getBookingStatistics() {
        List<BookingStatistics> statisticsList = new ArrayList<>();

        List<HotelEntity> hotels = hotelRepository.findAll();

        for (HotelEntity hotel : hotels) {
            int totalBookings = bookingRepository.countByHotelId(hotel.getId());
            int totalReviews = reviewRepository.countByHotelId(hotel.getId());

            BookingStatistics stats = new BookingStatistics(hotel.getId(), hotel.getName(), totalBookings, totalReviews);
            statisticsList.add(stats);
        }

        return statisticsList;
    }
}
