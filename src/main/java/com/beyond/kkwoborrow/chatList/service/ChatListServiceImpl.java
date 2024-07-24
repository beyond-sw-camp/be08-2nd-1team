package com.beyond.kkwoborrow.chatList.service;

import com.beyond.kkwoborrow.chatList.dto.ChatListResponseDto;
import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.chatList.repository.ChatListRepository;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatListServiceImpl implements ChatListService {
    ChatListRepository chatListRepository;
    UserRepository userRepository;

    @Override
    public ChatListResponseDto getChatList(Long chatId) {
        ChatList chatList = chatListRepository.findById(chatId).orElse(null);

        if (chatList != null) {
            return new ChatListResponseDto(chatList);
        }

        return null;
    }

    @Override
    public List<ChatListResponseDto> getChatLists(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER"));

        List<ChatList> chatLists = chatListRepository.findByUser(user);

        return ChatListResponseDto.convert(chatLists);
    }

    @Override
    public void delete(Long chatId) {
        chatListRepository.deleteById(chatId);
    }

    @Override
    public void deleteAll(Long userId) {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER"));

        chatListRepository.deleteAllByUser(users);
    }
}
