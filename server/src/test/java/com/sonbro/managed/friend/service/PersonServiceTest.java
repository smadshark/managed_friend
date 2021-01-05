package com.sonbro.managed.friend.service;

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
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

//        System.out.println(result);
        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName() {
        givenPeople();
        List<Person> result = personService.getPeopleByName("son");
        result.forEach(System.out::println);
    }

    @Test
    void getPersonByBloodType() {
        givenPeople();
        List<Person> result = personService.getPersonByBloodType("O");
        result.forEach(System.out::println);
    }

    @Test
    void getPersonByMonthOfBirthday() {
        givenPeople();
        // 9월 생일 사람들
        List<Person> result = personService.getPeopleByMonthOfBirthday(9);
        result.forEach(System.out::println);
    }

    @Test
    void getPersonByRangeOfBirthday() {
        givenPeople();
        // 9월에 1일부터 15일 사이에 생일인 사람들
        List<Person> result = personService.getPeopleByRangeOfBirthday(9, 20, 30);
        result.forEach(System.out::println);
    }

    private void givenBlocks() {
        givenBlock("kim");
    }

    private void givenBlock(String name) {
        blockRepository.save(new Block(name));
    }

    private void givenPeople() {
        givenPerson("son", 11, "O", LocalDate.of(1991,8,15));
        givenPerson("kim", 12, "A", LocalDate.of(1992,8,25));
        givenPerson("park", 13, "B", LocalDate.of(1993,9,30));
        givenPerson("son", 14, "O", LocalDate.of(1994,9,19));
    }

    private void givenPerson(String name, int age, String bloodType, @NonNull LocalDate birthday) {
        Person person = new Person(name, age, bloodType);
        // 날짜관련데이터는 LocalDate 사용이 좋은듯, 자동 valid
        person.setBirthday(new Birthday(birthday));

        personRepository.save(person);
    }
}