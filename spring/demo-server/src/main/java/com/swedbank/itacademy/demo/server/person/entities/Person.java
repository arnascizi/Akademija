package com.swedbank.itacademy.demo.server.person.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.swedbank.itacademy.demo.server.group.entities.Group;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@Table(name = "person")
@NoArgsConstructor
public class Person {

    @Id
    @NotNull
    private long pid;

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String surname;

    private String email;

    private String phone;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinTable(name = "person_group", joinColumns = @JoinColumn(name = "pid", referencedColumnName = "pid"), inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Group> groups;
}
