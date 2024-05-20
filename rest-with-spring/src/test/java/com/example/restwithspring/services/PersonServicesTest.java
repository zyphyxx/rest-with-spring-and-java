package com.example.restwithspring.services;

import com.example.restwithspring.model.Person;
import com.example.restwithspring.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonServices services;

    private Person person0;
    private Person person1;

    @BeforeEach
    void setUp() {
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

    @DisplayName("JUnit test for Given Person Object when Save Person then Return Person Object")
    @Test
    void testGivenPersonObject_WhenSavePerson_thenReturnPersonObject() {
        // Given
        // When
        when(repository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(repository.save(person0)).thenReturn(person0);

        Person savedPerson = services.create(person0);
        // Then
        assertNotNull(savedPerson);
        assertEquals("Edgar", savedPerson.getFirstName());

    }
}