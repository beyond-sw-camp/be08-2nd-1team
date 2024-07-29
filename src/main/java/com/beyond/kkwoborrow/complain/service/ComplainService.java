package com.beyond.kkwoborrow.complain.service;

import com.beyond.kkwoborrow.complain.dto.ComplainRequestDto;
import com.beyond.kkwoborrow.complain.dto.ComplainResponseDto;
import com.beyond.kkwoborrow.complain.dto.ComplainsResponseDto;

import java.util.List;

public interface ComplainService {
    ComplainResponseDto save(ComplainRequestDto complainRequestDto);
    ComplainResponseDto getComplain(Long complainId);
    List<ComplainResponseDto> getAllComplains(int page, int numOfRows, int totalCount);
    int getTotalCount();
    void deleteComplain(Long complainId);
}
