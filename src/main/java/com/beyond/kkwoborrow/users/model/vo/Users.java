package com.beyond.kkwoborrow.users.model.vo;

import jakarta.annotation.Nonnull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
public class Users {
    @Id
    @Column(name = "UserID")
    private int userId;
    @Nonnull
    @Column(name = "UserName")
    private String userName;
    @Nonnull
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
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
