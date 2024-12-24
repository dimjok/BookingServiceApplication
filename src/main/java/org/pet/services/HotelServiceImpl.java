package org.pet.services;

import lombok.AllArgsConstructor;
import org.pet.entities.HotelEntity;
import org.pet.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;

    @Override
    public HotelEntity createHotel(HotelEntity hotel) {
        return hotelRepository.save(hotel);
    }
    @Override
    public List<HotelEntity> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<HotelEntity> getAllHotelsSortedByNameAsc() {
        return hotelRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<HotelEntity> getAllHotelsSortedByRatingDesc() {
        return hotelRepository.findAllByOrderByRatingDesc();
    }

    @Override
    public List<HotelEntity> getAllHotelsSortedByNameDesc() {
        return hotelRepository.findAllByOrderByNameDesc();
    }

    @Override
    public List<HotelEntity> getAllHotelsSortedByRatingAsc() {
        return hotelRepository.findAllByOrderByRatingAsc();
    }
}
