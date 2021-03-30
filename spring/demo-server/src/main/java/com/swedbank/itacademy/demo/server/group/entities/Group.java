package com.swedbank.itacademy.demo.server.group.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swedbank.itacademy.demo.server.person.entities.Person;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"group\"")
public class Group {

    /** The id. */
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @SequenceGenerator(name = "group_generator", sequenceName = "group_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
    private long id;
    /** The name. */
    private @NonNull String name;
    /** The details. */
    private String details;
    /** The persons. */
    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;

}