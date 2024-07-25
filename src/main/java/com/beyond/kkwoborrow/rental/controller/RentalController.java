package com.beyond.kkwoborrow.rental.controller;

import com.beyond.kkwoborrow.rental.dto.RentalResponseDto;
import com.beyond.kkwoborrow.rental.service.RentalService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Tag(name = "Rental APIs", description = "렌탈 관련 API 목록")
public class RentalController {
    RentalService rentalService;

    // 대여 신청 가능 물품 불러오기
    @PostMapping("/rental/{isRental}")
    @Operation(summary = "대여 신청", description = "대여 가능한 물품의 목록을 조회한다.")
    public ResponseEntity<RentalResponseDto> Rent(@PathVariable("isRental") boolean isReturn) {
        RentalResponseDto rentalResponseDto = (RentalResponseDto) rentalService.findAll();

        if (isReturn) { // 대여가 가능하면 대여 가능한 물품들 리스트 나오도록 하는거 (아닌가..?)
            return new ResponseEntity<>(rentalResponseDto, HttpStatus.OK);
        } else { // 다른 사람이 이미 대여를 하고 있으면 안보여줌
            return new ResponseEntity<>(rentalResponseDto, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/rental/{isReturn}")
    @Operation(summary = "반납 신청", description = "반납해야할 물품 목록을 조회한다.")
    public ResponseEntity<RentalResponseDto> Return(@PathVariable("isReturn") LocalDateTime ReturnDate) {
        RentalResponseDto ReturnSearch = rentalService.Return(ReturnDate);

        if (LocalDateTime.now().isEqual(ReturnDate)) { // 만약에 지금 날짜랑 반납 날짜랑 같으면 반납해야하는 물품들을 조회한다.
            return new ResponseEntity<>(ReturnSearch, HttpStatus.OK);
        } else { // 만약에 날짜가 다르면 조회 안함.
            return new ResponseEntity<>(ReturnSearch, HttpStatus.NOT_FOUND);
        }
    }
}
