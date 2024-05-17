package com.example.restwithspring.repositories;

import com.example.restwithspring.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    @DisplayName("Given Person Object when Save then Return Saved Person")
    @Test
    void testGivenPersonObject_WhenSave_thenReturnSavedPerson() {
        // Given
        Person person0 = new Person("Edgar","Mendes","Suzano - SP","Male","edgar@zypmail.com");
        // When
        Person savedPerson = repository.save(person0);
        // Then
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);
    }

}