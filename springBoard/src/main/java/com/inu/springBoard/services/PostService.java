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
    List<Post> posts = postRepository.findAll();

    return posts.stream()
        .map(Post::toDto)
        .toList();
  }

  public PostDto create(PostDto postDto) {
    Post post = postRepository.save(Post.of(postDto));

    return post.toDto();
  }
}
