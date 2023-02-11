package dev.gabrielgianelli.cleanarch9.infra.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import dev.gabrielgianelli.cleanarch9.domain.model.ProductModel;
import dev.gabrielgianelli.cleanarch9.domain.repository.ProductRepository;

@Component
public class ProductRepositoryJpaAdapter implements ProductRepository {
    @Autowired
    private JpaProductRepository repository;
    private Pageable pageable;

    public ProductRepositoryJpaAdapter() {
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    @Override
    public Optional<ProductModel> findById(Long id) {
        var productModelJpa = repository.findById(id);
        return productModelJpa.map(ProductModel.class::cast);   
    }
}