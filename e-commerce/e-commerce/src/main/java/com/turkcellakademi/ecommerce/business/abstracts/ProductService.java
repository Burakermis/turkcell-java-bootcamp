package com.turkcellakademi.ecommerce.business.abstracts;

import com.turkcellakademi.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {
    Product productAdd(Product product);
    void productDelete(int id);
    Product productUpdate(int id,Product product);
    Product getByIdProduct(int id);
    List<Product> getAllProducts();
}
