package com.beyond.kkwoborrow.chatContent.repository;

import com.beyond.kkwoborrow.chatContent.entity.ChatContent;
import com.beyond.kkwoborrow.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatContentRepository extends JpaRepository<ChatContent, Long> {

    List<ChatContent> findAllByUser(Users user);
}