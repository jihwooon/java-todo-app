package com.example.javatodoapp.application.dto;

import com.example.javatodoapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getTodos() {
        List<TodoResponse> todoResponses = todoService.getTodos();
        return ResponseEntity.ok(todoResponses);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> saveTodo(@RequestBody TodoRequest request) {
         TodoResponse todoResponse = todoService.saveTodo(request);
         return ResponseEntity.status(HttpStatus.CREATED).body(todoResponse);
    }

}
