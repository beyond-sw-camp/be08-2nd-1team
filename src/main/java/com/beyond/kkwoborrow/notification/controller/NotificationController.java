package com.beyond.kkwoborrow.notification.controller;

import com.beyond.kkwoborrow.notification.dto.NotificationRequestDto;
import com.beyond.kkwoborrow.notification.dto.NotificationResponseDto;
import com.beyond.kkwoborrow.notification.service.NotificationService;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification-service")
@Tag(name = "Notification APIs", description = "문의사항 목록 관련 API 목록")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    // 특정 문의사항 조회
    @GetMapping("/notification/{noti-id}")
    @Operation(summary = "특정 문의사항 목록 조회", description = "notificationID로 해당 문의사항 목록을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "문의사항 목록이 성공적으로 조회되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NotificationResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 문의사항 목록을 찾을 수 없습니다.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<NotificationResponseDto> getNotiList(
            @Parameter(description = "조회할 문의사항 ID", required = true, example = "1")
            @PathVariable("noti-id") Long notificationId) {
        NotificationResponseDto responseDto = notificationService.getNotiList(notificationId);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 특정 유저의 모든 문의사항 조회
    @GetMapping("/notifications/{user-id}")
    @Operation(summary = "특정 사용자의 모든 문의사항 목록 조회", description = "userId로 해당 사용자의 모든 문의사항 목록을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "문의사항 목록이 성공적으로 조회되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NotificationResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 사용자의 문의사항 목록을 찾을 수 없습니다.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<List<NotificationResponseDto>> getNotiLists(
            @Parameter(description = "문의사항 목록을 조회할 사용자 ID", required = true, example = "1")
            @PathVariable("user-id") Long userId) {
        List<NotificationResponseDto> responseDto = notificationService.getNotiLists(userId);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 문의사항 등록
    @PostMapping("/notification")
    @Operation(summary = "문의사항 목록 등록", description = "새로운 문의사항 목록을 등록한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "문의사항 목록이 성공적으로 생성되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NotificationResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 요청",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<NotificationResponseDto> createNotification(
            @Parameter(description = "문의사항 목록 생성 요청 데이터", required = true)
            @RequestBody NotificationRequestDto requestDto) {
        NotificationResponseDto responseDto =  notificationService.save(requestDto);

        if(responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // 특정 문의사항 삭제
    @DeleteMapping("/notification/{noti-id}")
    @Operation(summary = "특정 문의사항 목록 삭제", description = "notificationId로 특정 문의사항 목록을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "문의사항 목록을 성공적으로 삭제되었습니다.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "문의사항 목록을 찾을 수 없습니다.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<Void> deleteChat(
            @Parameter(description = "문의사항 목록에서 삭제할 문의사항 ID", required = true, example = "1")
            @PathVariable("noti-id") Long notificationId) {
        notificationService.delete(notificationId);

        return ResponseEntity.noContent().build();
    }

    // 특정 유저의 모든 문의사항 삭제
    @DeleteMapping("/notifications/{user-id}")
    @Operation(summary = "특정 유저의 모든 문의사항 목록 삭제", description = "ID로 특정 유저의 모든 문의사항 목록을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "모든 문의사항 목록을 성공적으로 삭제되었습니다.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 유저의 문의사항 목록을 찾을 수 없습니다.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<Void> deleteChats(
            @Parameter(description = "문의사항 목록을 삭제할 사용자 ID", required = true, example = "1")
            @PathVariable("user-id") Long userId) {
        notificationService.deleteAll(userId);

        return ResponseEntity.noContent().build();
    }
}
