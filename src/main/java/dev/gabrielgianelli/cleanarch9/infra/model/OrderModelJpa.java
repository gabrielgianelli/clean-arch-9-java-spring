package dev.gabrielgianelli.cleanarch9.infra.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.gabrielgianelli.cleanarch9.domain.model.OrderModel;
import dev.gabrielgianelli.cleanarch9.domain.model.ProductModel;
import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "order", schema = "ccca9")
public class OrderModelJpa implements OrderModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemModelJpa> orderItems;
    @ManyToOne(fetch = FetchType.LAZY)
    private VoucherModelJpa voucher;
    private double percentageDiscount;
    private double totalValue;

    public OrderModelJpa() {}
    
    @Override
    public void create(String cpf, VoucherModel voucher) {
        this.cpf = cpf;
        this.voucher = (VoucherModelJpa) voucher;
        if (this.voucher != null) this.percentageDiscount = this.voucher.percentageDiscount();
        this.orderItems = new ArrayList<OrderItemModelJpa>();
    }

    @Override
    public void addItem(ProductModel productModel, String description, double price, int quantity) {
        var productModelJpa = (ProductModelJpa) productModel;
        var orderItemModelJpa = new OrderItemModelJpa(this, productModelJpa, description, price, quantity);
        this.orderItems.add(orderItemModelJpa);
    }

    @Override
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
