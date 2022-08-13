package net.beardy.finance.shortme.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class ShortUtil {

    public ShortUtil() {
        throw new UnsupportedOperationException("Utility class");
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

        final BigDecimal valueToAdd = BigDecimal.ONE.divide(normalizer, mathContext);

        if (hasDecimalPlaces(amountToAdd)) {
            return value.multiply(amountToAdd.add(BigDecimal.ONE)).setScale(roundingScale, RoundingMode.HALF_EVEN);
        }

        return value.add(valueToAdd);
    }

    public static boolean hasDecimalPlaces(BigDecimal value) {
        return value.compareTo(new BigDecimal(value.intValue())) != 0;
    }

}
