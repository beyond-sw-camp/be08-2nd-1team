package com.beyond.kkwoborrow.rental.service;

import com.beyond.kkwoborrow.posts.entity.Posts;
import com.beyond.kkwoborrow.posts.repository.PostRepository;
import com.beyond.kkwoborrow.rental.dto.RentalRequestDto;
import com.beyond.kkwoborrow.rental.dto.RentalResponseDto;
import com.beyond.kkwoborrow.rental.entity.Rental;
import com.beyond.kkwoborrow.rental.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
    private RentalRepository rentalRepository;

    private PostRepository postRepository;

    @Override
    public RentalResponseDto searchProduct(RentalRequestDto rentalRequestDto) {
        Posts post = postRepository.findById(rentalRequestDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("Invalid PostID"));

        Optional<Rental> rental = rentalRepository.findById(rentalRequestDto.getPostId());

        return rental.map(RentalResponseDto::new).orElse(null);
    }

    @Override
    public RentalResponseDto Return(Long transactionID) {
        Rental rental = rentalRepository.findById(transactionID).orElseThrow(() -> new IllegalArgumentException("transactionID Not found"));

        return new RentalResponseDto(rental);
    }
}
