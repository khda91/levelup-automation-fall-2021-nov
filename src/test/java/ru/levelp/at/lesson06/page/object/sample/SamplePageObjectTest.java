package ru.levelp.at.lesson06.page.object.sample;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.testng.annotations.Test;
import ru.levelp.at.lesson06.page.object.SeleniumBaseTest;

public class SamplePageObjectTest extends SeleniumBaseTest {

    @Test
    public void currencyConverterTest() {
        SberbankPersonPage spp = new SberbankPersonPage(driver);

        spp.open();

        BigDecimal convertionAmount = new BigDecimal("7000");

        spp.sendKeysToRatesSaleInputField(convertionAmount.toPlainString());
        BigDecimal eurSaleExchangeRate = spp.getEurSaleExchangeRateLabelText();
        BigDecimal expectedAmount = convertionAmount.divide(eurSaleExchangeRate, RoundingMode.FLOOR);

        BigDecimal actualAmount = spp.getRatesCalculatorGetInputFieldText();

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }
}
