package com.beyond.kkwoborrow.chatList.controller;

import com.beyond.kkwoborrow.chatList.dto.ChatListResponseDto;
import com.beyond.kkwoborrow.chatList.service.ChatListService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chatList-service/chats")
@Tag(name = "ChatList APIs", description = "채팅 목록 관련 API 목록")
public class ChatListController {
    private final ChatListService chatListService;

    @Autowired
    public ChatListController(ChatListService chatListService) {
        this.chatListService = chatListService;
    }

    @GetMapping("/{chat-id}")
    public ResponseEntity<ChatListResponseDto> getChatList(@PathVariable("chat-id") Long chatId) {
        ChatListResponseDto responseDto = chatListService.getChatList(chatId);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<List<ChatListResponseDto>> getChatLists(@PathVariable("user-id") Long userId) {
        List<ChatListResponseDto> responseDto = chatListService.getChatLists(userId);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{chat-id}")
    public void deleteChat(@PathVariable("chat-id") Long chatId) {
        chatListService.delete(chatId);
    }

    @DeleteMapping("/{user-id}")
    public void deleteChats(@PathVariable("user-id") Long userId) {
        chatListService.deleteAll(userId);
    }
}
