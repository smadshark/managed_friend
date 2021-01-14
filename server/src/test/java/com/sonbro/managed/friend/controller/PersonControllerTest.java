package com.sonbro.managed.friend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter messageConverter;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(personController).setMessageConverters(messageConverter).build();
    }

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/person/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("SON"))
                .andExpect(jsonPath("$.phoneNumber").isEmpty())
                .andExpect(jsonPath("$.age").isNumber())
                .andExpect(jsonPath("$.birthday").value("1988-08-05"))
                .andExpect(jsonPath("$.birthdayToday").isBoolean());
    }

    @Test
    void putPerson() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/person/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"SUCKER\", \"age\": 88, \"bloodType\": \"Z\" }"))
                .andDo(print())
                .andExpect(status().isOk());

        assertThat(personRepository.findById(1L).get().getName()).isEqualTo("SUCKER");
    }

    @Test
    void deletePerson() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/v1/person/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
//    void checkJsonString() throws JsonProcessingException {
//        Person person = new Person();
//        person.setName("Helo");
//        person.setBirthday(LocalDate.now());
//        person.setPhoneNumber("01022521822");
//
//        System.out.println(toJsonString(person));
//    }
//
//    private String toJsonString(Person person) throws JsonProcessingException {
//        return objectMapper.writeValueAsString(person);
//
//    }
}