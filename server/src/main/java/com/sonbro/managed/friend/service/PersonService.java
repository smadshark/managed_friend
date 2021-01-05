package com.sonbro.managed.friend.service;

import com.sonbro.managed.friend.domain.Block;
import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.repository.BlockRepository;
import com.sonbro.managed.friend.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks() {
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> getPersonByBloodType(String bloodType) {
        return personRepository.findByBloodType(bloodType);
    }

    public List<Person> getPeopleByMonthOfBirthday(int monthOfBirthday) {
        return personRepository.findByMonthOfBirthday(monthOfBirthday);
    }

    public List<Person> getPeopleByRangeOfBirthday(int monthOfBirthday, int startDayOfBirthday, int endDayOfBirthday) {
        return personRepository.findByRangeOfBirthday(monthOfBirthday, startDayOfBirthday, endDayOfBirthday);
    }
}
