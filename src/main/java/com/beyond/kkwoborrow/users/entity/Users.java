package com.beyond.kkwoborrow.users.entity;

import jakarta.annotation.Nonnull;

import jakarta.persistence.*;
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

    @Nonnull
    @Column(name = "UserName")
    private String userName;

    @Nonnull
    @Column(name = "Email")
    private String email;

    @Nonnull
    @Column(name = "Password")
    private String password;

    @Nonnull
    @Column(name = "UserRate")
    private double userRate;

    @Nonnull
    @Column(name = "UserType")
    private UserType userType;

    @Nonnull
    @Column(name = "Address")
    private String address;

    @Column(name = "RateCount")
    private int rateCount;
}
