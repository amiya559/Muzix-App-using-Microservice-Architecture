package com.amiya.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 20, min = 1)
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    @Size(max = 4, min = 4)
    private String yearOfBirth;

    @Column
    private String preferredLanguage;

    @Column
    private String preferredGenre;


}
