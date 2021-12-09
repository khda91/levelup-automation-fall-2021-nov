package ru.levelp.at.lesson12.design.pattern.strategy;

import java.math.BigDecimal;

public class RusTaxCalculator implements TaxCalculator {

    private static final BigDecimal TAX_RATE = new BigDecimal("0.13");

    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return amount.multiply(TAX_RATE);
    }
}
