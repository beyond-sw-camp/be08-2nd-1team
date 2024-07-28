package com.beyond.kkwoborrow.posts.repository;

import com.beyond.kkwoborrow.posts.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
