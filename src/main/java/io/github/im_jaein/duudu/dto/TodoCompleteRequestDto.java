package io.github.im_jaein.duudu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Schema(description = "todo 완료/미완료 요청 DTO")
public class TodoCompleteRequestDto {

    @Schema(description = "todo 완료 여부", example = "false")
    @NotNull(message = "완료 여부는 반드시 true/false로 지정되어야 합니다.")
    private Boolean isCompleted;

    public boolean getIsCompleted() {
        return Boolean.TRUE.equals(this.isCompleted); // null-safe
    }
}
