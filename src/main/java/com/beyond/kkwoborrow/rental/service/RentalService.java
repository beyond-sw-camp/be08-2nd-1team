package com.beyond.kkwoborrow.rental.service;
import com.beyond.kkwoborrow.rental.dto.RentalRequestDto;
import com.beyond.kkwoborrow.rental.dto.RentalResponseDto;

public interface RentalService {
    RentalResponseDto Rent(Long postId);

    RentalResponseDto Return(Long transactionID);
}
