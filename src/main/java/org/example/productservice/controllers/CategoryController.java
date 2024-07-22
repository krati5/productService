package org.example.productservice.controllers;

import org.example.productservice.dtos.ProductResponseDto;
import org.example.productservice.exceptions.NotFoundException;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.example.productservice.services.ICategoryService;
import org.example.productservice.services.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() throws NotFoundException {

        try {
            List<Category> categoryList = categoryService.getAllCategories();

            if(categoryList.isEmpty()){
                throw new NotFoundException("No categories found.");
            }

            logger.info("All categories: {}", categoryList);

            return new ResponseEntity<>(categoryList,
                    HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occured while adding category :{}.", e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("categoryName") String categoryName) throws NotFoundException {
        try {
            List<Product> products = categoryService.getProductsInCategory(categoryName);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occured while getting products in category :{}.", e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        try {
            Category createdCategory = categoryService.addCategory(category);
            return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occured while getting products in category :{}.", e.getMessage(), e);
            throw e;
        }
    }


//
//
//    @GetMapping("")
//    private ResponseEntity<List<Category>> getAllCategories() throws NotFoundException {
//        List<Product> categoryList = categoryService.getAllCategories();
//
//        if(categoryList.isEmpty()){
//            throw new NotFoundException("No products found.");
//        }
//        ResponseEntity<List<Product>> response = new ResponseEntity<>(categoryList,
//                HttpStatus.OK);
//        return response;
//    }
//
//    @GetMapping("/{categoryId}")
//    private ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId) throws NotFoundException{
//
//
//        Optional<Category> category = categoryService.getCategory(categoryId);
//        if(category.isEmpty()){
//            logger.error("Category with id {} not found.", categoryId);
//            throw new NotFoundException("Category with id "+ categoryId+" not found.");
//        }
//        ResponseEntity<Category> response = new ResponseEntity<>(
//                category.get(),
//                HttpStatus.OK);
//
//        return response;
//
//    }
//
//    @PostMapping("")
//    private ResponseEntity<Category> addCategory(@RequestBody ProductDto productDto) throws NotFoundException {
//        Category category =  productDto.toProduct();
//
//        try {
//            Category addedCategory = categoryService.addCategory(category);
//            logger.info("Added new category: {}", addedCategory);
//            return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
//        } catch (Exception e) {
//            logger.error("Error occured while adding category :{}.", e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @PatchMapping("/{categoryId}")
//    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Long categoryId,
//                                                 @RequestBody ProductDto productDto) throws NotFoundException {
//        Category category = productDto.toProduct();
//
//        try {
//            Category savedCategory = categoryService.updateCategory(categoryId, category);
//            return new ResponseEntity<>(savedCategory, HttpStatus.OK);
//        } catch (NotFoundException e) {
//            logger.error("Category with id {} not found.", categoryId);
//            throw e;
//        } catch (Exception e) {
//            logger.error("Error occured while updating category :{}.", e.getMessage(), e);
//            throw e;
//        }
//
//    }
//
//
//    @DeleteMapping("/{categoryId}")
//    private ResponseEntity<Category> deleteCategory(@PathVariable("categoryId") Long categoryId) throws NotFoundException {
//        try {
//            Category deletedCategory = categoryService.deleteCategory(categoryId);
//            return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
//        } catch (NotFoundException e) {
//            logger.error("Category with id {} not found.", categoryId);
//            throw e;
//        } catch (Exception e) {
//            logger.error("Error occured while deleting category :{}.", e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @GetMapping("/{categoryId}")
//    private String getProductsInCategory(@PathVariable("categoryId") Long categoryId){
//        return "Get products in a specific category";
//    }


}
