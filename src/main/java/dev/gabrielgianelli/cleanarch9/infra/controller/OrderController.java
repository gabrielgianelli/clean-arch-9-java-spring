package dev.gabrielgianelli.cleanarch9.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.gabrielgianelli.cleanarch9.application.dto.OrderDetailDTO;
import dev.gabrielgianelli.cleanarch9.application.dto.PlaceOrderDTO;
import dev.gabrielgianelli.cleanarch9.application.useCase.PlaceOrder;
import dev.gabrielgianelli.cleanarch9.infra.model.OrderModelJpa;
import dev.gabrielgianelli.cleanarch9.infra.repository.OrderRepositoryJpaAdapter;
import dev.gabrielgianelli.cleanarch9.infra.repository.ProductRepositoryJpaAdapter;
import dev.gabrielgianelli.cleanarch9.infra.repository.VoucherRepositoryJpaAdapter;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private VoucherRepositoryJpaAdapter voucherRepository;
    @Autowired
    private ProductRepositoryJpaAdapter productRepository;
    @Autowired
    private OrderRepositoryJpaAdapter orderRepository;
    @Autowired
    private OrderModelJpa orderModel;

    @PostMapping
    @Transactional
    public ResponseEntity<OrderDetailDTO> place(
            @RequestBody PlaceOrderDTO placeOrderDTO,
            UriComponentsBuilder uriBuilder,
            @PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {
        var placeOrder = new PlaceOrder(placeOrderDTO, voucherRepository, productRepository, orderRepository, orderModel);
        var orderDetail = placeOrder.execute();
        var uri = uriBuilder.path("/orders/{id}").buildAndExpand(orderDetail.id()).toUri();
        return ResponseEntity.created(uri).body(orderDetail);
    }
}
