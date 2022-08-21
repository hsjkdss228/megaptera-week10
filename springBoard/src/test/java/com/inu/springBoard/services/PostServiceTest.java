package com.inu.springBoard.services;

import com.inu.springBoard.dtos.PostDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostServiceTest {
  @Test
  void posts() {
    PostService postService = new PostService();

    List<PostDto> posts = postService.posts();

    assertThat(posts).hasSize(0);

    postService.create(new PostDto("Tester", "New Post", "Hello~"));

    assertThat(posts).hasSize(1);
  }

  @Test
  void create() {
    PostService postService = new PostService();

    PostDto postDto = postService.create(
        new PostDto("Tester", "New Post", "Hello~"));

    assertThat(postDto.getId()).isNotNull();
    assertThat(postDto.getAuthor()).isEqualTo("Tester");
  }
}
