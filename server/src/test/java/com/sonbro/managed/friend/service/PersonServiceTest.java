package com.sonbro.managed.friend.service;

import static org.assertj.core.api.Assertions.assertThat;
import com.sonbro.managed.friend.domain.Block;
import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.domain.dto.Birthday;
import com.sonbro.managed.friend.repository.BlockRepository;
import com.sonbro.managed.friend.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {
        List<Person> result = personService.getPeopleExcludeBlocks();

//        System.out.println(result);
        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName() {
        List<Person> result = personService.getPeopleByName("YOON");
        assertThat(result.get(0).getAge()).isEqualTo(27);
    }

    @Test
    void getPersonByMonthOfBirthday() {
        // 9월 생일 사람들
        List<Person> result = personService.getPeopleByMonthOfBirthday(9);
        result.forEach(System.out::println);
    }

    @Test
    void getPersonByRangeOfBirthday() {
        // 9월에 1일부터 15일 사이에 생일인 사람들
        List<Person> result = personService.getPeopleByRangeOfBirthday(9, 20, 30);
        result.forEach(System.out::println);
    }

}