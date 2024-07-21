package com.beyond.kkwoborrow.products.model.vo;

import com.beyond.kkwoborrow.users.model.vo.Users;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Products {
    @Id
    @Column(name = "ProductID")
    private int productId;
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
