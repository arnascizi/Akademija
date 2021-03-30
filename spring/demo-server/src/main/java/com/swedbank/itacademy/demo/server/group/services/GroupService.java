package com.swedbank.itacademy.demo.server.group.services;

import com.swedbank.itacademy.demo.server.group.entities.Group;
import com.swedbank.itacademy.demo.server.group.exception.GroupExistsException;
import com.swedbank.itacademy.demo.server.group.exception.GroupNotFoundException;

import java.util.List;

public interface GroupService {
    public List<Group> getAll();
    public Group findById(Long id) throws GroupNotFoundException;
    Group save(Group group) throws GroupExistsException;
    void update(Group group);
    void delete(long id) throws GroupNotFoundException;
    void deleteAll();
    void saveAndFlush(Group group);
}
