package com.sonbro.managed.friend.service;

import com.sonbro.managed.friend.domain.Block;
import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.repository.BlockRepository;
import com.sonbro.managed.friend.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

//        System.out.println(result);
        result.forEach(System.out::println);
    }

    private void givenBlocks() {
        givenBlock("kim");
    }

    private void givenBlock(String name) {
        blockRepository.save(new Block(name));
    }

    private void givenPeople() {
        givenPerson("son", 11, "O");
        givenPerson("kim", 12, "A");
        givenPerson("park", 13, "B");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }
}