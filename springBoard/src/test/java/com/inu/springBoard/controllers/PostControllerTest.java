package com.inu.springBoard.controllers;

import com.inu.springBoard.dtos.PostDto;
import com.inu.springBoard.repositories.PostRepository;
import com.inu.springBoard.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
class PostControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private PostRepository postRepository;

  @SpyBean
  private PostService postService;

  @Test
  void list() throws Exception {
    postService.create(new PostDto("Bot", "Post #1", "Hi~"));

    mockMvc.perform(MockMvcRequestBuilders.get("/posts"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("Post #1")
        ));
  }

  @Test
  void create() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/posts")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content("{" +
                "\"author\":\"tester\"," +
                "\"title\":\"New Post\"," +
                "\"body\":\"It's fun!\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("New Post")));
  }
}
