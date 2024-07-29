package com.beyond.kkwoborrow.alarm.service;

import com.beyond.kkwoborrow.alarm.dto.AlarmRequestDto;
import com.beyond.kkwoborrow.alarm.dto.AlarmResponseDto;

import java.util.List;

public interface AlarmService {
    AlarmResponseDto save(AlarmRequestDto newAlarm);
    AlarmResponseDto getAlarm(Long alarmId);
    void deleteAlarm(Long alarmId);
    AlarmResponseDto updateAlarm(Long alarmId, AlarmRequestDto updateAlarm);
    List<AlarmResponseDto> getAlarms(int page, int numOfRows, int totalCount);
    int getTotalCount();
}
