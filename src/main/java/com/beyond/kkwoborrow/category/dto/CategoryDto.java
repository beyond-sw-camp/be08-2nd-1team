package com.beyond.kkwoborrow.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private long categoryId;

    @NotNull
    private String categoryName;
}
