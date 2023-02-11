package dev.gabrielgianelli.cleanarch9.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;
import dev.gabrielgianelli.cleanarch9.infra.model.VoucherModelJpa;

@Repository
public interface JpaVoucherRepository extends JpaRepository<VoucherModelJpa, Long> {
    Optional<VoucherModel> findByDescription(String description);
}
