package com.beyond.kkwoborrow.complain.dto;

import com.beyond.kkwoborrow.complain.entity.Complain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplainResponseDto {
    private long complainID;
    private Long userId;

    public ComplainResponseDto(Complain complain) {
        this.complainID = complain.getComplainID();
        this.userId = complain.getUserID().getUserId();
    }
}
