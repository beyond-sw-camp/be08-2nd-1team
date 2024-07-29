package com.beyond.kkwoborrow.products.dto;

import com.beyond.kkwoborrow.users.entity.Users;
import lombok.Getter;

@Getter
public class ProductRequestDto {
    private String productName;
    private String location;
    private boolean available;
    private Long userId;
    private String category;
    private int price;
}
