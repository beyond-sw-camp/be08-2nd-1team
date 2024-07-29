package com.beyond.kkwoborrow.rental.service;

import com.beyond.kkwoborrow.post.entity.Posts;
import com.beyond.kkwoborrow.post.repository.PostRepository;
import com.beyond.kkwoborrow.rental.dto.RentalRequestDto;
import com.beyond.kkwoborrow.rental.dto.RentalResponseDto;
import com.beyond.kkwoborrow.rental.entity.Rental;
import com.beyond.kkwoborrow.rental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public RentalResponseDto Rent(RentalRequestDto rent) {
        Posts post = postRepository.findById(rent.getPostId()).orElseThrow(() -> new IllegalArgumentException("Invalid PostID"));

        Optional<Rental> rental = rentalRepository.findById(rent.getPostId());

        return rental.map(RentalResponseDto::new).orElse(null);
    }

    @Override
    public RentalResponseDto Return(Long transactionID) {
        // rentalRepository 에서 transactionID를 찾아 그리고 만약에 없으면 에러 띄우기
        Rental rental = rentalRepository.findById(transactionID).orElseThrow(() -> new IllegalArgumentException("transactionID Not found"));

        return new RentalResponseDto(rental);
    }
}
