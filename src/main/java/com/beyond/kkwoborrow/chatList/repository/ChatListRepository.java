package com.beyond.kkwoborrow.chatList.repository;

import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatListRepository extends JpaRepository<ChatList, Long> {
    List<ChatList> findByUser(Users user);

    void deleteAllByUser(Users user);

}
