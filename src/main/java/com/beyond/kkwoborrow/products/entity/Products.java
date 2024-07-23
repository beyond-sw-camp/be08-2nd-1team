package com.beyond.kkwoborrow.products.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long productId;

    @NotNull
    @Column(name = "ProductName")
    private String productName;

    @NotNull
    @Column(name = "Location")
    private String location;

    @NotNull
    @Column(name = "Available")
    private boolean available;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users userId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category categoryId;

    @NotNull
    @Column(name = "Price")
    private int price;
}
