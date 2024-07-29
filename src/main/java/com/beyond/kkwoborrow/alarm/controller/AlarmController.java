package com.beyond.kkwoborrow.alarm.controller;

import com.beyond.kkwoborrow.alarm.dto.AlarmRequestDto;
import com.beyond.kkwoborrow.alarm.dto.AlarmResponseDto;
import com.beyond.kkwoborrow.alarm.service.AlarmService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Alarms APIs", description = "알람 관련 API 목록")
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    // 알람 추가
    @PostMapping("/alarms")
    public ResponseEntity<AlarmResponseDto> createAlarm(@RequestBody AlarmRequestDto newAlarm) {
        AlarmResponseDto alarmResponseDto = alarmService.save(newAlarm);
        if (alarmResponseDto != null) {
            return new ResponseEntity<>(alarmResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 알람 정보 불러오기
    @GetMapping("/alarms/{alarm-id}")
    public ResponseEntity<AlarmResponseDto> getAlarm(@PathVariable("alarm-id") Long alarmId) {
        AlarmResponseDto alarmResponseDto = alarmService.getAlarm(alarmId);
        if (alarmResponseDto != null) {
            return new ResponseEntity<>(alarmResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 알람 정보 수정
    @PatchMapping("/alarms/{alarm-id}")
    public ResponseEntity<AlarmResponseDto> updateAlarm(@PathVariable("alarm-id") Long alarmId, @RequestBody AlarmRequestDto updateAlarm) {
        AlarmResponseDto alarmResponseDto = alarmService.updateAlarm(alarmId, updateAlarm);
        if (alarmResponseDto != null) {
            return new ResponseEntity<>(alarmResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 알람 삭제
    @DeleteMapping("/alarms/{alarm-id}")
    public void deleteAlarm(@PathVariable("alarm-id") Long alarmId) {
        alarmService.deleteAlarm(alarmId);
    }
}
