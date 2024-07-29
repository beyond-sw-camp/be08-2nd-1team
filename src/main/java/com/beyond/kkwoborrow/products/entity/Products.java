package com.beyond.kkwoborrow.products.entity;

import com.beyond.kkwoborrow.products.dto.ProductRequestDto;
import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long productId;

    @NotNull
    @Column(name = "ProductName")
    private String productName;

    @NotNull
    @Column(name = "Location")
    private String location;

    @NotNull
    @Column(name = "Available")
    private boolean available;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users userId;

    @NotNull
    private Category category;

    @NotNull
    @Column(name = "Price")
    private int price;

    public Products(ProductRequestDto product) {
       this.setProductRequestDto(product);
    }

    public void setProductRequestDto(ProductRequestDto product){
        this.productName = product.getProductName();
        this.location = product.getProductName();
        this.available = product.isAvailable();

        switch (product.getCategory()){
            case "육아 용품":
                this.category =  Category.BABYPRODUCTS;
            case "생활 가전":
                this.category =  Category.APPLIANCES;
            case "취미 용품":
                this.category =  Category.HOBBIES;
            case "전자 제품":
                this.category =  Category.ELECTRONICS;
            case "스포츠 용품":
                this.category =  Category.SPORTS;
            case "생활 용품":
                this.category =  Category.HOUSEWARES;
            case "반려 동물 용품":
                this.category =  Category.PETSUPPLIES;
            case "여행 및 캠핑 용품":
                this.category =  Category.TRAVELGEAR;
        }

        this.price = product.getPrice();
    }
}
