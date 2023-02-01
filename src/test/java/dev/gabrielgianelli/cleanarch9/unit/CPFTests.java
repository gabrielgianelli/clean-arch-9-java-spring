package dev.gabrielgianelli.cleanarch9.unit;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dev.gabrielgianelli.cleanarch9.domain.CPF;

public class CPFTests {
    @Test
    public void shouldBeAbleToValidateACPF() {
        var cpf = (new CPF("892.078.830-82")).getValue();
        assertEquals(cpf, "89207883082");
        cpf = (new CPF("737.589.620-80")).getValue();
        assertEquals(cpf, "73758962080");
    }

    @Test
    public void shouldNotBeAbleToValidateCPFWhenAllDigitsAreTheSame() {
        assertThrows(RuntimeException.class, () -> new CPF("892078830820"));
    }

    @Test
    public void shouldNotBeAbleToValidateCPFWithLengthDifferentThanEleven() {
        assertThrows(RuntimeException.class, () -> new CPF("8920788308"));
    }

    @Test
    public void shouldNotBeAbleToValidateAnEmptyCPF() {
        assertThrows(RuntimeException.class, () -> new CPF(""));
        assertThrows(RuntimeException.class, () -> new CPF(null));
    };
}