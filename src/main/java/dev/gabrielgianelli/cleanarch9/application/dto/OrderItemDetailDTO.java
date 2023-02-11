package dev.gabrielgianelli.cleanarch9.application.dto;

import dev.gabrielgianelli.cleanarch9.domain.entity.OrderItem;

public record OrderItemDetailDTO(
    String description,
    Double price,
    int quantity
) 
{
    public OrderItemDetailDTO(OrderItem orderItem) {
        this(orderItem.description(), orderItem.price(), orderItem.quantity());
    }
}
