package com.beyond.kkwoborrow.complain.controller;

import com.beyond.kkwoborrow.complain.dto.ComplainRequestDto;
import com.beyond.kkwoborrow.complain.dto.ComplainResponseDto;
import com.beyond.kkwoborrow.complain.service.ComplainService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Complains APIs", description = "신고 관련 API 목록")
@RequestMapping("/complains")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @PostMapping
    public ResponseEntity<ComplainResponseDto> createComplain(@RequestBody ComplainRequestDto complainRequestDto) {
        ComplainResponseDto complainResponseDto = complainService.save(complainRequestDto);
        return new ResponseEntity<>(complainResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{complainId}")
    public ResponseEntity<ComplainResponseDto> getComplain(@PathVariable Long complainId) {
        ComplainResponseDto complainResponseDto = complainService.getComplain(complainId);
        return new ResponseEntity<>(complainResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{complainId}")
    public ResponseEntity<Void> deleteComplain(@PathVariable Long complainId) {
        complainService.deleteComplain(complainId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
