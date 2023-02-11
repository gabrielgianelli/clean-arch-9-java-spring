package dev.gabrielgianelli.cleanarch9.application.useCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.gabrielgianelli.cleanarch9.application.dto.OrderDetailDTO;
import dev.gabrielgianelli.cleanarch9.application.dto.OrderItemDetailDTO;
import dev.gabrielgianelli.cleanarch9.application.dto.PlaceOrderDTO;
import dev.gabrielgianelli.cleanarch9.domain.entity.Order;
import dev.gabrielgianelli.cleanarch9.domain.entity.Product;
import dev.gabrielgianelli.cleanarch9.domain.entity.Voucher;
import dev.gabrielgianelli.cleanarch9.domain.model.OrderModel;
import dev.gabrielgianelli.cleanarch9.domain.model.VoucherModel;
import dev.gabrielgianelli.cleanarch9.domain.repository.OrderRepository;
import dev.gabrielgianelli.cleanarch9.domain.repository.ProductRepository;
import dev.gabrielgianelli.cleanarch9.domain.repository.VoucherRepository;

public class PlaceOrder {
    private PlaceOrderDTO input;
    private VoucherRepository voucherRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private OrderModel orderModel;

    public PlaceOrder(
        PlaceOrderDTO input,
        VoucherRepository voucherRepository,
        ProductRepository productRepository,
        OrderRepository orderRepository,
        OrderModel orderModel) 
    {
        this.input = input;
        this.voucherRepository = voucherRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderModel = orderModel;
    }

    public OrderDetailDTO execute() 
    {
        Voucher voucher = null;
        VoucherModel voucherModel = null;
        Optional<VoucherModel> findedVoucher;
        if (!input.voucher().isEmpty()) {
            findedVoucher = voucherRepository.findByDescription(input.voucher());
            if (findedVoucher.isEmpty()) throw new RuntimeException("Voucher not found.");
            voucherModel = findedVoucher.get();
            voucher = new Voucher(voucherModel);
        }
        var order = new Order(input.cpf(), voucher);
        orderModel.create(order.cpf().getValue(), voucherModel);
        addItems(order);
        orderModel.setTotalValue(order.totalValue());
        orderRepository.save(orderModel);
        return new OrderDetailDTO(order, getItemsDTO(order));
    }
    
    private void addItems(Order order) {
        for (var item : input.items()) {
            var productModel = productRepository.findById(item.productId());
            if (productModel.isEmpty()) throw new RuntimeException("Product not found.");
            var product = new Product(productModel.get());
            order.addItem(product, item.quantity());
            orderModel.addItem(productModel.get(), product.description(), product.price(), item.quantity());
        }
    }
    
    private List<OrderItemDetailDTO> getItemsDTO(Order order) {
        List<OrderItemDetailDTO> itemsDTO = new ArrayList<>();
        for (var item : order.items()) {
            itemsDTO.add(new OrderItemDetailDTO(item));
        }
        return itemsDTO;
    }
}
