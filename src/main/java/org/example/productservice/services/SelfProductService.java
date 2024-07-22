package org.example.productservice.services;

import org.example.productservice.exceptions.NotFoundException;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.example.productservice.repositories.CategoryRepository;
import org.example.productservice.repositories.ProductRepository;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SelfProductService implements IProductService{
    private static final Logger logger = LoggerFactory.getLogger(SelfProductService.class);
    private ProductRepository productRepository ;
    private CategoryRepository categoryRepository ;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository ){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private Category getOrSetCategory(Category category){
        // Ensure the category is saved or retrieved from the repository
        if (category != null) {
            Category savedCategory = categoryRepository.findByName(category.getName())
                    .orElseGet(() -> categoryRepository.save(category));
            return savedCategory;

        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product addProduct(Product product) {
        product.setCategory(getOrSetCategory(product.getCategory()));

        return productRepository.save(product);
    }



    @Override
    public Product updateProduct(Long productId, Product product) throws NotFoundException {
        product.setCategory(getOrSetCategory(product.getCategory()));

        Optional<Product> existingProductOptional = getSingleProduct(productId);
        if(existingProductOptional.isEmpty()){
            throw new NotFoundException("Product with id "+ productId+" not found.");
        }

        Product existingProduct = existingProductOptional.get();
        // Update only the fields that are present in the updatedProduct
        if (product.getId() != null) {
            existingProduct.setId(productId);
            }
        if (product.getImageUrl() != null) {
            existingProduct.setImageUrl(product.getImageUrl());
        }
        if (product.getTitle() != null) {
            existingProduct.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getCategory() != null) {
            existingProduct.setCategory(product.getCategory());
        }
        // Save updated product
        return productRepository.save(existingProduct);

    }

    @Override
    public Product replaceProduct(Long productId, Product product) throws NotFoundException {
        product.setCategory(getOrSetCategory(product.getCategory()));

        Optional<Product> existingProductOptional = getSingleProduct(productId);
        if(existingProductOptional.isEmpty()){
            throw new NotFoundException("Product with id "+ productId+" not found.");
        }

        Product existingProduct = existingProductOptional.get();
        // Update fields
        existingProduct.setId(productId);
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());

        // Save updated product
        return productRepository.save(existingProduct);

    }

    @Override
    public Product deleteProduct(Long productId) throws NotFoundException {
        Optional<Product> existingProductOptional = getSingleProduct(productId);
        if(existingProductOptional.isEmpty()){
            throw new NotFoundException("Product with id "+ productId+" not found.");
        }

        productRepository.deleteById(productId);
        return existingProductOptional.get();
    }
}
