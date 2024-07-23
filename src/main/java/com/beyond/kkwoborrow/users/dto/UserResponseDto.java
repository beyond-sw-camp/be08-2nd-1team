package com.beyond.kkwoborrow.users.dto;

import com.beyond.kkwoborrow.users.entity.UserType;
import com.beyond.kkwoborrow.users.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {

    private String userName;
    private String email;
    private double userRate;
    private UserType userType;
    private String address;

    public UserResponseDto(Users user) {
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.userRate = user.getUserRate();
        this.userType = user.getUserType();
        this.address = user.getAddress();
    }
}
