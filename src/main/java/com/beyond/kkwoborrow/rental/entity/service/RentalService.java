package com.beyond.kkwoborrow.rental.entity.service;

import com.beyond.kkwoborrow.rental.entity.Rental;
import com.beyond.kkwoborrow.rental.entity.dto.RentalResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface RentalService {
    List<Rental> findAll();

    RentalResponseDto Return(LocalDateTime returnDate);
}
