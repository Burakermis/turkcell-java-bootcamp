package com.turkcellakademi.ecommerce.business.concretes;

import com.turkcellakademi.ecommerce.business.abstracts.ProductService;
import com.turkcellakademi.ecommerce.entities.Product;
import com.turkcellakademi.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product productAdd(Product product) {
        productRepository.productAdd(product);
        return product;
    }
    @Override
    public void productDelete(int id) {
        productRepository.productDelete(id);
    }
    @Override
    public Product productUpdate(int id,Product product) {
        return productRepository.productUpdate(id,product);
    }
    @Override
    public Product getByIdProduct(int id) {
        return productRepository.getByIdProduct(id);
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    // Business rules
    private void validateProduct(Product product){
        productPrice(product);
        productQuantity(product);
        productPrice(product);
    }
    private void productPrice(Product product){
        if(product.getPrice() <= 0)
            throw new IllegalArgumentException("Price cannot be less than or equal to zero.");
    }

    private void productQuantity(Product product){
        if(product.getQuantity() < 0)
            throw new IllegalArgumentException("Quantity cannot be less than zero.");
    }

    private void productDescription(Product product){
        if(product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
    }

}
