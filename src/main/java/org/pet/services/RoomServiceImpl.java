package org.pet.services;

import lombok.AllArgsConstructor;
import org.pet.entities.RoomEntity;
import org.pet.enums.RoomType;
import org.pet.repositories.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    @Override
    public List<RoomEntity> getRoomsByHotel(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    @Override
    public List<RoomEntity> getAvailableRooms(Long hotelId) {
        return roomRepository.findByHotelIdAndAvailableTrue(hotelId);
    }

    @Override
    public List<RoomEntity> getAvailableRoomsSortedByPriceAsc(Long hotelId) {
        return roomRepository.findByHotelIdAndAvailableTrueOrderByPriceAsc(hotelId);
    }

    @Override
    public List<RoomEntity> getAvailableRoomsSortedByPriceDesc(Long hotelId) {
        return roomRepository.findByHotelIdAndAvailableTrueOrderByPriceDesc(hotelId);
    }

    @Override
    public List<RoomEntity> getAvailableSingleRoomsSortedByPriceAsc(Long hotelId) {
        List<RoomEntity> availableRooms = roomRepository.findByHotelIdAndAvailableTrueAndRoomTypeOrderByPriceAsc(hotelId, RoomType.SINGLE);
        if (availableRooms.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Нет доступных одноместных комнат в этом отеле.");
        }
        return availableRooms;
    }

    @Override
    public List<RoomEntity> getAvailableDoubleRoomsSortedByPriceAsc(Long hotelId) {
        List<RoomEntity> availableRooms = roomRepository.findByHotelIdAndAvailableTrueAndRoomTypeOrderByPriceAsc(hotelId, RoomType.DOUBLE);
        if (availableRooms.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Нет доступных двухместных комнат в этом отеле.");
        }
        return availableRooms;
    }
}
