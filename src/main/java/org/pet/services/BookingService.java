package org.pet.services;

import org.pet.entities.BookingEntity;
import org.pet.statistics.BookingStatistics;

import java.util.List;

public interface BookingService {

    BookingEntity createBooking(BookingEntity booking);

    List<BookingEntity> getUserBookings(Long userId);

    List<BookingStatistics> getBookingStatistics();

}
