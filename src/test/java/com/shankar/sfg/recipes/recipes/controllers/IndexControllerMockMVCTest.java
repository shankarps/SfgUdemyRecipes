package com.shankar.sfg.recipes.recipes.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @implNote This Test class tests the IndexController with a Mvc container
 * (without the dispatcher servlet and web application running).
 * This is a slow test, since all the beans are created.
 * @see IndexController
 */

@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerMockMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void testIndexControllerView() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("My Recipes")));;
    }
}
