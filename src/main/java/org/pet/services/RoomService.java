package org.pet.services;

import org.pet.entities.RoomEntity;

import java.util.List;

public interface RoomService {
    List<RoomEntity> getRoomsByHotel(Long hotelId);

    List<RoomEntity> getAvailableRooms(Long hotelId);

    List<RoomEntity> getAvailableRoomsSortedByPriceAsc(Long hotelId);

    List<RoomEntity> getAvailableRoomsSortedByPriceDesc(Long hotelId);

    List<RoomEntity> getAvailableSingleRoomsSortedByPriceAsc(Long hotelId);

    List<RoomEntity> getAvailableDoubleRoomsSortedByPriceAsc(Long hotelId);
}
