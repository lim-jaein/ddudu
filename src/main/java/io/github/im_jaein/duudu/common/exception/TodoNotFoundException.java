package io.github.im_jaein.duudu.common.exception;

public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(Long id) {
        super("존재하지 않는 todo 입니다. (id:"+id+")");
    }

    public TodoNotFoundException(String message) {
        super(message);
    }
}
