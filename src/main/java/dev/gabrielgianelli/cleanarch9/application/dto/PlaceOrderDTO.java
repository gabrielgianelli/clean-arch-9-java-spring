package dev.gabrielgianelli.cleanarch9.application.dto;

import java.util.List;

public record PlaceOrderDTO(
    String cpf,
    String voucher,
    List<PlaceOrderItemDTO> items
) {}
