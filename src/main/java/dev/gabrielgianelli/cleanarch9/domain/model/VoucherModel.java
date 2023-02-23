package dev.gabrielgianelli.cleanarch9.domain.model;

import java.time.LocalDate;

public interface VoucherModel {
    Long id();
    String description();
    double percentageDiscount();
    LocalDate expirationDate();
}
