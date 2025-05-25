package io.github.im_jaein.duudu.dto;

import lombok.Getter;import lombok.AllArgsConstructor;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class TodoResponseDto {

    private Long id;
    private String content;
    private boolean completed;
    private LocalDateTime createdAt;
}
