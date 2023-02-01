package dev.gabrielgianelli.cleanarch9.unit;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dev.gabrielgianelli.cleanarch9.domain.Order;
import dev.gabrielgianelli.cleanarch9.domain.Product;
import dev.gabrielgianelli.cleanarch9.domain.Voucher;

public class OrderTests {
    @Test
    public void shouldBeAbleToMakeAnOrderWith3items() {
        var order = new Order("892.078.830-82", null);
        order.addItem(new Product("PlayStation 5", 4300.00), 1);
        order.addItem(new Product("Nintendo Switch", 2300.00), 2);
        order.addItem(new Product("PC Gamer", 7500.00), 1);
        var totalValue = order.totalValue();
        var expectedTotalValue = 16400.00;
        assertEquals(totalValue, expectedTotalValue);
    }

    @Test
    public void shouldBeAbleToMakeAnOrderWithDiscountVoucher() {
        var voucher = new Voucher("QUINZE%", 15.00);
        var order = new Order("892.078.830-82", voucher);
        order.addItem(new Product("PlayStation 5", 4300.00), 1);
        order.addItem(new Product("Nintendo Switch", 2300.00), 2);
        order.addItem(new Product("PC Gamer", 7500.00), 1);
        var totalValue = order.totalValue();
        var expectedTotalValue = 13940.00;
        assertEquals(totalValue, expectedTotalValue);
    }

    @Test
    public void shouldNotBeAbleToMakeAnOrderWithInvalidCPF() {
        assertThrows(RuntimeException.class, () -> new Order("892.078.830-00", null));
    }
}
