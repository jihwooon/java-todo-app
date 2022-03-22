package com.example.javatodoapp.service;

import com.example.javatodoapp.application.dto.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getTodos();
}
