package com.beyond.kkwoborrow.complain.service;

import com.beyond.kkwoborrow.complain.dto.ComplainRequestDto;
import com.beyond.kkwoborrow.complain.dto.ComplainResponseDto;
import com.beyond.kkwoborrow.complain.dto.ComplainsResponseDto;
import com.beyond.kkwoborrow.complain.entity.Complain;
import com.beyond.kkwoborrow.complain.repository.ComplainRepository;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Users user = userRepository.findById(complainRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Complain complain = new Complain();
        complain.setUserID(user);
        // 추가 필드 설정이 필요한 경우 여기서 설정
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
        int offset = (page - 1) * numOfRows;
        List<Complain> complains = complainRepository.findAll().stream()
                .skip(offset)
                .limit(numOfRows)
                .collect(Collectors.toList());
        return complains.stream().map(ComplainResponseDto::new).collect(Collectors.toList());
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
