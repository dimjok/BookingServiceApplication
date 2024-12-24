package org.pet.services;

import org.pet.entities.HotelEntity;

import java.util.List;

public interface HotelService {

    HotelEntity createHotel(HotelEntity hotel);
    List<HotelEntity> getAllHotels();

    List<HotelEntity> getAllHotelsSortedByNameAsc();

    List<HotelEntity> getAllHotelsSortedByRatingDesc();

    List<HotelEntity> getAllHotelsSortedByNameDesc();

    List<HotelEntity> getAllHotelsSortedByRatingAsc();
}
