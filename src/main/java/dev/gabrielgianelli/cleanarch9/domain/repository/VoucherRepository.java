package dev.gabrielgianelli.cleanarch9.domain.repository;

import java.util.Optional;

import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;

public interface VoucherRepository {
    Optional<VoucherModel> findByDescription(String description);
}
