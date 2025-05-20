package io.github.im_jaein.duudu.controller;

import io.github.im_jaein.duudu.domain.entity.Todo;
import io.github.im_jaein.duudu.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody String content) {
        Todo todo = todoService.createTodo(content);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }
}
