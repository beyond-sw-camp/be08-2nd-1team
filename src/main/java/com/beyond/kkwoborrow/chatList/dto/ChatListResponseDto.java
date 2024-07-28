package com.beyond.kkwoborrow.chatList.dto;

import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.users.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Schema(description = "채팅 리스트 응답 데이터 전송 객체")
public class ChatListResponseDto {
    @Schema(description = "채팅 ID", example = "1")
    private long chatId;

    @Schema(description = "사용자 정보")
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
