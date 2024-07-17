package org.example.productservice.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryService implements ICategoryService{
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getProductsInCategory(Long categoryId) {
        return null;
    }
}
