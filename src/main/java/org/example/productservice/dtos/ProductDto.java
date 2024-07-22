package org.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productservice.clients.fakestoreapi.FakeStoreProductDto;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;

@Getter
@Setter
@ToString
public class ProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setPrice(this.getPrice());
        Category category = new Category();
        category.setName(this.getCategory());
        product.setCategory(category);
        product.setImageUrl(this.getImage());
        return product;
    }

    public static ProductDto fromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImageUrl());
        productDto.setCategory(product.getCategory().getName());
        return productDto;
    }
}
