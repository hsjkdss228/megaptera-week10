package com.inu.springBoard.models;

import com.inu.springBoard.dtos.PostDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostTest {
  @Test
  void creation() {
    Post post = new Post(1L, "Tester", "Fun story", "Joke");

    assertThat(post.id()).isEqualTo(1L);
  }

  @Test
  void convertToDto() {
    Post post = new Post(1L, "Tester", "Fun story", "Joke");

    PostDto postDto = post.toDto();

    assertThat(postDto)
        .isEqualTo(new PostDto(1L, "Tester", "Fun story", "Joke"));
  }

  @Test
  void createFromDto() {
    PostDto postDto = new PostDto(1L, "Tester", "Fun story", "Joke");

    Post post = Post.of(postDto);

    assertThat(postDto)
        .isEqualTo(new PostDto(1L, "Tester", "Fun story", "Joke"));
  }
}
