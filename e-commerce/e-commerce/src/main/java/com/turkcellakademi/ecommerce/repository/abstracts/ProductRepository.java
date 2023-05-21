package com.turkcellakademi.ecommerce.repository.abstracts;

import com.turkcellakademi.ecommerce.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product productAdd(Product product);
    void productDelete(int id);
    Product productUpdate(int id, Product product);
    Product getByIdProduct(int id);
    List<Product> getAllProducts();
}
