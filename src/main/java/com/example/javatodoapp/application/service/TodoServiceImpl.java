package com.example.javatodoapp.application.service;

import com.example.javatodoapp.application.dto.TodoRequest;
import com.example.javatodoapp.application.dto.TodoResponse;
import com.example.javatodoapp.domain.Todo;
import com.example.javatodoapp.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<TodoResponse> getTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> TodoResponse.of(todo.getId(), todo.getContent()))
                .collect(Collectors.toList());
    }

    @Override
    public TodoResponse saveTodo(TodoRequest request) {
        Todo saveTodo = todoRepository.save(Todo.of(request.getContent()));
        return TodoResponse.of(saveTodo.getId(), saveTodo.getContent());
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
