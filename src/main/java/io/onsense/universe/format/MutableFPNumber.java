package io.onsense.universe.format;

import java.math.BigInteger;

/**
 * @author Koen Rooijmans
 */
public class MutableFPNumber {

    private static final BigInteger BI_MIN_BASE = new BigInteger("0B5E620F47FFFE666", 16);
    private static final BigInteger BI_MAX_BASE = new BigInteger("0E35FA9319FFFE000", 16);

    private static final int C_64 = 64;

    private static final int MIN_PRECISION = 72;
    private BigInteger _significand;
    private int _binaryExponent;

    public MutableFPNumber(BigInteger frac, int binaryExponent) {
        _significand = frac;
        _binaryExponent = binaryExponent;
    }

    public void normalise64bit() {
        int oldBitLen = _significand.bitLength();
        int sc = oldBitLen - C_64;
        if (sc == 0) {
            return;
        }
        if (sc < 0) {
            throw new IllegalStateException("Not enough precision");
        }
        _binaryExponent += sc;
        if (sc > 32) {
            int highShift = (sc - 1) & 0xFFFFE0;
            _significand = _significand.shiftRight(highShift);
            sc -= highShift;
            oldBitLen -= highShift;
        }
        if (sc < 1) {
            throw new IllegalStateException();
        }
        _significand = Rounder.round(_significand, sc);
        if (_significand.bitLength() > oldBitLen) {
            sc++;
            _binaryExponent++;
        }
        _significand = _significand.shiftRight(sc);
    }

    public int get64BitNormalisedExponent() {
        return _binaryExponent + _significand.bitLength() - C_64;

    }

    public boolean isBelowMaxRep() {
        int sc = _significand.bitLength() - C_64;
        return _significand.compareTo(BI_MAX_BASE.shiftLeft(sc)) < 0;
    }

    public boolean isAboveMinRep() {
        int sc = _significand.bitLength() - C_64;
        return _significand.compareTo(BI_MIN_BASE.shiftLeft(sc)) > 0;
    }

    public NormalisedDecimal createNormalisedDecimal(int pow10) {
        int missingUnderBits = _binaryExponent - 39;
        int fracPart = (_significand.intValue() << missingUnderBits) & 0xFFFF80;
        long wholePart = _significand.shiftRight(C_64 - _binaryExponent - 1).longValue();
        return new NormalisedDecimal(wholePart, fracPart, pow10);
    }

    public void multiplyByPowerOfTen(int pow10) {
        TenPower tp = TenPower.getInstance(Math.abs(pow10));
        if (pow10 < 0) {
            mulShift(tp._divisor, tp._divisorShift);
        } else {
            mulShift(tp._multiplicand, tp._multiplierShift);
        }
    }

    private void mulShift(BigInteger multiplicand, int multiplierShift) {
        _significand = _significand.multiply(multiplicand);
        _binaryExponent += multiplierShift;
        int sc = (_significand.bitLength() - MIN_PRECISION) & 0xFFFFFFE0;
        if (sc > 0) {
            _significand = _significand.shiftRight(sc);
            _binaryExponent += sc;
        }
    }

    private static final class Rounder {
        private static final BigInteger[] HALF_BITS;

        static {
            BigInteger[] bis = new BigInteger[33];
            long acc = 1;
            for (int i = 1; i < bis.length; i++) {
                bis[i] = BigInteger.valueOf(acc);
                acc <<= 1;
            }
            HALF_BITS = bis;
        }

        public static BigInteger round(BigInteger bi, int nBits) {
            if (nBits < 1) {
                return bi;
            }
            return bi.add(HALF_BITS[nBits]);
        }
    }

    private static final class TenPower {

        private static final BigInteger FIVE = new BigInteger("5");
        private static final TenPower[] _cache = new TenPower[350];

        public final BigInteger _multiplicand;
        public final BigInteger _divisor;
        public final int _divisorShift;
        public final int _multiplierShift;

        private TenPower(int index) {
            BigInteger fivePowIndex = FIVE.pow(index);

            int bitsDueToFiveFactors = fivePowIndex.bitLength();
            int px = 80 + bitsDueToFiveFactors;
            BigInteger fx = BigInteger.ONE.shiftLeft(px).divide(fivePowIndex);
            int adj = fx.bitLength() - 80;
            _divisor = fx.shiftRight(adj);
            bitsDueToFiveFactors -= adj;

            _divisorShift = -(bitsDueToFiveFactors + index + 80);
            int sc = fivePowIndex.bitLength() - 68;
            if (sc > 0) {
                _multiplierShift = index + sc;
                _multiplicand = fivePowIndex.shiftRight(sc);
            } else {
                _multiplierShift = index;
                _multiplicand = fivePowIndex;
            }
        }

        static TenPower getInstance(int index) {
            TenPower result = _cache[index];
            if (result == null) {
                result = new TenPower(index);
                _cache[index] = result;
            }
            return result;
        }
    }
}
