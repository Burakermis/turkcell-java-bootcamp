package com.turkcellakademi.ecommerce.api.controllers;

import com.turkcellakademi.ecommerce.business.abstracts.ProductService;
import com.turkcellakademi.ecommerce.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Product productAdd(@RequestBody Product product){
        return productService.productAdd(product);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void productDelete(@PathVariable int id){
        productService.productDelete(id);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.productUpdate(id, product);
    }
    @GetMapping("/{id}")
    private Product getByIdProduct(@PathVariable int id){
        return productService.getByIdProduct(id);
    }

    @GetMapping
    private List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
