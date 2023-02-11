package dev.gabrielgianelli.cleanarch9.infra.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;
import dev.gabrielgianelli.cleanarch9.domain.repository.VoucherRepository;

@Component
public class VoucherRepositoryJpaAdapter implements VoucherRepository {
    @Autowired
    private JpaVoucherRepository repository;

    @Override
    public Optional<VoucherModel> findByDescription(String description) {
        return repository.findByDescription(description);
    }
}
