package dev.gabrielgianelli.cleanarch9.infra.model;

import dev.gabrielgianelli.cleanarch9.domain.model.OrderItemModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item", schema = "ccca9")
public class OrderItemModelJpa implements OrderItemModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderModelJpa order;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductModelJpa product;
    private String description;
    private double price;
    private int quantity;

    public OrderItemModelJpa() {}

    public OrderItemModelJpa(OrderModelJpa order, ProductModelJpa product, String description, double price, int quantity) {
        this.order = order;
        this.product = product;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}