package org.example.productservice.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ICategoryService {

    String getAllCategories();

    String getProductsInCategory(Long categoryId);
}
