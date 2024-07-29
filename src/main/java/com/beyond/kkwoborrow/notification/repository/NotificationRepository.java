package com.beyond.kkwoborrow.notification.repository;

import com.beyond.kkwoborrow.notification.entity.Notifications;
import com.beyond.kkwoborrow.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findAllByUser(Users user);

    void deleteAllByUser(Users user);

}
