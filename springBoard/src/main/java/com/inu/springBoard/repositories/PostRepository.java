package com.inu.springBoard.repositories;

import com.inu.springBoard.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SuppressWarnings("unchecked")
public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findAll();

  Post save(Post post);
}
