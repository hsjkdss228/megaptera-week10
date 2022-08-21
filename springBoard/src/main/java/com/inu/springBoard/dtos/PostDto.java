package com.inu.springBoard.dtos;

import java.util.Objects;

public class PostDto {
  private Long id;

  private String author;

  private String title;

  private String body;

  public PostDto() {

  }

  public PostDto(String author, String title, String body) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.body = body;
  }

  public PostDto(long id, String author, String title, String body) {
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
