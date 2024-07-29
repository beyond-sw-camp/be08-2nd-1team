package com.beyond.kkwoborrow.notification.service;

import com.beyond.kkwoborrow.notification.dto.NotificationResponseDto;
import com.beyond.kkwoborrow.notification.entity.Notifications;
import com.beyond.kkwoborrow.notification.repository.NotificationRepository;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;

    private UserRepository userRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Notifications save(Notifications notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public NotificationResponseDto getNotiList(Long notificationId) {
        Notifications notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND NOTIFICATION : " + notificationId));

        return new NotificationResponseDto(notification);
    }

    @Override
    public List<NotificationResponseDto> getNotiLists(Long userId) {
        Users user = userRepository.findById(userId)
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
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND USER : " + userId));

        notificationRepository.deleteAllByUser(user);
    }

}
