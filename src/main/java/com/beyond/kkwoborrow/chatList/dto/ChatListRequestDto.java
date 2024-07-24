package com.beyond.kkwoborrow.chatList.dto;

import com.beyond.kkwoborrow.users.entity.Users;
import lombok.Getter;

@Getter
public class ChatListRequestDto {
    private long chatId;

    private Users user;
}
