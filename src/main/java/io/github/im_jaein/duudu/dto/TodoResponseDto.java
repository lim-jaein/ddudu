package io.github.im_jaein.duudu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;import lombok.AllArgsConstructor;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@Schema(description = "todo 응답 DTO")
public class TodoResponseDto {

    @Schema(description = "todo ID", example = "1")
    private Long id;

    @Schema(description = "todo 내용", example = "운동 하기")
    private String content;

    @Schema(description = "todo 완료 여부", example = "false")
    private boolean completed;

    @Schema(description = "todo 생성 시간", example = "2025-05-25 15:49:32")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
