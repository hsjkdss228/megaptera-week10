package com.inu.springBoard.services;

import com.inu.springBoard.dtos.PostDto;
import com.inu.springBoard.models.Post;
import com.inu.springBoard.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

  // TODO: id와 새로운 DTO를 받아야 함
  public PostDto update() {
    Long id = 1L;

    Post post = postRepository.getReferenceById(id);
    post.decorateTitle();

    return post.toDto();
  }
}
