package org.example.productservice.controllers;

import org.example.productservice.services.ICategoryService;
import org.example.productservice.services.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping("")
    private String getAllCategories(){
        return "Get All Categories";
    }
    @GetMapping("/{categoryId}")
    private String getProductsInCategory(@PathVariable("categoryId") Long categoryId){
        return "Get products in a specific category";
    }
}
