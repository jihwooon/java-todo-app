package com.example.javatodoapp.application.dto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class TodoResponse {
    private final Long id;
    private final String content;
}
