package com.inu.springBoard.repositories;

import com.inu.springBoard.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
  private final List<Post> posts = new ArrayList<>();

  private Long id = 1L;

  public List<Post> findAll() {
    return new ArrayList<>(posts);
  }

  public Post save(Post post) {
    Post savedPost = new Post(id, post);

    // TODO: 이런 방식의 id 발급은 Multi-thread 환경에서 문제 발생 가능
    //  Spring은 Multi-thread 환경임
    //  따라서 Spring Data JPA로 해결해야 함
    id += 1;

    posts.add(savedPost);

    return savedPost;
  }
}
