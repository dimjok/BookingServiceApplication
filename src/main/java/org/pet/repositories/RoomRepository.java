package org.pet.repositories;

import org.pet.entities.RoomEntity;
import org.pet.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    @Override
    Optional<RoomEntity> findById(Long id);

    List<RoomEntity> findByHotelId(Long hotelId);

    List<RoomEntity> findByHotelIdAndAvailableTrue(Long hotelId);

    List<RoomEntity> findByHotelIdAndAvailableTrueOrderByPriceAsc(Long hotelId);

    List<RoomEntity> findByHotelIdAndAvailableTrueOrderByPriceDesc(Long hotelId);

    List<RoomEntity> findByHotelIdAndAvailableTrueAndRoomTypeOrderByPriceAsc(Long hotelId, RoomType roomType);

    List<RoomEntity> findByHotelIdAndAvailableTrueAndRoomTypeOrderByPriceDesc(Long hotelId, RoomType roomType);
}
