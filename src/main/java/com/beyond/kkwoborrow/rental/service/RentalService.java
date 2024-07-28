package com.beyond.kkwoborrow.rental.service;
import com.beyond.kkwoborrow.rental.dto.RentalRequestDto;
import com.beyond.kkwoborrow.rental.dto.RentalResponseDto;

public interface RentalService {
    RentalResponseDto searchProduct(RentalRequestDto rentalRequestDto);

    RentalResponseDto Return(Long transactionID);
}
