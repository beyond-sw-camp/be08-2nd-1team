package com.beyond.kkwoborrow.products.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long productId;

    @Nonnull
    @Column(name = "ProductName")
    private String productName;

    @Nonnull
    @Column(name = "Location")
    private String location;

    @Nonnull
    @Column(name = "Available")
    private boolean available;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users userId;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category categoryId;

    @Nonnull
    @Column(name = "Price")
    private int price;
}
