package dev.gabrielgianelli.cleanarch9.domain.entity;

import java.time.LocalDate;

import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;

public class Voucher {
    private Long id;
    private String description;
    private double percentageDiscount;
    private LocalDate expirationDate;

    public Voucher(String description, double percentageDiscount, LocalDate expirationDate) {
        this.description = description;
        this.percentageDiscount = percentageDiscount;
        this.expirationDate = expirationDate;
    }

    public Voucher(VoucherModel voucherModel) {
        this.description = voucherModel.description();
        this.percentageDiscount = voucherModel.percentageDiscount();
        this.expirationDate = voucherModel.expirationDate();
    }

    public String description() {
        return description;
    }

    public double percentageDiscount() {
        return percentageDiscount;
    }

    public LocalDate expirationDate() {
        return expirationDate;
    }
}
