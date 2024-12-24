package org.pet.repositories;

import org.pet.entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Override
    Optional<ReviewEntity> findById(Long id);

    List<ReviewEntity> findByHotelId(Long hotelId);

    int countByHotelId(Long hotelId);
}
