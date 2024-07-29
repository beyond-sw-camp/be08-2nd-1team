package com.beyond.kkwoborrow.chatContent.service;

import com.beyond.kkwoborrow.chatContent.dto.ChatContentRequestDto;
import com.beyond.kkwoborrow.chatContent.dto.ChatContentResponseDto;
import com.beyond.kkwoborrow.chatContent.entity.ChatContent;
import com.beyond.kkwoborrow.chatContent.repository.ChatContentRepository;
import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.chatList.repository.ChatListRepository;
import com.beyond.kkwoborrow.notification.entity.Notifications;
import com.beyond.kkwoborrow.notification.repository.NotificationRepository;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatContentServiceImpl implements ChatContentService {
    @Autowired
    private ChatContentRepository chatContentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatListRepository chatListRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public ChatContent save(ChatContent chatContent) {
        return chatContentRepository.save(chatContent);
    }

    @Override
    public ChatContentResponseDto getChatContent(long contentId, long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        ChatContent chatContent = chatContentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CHATCONTENT : " + contentId));

        // 사용자 권한 확인
        if(chatContent.getUser() != user) {
            throw new RuntimeException("UNAUTHORIZED ACCESS : " + userId);
        }

        return new ChatContentResponseDto(chatContent);
    }

    @Override
    public List<ChatContentResponseDto> getChatContents(long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        List<ChatContent> chatContents = chatContentRepository.findAllByUser(user);

        return chatContents.stream()
                .map(ChatContentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ChatContentResponseDto updateChatContent(long contentId, ChatContentRequestDto requestDto) {
        ChatContent chatContent = chatContentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CONTENT : " + contentId));

        Users user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + requestDto.getUserId()));

        ChatList chatList = chatListRepository.findById(requestDto.getChatId())
                .orElseThrow(() -> new RuntimeException("NOT FOUND CHAT LIST : " + requestDto.getChatId()));

        Notifications notification = notificationRepository.findById(requestDto.getNotificationId())
                .orElseThrow(() -> new RuntimeException("NOT FOUND NOTIFICATION : " + requestDto.getNotificationId()));


        chatContent.setDetail(requestDto.getDetail());
        chatContent.setSendTime(requestDto.getSendTime());
        chatContent.setUser(user);
        chatContent.setChatList(chatList);
        chatContent.setNotification(notification);

        ChatContent updatedChatContent = chatContentRepository.save(chatContent);

        return new ChatContentResponseDto(updatedChatContent);
    }

    @Override
    public void deleteChatContent(long contentId, long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        ChatContent chatContent = chatContentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CHATCONTENT : " + contentId));

        // 사용자 권한 확인
        if(chatContent.getUser() != user) {
            throw new RuntimeException("UNAUTHORIZED ACCESS : " + userId);
        }

        chatContentRepository.delete(chatContent);
    }

    @Override
    public void deleteChatContents(long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        List<ChatContent> chatContents = chatContentRepository.findAllByUser(user);

        // 사용자 권한 확인
        if(chatContents.getFirst().getUser() != user) {
            throw new RuntimeException("UNAUTHORIZED ACCESS : " + userId);
        }

        chatContentRepository.deleteAll(chatContents);
    }

}
