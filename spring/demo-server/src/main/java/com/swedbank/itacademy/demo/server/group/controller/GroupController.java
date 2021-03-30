package com.swedbank.itacademy.demo.server.group.controller;

import com.swedbank.itacademy.demo.server.group.entities.Group;
import com.swedbank.itacademy.demo.server.group.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/groups")
public class GroupController {

    private static final Logger log = LoggerFactory.getLogger(GroupController.class);
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Group>> getGroups() {
        List<Group> list = groupService.getAll();
        return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable final long id) {
        Group group = groupService.findById(id);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Group> addGroup(@RequestBody final Group group) {
        Group newGroup = groupService.save(group);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newGroup.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateGroup(@PathVariable final long id, @RequestBody final Group group) {
        Group existingGroup = groupService.findById(id);
        group.setId(existingGroup.getId());
        groupService.update(group);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable final long id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllGroups() {
        groupService.deleteAll();
        return ResponseEntity.ok().build();
    }

}
