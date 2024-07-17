package org.example.productservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.productservice.clients.fakestoreapi.FakeStoreProductDto;
import org.example.productservice.exceptions.NotFoundException;
import org.example.productservice.models.Product;
import org.example.productservice.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("")
    private ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(),
                HttpStatus.OK);
        return response;
    }

    @GetMapping("/{productId}")
    private ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException{
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token", "ajdnfybfeee876668");

        Optional<Product> product = productService.getSingleProduct(productId);
        if(product.isEmpty()){
            logger.error("Product with id {} not found.", productId);
            throw new NotFoundException("Product with id "+ productId+" not found.");
        }
        ResponseEntity<Product> response = new ResponseEntity<>(
                product.get(),
                headers,
                HttpStatus.OK);

        return response;

    }

    @PostMapping("")
    private ResponseEntity<Product> addProduct(@RequestBody FakeStoreProductDto fakeStoreProductDto) {
        Product product =  fakeStoreProductDto.toProduct();
        Product addedProduct = productService.addProduct(product);
        logger.info("Added new product: {}", addedProduct);

        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);

    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId,
                                 @RequestBody FakeStoreProductDto fakeStoreProductDto) {
        Product product =  fakeStoreProductDto.toProduct();

        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.updateProduct(productId, product),
                HttpStatus.OK);

        return response;


    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("productId") Long productId,
                                 @RequestBody FakeStoreProductDto fakeStoreProductDto) {
        Product product =  fakeStoreProductDto.toProduct();

        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.replaceProduct(productId, product),
                HttpStatus.OK);

        return response;
    }


    @DeleteMapping("/{productId}")
    private ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId){

        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.deleteProduct(productId),
                HttpStatus.OK);

        return response;
    }


}
