package com.example.restwithspring.services;

import com.example.restwithspring.exceptions.ResourceNotFoundException;
import com.example.restwithspring.model.Person;
import com.example.restwithspring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {

        logger.info("Finding all people");

        return repository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding one person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
    }

    public Person create(Person person) {

        logger.info("Creating one person!");

        Optional<Person> savedPerson = repository.findByEmail(person.getEmail());
        if (savedPerson.isPresent()){
            throw new ResourceNotFoundException(
                    String.format("Person already exist with given e-Mail: %s",person.getEmail()));
        }

        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating one person!");

        Person newPerson = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + person.getId()));

        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson.setAddress(person.getAddress());
        newPerson.setGender(person.getGender());

        return repository.save(newPerson);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        Person newPerson = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));

        repository.delete(newPerson);

    }


}
