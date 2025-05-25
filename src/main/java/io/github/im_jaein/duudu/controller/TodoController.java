package io.github.im_jaein.duudu.controller;

import io.github.im_jaein.duudu.dto.TodoRequestDto;
import io.github.im_jaein.duudu.dto.TodoResponseDto;
import io.github.im_jaein.duudu.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto requestDto) {
        TodoResponseDto todo = todoService.createTodo(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAllTodos() {
        List<TodoResponseDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }
}
