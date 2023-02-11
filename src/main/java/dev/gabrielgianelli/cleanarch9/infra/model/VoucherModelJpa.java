package dev.gabrielgianelli.cleanarch9.infra.model;

import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "voucher", schema = "ccca9")
public class VoucherModelJpa implements VoucherModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double percentageDiscount;
    
    @Override
    public Long id() {
        return this.id;
    }
    @Override
    public String description() {
        return this.description;
    }
    @Override
    public double percentageDiscount() {
        return this.percentageDiscount;
    }
}
