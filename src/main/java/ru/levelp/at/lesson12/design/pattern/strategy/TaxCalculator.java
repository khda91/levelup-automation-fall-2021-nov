package ru.levelp.at.lesson12.design.pattern.strategy;

import java.math.BigDecimal;

public interface TaxCalculator {

    BigDecimal calculate(BigDecimal amount);
}
