package com.beyond.kkwoborrow.products.repository;

import com.beyond.kkwoborrow.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
