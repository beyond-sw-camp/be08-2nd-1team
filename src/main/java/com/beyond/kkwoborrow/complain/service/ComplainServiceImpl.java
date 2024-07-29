package com.beyond.kkwoborrow.complain.service;

import com.beyond.kkwoborrow.complain.dto.ComplainRequestDto;
import com.beyond.kkwoborrow.complain.dto.ComplainResponseDto;
import com.beyond.kkwoborrow.complain.entity.Complain;
import com.beyond.kkwoborrow.complain.repository.ComplainRepository;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ComplainResponseDto save(ComplainRequestDto complainRequestDto) {
        Users user = userRepository.findById(complainRequestDto.getUserId())
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
    public void deleteComplain(Long complainId) {
        complainRepository.deleteById(complainId);
    }
}
