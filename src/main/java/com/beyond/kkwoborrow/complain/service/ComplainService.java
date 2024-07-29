package com.beyond.kkwoborrow.complain.service;

import com.beyond.kkwoborrow.complain.dto.ComplainRequestDto;
import com.beyond.kkwoborrow.complain.dto.ComplainResponseDto;

public interface ComplainService {
    ComplainResponseDto save(ComplainRequestDto complainRequestDto);
    ComplainResponseDto getComplain(Long complainId);
    void deleteComplain(Long complainId);
}
