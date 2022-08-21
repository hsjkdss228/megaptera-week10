package com.inu.springBoard.controllers;

import com.inu.springBoard.dtos.PostDto;
import com.inu.springBoard.exceptions.InvalidPostDtoException;
import com.inu.springBoard.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public List<PostDto> list() {
    return postService.posts();
  }

  @PostMapping("/posts")
  @ResponseStatus(HttpStatus.CREATED)
  public PostDto create(
      @Validated @RequestBody PostDto postDto
  ) {
//    if (!postDto.isValid()) {
//      throw new InvalidPostDtoException();
//    }

    return postService.create(postDto);
  }

//  @ExceptionHandler(InvalidPostDtoException.class)
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  public String createFail() {
//    return "멸ㅋ망ㅋ";
//  }
}
