package com.beyond.kkwoborrow.chatList.service;

import com.beyond.kkwoborrow.chatList.dto.ChatListRequestDto;
import com.beyond.kkwoborrow.chatList.dto.ChatListResponseDto;
import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.chatList.repository.ChatListRepository;
import com.beyond.kkwoborrow.users.entity.UserType;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        List<ChatList> chatLists = chatListRepository.findAllByUser(user);

        return ChatListResponseDto.convert(chatLists);
    }
    @Override
    public ChatListResponseDto createChatList(ChatListRequestDto requestDto) {
        Users user = userRepository.findByUserIdAndUserTypeNot(requestDto.getUserId(), UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + requestDto.getUserId()));

        ChatList chatList = new ChatList(user);

        ChatList savedChatList = chatListRepository.save(chatList);

        return new ChatListResponseDto(savedChatList);
    }

    @Transactional
    @Override
    public void delete(Long chatId) {
        ChatList chatList = chatListRepository.findById(chatId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CHATLIST : " + chatId));

        chatListRepository.delete(chatList);
    }

    @Transactional
    @Override
    public void deleteAll(Long userId) {
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        chatListRepository.deleteAllByUser(user);
    }
}
