package com.inu.springBoard.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

  @Test
  void list() throws Exception {
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
