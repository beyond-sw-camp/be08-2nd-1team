package com.beyond.kkwoborrow.chatList.service;

import com.beyond.kkwoborrow.chatList.dto.ChatListRequestDto;
import com.beyond.kkwoborrow.chatList.dto.ChatListResponseDto;

import java.util.List;

public interface ChatListService {
    ChatListResponseDto getChatList(Long chatId);

    List<ChatListResponseDto> getChatLists(Long userId);

    ChatListResponseDto createChatList(ChatListRequestDto requestDto);

    void delete(Long chatId);

    void deleteAll(Long userId);

}
