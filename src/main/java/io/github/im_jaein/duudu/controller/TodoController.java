package io.github.im_jaein.duudu.controller;

import io.github.im_jaein.duudu.dto.TodoRequestDto;
import io.github.im_jaein.duudu.dto.TodoResponseDto;
import io.github.im_jaein.duudu.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
@Tag(name="DDudu", description = "todo API")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @Operation(summary = "todo 등록", description = "새로운 todo 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "등록 성공"),
            @ApiResponse(responseCode = "500", description = "서버 에러 발생")
    })
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto requestDto) {
        TodoResponseDto todo = todoService.createTodo(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @GetMapping
    @Operation(summary = "전체 todo 조회", description = "모든 todo 목록 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 에러 발생")
    })
    public ResponseEntity<List<TodoResponseDto>> getAllTodos() {
        List<TodoResponseDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }
}
