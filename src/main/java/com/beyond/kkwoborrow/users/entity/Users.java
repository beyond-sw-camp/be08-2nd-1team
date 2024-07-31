package com.beyond.kkwoborrow.users.entity;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "Email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "UserRate")
    @ColumnDefault("5")
    private double userRate;

    @NotNull
//    @Convert(converter = UserTypeConverter.class)
    @Column(name = "UserType")
    private UserType userType;

    @NotNull
    @Column(name = "Address")
    private String address;

    @Column(name = "RateCount")
    @ColumnDefault("0")
    private int rateCount;

    public Users(UserRequestDto user) {
        this.setUserRequestDto(user);
    }

    public Users(String username, String encodedPassword) {
    }

    public void setUserRequestDto(UserRequestDto user){
        this.userName = user.getUserName();
        this.email = user.getEmail();

        // TODO: 암호화 처리
        this.password = user.getPassword();

        // TEST 미입력 값 처리
        if (user.getUserRate() == -1){
            this.userRate = 5;
        } else{
            this.userRate = user.getUserRate();
        }

        if (user.getUserType().equals("USER")){
            this.userType = UserType.USER;
        } else{
            this.userType = UserType.ADMIN;

        }
        this.address = user.getAddress();

        // TEST 미입력 값 처리
        if (user.getRateCount() == -1){
            this.rateCount = 0;
        } else {
            this.rateCount = user.getRateCount();
        }
    }
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
}

