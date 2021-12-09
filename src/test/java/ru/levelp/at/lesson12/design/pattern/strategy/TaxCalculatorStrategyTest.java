package ru.levelp.at.lesson12.design.pattern.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxCalculatorStrategyTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {new TaxCalculatorProviderImpl(new RusTaxCalculator()),
                new BigDecimal("1000"), new BigDecimal("130.00")},
            {new TaxCalculatorProviderImpl(new UsaTaxCalculator()),
                new BigDecimal("1000"), new BigDecimal("200.0")},
            {new TaxCalculatorProviderImpl(new UsaTaxCalculator()),
                new BigDecimal("4000"), new BigDecimal("1200.0")},
            {new TaxCalculatorProviderImpl(new UsaTaxCalculator()),
                new BigDecimal("6000"), new BigDecimal("2100.00")},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void taxCalculatorTest(TaxCalculatorProvider provider, BigDecimal amount, BigDecimal expectedAmount) {
        BigDecimal actualAmount = provider.calculate(amount);
        assertThat(actualAmount).isEqualTo(expectedAmount);
    }
}
