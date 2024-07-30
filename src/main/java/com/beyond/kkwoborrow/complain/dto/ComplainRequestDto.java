package com.beyond.kkwoborrow.complain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplainRequestDto {
    @Schema(description = "post_id", example = "1")
    private Long userId;
}
