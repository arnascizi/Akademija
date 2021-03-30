package com.swedbank.itacademy.demo.server.group.services;

import com.swedbank.itacademy.demo.server.group.entities.Group;
import com.swedbank.itacademy.demo.server.group.exception.GroupExistsException;
import com.swedbank.itacademy.demo.server.group.exception.GroupNotFoundException;
import com.swedbank.itacademy.demo.server.group.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    public GroupServiceImpl(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAll() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }

    @Override
    public Group findById(Long id) throws GroupNotFoundException {
        Group group = groupRepository.findById(id).orElseThrow(() -> new GroupNotFoundException(id));
        return group;
    }

    @Override
    public Group save(Group group) throws GroupExistsException {
        Optional<Group> oldGroup = groupRepository.findById(group.getId());
        if (oldGroup.isPresent()) {
            throw new GroupExistsException(oldGroup.toString());
        }

        return groupRepository.save(group);
    }

    @Override
    public void update(Group group) {

        groupRepository.save(group);
    }

    @Override
    public void delete(long id) throws GroupNotFoundException {

        Optional<Group> group = groupRepository.findById(id);
        if (group.isPresent()) {
            groupRepository.deleteById(id);
        } else {
            throw new GroupNotFoundException(id);
        }

    }

    @Override
    public void deleteAll() {
        groupRepository.deleteAll();
    }

    @Override
    public void saveAndFlush(Group group) {
        groupRepository.saveAndFlush(group);
    }
}
