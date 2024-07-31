package com.beyond.kkwoborrow.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

    private String userName;
    private String password;
    private String email;
    private double userRate;
    private String userType;
    private String address;
    private int rateCount;

}
