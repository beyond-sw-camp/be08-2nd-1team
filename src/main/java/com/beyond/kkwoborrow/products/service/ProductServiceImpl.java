package com.beyond.kkwoborrow.products.service;

import com.beyond.kkwoborrow.products.dto.ProductRequestDto;
import com.beyond.kkwoborrow.products.dto.ProductResponseDto;
import com.beyond.kkwoborrow.products.entity.Products;
import com.beyond.kkwoborrow.products.repository.ProductRepository;
import com.beyond.kkwoborrow.users.entity.UserType;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ProductResponseDto save(ProductRequestDto product) {
        Products newProduct = new Products(product);
        // user 찾아서 넣어 주기
        Optional<Users> exitUser = userRepository.findByUserIdAndUserTypeNot(product.getUserId(), UserType.LEAVE);

        if (exitUser.isPresent()) {
            newProduct.setUserId(exitUser.get());
            productRepository.save(newProduct);
            return new ProductResponseDto(newProduct);
        } else {
            return null;
        }

    }

    @Override
    public ProductResponseDto getProduct(Long productId) {
        Optional<Products> product = productRepository.findById(productId);

        return product.map(ProductResponseDto::new).orElse(null);
    }

    @Override
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto productInfo) {
        Optional<Products> updateProduct = productRepository.findById(productId);

        if (updateProduct.isPresent()) {
            updateProduct.get().setProductRequestDto(productInfo);

            Optional<Users> user = userRepository.findByUserIdAndUserTypeNot(productInfo.getUserId(), UserType.LEAVE);
            user.ifPresent(users -> updateProduct.get().setUserId(users));

            productRepository.save(updateProduct.get());

            return new ProductResponseDto(updateProduct.get());
        }
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Products> getProducts() {
        return productRepository.findAll();
    }
}
