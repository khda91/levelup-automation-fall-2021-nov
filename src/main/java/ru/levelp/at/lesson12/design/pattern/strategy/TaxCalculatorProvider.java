package ru.levelp.at.lesson12.design.pattern.strategy;

import java.math.BigDecimal;

public interface TaxCalculatorProvider {

    BigDecimal calculate(BigDecimal amount);
}
