package com.inu.springBoard.controllers;

import com.inu.springBoard.dtos.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {
  @GetMapping("/posts")
  public List<PostDto> list() {
    List<PostDto> posts = new ArrayList<>();
    PostDto post = new PostDto(1L, "Inu", "Post #1", "...");
    posts.add(post);

    return posts;
  }

  @PostMapping("/posts")
  @ResponseStatus(HttpStatus.CREATED)
  public PostDto create(
      @RequestBody PostDto postDto
  ) {
    // TODO: 게시물 목록 변경이 일어나야 함

    return postDto;
  }
}
