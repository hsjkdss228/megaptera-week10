package com.inu.springBoard.repositories;

import com.inu.springBoard.models.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostRepositoryTest {
  @Test
  void findAll() {
    PostRepository postRepository = new PostRepository();

    assertThat(postRepository.findAll()).hasSize(0);

    Post post = new Post(1L, "Author", "Title", "Body");
    postRepository.save(post);

    assertThat(postRepository.findAll()).hasSize(1);
  }

  // TODO: save에서 id를 올바르게 지정해줘야 함
}
