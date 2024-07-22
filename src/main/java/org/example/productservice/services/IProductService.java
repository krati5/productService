package org.example.productservice.services;

import org.example.productservice.clients.fakestoreapi.FakeStoreProductDto;
import org.example.productservice.exceptions.NotFoundException;
import org.example.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> getAllProducts();

    Optional<Product> getSingleProduct(Long productId);

    Product addProduct(Product product);

    Product updateProduct(Long productId, Product product) throws NotFoundException;

    Product replaceProduct(Long productId, Product product) throws NotFoundException;

    Product deleteProduct(Long productId) throws NotFoundException;
}