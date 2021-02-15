package com.swedbank.itacademy.demo.server.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
}
