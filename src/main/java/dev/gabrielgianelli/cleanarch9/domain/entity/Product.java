package dev.gabrielgianelli.cleanarch9.domain.entity;

import dev.gabrielgianelli.cleanarch9.domain.model.ProductModel;

public class Product {
    private Long id;
    private String description;
    private Double price;

    public Product(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public Product(ProductModel productModel) {
        this.id = productModel.id();
        this.description = productModel.description();
        this.price = productModel.price();
    }

    public void edit(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public String description() {
        return description;
    }

    public Double price() {
        return price;
    }
}
