package dev.gabrielgianelli.cleanarch9.domain.entity;

public class OrderItem {
    private Long id;
    private String description;
    private double price;
    private int quantity;

    public OrderItem(Product product, Integer quantity) {
        this.description = product.description();
        this.price = product.price();
        setQuantity(quantity);
    }

    public double totalValue() {
        return price * quantity;
    }

    private void setQuantity(int quantity) {
        if (quantity <= 0) throw new RuntimeException("Quantity cannot be less than 1");
        this.quantity = quantity;
    }

    public String description() {
        return description;
    }

    public Double price() {
        return price;
    }

    public int quantity() {
        return quantity;
    }
}
