package com.sonbro.managed.friend.repository;

// static method simple call
import static org.assertj.core.api.Assertions.assertThat;
import com.sonbro.managed.friend.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void create() {
        Person person = new Person();
        person.setName("YOU");
        person.setAge(4);
        personRepository.save(person);
        List<Person> people = personRepository.findAll();
        assertThat(people.size()).isEqualTo(6);
        assertThat(people.get(5).getName()).isEqualTo("YOU");
        assertThat(people.get(5).getAge()).isEqualTo(4);
        System.out.println(people);
    }
}
