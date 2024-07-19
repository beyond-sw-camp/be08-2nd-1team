package com.beyond.kkwoborrow.products.model.vo;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    private int categoryId;
    @Nonnull
    private String categoryName;
}
