package com.beyond.kkwoborrow.complain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComplainsResponseDto {
    private int code;
    private String message;
    private List<ComplainResponseDto> result;
    private int page;
    private int numOfRows;
    private int totalCount;

    public ComplainsResponseDto(List<ComplainResponseDto> result, int page, int numOfRows, int totalCount) {
        this.code = 200;
        this.message = "OK";
        this.result = result;
        this.page = page;
        this.numOfRows = numOfRows;
        this.totalCount = totalCount;
    }
}