package io.onsense.universe;

import cern.jet.math.Bessel;
import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author Koen Rooijmans
 */
public class Bessi {

    public static final BigDecimal ACC = new BigDecimal("4.0");
    public static final BigDecimal BIGNO = new BigDecimal("1.0e10");
    public static final BigDecimal BIGNI = new BigDecimal("1.0e-10");

    public static BigDecimal bessi(int n, BigDecimal x) {
        if (n == 0) {
            return BigDecimal.valueOf(Bessel.i0(x.doubleValue()));
        }
        if (n == 1) {
            return BigDecimal.valueOf(Bessel.i1(x.doubleValue()));
        }
        if (n < 2) {
            throw new IllegalArgumentException("Function order must be greater than 1");
        }
        if (x.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal tox = new BigDecimal("2.0").divide(x.abs(), MathContext.DECIMAL128);
            BigDecimal ans = BigDecimal.ZERO;
            BigDecimal bip = BigDecimal.ZERO;
            BigDecimal bi = BigDecimal.ONE;
            for (int j = 2 * (n + BigDecimalMath.sqrt(ACC.multiply(new BigDecimal(n), MathContext.DECIMAL128), MathContext.DECIMAL128).intValue()); j > 0; --j) {
                BigDecimal bim = bip.add(new BigDecimal(j).multiply(tox).multiply(bi));
                bip = bi;
                bi = bim;
                if (bi.abs(MathContext.DECIMAL128).compareTo(BIGNO) == -1) {
                    ans = ans.multiply(BIGNI);
                    bi = bi.multiply(BIGNI);
                    bip = bip.multiply(BIGNI);
                }
                if (j == n) {
                    ans = bip;
                }
            }
            ans = ans.multiply(new BigDecimal(Bessel.i0(x.doubleValue())).divide(bi, MathContext.DECIMAL128));
            return (((x.doubleValue() < 0.0) && ((n % 2) == 0)) ? ans.negate() : ans);
        }
    }
}
