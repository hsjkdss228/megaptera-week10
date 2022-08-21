package com.inu.springBoard.repositories;

import com.inu.springBoard.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
  private final List<Post> posts = new ArrayList<>();

  public List<Post> findAll() {
    return new ArrayList<>(posts);
  }

  public void save(Post post) {
    posts.add(post);
  }
}
