package io.github.im_jaein.duudu.service;

import io.github.im_jaein.duudu.domain.entity.Todo;
import io.github.im_jaein.duudu.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo createTodo(String content) {
        Todo todo = new Todo(content);
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
