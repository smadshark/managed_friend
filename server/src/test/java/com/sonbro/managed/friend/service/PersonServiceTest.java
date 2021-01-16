package com.sonbro.managed.friend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    // spring context
    // @Autowired
    // private PersonService personService;
    //
    // @Autowired
    // private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;

    @Test
    void getPeopleByName() {
        // when = if
        when(personRepository.findByName("YOON"))
            .thenReturn(Lists.newArrayList(new Person("YOON")));

        List<Person> result = personService.getPeopleByName("YOON");
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("YOON");
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

    @Test
    void getPerson() {
        // when = if
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("SON")));

        Person person = personService.getPerson(1L);
        assertThat(person.getName()).isEqualTo("SON");
    }

    @Test
    void getPersonIfNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty());

        Person person = personService.getPerson(1L);
        assertThat(person).isNull();
    }

    @Test
    void postPerson() {
        Person person = new Person();
        person.setName("HELLO");
        personService.postPerson(person);

        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void modifyIfPersonNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty());
        Person person = new Person();
        person.setName("HELLO");
        person.setPhoneNumber("010-1111-2222");

        assertThrows(RuntimeException.class, () -> personService.putPerson(1L, person));
    }

    @Test
    void modify() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("SON")));

        personService.putPerson(1L, new Person("SON"));

        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void modifyByNameIfPersonNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("HELLO")));

        personService.putPerson(1L, new Person("HELL"));

        verify(personRepository, times(1)).save(argThat(new IsNameWillBeUpdated()));
    }

    @Test
    void delete() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("SSON")));

        personService.deletePerson(1L);

//        verify(personRepository, times(2)).save(any(Person.class));
    }

    private static class IsNameWillBeUpdated implements ArgumentMatcher<Person> {
        @Override
        public boolean matches(Person person) {
            return person.getName().equals("HELL");
        }
    }
}