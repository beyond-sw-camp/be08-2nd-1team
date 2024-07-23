package com.beyond.kkwoborrow.posts.service;

import com.beyond.kkwoborrow.post.service.PostService;
import com.beyond.kkwoborrow.posts.repository.PostRepository;
import com.beyond.kkwoborrow.posts.dto.PostDTO;
import com.beyond.kkwoborrow.Posts.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO findById(Long id) {
        Optional<Posts> post = postRepository.findById(id);
        return post.map(this::convertToDto).orElse(null);
    }

    @Override
    public PostDTO save(PostDTO postsDTO) {
        Posts post = convertToEntity(postsDTO);
        com.beyond.kkwoborrow.Posts.entity.Posts savedPost = postRepository.save(post);
        return convertToDto(savedPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    private PostDTO convertToDto(Posts post) {
        return new PostDTO(
                post.getPostId(),
                post.getTitle(),
                post.getPostContent(),
                post.getUploadDate(),
                post.getUpdateDate(),
                post.getUserId(),
                post.getProductId()
        );
    }

    private Posts convertToEntity(PostDTO postDTO) {
        return new Posts(
                postDTO.getPostId(),
                postDTO.getTitle(),
                postDTO.getPostContent(),
                postDTO.getUploadDate(),
                postDTO.getUpdateDate(),
                postDTO.getUserId(),
                postDTO.getProductId()
        );
    }
}
