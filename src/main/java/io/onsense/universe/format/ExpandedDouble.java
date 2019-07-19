package io.onsense.universe.format;

import java.math.BigInteger;

/**
 * @author Koen Rooijmans
 */
public class ExpandedDouble {

    private static final BigInteger BI_FRAC_MASK = BigInteger.valueOf(IEEEDouble.FRAC_MASK);
    private static final BigInteger BI_IMPLIED_FRAC_MSB = BigInteger.valueOf(IEEEDouble.FRAC_ASSUMED_HIGH_BIT);
    private final BigInteger _significand;
    private final int _binaryExponent;

    public ExpandedDouble(long rawBits) {
        int biasedExp = (int) (rawBits >> 52);
        if (biasedExp == 0) {
            BigInteger frac = BigInteger.valueOf(rawBits).and(BI_FRAC_MASK);
            int expAdj = 64 - frac.bitLength();
            _significand = frac.shiftLeft(expAdj);
            _binaryExponent = (biasedExp & 0x07FF) - 1023 - expAdj;
        } else {
            _significand = getFrac(rawBits);
            _binaryExponent = (biasedExp & 0x07FF) - 1023;
        }
    }

    private static BigInteger getFrac(long rawBits) {
        return BigInteger.valueOf(rawBits).and(BI_FRAC_MASK).or(BI_IMPLIED_FRAC_MSB).shiftLeft(11);
    }

    public NormalisedDecimal normaliseBaseTen() {
        return NormalisedDecimal.create(_significand, _binaryExponent);
    }

    public int getBinaryExponent() {
        return _binaryExponent;
    }
}
