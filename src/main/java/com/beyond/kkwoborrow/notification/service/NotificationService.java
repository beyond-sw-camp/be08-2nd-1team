package com.beyond.kkwoborrow.notification.service;

import com.beyond.kkwoborrow.notification.dto.NotificationRequestDto;
import com.beyond.kkwoborrow.notification.dto.NotificationResponseDto;
import com.beyond.kkwoborrow.notification.entity.Notifications;

import java.util.List;

public interface NotificationService {
    NotificationResponseDto save(NotificationRequestDto requestDto);

    NotificationResponseDto getNotiList(Long notificationId);

    List<NotificationResponseDto> getNotiLists(Long userId);

    void delete(Long notificationId);

    void deleteAll(Long userId);
}
