package dev.gabrielgianelli.cleanarch9.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CPF {
    private String value;
    private final int digitsCount = 11;

    public CPF(String value) {
        if (!isValid(value)) throw new RuntimeException("Invalid CPF");
        this.value = sanitize(value);
    }
    
    public String getValue() {
        return this.value;
    }
    
    private Boolean isValid(String rawCPF) {
        if (rawCPF == null) return false;
        var cpf = sanitize(rawCPF);
        if (cpf.length() != digitsCount) return false;
        if(isOnlyARepeatedNumber(cpf)) return false;
        var partialCpf = cpf.substring(0, cpf.length() - 2);
        var firstCalculatedCheckDigit = nextDigit(partialCpf);
        var secondCalculatedCheckDigit = nextDigit(partialCpf + "" + firstCalculatedCheckDigit);
        var calculatedCheckDigits = firstCalculatedCheckDigit + "" + secondCalculatedCheckDigit;
        var receivedCheckDigits = cpf.substring(cpf.length() - 2, cpf.length());
        return receivedCheckDigits.equals(calculatedCheckDigits);
    }
    
    private String sanitize(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }
    
    private Boolean isOnlyARepeatedNumber(String cpf) {
        var firstDigit = cpf.substring(0, 1);
        for (var digit : cpf.split("")) {
            if (digit != firstDigit) return false;
        }
        return true;
    }

    private int nextDigit(String partialCpf) {
        var digits = partialCpf.chars()
            .filter(Character::isDigit)
            .map(Character::getNumericValue)
            .boxed()
            .collect(Collectors.toList());
        var digitsTotal = IntStream.range(0, digits.size())
            .map(index -> (digits.size() + 2 - (index + 1)) * digits.get(index))
            .sum();
        var remainder = digitsTotal % this.digitsCount;
        return remainder < 2 ? 0 : this.digitsCount - remainder;
    }
}
