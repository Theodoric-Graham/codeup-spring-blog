package com.codeup.springblog.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table (name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dog_name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    private DogOwner owner;

    public Dog(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
