package org.pet.entities;

import lombok.Getter;
import lombok.Setter;
import org.pet.enums.BookingStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    @Enumerated
    @Column(columnDefinition = "enum('CONFIRMED', 'CANCELLED', 'COMPLETED')")
    private BookingStatus status;

}
