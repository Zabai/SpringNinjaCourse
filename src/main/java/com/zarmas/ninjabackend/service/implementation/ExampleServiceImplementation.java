package com.zarmas.ninjabackend.service.implementation;

import com.zarmas.ninjabackend.model.Person;
import com.zarmas.ninjabackend.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImplementation implements ExampleService {
    private final Log log = LogFactory.getLog(ExampleServiceImplementation.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("General Kenobi", 34));
        personList.add(new Person("Yoda", 99));
        personList.add(new Person("Peter Parker", 24));
        personList.add(new Person("Deadpool", 32));

        log.info("HELLO FROM SERVICE");

        return personList;
    }
}
