package dev.gabrielgianelli.cleanarch9.domain.model;

public interface OrderModel {
    void create(String cpf, VoucherModel voucher);
    void addItem(ProductModel productModel, String description, double price, int quantity);
    void setTotalValue(double totalValue);
}
