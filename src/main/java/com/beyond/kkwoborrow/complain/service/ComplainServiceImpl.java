package com.beyond.kkwoborrow.complain.service;

import com.beyond.kkwoborrow.complain.dto.ComplainRequestDto;
import com.beyond.kkwoborrow.complain.dto.ComplainResponseDto;
import com.beyond.kkwoborrow.complain.entity.Complain;
import com.beyond.kkwoborrow.complain.repository.ComplainRepository;
import com.beyond.kkwoborrow.users.entity.UserType;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ComplainResponseDto save(ComplainRequestDto complainRequestDto) {
        Users user = userRepository.findByUserIdAndUserTypeNot(complainRequestDto.getUserId(), UserType.LEAVE)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Complain complain = new Complain();
        complain.setUserID(user);
        Complain savedComplain = complainRepository.save(complain);
        return new ComplainResponseDto(savedComplain);
    }

    @Override
    public ComplainResponseDto getComplain(Long complainId) {
        Complain complain = complainRepository.findById(complainId)
                .orElseThrow(() -> new IllegalArgumentException("Complain not found"));
        return new ComplainResponseDto(complain);
    }

    @Override
    public List<ComplainResponseDto> getAllComplains(int page, int numOfRows, int totalCount) {
        Pageable pageable = PageRequest.of(page - 1, numOfRows, Sort.by("complainID").ascending());
        List<Complain> complains = complainRepository.findAll(pageable).getContent();
        return complains.stream()
                .map(ComplainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public int getTotalCount() {
        return (int) complainRepository.count();
    }

    @Override
    public void deleteComplain(Long complainId) {
        complainRepository.deleteById(complainId);
    }
}
