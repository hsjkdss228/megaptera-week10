package com.inu.springBoard.services;

import com.inu.springBoard.dtos.PostDto;
import com.inu.springBoard.repositories.PostRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostServiceTest {
  @Test
  void posts() {
    PostRepository postRepository = new PostRepository();

    PostService postService = new PostService(postRepository);

    assertThat(postService.posts()).hasSize(0);

    postService.create(new PostDto("Tester", "New Post", "Hello~"));

    assertThat(postService.posts()).hasSize(1);
  }

  @Test
  void create() {
    PostRepository postRepository = new PostRepository();

    PostService postService = new PostService(postRepository);

    PostDto postDto = postService.create(
        new PostDto("Tester", "New Post", "Hello~"));

    assertThat(postDto.getId()).isNotNull();
    assertThat(postDto.getAuthor()).isEqualTo("Tester");
  }
}
