package io.github.im_jaein.duudu.service;

import io.github.im_jaein.duudu.common.exception.TodoNotFoundException;
import io.github.im_jaein.duudu.domain.entity.Todo;
import io.github.im_jaein.duudu.dto.TodoRequestDto;
import io.github.im_jaein.duudu.dto.TodoResponseDto;
import io.github.im_jaein.duudu.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto.getContent());
        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(
                savedTodo.getId(),
                savedTodo.getContent(),
                savedTodo.isCompleted(),
                savedTodo.getCreatedAt()
        );
    }

    public List<TodoResponseDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoResponseDto(
                        todo.getId(),
                        todo.getContent(),
                        todo.isCompleted(),
                        todo.getCreatedAt()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void completeTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todo.complete();
    }

    public void deleteTodo(Long id) {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
    }
}
