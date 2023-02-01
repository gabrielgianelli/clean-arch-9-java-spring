package dev.gabrielgianelli.cleanarch9.domain;

public class Voucher {
    private Long id;
    private String description;
    private double discountPercentage;

    public Voucher(String description, double discountPercentage) {
        this.description = description;
        this.discountPercentage = discountPercentage;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
