package com.beyond.kkwoborrow.users.entity;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @NotNull
    @Column(name = "UserName")
    private String userName;

    @NotNull
    @Column(name = "Email")
    private String email;

    @NotNull
    @Column(name = "Password")
    private String password;

    @NotNull
    @Column(name = "UserRate")
    @ColumnDefault("5")
    private double userRate;

    @NotNull
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

        if (user.getUserType().equals("JOIN")){
            this.userType = UserType.JOIN;
        } else{
            this.userType = UserType.LEAVE;

        }
        this.address = user.getAddress();

        // TEST 미입력 값 처리
        if (user.getRateCount() == -1){
            this.rateCount = 0;
        } else {
            this.rateCount = user.getRateCount();
        }
    }
}
