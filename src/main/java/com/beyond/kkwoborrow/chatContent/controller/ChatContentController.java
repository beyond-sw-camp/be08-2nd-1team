package com.beyond.kkwoborrow.chatContent.controller;

import com.beyond.kkwoborrow.chatContent.dto.ChatContentRequestDto;
import com.beyond.kkwoborrow.chatContent.dto.ChatContentResponseDto;
import com.beyond.kkwoborrow.chatContent.service.ChatContentService;
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
@RequestMapping("/api/v1/content-service")
@Tag(name = "ChatContent APIs", description = "채팅 내용 관련 API 목록")
public class ChatContentController {
    @Autowired
    private ChatContentService chatContentService;

    // 채팅 내용 등록
    @PostMapping("/content/chat")
    @Operation(summary = "채팅 내용 등록", description = "새로운 채팅 내용을 등록한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "채팅 내용이 성공적으로 등록되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ChatContentResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 요청 데이터",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ChatContentResponseDto> createChatContent(
            @RequestBody @Parameter(description = "채팅 내용 등록 요청 데이터", required = true) ChatContentRequestDto requestDto) {
        ChatContentResponseDto responseDto = chatContentService.save(requestDto);

        if(responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/content/noti")
    @Operation(summary = "문의사항 내용 등록", description = "새로운 문의사항을 등록한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "문의사항이 성공적으로 등록되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ChatContentResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 요청 데이터",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ChatContentResponseDto> createChatContentNoti(
            @RequestBody @Parameter(description = "문의사항 내용 등록 요청 데이터", required = true) ChatContentRequestDto requestDto) {
        ChatContentResponseDto responseDto = chatContentService.saveNoti(requestDto);

        if(responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 채팅 내용 수정
    @PatchMapping("/content/chat/{content-id}")
    @Operation(summary = "채팅/문의사항 내용 수정", description = "특정 채팅/문의사항 내용을 수정한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "채팅/문의사항 내용 수정 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ChatContentResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "채팅/문의사항 내용을 찾을 수 없음",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ChatContentResponseDto> updateChatContent(
            @PathVariable("content-id") @Parameter(description = "채팅/문의사항 내용 ID", example = "1") long contentId,
            @RequestBody @Parameter(description = "채팅/문의사항 내용 수정 요청 데이터", required = true) ChatContentRequestDto requestDto) {
        ChatContentResponseDto responseDto = chatContentService.updateChatContent(contentId, requestDto);

        if(responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // 특정 채팅/문의사항 내용 조회
    @GetMapping("/content/{content-id}/{user-id}")
    @Operation(summary = "채팅/문의사항 내용 조회", description = "특정 채팅/문의사항 내용을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "채팅/문의사항 내용 조회 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ChatContentResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "채팅/문의사항 내용을 찾을 수 없음",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ChatContentResponseDto> getChatContent(
            @PathVariable("content-id") @Parameter(description = "채팅/문의사항 내용 ID", example = "1") long contentId,
            @PathVariable("user-id") @Parameter(description = "사용자 ID", example = "1") long userId) {
        ChatContentResponseDto responseDto = chatContentService.getChatContent(contentId, userId);

        if(responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 특정 채팅/문의사항 내용 삭제
    @DeleteMapping("/content/chat/{content-id}/{user-id}")
    @Operation(summary = "채팅/문의사항 내용 삭제", description = "특정 채팅/문의사항 내용을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "채팅/문의사항 내용 삭제 성공"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "채팅/문의사항 내용을 찾을 수 없음",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<Void> deleteChatContent(
            @PathVariable("content-id") @Parameter(description = "채팅 내용 ID", example = "1") long contentId,
            @PathVariable("user-id") @Parameter(description = "사용자 ID", example = "1") long userId) {
        chatContentService.deleteChatContent(contentId, userId);

        return ResponseEntity.noContent().build();
    }

    // 모든 채팅/문의사항 내용 조회
    @GetMapping("/contents/{user-id}")
    @Operation(summary = "해당 사용자의 모든 채팅/문의사항 내용 조회", description = "해당 사용자의 모든 채팅/문의사항 내용을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "모든 채팅/문의사항 내용 조회 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ChatContentResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "사용자 또는 채팅/문의사항 내용을 찾을 수 없음",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<List<ChatContentResponseDto>> getChatContents(
            @PathVariable("user-id") @Parameter(description = "사용자 ID", example = "1") long userId) {
        List<ChatContentResponseDto> responseDtoList = chatContentService.getChatContents(userId);

        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    // 모든 채팅/문의사항 내용 삭제
    @DeleteMapping("/contents/{user-id}")
    @Operation(summary = "해당 사용자의 모든 채팅/문의사항 내용 삭제", description = "해당 사용자의 모든 채팅/문의사항 내용을 삭제한다.")
    public ResponseEntity<Void> deleteAllChatContents(
            @PathVariable("user-id") @Parameter(description = "사용자 ID", example = "1") long userId) {

        chatContentService.deleteChatContents(userId);

        return ResponseEntity.noContent().build();
    }
}