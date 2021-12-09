package ru.levelp.at.lesson12.design.pattern.strategy;

import java.math.BigDecimal;

public class TaxCalculatorProviderImpl implements TaxCalculatorProvider {

    private final TaxCalculator taxCalculator;

    public TaxCalculatorProviderImpl(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return taxCalculator.calculate(amount);
    }
}
