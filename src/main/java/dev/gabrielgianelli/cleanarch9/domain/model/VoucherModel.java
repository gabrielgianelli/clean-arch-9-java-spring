package dev.gabrielgianelli.cleanarch9.domain.model;

public interface VoucherModel {
    Long id();
    String description();
    double percentageDiscount();
}
