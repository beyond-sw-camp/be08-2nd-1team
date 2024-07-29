package com.beyond.kkwoborrow.products.controller;

import com.beyond.kkwoborrow.products.dto.BaseResponseDto;
import com.beyond.kkwoborrow.products.dto.ProductRequestDto;
import com.beyond.kkwoborrow.products.dto.ProductResponseDto;
import com.beyond.kkwoborrow.products.entity.Products;
import com.beyond.kkwoborrow.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Products APIs", description = "제품 관련 API 목록")
public class ProductController {
    @Autowired
    ProductService productService;

    // 제품 등록
    @PostMapping("/products")
    @Operation(summary = "제품 저장", description = "제품을 저장한다.")
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
    @Operation(summary = "특정 제품 조회", description = "특정 제품의 정보를 조회한다.")
    public ResponseEntity<ProductResponseDto> getProduct(@Parameter(description = "제품 번호", example = "1")@PathVariable("product-id") Long productId){
        ProductResponseDto productResponseDto = productService.getProduct(productId);
        if (productResponseDto != null){
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 제품 목록 불러오기
    @GetMapping("/products")
    @Operation(summary = "제품 목록 조회", description = "제품 목록을 조회한다.")
    public ResponseEntity<BaseResponseDto<Products>> getProducts(){
        List<Products> products =  productService.getProducts();
        if (!products.isEmpty()){
            return ResponseEntity.ok(new BaseResponseDto<>(HttpStatus.OK, products));
        } else{
            return ResponseEntity.ok(new BaseResponseDto<>(HttpStatus.NOT_FOUND, products));
        }

    }


    // 제품 정보 수정
    @PatchMapping("/products/{product-id}")
    @Operation(summary = "제품 정보 수정", description = "특정 제품의 정보를 수정한다.")
    public ResponseEntity<ProductResponseDto> updateProduct(@Parameter(description = "제품 번호", example = "1")@PathVariable("product-id") Long productId, @RequestBody ProductRequestDto updateProduct){
        ProductResponseDto productResponseDto = productService.updateProduct(productId, updateProduct);
        if (productResponseDto != null){
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 제품 정보 삭제
    @DeleteMapping("/products/{product-id}")
    @Operation(summary = "제품 정보 삭제", description = "특정 제품의 정보를 삭제한다.")
    public void deleteUser(@Parameter(description = "제품 번호", example = "1")@PathVariable("product-id") Long productId) {
        productService.deleteProduct(productId);
    }

}
