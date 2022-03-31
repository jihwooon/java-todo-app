package com.example.javatodoapp.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Exclude
    private String content;

    public static Todo of(String content) {
        Todo todo = new Todo();
        todo.content = content;
        return todo;
    }

    public static Todo of(Long id, String content) {
        Todo todo = new Todo();
        todo.id = id;
        todo.content = content;
        return todo;
    }
}
