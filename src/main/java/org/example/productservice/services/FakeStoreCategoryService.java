package org.example.productservice.services;

import org.example.productservice.exceptions.NotFoundException;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreCategoryService implements ICategoryService{
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) throws NotFoundException {
        return null;
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }
//
//    @Override
//    public Optional<Category> getCategory(Long categoryId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Category addCategory(Category category) {
//        return null;
//    }
//
//    @Override
//    public Category updateCategory(Long categoryId, Category category) {
//        return null;
//    }
//
//    @Override
//    public Category deleteCategory(Long categoryId) {
//        return null;
//    }
//
//    @Override
//    public List<Product> getProductsInCategory(Long categoryId) {
//        return null;
//    }
}
