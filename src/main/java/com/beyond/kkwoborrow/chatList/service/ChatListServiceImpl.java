package com.beyond.kkwoborrow.chatList.service;

import com.beyond.kkwoborrow.chatList.dto.ChatListResponseDto;
import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.chatList.repository.ChatListRepository;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatListServiceImpl implements ChatListService {
    @Autowired
    ChatListRepository chatListRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ChatListResponseDto getChatList(Long chatId) {
        ChatList chatList = chatListRepository.findById(chatId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CHATLIST : " + chatId));

        return new ChatListResponseDto(chatList);
    }

    @Override
    public List<ChatListResponseDto> getChatLists(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        List<ChatList> chatLists = chatListRepository.findByUser(user);

        return ChatListResponseDto.convert(chatLists);
    }

    @Override
    public void delete(Long chatId) {
        ChatList chatList = chatListRepository.findById(chatId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CHATLIST : " + chatId));

        if(chatList != null) {
            chatListRepository.deleteById(chatId);
        }
    }

    @Override
    public void deleteAll(Long userId) {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        if(users != null) {
            chatListRepository.deleteAllByUser(users);
        }
    }
}
