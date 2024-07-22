//package org.example.productservice.dtos;
//
//import jakarta.persistence.OneToMany;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.example.productservice.models.Category;
//import org.example.productservice.models.Product;
//
//import java.util.List;
//
//@Getter
//@Setter
//@ToString
//public class CategoryDto {
//    private Long id;
//    private String name;
//    private String description;
//    private List<Long> productIds;
//
//    public Category toCategory(){
//        Category category = new Category();
//        category.setId(this.getId());
//        category.setName(this.getName());
//        category.setDescription(this.getDescription());
//
//        return category;
//    }
//
//    public static CategoryDto fromCategory(Category category) {
//        ProductDto productDto = new ProductDto();
//        productDto.setId(product.getId());
//        productDto.setTitle(product.getTitle());
//        productDto.setPrice(product.getPrice());
//        productDto.setDescription(product.getDescription());
//        productDto.setImage(product.getImageUrl());
//        productDto.setCategory(product.getCategory().getName());
//        return productDto;
//    }
//}
