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
        BigDecimal profit, BigDecimal fee) {
        final BigDecimal dollarAmount = sellPrice.multiply(sellAmount);

        final BigDecimal buyAmount = ShortUtil.numberAdder(sellAmount, profit);

        final MathContext mathContext = new MathContext(7, RoundingMode.HALF_EVEN);

        final BigDecimal feeDebuffer = BigDecimal.ONE.subtract(fee.multiply(new BigDecimal(2)));
        final BigDecimal price = dollarAmount.multiply(feeDebuffer).divide(buyAmount, mathContext);

        return new ShortCalculationResponse(price, buyAmount);
    }

    public static ShortCalculationResponse calculateShort(BigDecimal sellPrice, BigDecimal sellAmount,
        BigDecimal profit) {
        return calculateShort(sellPrice, sellAmount, profit, BigDecimal.ZERO);
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

        if (hasDecimalPlaces(amountToAdd)) {
            return value.multiply(amountToAdd.add(BigDecimal.ONE)).setScale(roundingScale, RoundingMode.HALF_EVEN);
        }

        final BigDecimal valueToAdd = amountToAdd.divide(normalizer, mathContext);

        return value.add(valueToAdd);
    }

    public static boolean hasDecimalPlaces(BigDecimal value) {
        return value.compareTo(new BigDecimal(value.intValue())) != 0;
    }

}
