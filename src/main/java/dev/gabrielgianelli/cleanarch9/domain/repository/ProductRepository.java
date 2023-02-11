package dev.gabrielgianelli.cleanarch9.domain.repository;

import java.util.Optional;

import dev.gabrielgianelli.cleanarch9.domain.model.ProductModel;

public interface ProductRepository {
    Optional<ProductModel> findById(Long id);
}
