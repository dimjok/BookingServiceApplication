package org.pet.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookingStatistics {
    private Long hotelId;
    private String hotelName;
    private int totalBookings;
    private int totalReviews;
}
