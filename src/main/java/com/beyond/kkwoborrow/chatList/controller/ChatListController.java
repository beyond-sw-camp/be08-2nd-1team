package com.beyond.kkwoborrow.chatList.controller;

import com.beyond.kkwoborrow.chatList.dto.ChatListRequestDto;
import com.beyond.kkwoborrow.chatList.dto.ChatListResponseDto;
import com.beyond.kkwoborrow.chatList.service.ChatListService;
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
@RequestMapping("/api/v1/chatList-service")
@Tag(name = "ChatList APIs", description = "채팅 목록 관련 API 목록")
public class ChatListController {
    private final ChatListService chatListService;

    @Autowired
    public ChatListController(ChatListService chatListService) {
        this.chatListService = chatListService;
    }

    @GetMapping("/chat/{chat-id}")
    @Operation(summary = "채팅 목록 조회", description = "하나의 채팅 목록을 조회한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChatListResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "NOT FOUND",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<ChatListResponseDto> getChatList(
            @Parameter(description = "조회할 채팅 ID", example = "1", required = true)
            @PathVariable("chat-id") Long chatId) {
        ChatListResponseDto responseDto = chatListService.getChatList(chatId);

        if(responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/chats/user/{user-id}")
    @Operation(summary = "사용자별 채팅 목록 조회", description = "특정 사용자에 대한 모든 채팅 목록을 조회한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "채팅 목록 조회 성공",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChatListResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "사용자 또는 채팅 목록을 찾을 수 없음",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<List<ChatListResponseDto>> getChatLists(
            @Parameter(description = "조회할 사용자 ID", example = "1", required = true)
            @PathVariable("user-id") Long userId) {
        List<ChatListResponseDto> responseDto = chatListService.getChatLists(userId);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/chat")
    @Operation(summary = "채팅 목록 생성", description = "새로운 채팅 목록을 생성한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "채팅 목록 생성 성공",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChatListResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "잘못된 요청 데이터",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<ChatListResponseDto> createChatList(
            @Parameter(description = "생성할 채팅 목록 데이터", required = true)
            @RequestBody ChatListRequestDto requestDto) {
        ChatListResponseDto responseDto = chatListService.createChatList(requestDto);

        if(responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/chat/{chat-id}")
    @Operation(summary = "채팅 목록 삭제", description = "특정 채팅 목록을 삭제한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "채팅 목록 삭제 성공",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "채팅 목록을 찾을 수 없음",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public void deleteChat(
            @Parameter(description = "삭제할 채팅 ID", example = "1", required = true)
            @PathVariable("chat-id") Long chatId) {
        chatListService.delete(chatId);
    }

    @DeleteMapping("/chats/user/{user-id}")
    @Operation(summary = "특정 사용자의 모든 채팅 목록 삭제", description = "특정 사용자에 대한 모든 채팅 목록을 삭제한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "채팅 목록 삭제 성공",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "사용자 또는 채팅 목록을 찾을 수 없음",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public void deleteChats(
            @Parameter(description = "대화 목록을 삭제할 사용자 ID", example = "1", required = true)
            @PathVariable("user-id") Long userId) {
        chatListService.deleteAll(userId);
    }
}
