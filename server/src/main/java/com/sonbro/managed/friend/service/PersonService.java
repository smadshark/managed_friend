package com.sonbro.managed.friend.service;

import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> getPeopleByMonthOfBirthday(int monthOfBirthday) {
        return personRepository.findByMonthOfBirthday(monthOfBirthday);
    }

    public List<Person> getPeopleByRangeOfBirthday(int monthOfBirthday, int startDayOfBirthday, int endDayOfBirthday) {
        return personRepository.findByRangeOfBirthday(monthOfBirthday, startDayOfBirthday, endDayOfBirthday);
    }

    public Person getPerson(Long id) {
        // No value present : 값이 없을때에 대한 로직 필요
        // Person person = personRepository.findById(id).get(); (get 은 optional)
        return personRepository.findById(id).orElse(null);
    }

    @Transactional
    public void postPerson(Person person) {
        Person newPerson = new Person();
        newPerson.setName(person.getName())
                .setBirthday(person.getBirthday())
                .setPhoneNumber(person.getPhoneNumber());

        personRepository.save(newPerson);
    }

    @Transactional
    public void putPerson(Long id, Person person) {
        Person selectedPerson = personRepository.findById(id).orElseThrow(() -> new RuntimeException("No ID"));

        selectedPerson
                .setName(person.getName())
                .setPhoneNumber(person.getPhoneNumber());

        personRepository.save(selectedPerson);
    }

    public void deletePerson(Long id) {
        Person selectedPerson = personRepository.findById(id).orElseThrow(() -> new RuntimeException("No ID"));
        personRepository.delete(selectedPerson);

    }
}
