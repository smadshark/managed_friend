package com.sonbro.managed.friend.controller;

import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/person")
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PutMapping("{id}")
    public void putPerson(@PathVariable Long id, @RequestBody Person person) {
        personService.putPerson(id, person);
    }
}
