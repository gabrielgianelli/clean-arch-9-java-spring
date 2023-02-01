package dev.gabrielgianelli.cleanarch9.domain;

public class Product {
    private Long id;
    private String description;
    private Double price;

    public Product(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public void edit(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public String description() {
        return this.description;
    }

    public Double price() {
        return this.price;
    }
}
