package com.example.restwithspring.repositories;

import com.example.restwithspring.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    @DisplayName("Given Person Object when Save then Return Saved Person")
    @Test
    void testGivenPersonObject_WhenSave_thenReturnSavedPerson() {
        // Given
        Person person0 = new Person("Edgar", "Mendes", "Suzano - SP", "Male", "edgar@zypmail.com");
        // When
        Person savedPerson = repository.save(person0);
        // Then
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);
    }

    @DisplayName("Given Person List when findAll then Return all Person")
    @Test
    void testGivenPersonList_WhenFindingAll_thenReturnSavedPersonList() {
        // Given
        Person person0 = new Person("Edgar", "Mendes", "Suzano - SP", "Male", "edgar@zypmail.com");
        Person person1 = new Person("Leonardo", "Mendes", "Suzano - SP", "Male", "leonardo@zypmail.com");

        repository.save(person0);
        repository.save(person1);
        // When
        List<Person> personList = repository.findAll();
        // Then
        assertNotNull(personList);
        assertEquals(2, personList.size());
    }

    @DisplayName("Given Person Object when findByID then Return Saved Person")
    @Test
    void testGivenPersonObject_WhenFindByID_thenReturnSavedPersonObject() {
        // Given
        Person person0 = new Person("Edgar", "Mendes", "Suzano - SP", "Male", "edgar@zypmail.com");

        repository.save(person0);
        // When
        Person savedPerson = repository.findById(person0.getId()).get();
        // Then
        assertNotNull(savedPerson);
        assertEquals(person0.getId(),savedPerson.getId());

    }

}