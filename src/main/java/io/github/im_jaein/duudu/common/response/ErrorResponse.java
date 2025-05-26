package io.github.im_jaein.duudu.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private String code;
    private String message;
}
