package org.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private Double price;
    // 1 product can have 1 category and 1 category can have multiple products
    // P : C is m:1 cardinatly
    @ManyToOne
    private Category category;
    private String imageUrl;
}
