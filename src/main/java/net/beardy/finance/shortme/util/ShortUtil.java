package net.beardy.finance.shortme.util;

import net.beardy.finance.shortme.util.dto.ShortCalculationResponse;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class ShortUtil {

    public ShortUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static ShortCalculationResponse calculateShort(BigDecimal sellPrice, BigDecimal sellAmount,
        BigDecimal profit) {
        final BigDecimal dollarAmount = sellPrice.multiply(sellAmount);

        final BigDecimal buyAmount = ShortUtil.numberAdder(sellAmount, profit);

        final MathContext mathContext = new MathContext(7, RoundingMode.HALF_EVEN);

        return new ShortCalculationResponse(dollarAmount.divide(buyAmount, mathContext), buyAmount);
    }

    public static BigDecimal numberAdder(BigDecimal value, BigDecimal amountToAdd) {
        BigDecimal normalizer = BigDecimal.ONE;
        BigDecimal saver = value;

        while (hasDecimalPlaces(saver)) {
            normalizer = normalizer.multiply(BigDecimal.TEN);
            saver = saver.multiply(BigDecimal.TEN);
        }

        final int roundingScale = (int) Math.log10(normalizer.doubleValue());
        final MathContext mathContext = new MathContext(roundingScale, RoundingMode.HALF_EVEN);

        final BigDecimal valueToAdd = amountToAdd.divide(normalizer, mathContext);

        if (hasDecimalPlaces(amountToAdd)) {
            return value.multiply(amountToAdd.add(BigDecimal.ONE)).setScale(roundingScale, RoundingMode.HALF_EVEN);
        }

        return value.add(valueToAdd);
    }

    public static boolean hasDecimalPlaces(BigDecimal value) {
        return value.compareTo(new BigDecimal(value.intValue())) != 0;
    }

}
