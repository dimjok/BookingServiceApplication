package org.pet.entities;

import lombok.Getter;
import lombok.Setter;
import org.pet.enums.RoomType;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('SINGLE', 'DOUBLE')")
    private RoomType roomType;

    private double price;

    private boolean available;
}
