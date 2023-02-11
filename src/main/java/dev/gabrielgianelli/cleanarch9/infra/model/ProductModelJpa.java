package dev.gabrielgianelli.cleanarch9.infra.model;

import dev.gabrielgianelli.cleanarch9.domain.model.ProductModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product", schema = "ccca9")
public class ProductModelJpa implements ProductModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double price;

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String description() {
        return description;
    }
    
    @Override
    public Double price() {
        return price;
    }
}
