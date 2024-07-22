package org.example.productservice.services;

import org.example.productservice.exceptions.NotFoundException;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> getAllCategories();
//
//    Optional<Category> getCategory(Long categoryId);
//
//    Category addCategory(Category category);
//    Category updateCategory(Long categoryId, Category category);
//
//    Category deleteCategory(Long categoryId);
//
    List<Product> getProductsInCategory(String categoryName) throws NotFoundException;

    Category addCategory(Category category);
}
