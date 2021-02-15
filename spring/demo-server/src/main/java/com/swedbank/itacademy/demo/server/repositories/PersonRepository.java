package com.swedbank.itacademy.demo.server.repositories;

import com.swedbank.itacademy.demo.server.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
