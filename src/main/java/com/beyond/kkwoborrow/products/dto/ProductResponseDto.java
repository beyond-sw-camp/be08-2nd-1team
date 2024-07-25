package com.beyond.kkwoborrow.products.dto;

import com.beyond.kkwoborrow.products.entity.Products;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDto {
    private long productId;
    private String productName;
    private String location;
    private boolean available;
    private Long userId;
    private String category;
    private int price;

    public ProductResponseDto(Products product){
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.location = product.getLocation();
        this.available = product.isAvailable();
        this.userId = product.getUserId().getUserId();
        this.category = product.getCategory().name();
        this.price = product.getPrice();
    }
}