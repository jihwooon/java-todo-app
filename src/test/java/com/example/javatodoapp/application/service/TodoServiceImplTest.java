package com.example.javatodoapp.application.service;

import com.example.javatodoapp.application.dto.TodoRequest;
import com.example.javatodoapp.application.dto.TodoResponse;
import com.example.javatodoapp.domain.Todo;
import com.example.javatodoapp.domain.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {

    @InjectMocks
    private TodoServiceImpl todoService;

    @Mock
    private TodoRepository todoRepository;

    @BeforeEach
    public void setUp() {
        todoRepository = mock(TodoRepository.class);
        todoService = new TodoServiceImpl(todoRepository);
    }

    @Test
    public void getTodos() {
        List<Todo> todos = List.of(Todo.of(1L, "할 일"));

        when(todoRepository.findAll()).thenReturn(todos);

        List<TodoResponse> todoResponses = todoService.getTodos();

        assertThat(todoResponses).hasSize(todos.size());

        verify(todoRepository).findAll();
    }

    @Test
    public void saveTodo() {
        TodoRequest request = TodoRequest.of("할 일");
        Todo todo = Todo.of(request.getContent());

//        when(todoRepository.save(todo)).thenReturn(Todo.of(1L, request.getContent()));

        TodoResponse todoResponse = todoService.saveTodo(request);

        assertThat(todoResponse).isNotNull();
        verify(todoRepository).save(todo);
    }

    @Test
    public void deleteTodo() {
        Long id = 1L;

        todoService.deleteTodo(id);

        verify(todoRepository).deleteById(id);
    }

}
