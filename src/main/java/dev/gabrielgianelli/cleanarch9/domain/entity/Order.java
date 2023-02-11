package dev.gabrielgianelli.cleanarch9.domain.entity;

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

    public Long id() {
        return id;
    }

    public CPF cpf() {
        return cpf;
    }

    public List<OrderItem> items() {
        return this.orderItems;
    }

    public void addItem(Product product, Integer quantity) {
        orderItems.add(new OrderItem(product, quantity));
    }

    public double totalValue() {
        var totalValue = orderItems
            .stream()
            .map(item -> item.totalValue())
            .reduce(0.0, (total, current) -> total + current);
        if (voucher != null) totalValue *= (100 - voucher.percentageDiscount()) / 100;
        return totalValue;
    }
}
