package com.beyond.kkwoborrow.users.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private String userName;
    private String email;
    private String password;
    private double userRate;
    private String userType;
    private String address;
    private int rateCount;

}
