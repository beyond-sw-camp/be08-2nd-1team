package com.beyond.kkwoborrow.users.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private long userId;

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
    private double userRate;

    @NotNull
    @Column(name = "UserType")
    private UserType userType;

    @NotNull
    @Column(name = "Address")
    private String address;

    @Column(name = "RateCount")
    private int rateCount;
}
