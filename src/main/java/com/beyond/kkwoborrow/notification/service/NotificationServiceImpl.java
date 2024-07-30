package com.beyond.kkwoborrow.notification.service;

import com.beyond.kkwoborrow.notification.dto.NotificationRequestDto;
import com.beyond.kkwoborrow.notification.dto.NotificationResponseDto;
import com.beyond.kkwoborrow.notification.entity.Notifications;
import com.beyond.kkwoborrow.notification.repository.NotificationRepository;
import com.beyond.kkwoborrow.users.entity.UserType;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public NotificationResponseDto save(NotificationRequestDto requestDto) {
        Users user = userRepository.findByUserIdAndUserTypeNot(requestDto.getUserId(), UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + requestDto.getUserId()));

        Notifications notification = new Notifications(user);

        notificationRepository.save(notification);

        return new NotificationResponseDto(notification);
    }

    @Override
    public NotificationResponseDto getNotiList(Long notificationId) {
        Notifications notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND NOTIFICATION : " + notificationId));

        return new NotificationResponseDto(notification);
    }

    @Override
    public List<NotificationResponseDto> getNotiLists(Long userId) {
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        List<Notifications> notifications = notificationRepository.findAllByUser(user);

        return NotificationResponseDto.convert(notifications);
    }

    @Transactional
    @Override
    public void delete(Long notificationId) {
        Notifications notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND NOTIFICATION : " + notificationId));

        notificationRepository.delete(notification);
    }

    @Transactional
    @Override
    public void deleteAll(Long userId) {
        Users user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        notificationRepository.deleteAllByUser(user);
    }

}
