package com.turkcellakademi.ecommerce.entities;

import lombok.Data;

@Data
public class Product {
    private String name;
    private String description;
    private int ıd;
    private int quantity;
    private int price;
    public Product() {
    }

    public Product(int ıd, String name, String description, int quantity, int price) {
        this.name = name;
        this.description = description;
        this.ıd = ıd;
        this.quantity = quantity;
        this.price = price;
    }

}
