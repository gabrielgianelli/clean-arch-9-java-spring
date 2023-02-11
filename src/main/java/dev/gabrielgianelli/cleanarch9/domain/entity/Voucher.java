package dev.gabrielgianelli.cleanarch9.domain.entity;

import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;

public class Voucher {
    private Long id;
    private String description;
    private double percentageDiscount;

    public Voucher(String description, double percentageDiscount) {
        this.description = description;
        this.percentageDiscount = percentageDiscount;
    }

    public Voucher(VoucherModel voucherModel) {
        this.description = voucherModel.description();
        this.percentageDiscount = voucherModel.percentageDiscount();
    }

    public String description() {
        return description;
    }

    public double percentageDiscount() {
        return percentageDiscount;
    }
}
