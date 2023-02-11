package dev.gabrielgianelli.cleanarch9.application.dto;

import java.util.List;

import dev.gabrielgianelli.cleanarch9.domain.entity.CPF;
import dev.gabrielgianelli.cleanarch9.domain.entity.Order;

public record OrderDetailDTO(Long id, CPF cpf, List<OrderItemDetailDTO> orderItems) {
    public OrderDetailDTO(Order order, List<OrderItemDetailDTO> items) {
        this(order.id(), order.cpf(), items);
    }
}
