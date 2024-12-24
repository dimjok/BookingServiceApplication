package org.pet.repositories;

import org.pet.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    @Override
    Optional<BookingEntity> findById(Long id);

    List<BookingEntity> findByUserId(Long userId);

    int countByHotelId(Long hotelId);
}
