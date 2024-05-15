package com.example.restwithspring.repositories;

import com.example.restwithspring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long> { }
