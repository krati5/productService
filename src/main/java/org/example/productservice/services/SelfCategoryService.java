package org.example.productservice.services;

import lombok.AllArgsConstructor;
import org.example.productservice.exceptions.NotFoundException;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.example.productservice.repositories.CategoryRepository;
import org.example.productservice.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@AllArgsConstructor
public class SelfCategoryService implements ICategoryService{
    private static final Logger logger = LoggerFactory.getLogger(SelfProductService.class);
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) throws NotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        if(categoryOptional.isEmpty()){
            throw new NotFoundException("Category with name "+categoryName+" not found.");
        }
        Category category = categoryOptional.get();
        return category.getProducts();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

//    @Override
//    public List<Category> getAllCategories() {
//        return null;
//    }
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
