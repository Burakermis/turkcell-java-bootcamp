package com.turkcellakademi.ecommerce.repository.concretes;

import com.turkcellakademi.ecommerce.entities.Product;
import com.turkcellakademi.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    List<Product> products ;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(0,"Iphone 11","Telefon",5,17000));
        products.add(new Product(1,"Samsung S22","Akıllı telefon",2,30000));
    }

    @Override
    public Product productAdd(Product product) {
        products.add(product);
        return product;
    }
    @Override
    public void productDelete(int id) {
        products.remove(id);
    }

    @Override
    public Product productUpdate(int id,Product product) {
       products.set(id,product);
       return product;
    }

    @Override
    public Product getByIdProduct(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
