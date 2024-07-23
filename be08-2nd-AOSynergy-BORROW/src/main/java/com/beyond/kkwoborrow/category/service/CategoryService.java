package com.beyond.kkwoborrow.category.service;

import com.beyond.kkwoborrow.category.dto.CategoryDto;
import com.beyond.kkwoborrow.category.entity.Category;

import com.beyond.kkwoborrow.category.Repository.CategoryRepository;

import com.beyond.kkwoborrow.category.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(CategoryMapper.INSTANCE::toDto).orElse(null);
    }

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toDto(savedCategory);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
