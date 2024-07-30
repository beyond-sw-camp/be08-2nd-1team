package com.beyond.kkwoborrow.chatContent.service;

import com.beyond.kkwoborrow.chatContent.dto.ChatContentRequestDto;
import com.beyond.kkwoborrow.chatContent.dto.ChatContentResponseDto;

import java.util.List;

public interface ChatContentService {
    ChatContentResponseDto save(ChatContentRequestDto requestDto);

    ChatContentResponseDto getChatContent(long contentId, long userId);

    List<ChatContentResponseDto> getChatContents(long userId);

    ChatContentResponseDto updateChatContent(long contentId, ChatContentRequestDto requestDto);

    void deleteChatContent(long contentId, long userId);

    void deleteChatContents(long userId);
}
