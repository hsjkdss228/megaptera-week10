package com.inu.springBoard.dtos;

public class PostDto {
  private Long id;

  private String author;

  private String title;

  private String body;

  public PostDto() {

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
}
