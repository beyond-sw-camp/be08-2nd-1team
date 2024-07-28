package com.beyond.kkwoborrow.posts.service;

import com.beyond.kkwoborrow.posts.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> findAll();
    PostDTO findById(Long id);
    PostDTO save(PostDTO postDTO);

    void deleteById(Long id);
}