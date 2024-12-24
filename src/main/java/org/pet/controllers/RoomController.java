package org.pet.controllers;

import org.pet.entities.RoomEntity;
import org.pet.services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/hotel/{hotelId}")
    public List<RoomEntity> getRoomsByHotel(@PathVariable Long hotelId) {
        return roomService.getRoomsByHotel(hotelId);
    }

    @GetMapping("/available/{hotelId}")
    public List<RoomEntity> getAvailableRooms(@PathVariable Long hotelId) {
        return roomService.getAvailableRooms(hotelId);
    }

    @GetMapping("/available/sorted/priceAsc/{hotelId}")
    public List<RoomEntity> getAvailableRoomsSortedByPriceAsc(@PathVariable Long hotelId) {
        return roomService.getAvailableRoomsSortedByPriceAsc(hotelId);
    }

    @GetMapping("/available/sorted/priceDesc/{hotelId}")
    public List<RoomEntity> getAvailableRoomsSortedByPriceDesc(@PathVariable Long hotelId) {
        return roomService.getAvailableRoomsSortedByPriceDesc(hotelId);
    }
    @GetMapping("/available/single/sorted/priceAsc/{hotelId}")
    public List<RoomEntity> getAvailableSingleRoomsSortedByPriceAsc(@PathVariable Long hotelId) {
        return roomService.getAvailableSingleRoomsSortedByPriceAsc(hotelId);
    }

    @GetMapping("/available/double/sorted/priceAsc/{hotelId}")
    public List<RoomEntity> getAvailableDoubleRoomsSortedByPriceAsc(@PathVariable Long hotelId) {
        return roomService.getAvailableDoubleRoomsSortedByPriceAsc(hotelId);
    }
}
