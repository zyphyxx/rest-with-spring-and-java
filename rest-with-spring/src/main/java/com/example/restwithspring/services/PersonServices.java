package com.example.restwithspring.services;

import com.example.restwithspring.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    private final AtomicLong counter = new AtomicLong();

    public List<Person> findAll () {

        logger.info("Finding all people");
        List<Person> persons = new ArrayList<>();
        for (int i =0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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

    public Person create (Person person) {

        logger.info("Creating one person!");

        Person newPerson = new Person(
                counter.incrementAndGet(),
                "Person name " + person.getFirstName(),
                "Last name " + person.getLastName(),
                "Some address in Brasil " + person.getAddress(),
                "Male");

        return newPerson;
    }

    public Person update (Person person) {

        logger.info("Updating one person!");

        Person newPerson = new Person(
                counter.incrementAndGet(),
                "Person name " + person.getFirstName(),
                "Last name " + person.getLastName(),
                "Some address in Brasil " + person.getAddress(),
                "Male");

        return newPerson;
    }

    private Person mockPerson(int i) {

        Person person = new Person(
                counter.incrementAndGet(),
                "Person name " + i,
                "Last name " + i,
                "Some address in Brasil " + i,
                "Male");

        return person;
    }

    public void delete (String id) {

        logger.info("Deleting one person!");

    }
}
