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


}
