package com.beyond.kkwoborrow.alarm.dto;

import com.beyond.kkwoborrow.alarm.entity.Alarm;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class AlarmsResponseDto {
    private int code;
    private String message;
    private List<AlarmResponseDto> result;
    private int page;
    private int numOfRows;
    private int totalCount;

    public AlarmsResponseDto(HttpStatus status, List<AlarmResponseDto> alarms, int page, int totalCount) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
        this.result = alarms;
        this.page = page;
        this.numOfRows = alarms.size();
        this.totalCount = totalCount;
    }
}
