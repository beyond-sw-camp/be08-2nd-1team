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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        chatContent.setSendTime(LocalDateTime.now());
        chatContent.setUser(user);
        ChatList chatList = new ChatList(user);
        chatListRepository.save(chatList);

        chatContent.setChatList(chatList);

        ChatContent createdContent = chatContentRepository.save(chatContent);

        return new ChatContentResponseDto(createdContent);
    }

    @Override
    public ChatContentResponseDto saveNoti(ChatContentRequestDto requestDto) {
        Users user = userRepository.findByUserIdAndUserTypeNot(requestDto.getUserId(), UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + requestDto.getUserId()));

        ChatContent chatContent = new ChatContent();
        chatContent.setDetail(requestDto.getDetail());
        chatContent.setSendTime(LocalDateTime.now());
        chatContent.setUser(user);

        Notifications notification = new Notifications(user);
        notificationRepository.save(notification);

        chatContent.setNotification(notification);

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

    @Transactional
    @Override
    public ChatContentResponseDto updateChatContent(long contentId, ChatContentRequestDto requestDto) {
        ChatContent chatContent = chatContentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND CONTENT : " + contentId));

        Users user = userRepository.findByUserIdAndUserTypeNot(requestDto.getUserId(), UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + requestDto.getUserId()));

        chatContent.setDetail(requestDto.getDetail());
        chatContent.setSendTime(LocalDateTime.now());
        chatContent.setUser(user);

        ChatContent updatedChatContent = chatContentRepository.save(chatContent);

        return new ChatContentResponseDto(updatedChatContent);
    }

    @Transactional
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

        // 기존의 채팅 id가 더 이상 존재하지 않는다면 chatList에서도 delete
        if(chatContent.getChatList() != null) {
            if(chatContentRepository.findById(chatContent.getChatList().getChatId()).isEmpty()) {
                chatListRepository.deleteByChatIdAndUser_UserId(chatContent.getChatList().getChatId(), userId);
            }
        }

        if(chatContent.getNotification() != null) {
            if(chatContentRepository.findById(chatContent.getNotification().getNotificationId()).isEmpty()) {
                notificationRepository.deleteByNotificationIdAndUser_UserId(chatContent.getNotification().getNotificationId(), userId);
            }
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
        if(chatContents.getFirst().getChatList() != null) {
            chatListRepository.deleteById(chatContents.getFirst().getChatList().getChatId());
        }
        if(chatContents.getFirst().getNotification() != null) {
            notificationRepository.deleteById(chatContents.getFirst().getNotification().getNotificationId());
        }
    }

}
