package com.beyond.kkwoborrow.entity;

import jakarta.persistence.*;
// 이거 스프링워크에서 받아와야할 거같기는한데...
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @lombok.Setter
    @lombok.Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "CategoryName", nullable = false)
    private String categoryName;

    // Getters and Setters

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
