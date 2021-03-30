package com.swedbank.itacademy.demo.server.person.repositories;

import com.swedbank.itacademy.demo.server.person.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
