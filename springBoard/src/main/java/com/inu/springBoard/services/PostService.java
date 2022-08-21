package com.inu.springBoard.services;

import com.inu.springBoard.dtos.PostDto;
import com.inu.springBoard.models.Post;
import com.inu.springBoard.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<PostDto> posts() {
    return postRepository.findAll().stream()
        .map(Post::toDto)
        .toList();
  }

  public PostDto create(PostDto postDto) {
    // TODO: DTO >> 도메인 모델 변환 필요함
    Post post
        = new Post(1L, postDto.getAuthor(), postDto.getTitle(), postDto.getBody());

    postRepository.save(post);

    return post.toDto();
  }
}
