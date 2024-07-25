package com.beyond.kkwoborrow.products.controller;

import com.beyond.kkwoborrow.products.dto.ProductRequestDto;
import com.beyond.kkwoborrow.products.dto.ProductResponseDto;
import com.beyond.kkwoborrow.products.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Products APIs", description = "제품 관련 API 목록")
public class ProductController {
    @Autowired
    ProductService productService;

    // 재품 등록
    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> enroll(@RequestBody ProductRequestDto newProduct){
        ProductResponseDto productResponseDto = productService.save(newProduct);
        if (productResponseDto != null){
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 제품 정보 불러오기
    @GetMapping("/products/{product-id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("product-id") Long productId){
        ProductResponseDto productResponseDto = productService.getProduct(productId);
        if (productResponseDto != null){
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 제품 목록 불러오기


    // 제품 정보 수정
    @PatchMapping("/products/{product-id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("product-id") Long productId, @RequestBody ProductRequestDto updateProduct){
        ProductResponseDto productResponseDto = productService.updateProduct(productId, updateProduct);
        if (productResponseDto != null){
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 제품 정보 삭제
    @DeleteMapping("/products/{product-id}")
    public void deleteUser(@PathVariable("product-id") Long productId) {
        productService.deleteProduct(productId);
    }

}
