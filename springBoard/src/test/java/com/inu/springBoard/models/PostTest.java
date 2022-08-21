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
  void copy() {
    Post post1 = new Post(1L, "Tester", "Fun story", "Joke");
    Post post2 = new Post(2L, "Tester", "Fun story", "Joke");

    assertThat(post1.id()).isEqualTo(1L);
    assertThat(post2.id()).isEqualTo(2L);

    assertThat(post1.toDto())
        .isEqualTo(new Post(post1.id(), post2).toDto());
  }

  @Test
  void createFromDto() {
    PostDto postDto = new PostDto(1L, "Tester", "Fun story", "Joke");

    Post post = Post.of(postDto);

    assertThat(postDto)
        .isEqualTo(new PostDto(1L, "Tester", "Fun story", "Joke"));
  }
}
