package com.example.exerciseschool.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be null")
    @Column(columnDefinition = "varchar(255) not null")
    private String name;
    @NotNull(message = "age should not be null")
    @Positive(message = "age should be number")
    @Column(columnDefinition = "int not null check(age>0)")
    private Integer age;
    @NotEmpty(message = "major should not be null")
    @Column(columnDefinition = "varchar(255) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course>courses;
}
