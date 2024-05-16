package com.example.restwithspring.controllers;

import com.example.restwithspring.model.Person;
import com.example.restwithspring.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return services.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findByID(
            @PathVariable(value = "id") Long id) {

        return services.findById(id);
    }

    @RequestMapping( method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {

        return services.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {

        return services.update(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void delete(
            @PathVariable(value = "id") Long id) {

        services.delete(id);
    }
}
