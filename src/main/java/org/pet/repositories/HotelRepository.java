package org.pet.repositories;

import org.pet.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

    @Override
    Optional<HotelEntity> findById(Long id);

    @Override
    List<HotelEntity> findAll();

    List<HotelEntity> findAllByOrderByNameAsc();

    List<HotelEntity> findAllByOrderByRatingDesc();

    List<HotelEntity> findAllByOrderByNameDesc();

    List<HotelEntity> findAllByOrderByRatingAsc();
}
