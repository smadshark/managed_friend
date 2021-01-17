package com.sonbro.eatgo.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//.andExpect(MockMvcResultMatchers.content().string("hello world"));
@SpringBootTest
class RestaurantControllerTests {
    @Autowired
    private RestaurantController restaurantController;
//    @Autowired
    private MockMvc mockMvc;

    @Test
    public void list() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
        mockMvc.perform(
            MockMvcRequestBuilders.get("/restaurants")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Bob zip")))
        .andExpect(content().string(containsString("Seoul")))
        .andExpect(content().string(containsString("Bob zip in Seoul")));
    }

    @Test
    public void detail() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();

        mockMvc.perform(
            MockMvcRequestBuilders.get("/restaurants/1004")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":1004")))
        .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));

        mockMvc.perform(
            MockMvcRequestBuilders.get("/restaurants/2021")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":2021")))
        .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }
}