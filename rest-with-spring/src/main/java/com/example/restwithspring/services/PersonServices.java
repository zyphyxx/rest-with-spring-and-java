package com.example.restwithspring.services;

import com.example.restwithspring.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    private final AtomicLong counter = new AtomicLong();

    public Person findById (String id) {

        logger.info("Finding one person!");

        Person person = new Person(
                counter.incrementAndGet(),
                "Edgar",
                "Mendes",
                "Suzano-SP",
                "Male");

        return person;
    }
}
