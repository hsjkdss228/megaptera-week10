package com.inu.springBoard.dtos;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class PostDto {
  private Long id;

  @NotBlank
  private String author;

  @NotBlank
  private String title;

  @NotBlank
  private String body;

  public PostDto() {

  }

  public PostDto(String author, String title, String body) {
    this.author = author;
    this.title = title;
    this.body = body;
  }

  public PostDto(Long id, String author, String title, String body) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.body = body;
  }

  public Long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    PostDto otherPostDto = (PostDto) other;
    return Objects.equals(id, otherPostDto.id) &&
        Objects.equals(author, otherPostDto.author) &&
        Objects.equals(title, otherPostDto.title) &&
        Objects.equals(body, otherPostDto.body);
  }

  @Override
  public String toString() {
    return "PostDto(" +
        "id: " + id + ", " +
        "author: " + author + ", " +
        "title: " + title + ", " +
        "body: " + body + ")";
  }
}
