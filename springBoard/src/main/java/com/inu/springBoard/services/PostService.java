package com.inu.springBoard.services;

import com.inu.springBoard.dtos.PostDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
  private List<PostDto> posts = new ArrayList<>();

  public List<PostDto> posts() {
    return posts;
  }

  public PostDto create(PostDto postDto) {
    // TODO: 매번 새로운 ID 발급 필요함
    Long id = 1L;

    PostDto createdPostDto
        = new PostDto(id, postDto.getAuthor(), postDto.getTitle(), postDto.getBody());

    posts.add(createdPostDto);

    return createdPostDto;
  }
}
