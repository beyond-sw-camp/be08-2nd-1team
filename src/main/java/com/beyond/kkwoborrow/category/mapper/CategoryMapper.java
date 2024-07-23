package com.beyond.kkwoborrow.category.mapper;

import com.beyond.kkwoborrow.category.dto.CategoryDto;
import com.beyond.kkwoborrow.category.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDTO);
}
