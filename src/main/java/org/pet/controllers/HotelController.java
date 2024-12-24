package org.pet.controllers;

import org.pet.entities.HotelEntity;
import org.pet.services.HotelService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/sorted/name/asc")
    public List<HotelEntity> getAllHotelsSortedByNameAsc() {
        return hotelService.getAllHotelsSortedByNameAsc();
    }

    @GetMapping("/sorted/rating/asc")
    public List<HotelEntity> getAllHotelsSortedByRatingAsc() {
        return hotelService.getAllHotelsSortedByRatingAsc();
    }

    @GetMapping("/sorted/name/desc")
    public List<HotelEntity> getAllHotelsSortedByNameDesc() {
        return hotelService.getAllHotelsSortedByNameDesc();
    }

    @GetMapping("/sorted/rating/desc")
    public List<HotelEntity> getAllHotelsSortedByRatingDesc() {
        return hotelService.getAllHotelsSortedByRatingDesc();
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<HotelEntity> getAllHotels() {
        return hotelService.getAllHotels();
    }
}
