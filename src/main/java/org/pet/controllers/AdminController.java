package org.pet.controllers;

import org.pet.entities.HotelEntity;
import org.pet.entities.UserEntity;
import org.pet.services.HotelService;
import org.pet.services.HotelServiceImpl;
import org.pet.services.UserService;
import org.pet.services.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService userService;
    private final HotelService hotelService;

    public AdminController(UserServiceImpl userService, HotelServiceImpl hotelService) {
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/hotels")
    @PreAuthorize("hasRole('ADMIN')")
    public List<HotelEntity> getAllHotels() {
        return hotelService.getAllHotels();
    }
}
