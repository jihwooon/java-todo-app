package com.example.javatodoapp.service;

import com.example.javatodoapp.application.dto.TodoRequest;
import com.example.javatodoapp.application.dto.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getTodos();

    TodoResponse saveTodo(TodoRequest request);

    void deleteTodo(Long id);
}
