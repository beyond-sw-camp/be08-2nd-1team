package com.beyond.kkwoborrow.alarm.controller;

import com.beyond.kkwoborrow.alarm.dto.AlarmRequestDto;
import com.beyond.kkwoborrow.alarm.dto.AlarmResponseDto;
import com.beyond.kkwoborrow.alarm.dto.AlarmsResponseDto;
import com.beyond.kkwoborrow.alarm.service.AlarmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Tag(name = "Alarms APIs", description = "알람 관련 API 목록")
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    // 알람 정보 불러오기
    @GetMapping("/alarms/{alarm-id}")
    @Operation(summary = "특정 알람 조회", description = "특정 알람의 정보를 불러온다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameter(name = "alarm-id", description = "알람 ID", example = "1")
    public ResponseEntity<AlarmResponseDto> getAlarm(@PathVariable("alarm-id") Long alarmId) {
        AlarmResponseDto alarmResponseDto = alarmService.getAlarm(alarmId);
        if (alarmResponseDto != null) {
            return new ResponseEntity<>(alarmResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 알람 목록 조회
    @GetMapping("/alarms")
    @Operation(summary = "알람 목록 조회", description = "전체 알람의 목록을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호", example = "1"),
            @Parameter(name = "numOfRows", description = "한 페이지 결과 수", example = "10")
    })
    public ResponseEntity<AlarmsResponseDto> getAlarms(@RequestParam int page, @RequestParam int numOfRows) {
        int totalCount = alarmService.getTotalCount();
        if (page <= 0 || numOfRows <= 0 || (page - 1) * numOfRows >= totalCount) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<AlarmResponseDto> alarms = alarmService.getAlarms(page, numOfRows, totalCount);
        AlarmsResponseDto response = new AlarmsResponseDto(HttpStatus.OK, alarms, page, totalCount);
        return ResponseEntity.ok(response);
    }


    // 알람 추가
    @PostMapping("/alarms")
    @Operation(summary = "알람 추가", description = "새로운 알람을 추가한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    public ResponseEntity<AlarmResponseDto> createAlarm(@RequestBody AlarmRequestDto newAlarm) {
        AlarmResponseDto alarmResponseDto = alarmService.save(newAlarm);
        if (alarmResponseDto != null) {
            return new ResponseEntity<>(alarmResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 알람 정보 수정
    @PatchMapping("/alarms/{alarm-id}")
    @Operation(summary = "알람 정보 수정", description = "특정 알람의 정보를 수정한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameter(name = "alarm-id", description = "알람 ID", example = "1")
    public ResponseEntity<AlarmResponseDto> updateAlarm(@PathVariable("alarm-id") Long alarmId, @RequestBody AlarmRequestDto updateAlarm) {
        AlarmResponseDto alarmResponseDto = alarmService.updateAlarm(alarmId, updateAlarm);
        if (alarmResponseDto != null) {
            return new ResponseEntity<>(alarmResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 알람 삭제
    @DeleteMapping("/alarms/{alarm-id}")
    @Operation(summary = "알람 삭제", description = "특정 알람을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameter(name = "alarm-id", description = "알람 ID", example = "1")
    public ResponseEntity<Void> deleteAlarm(@PathVariable("alarm-id") Long alarmId) {
        try {
            alarmService.deleteAlarm(alarmId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
