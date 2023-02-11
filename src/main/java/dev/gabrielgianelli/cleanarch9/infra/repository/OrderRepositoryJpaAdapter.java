package dev.gabrielgianelli.cleanarch9.infra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.gabrielgianelli.cleanarch9.domain.model.OrderModel;
import dev.gabrielgianelli.cleanarch9.domain.repository.OrderRepository;
import dev.gabrielgianelli.cleanarch9.infra.model.OrderModelJpa;

@Component
public class OrderRepositoryJpaAdapter implements OrderRepository {
    @Autowired
    private JpaOrderRepository repository;

    public OrderRepositoryJpaAdapter() {
    }

    @Override
    public void save(OrderModel orderModel) {
        repository.save((OrderModelJpa) orderModel);
    }
}
