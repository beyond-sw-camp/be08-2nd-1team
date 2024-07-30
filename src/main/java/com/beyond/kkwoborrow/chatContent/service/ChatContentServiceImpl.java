package com.beyond.kkwoborrow.chatContent.service;

import com.beyond.kkwoborrow.chatContent.dto.ChatContentRequestDto;
import com.beyond.kkwoborrow.chatContent.dto.ChatContentResponseDto;
import com.beyond.kkwoborrow.chatContent.entity.ChatContent;
import com.beyond.kkwoborrow.chatContent.repository.ChatContentRepository;
import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.chatList.repository.ChatListRepository;
import com.beyond.kkwoborrow.notification.entity.Notifications;
import com.beyond.kkwoborrow.notification.repository.NotificationRepository;
import com.beyond.kkwoborrow.users.entity.UserType;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ChatContentResponseDto save(ChatContentRequestDto requestDto) {
        Users user = userRepository.findByUserIdAndUserTypeNot(requestDto.getUserId(), UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + requestDto.getUserId()));

        ChatContent chatContent = new ChatContent();
        chatContent.setDetail(requestDto.getDetail());
        chatContent.setSendTime(requestDto.getSendTime());
        chatContent.setUser(user);

        if(requestDto.getChatId() != null) {
            ChatList chatList = new ChatList(requestDto.getChatId(), user);
            chatContent.setChatList(chatList);
        }

        if(requestDto.getNotificationId() != null) {
            Notifications notification = new Notifications(requestDto.getNotificationId(), user);
            chatContent.setNotification(notification);
        }

        ChatContent createdContent = chatContentRepository.save(chatContent);

        return new ChatContentResponseDto(createdContent);
    }

    @Override
    public ChatContentResponseDto getChatContent(long contentId, long userId) {
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
                .orElseThrow(() -> new EntityNotFoundException("NOT FOUND USER : " + userId));

        ChatContent chatContent = chatContentRepository.findById(contentId)
                .orElseThrow(() -> new EntityNotFoundException("NOT FOUND CHATCONTENT : " + contentId));

        // 사용자 권한 확인
        if(chatContent.getUser() != user) {
            throw new RuntimeException("UNAUTHORIZED ACCESS : " + userId);
        }

        return new ChatContentResponseDto(chatContent);
    }

    @Override
    public List<ChatContentResponseDto> getChatContents(long userId) {
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
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

        Users user = userRepository.findByUserIdAndUserTypeNot(requestDto.getUserId(), UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + requestDto.getUserId()));

        chatContent.setDetail(requestDto.getDetail());
        chatContent.setSendTime(requestDto.getSendTime());
        chatContent.setUser(user);

        ChatContent updatedChatContent = chatContentRepository.save(chatContent);

        return new ChatContentResponseDto(updatedChatContent);
    }

    @Override
    public void deleteChatContent(long contentId, long userId) {
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        ChatContent chatContent = chatContentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CHATCONTENT : " + contentId));

        // 사용자 권한 확인
        if(chatContent.getUser() != user) {
            throw new RuntimeException("UNAUTHORIZED ACCESS : " + userId);
        }

        chatContentRepository.delete(chatContent);

        if(!chatContentRepository.findById(chatContent.getChatList().getChatId()).isEmpty()) {
            chatListRepository.deleteById(chatContent.getChatList().getChatId());
        }

        if(!chatContentRepository.findById(chatContent.getNotification().getNotificationId()).isEmpty()) {
            notificationRepository.deleteById(chatContent.getNotification().getNotificationId());
        }
    }

    @Override
    public void deleteChatContents(long userId) {
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        List<ChatContent> chatContents = chatContentRepository.findAllByUser(user);

        // 사용자 권한 확인
        if(chatContents.getFirst().getUser() != user) {
            throw new RuntimeException("UNAUTHORIZED ACCESS : " + userId);
        }

        chatContentRepository.deleteAll(chatContents);
        chatListRepository.deleteById(chatContents.getFirst().getChatList().getChatId());
        notificationRepository.deleteById(chatContents.getFirst().getNotification().getNotificationId());
    }

}
