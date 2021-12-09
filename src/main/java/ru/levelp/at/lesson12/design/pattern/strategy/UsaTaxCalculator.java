package ru.levelp.at.lesson12.design.pattern.strategy;

import java.math.BigDecimal;

public class UsaTaxCalculator implements TaxCalculator {

    private static final BigDecimal TAX_RATE_AMOUNT_BELOW_3000 =
        new BigDecimal("0.2");
    private static final BigDecimal TAX_RATE_AMOUNT_BETWEEN_3000_5000 =
        new BigDecimal("0.3");
    private static final BigDecimal TAX_RATE_AMOUNT_ABOVE_5000 =
        new BigDecimal("0.35");

    @Override
    public BigDecimal calculate(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("3000")) > 0
        && amount.compareTo(new BigDecimal("5000")) < 0) {
            return amount.multiply(TAX_RATE_AMOUNT_BETWEEN_3000_5000);
        }

        if (amount.compareTo(new BigDecimal("5000")) > 0) {
            return amount.multiply(TAX_RATE_AMOUNT_ABOVE_5000);
        }

        return amount.multiply(TAX_RATE_AMOUNT_BELOW_3000);
    }
}
