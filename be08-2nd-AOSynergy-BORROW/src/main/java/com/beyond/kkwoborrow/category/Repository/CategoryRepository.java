package com.beyond.kkwoborrow.category.Repository;

import com.beyond.kkwoborrow.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
