package io.github.im_jaein.duudu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "todo 등록 요청 DTO")
public class TodoRequestDto {

    @Schema(description = "todo 등록 요청 내용", example = "운동 하기")
    private String content;
}
