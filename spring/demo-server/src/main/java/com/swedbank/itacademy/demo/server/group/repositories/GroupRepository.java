package com.swedbank.itacademy.demo.server.group.repositories;

import com.swedbank.itacademy.demo.server.group.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
