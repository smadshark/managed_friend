package com.sonbro.managed.friend.service;

import com.sonbro.managed.friend.domain.Block;
import com.sonbro.managed.friend.domain.Person;
import com.sonbro.managed.friend.repository.BlockRepository;
import com.sonbro.managed.friend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();
        List<Block> blocks = blockRepository.findAll();
        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());

        return people.stream().filter(person -> !blockNames.contains(person.getName())).collect(Collectors.toList());
    }
}
