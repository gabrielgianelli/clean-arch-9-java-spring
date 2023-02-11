package dev.gabrielgianelli.cleanarch9.domain.repository;

import dev.gabrielgianelli.cleanarch9.domain.model.OrderModel;

public interface OrderRepository {
    public void save(OrderModel orderModel);
}
