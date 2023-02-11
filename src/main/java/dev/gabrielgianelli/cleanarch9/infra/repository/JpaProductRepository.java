package dev.gabrielgianelli.cleanarch9.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype. Repository;

import dev.gabrielgianelli.cleanarch9.infra.model.ProductModelJpa;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductModelJpa, Long> {
    Optional<ProductModelJpa> findById(Long id);
}
