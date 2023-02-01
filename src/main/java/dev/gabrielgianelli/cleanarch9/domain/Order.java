package dev.gabrielgianelli.cleanarch9.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private CPF cpf;
    private List<OrderItem> orderItems;
    private Voucher voucher;

    public Order(String cpf, Voucher voucher) {
        this.cpf = new CPF(cpf);
        this.voucher = voucher;
        this.orderItems = new ArrayList<OrderItem>();
    }

    public void addItem(Product product, Integer quantity) {
        this.orderItems.add(new OrderItem(product, quantity));
    }

    public double totalValue() {
        return orderItems
            .stream()
            .map(item -> item.totalValue())
            .reduce(0.0, (total, current) -> total + current);
    }
}
