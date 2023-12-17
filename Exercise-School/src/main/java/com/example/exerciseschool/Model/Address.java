package com.example.exerciseschool.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(255) not null")
    private String area;
    @Column(columnDefinition = "varchar(255) not null")
    private String street;
    @Column(columnDefinition = "varchar(255) not null")
    private String Building_number;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
