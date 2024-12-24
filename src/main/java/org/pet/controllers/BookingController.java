package org.pet.controllers;

import org.pet.entities.BookingEntity;
import org.pet.services.BookingService;
import org.pet.statistics.BookingStatistics;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingEntity createBooking(@RequestBody BookingEntity booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/user/{userId}")
    public List<BookingEntity> getUserBookings(@PathVariable Long userId) {
        return bookingService.getUserBookings(userId);
    }

    @GetMapping("/statistics")
    public List<BookingStatistics> getBookingStatistics() {
        return bookingService.getBookingStatistics();
    }
}
