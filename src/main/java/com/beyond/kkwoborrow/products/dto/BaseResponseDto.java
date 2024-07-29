package com.beyond.kkwoborrow.products.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class BaseResponseDto<T> {
    @Schema(description = "응답 코드", example = "200")
    private int code;

    @Schema(description = "응답 메시지", example = "OK")
    private String message;

    @Schema(description = "응답 데이터")
    private List<T> result;

    public BaseResponseDto(HttpStatus status, List<T> result) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
        this.result = result;
    }
}
