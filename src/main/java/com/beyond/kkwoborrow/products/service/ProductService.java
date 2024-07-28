package com.beyond.kkwoborrow.products.service;

import com.beyond.kkwoborrow.products.dto.ProductRequestDto;
import com.beyond.kkwoborrow.products.dto.ProductResponseDto;
import com.beyond.kkwoborrow.products.entity.Products;

import java.util.List;

public interface ProductService {
    ProductResponseDto save(ProductRequestDto newProduct);

    ProductResponseDto getProduct(Long productId);

    ProductResponseDto updateProduct(Long productId, ProductRequestDto updateProduct);

    void deleteProduct(Long productId);

    List<Products> getProducts();
}
