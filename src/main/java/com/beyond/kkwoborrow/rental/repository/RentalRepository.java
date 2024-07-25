package com.beyond.kkwoborrow.rental.repository;

import com.beyond.kkwoborrow.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
