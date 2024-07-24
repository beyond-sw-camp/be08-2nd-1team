package com.beyond.kkwoborrow.chatList.dto;

import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.users.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ChatListResponseDto {
    private long chatId;

    private Users user;

    public ChatListResponseDto(ChatList chatList) {
        this.chatId = chatList.getChatId();
        this.user = chatList.getUser();
    }

    public static List<ChatListResponseDto> convert(List<ChatList> chatLists) {
        return chatLists.stream()
                .map(ChatListResponseDto::new)
                .collect(Collectors.toList());
    }
}
