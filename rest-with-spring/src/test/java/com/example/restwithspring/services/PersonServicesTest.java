package com.example.restwithspring.services;

import com.example.restwithspring.exceptions.ResourceNotFoundException;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @DisplayName("JUnit test for Given Existing Email when Save Person then Return Throws Exception")
    @Test
    void testGivenExistingEmail_WhenSavePerson_thenReturnThrowException() {
        // Given
        when(repository.findByEmail(anyString())).thenReturn(Optional.of(person0));
        // When
        assertThrows(ResourceNotFoundException.class, () -> {
            services.create(person0);
        });

        // Then
        verify(repository, never()).save(any(Person.class));

    }
}