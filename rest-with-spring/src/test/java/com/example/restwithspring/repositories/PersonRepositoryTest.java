package com.example.restwithspring.repositories;

import com.example.restwithspring.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    private Person person0;
    private Person person1;

    @BeforeEach
    public void setup () {
        // Given
        person0 = new Person(
                "Edgar", "Mendes",
                "Suzano - SP", "Male",
                "edgar@zypmail.com");

        person1 = new Person(
                "Leonardo", "Mendes",
                "Suzano - SP", "Male",
                "leonardo@zypmail.com");
    }

    @DisplayName("Given Person Object when Save then Return Saved Person")
    @Test
    void testGivenPersonObject_WhenSave_thenReturnSavedPerson() {

        // When
        Person savedPerson = repository.save(person0);
        // Then
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);
    }

    @DisplayName("Given Person List when findAll then Return all Person")
    @Test
    void testGivenPersonList_WhenFindingAll_thenReturnSavedPersonList() {

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
        repository.save(person0);
        // When
        Person savedPerson = repository.findById(person0.getId()).get();
        // Then
        assertNotNull(savedPerson);
        assertEquals(person0.getId(),savedPerson.getId());

    }
    @DisplayName("Given Person Object when findByEmail then Return Saved Person")
    @Test
    void testGivenPersonObject_WhenFindByEmail_thenReturnSavedPersonObject() {

        // Given
        repository.save(person0);
        // When
        Person savedPerson = repository.findByEmail("edgar@zypmail.com").get();
        // Then
        assertNotNull(savedPerson);
        assertEquals(person0.getId(),savedPerson.getId());

    }
    @DisplayName("Given Person Object when Updated then Return Updated Person")
    @Test
    void testGivenPersonObject_WhenUpdatedPerson_thenReturnUpdatedPersonObject() {

        // Given
        Person updatedPerson = repository.save(person0);
        // When
        updatedPerson.setFirstName("Anny");
        updatedPerson.setEmail("anny@gmail.com");
        // Then
        assertNotNull(updatedPerson);
        assertEquals("Anny",updatedPerson.getFirstName());
        assertEquals("anny@gmail.com",updatedPerson.getEmail());

    }
    @DisplayName("Given Person Object when Delete then Return Removed Person")
    @Test
    void testGivenPersonObject_WhenDelete_thenReturnRemovedPerson() {

        // Given
        repository.save(person0);
        // When
        repository.deleteById(person0.getId());

        Optional<Person> personOptional = repository.findById(person0.getId());
        // Then
        assertTrue(personOptional.isEmpty());

    }

}