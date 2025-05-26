package io.github.im_jaein.duudu.common.exception;

import io.github.im_jaein.duudu.common.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        // 유효성 검사 처리
        // 여러 validation 오류 중 첫 번째 메시지 만을 리턴
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getDefaultMessage())
                .orElse("잘못된 요청입니다.");

        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse("400", message));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIlligalArgument(IllegalArgumentException ex) {
        // 존재하지 않는 리소스 등의 상황
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("404", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex) {
        // 그 외 모든 예외 (500)
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("500", "서버 오류가 발생했습니다."));
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTodoNotFound(TodoNotFoundException ex) {
        // 존재하지 않는 todo
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse("400", ex.getMessage()));
    }
}
